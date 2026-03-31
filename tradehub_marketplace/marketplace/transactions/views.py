from django.shortcuts import render, redirect, get_object_or_404
from django.contrib.auth.decorators import login_required
from django.contrib.auth import login
from django.contrib.auth.models import User
from django.contrib import messages
from django.db import transaction as db_transaction
from django.db.models import Sum, Count, Q
from .models import UserProfile, Product, Transaction, Category
from .forms import RegisterForm, ProductForm


def home(request):
    if request.user.is_authenticated:
        return redirect('dashboard')
    products = Product.objects.filter(status='active').select_related('seller', 'category')[:6]
    return render(request, 'marketplace/home.html', {'products': products})


def register(request):
    if request.method == 'POST':
        form = RegisterForm(request.POST)
        if form.is_valid():
            user = form.save()
            UserProfile.objects.create(
                user=user,
                role=form.cleaned_data['role'],
                phone=form.cleaned_data.get('phone', ''),
                balance=1000.00
            )
            login(request, user)
            messages.success(request, f'Welcome, {user.username}! Your account is ready.')
            return redirect('dashboard')
    else:
        form = RegisterForm()
    return render(request, 'registration/register.html', {'form': form})


@login_required
def dashboard(request):
    profile = request.user.profile
    context = {'profile': profile}

    if profile.can_sell():
        context['my_products'] = Product.objects.filter(seller=request.user)[:5]
        context['sales'] = Transaction.objects.filter(seller=request.user)
        context['total_sales'] = context['sales'].filter(status='completed').aggregate(
            total=Sum('total_amount'))['total'] or 0
        context['pending_sales'] = context['sales'].filter(status='pending').count()

    if profile.can_buy():
        context['purchases'] = Transaction.objects.filter(buyer=request.user)[:5]
        context['total_spent'] = Transaction.objects.filter(
            buyer=request.user, status='completed'
        ).aggregate(total=Sum('total_amount'))['total'] or 0

    context['recent_transactions'] = Transaction.objects.filter(
        Q(buyer=request.user) | Q(seller=request.user)
    ).select_related('buyer', 'seller', 'product')[:8]

    return render(request, 'marketplace/dashboard.html', context)


@login_required
def product_list(request):
    products = Product.objects.filter(status='active').select_related('seller', 'category')
    categories = Category.objects.all()
    cat_id = request.GET.get('category')
    search = request.GET.get('q', '')
    if cat_id:
        products = products.filter(category_id=cat_id)
    if search:
        products = products.filter(Q(name__icontains=search) | Q(description__icontains=search))
    return render(request, 'marketplace/product_list.html', {
        'products': products, 'categories': categories, 'search': search
    })


@login_required
def product_detail(request, pk):
    product = get_object_or_404(Product, pk=pk)
    return render(request, 'marketplace/product_detail.html', {'product': product})


@login_required
def product_create(request):
    profile = request.user.profile
    if not profile.can_sell():
        messages.error(request, 'Only sellers can list products.')
        return redirect('dashboard')
    if request.method == 'POST':
        form = ProductForm(request.POST)
        if form.is_valid():
            product = form.save(commit=False)
            product.seller = request.user
            product.save()
            messages.success(request, f'"{product.name}" listed successfully!')
            return redirect('dashboard')
    else:
        form = ProductForm()
    return render(request, 'marketplace/product_form.html', {'form': form})


@login_required
def buy_product(request, pk):
    product = get_object_or_404(Product, pk=pk, status='active')
    profile = request.user.profile

    if not profile.can_buy():
        messages.error(request, 'Only buyers can purchase products.')
        return redirect('product_detail', pk=pk)

    if product.seller == request.user:
        messages.error(request, 'You cannot buy your own product.')
        return redirect('product_detail', pk=pk)

    if request.method == 'POST':
        quantity = int(request.POST.get('quantity', 1))
        total = product.price * quantity

        if profile.balance < total:
            messages.error(request, f'Insufficient balance. You need ${total} but have ${profile.balance}.')
            return redirect('product_detail', pk=pk)

        if product.stock < quantity:
            messages.error(request, f'Only {product.stock} items available.')
            return redirect('product_detail', pk=pk)

        with db_transaction.atomic():
            txn = Transaction.objects.create(
                buyer=request.user,
                seller=product.seller,
                product=product,
                quantity=quantity,
                unit_price=product.price,
                total_amount=total,
                status='completed'
            )
            profile.balance -= total
            profile.save()

            seller_profile = product.seller.profile
            seller_profile.balance += total
            seller_profile.save()

            product.stock -= quantity
            if product.stock == 0:
                product.status = 'sold'
            product.save()

        messages.success(request, f'Purchase successful! TXN-{txn.pk:06d}')
        return redirect('transaction_detail', pk=txn.pk)

    return render(request, 'marketplace/buy_product.html', {'product': product})


@login_required
def transaction_list(request):
    txns = Transaction.objects.filter(
        Q(buyer=request.user) | Q(seller=request.user)
    ).select_related('buyer', 'seller', 'product')
    return render(request, 'transactions/list.html', {'transactions': txns})


@login_required
def transaction_detail(request, pk):
    txn = get_object_or_404(
        Transaction,
        Q(buyer=request.user) | Q(seller=request.user),
        pk=pk
    )
    return render(request, 'transactions/detail.html', {'txn': txn})
