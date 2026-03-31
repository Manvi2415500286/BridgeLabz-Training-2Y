"""
Run this after migrations to seed sample data:
  python manage.py shell < seed_data.py
"""
import os
os.environ.setdefault('DJANGO_SETTINGS_MODULE', 'marketplace.settings')

import django
django.setup()

from django.contrib.auth.models import User
from transactions.models import UserProfile, Category, Product, Transaction
from decimal import Decimal

print("🌱 Seeding database...")

# ── Categories ──────────────────────────────────────────────────────────────
categories = [
    ("Electronics",  "Gadgets and devices",           "💻"),
    ("Clothing",     "Fashion and apparel",            "👕"),
    ("Books",        "Books and educational material", "📚"),
    ("Home & Garden","Home improvement and decor",     "🏡"),
    ("Sports",       "Sports and outdoor gear",        "⚽"),
    ("Food",         "Gourmet and specialty foods",    "🍕"),
]
cat_objs = {}
for name, desc, icon in categories:
    cat, _ = Category.objects.get_or_create(name=name, defaults={"description": desc, "icon": icon})
    cat_objs[name] = cat
    print(f"  ✔ Category: {icon} {name}")

# ── Superuser (admin) ───────────────────────────────────────────────────────
if not User.objects.filter(username="admin").exists():
    admin = User.objects.create_superuser("admin", "admin@tradehub.com", "admin123")
    UserProfile.objects.create(user=admin, role="both", balance=Decimal("99999"), is_verified=True)
    print("  ✔ Superuser: admin / admin123")

# ── Sellers ─────────────────────────────────────────────────────────────────
sellers_data = [
    ("alice_sells", "alice@tradehub.com", "Alice Johnson", 5000),
    ("bob_store",   "bob@tradehub.com",   "Bob Williams",  3200),
    ("carol_shop",  "carol@tradehub.com", "Carol Davis",   7800),
]
sellers = {}
for username, email, full_name, balance in sellers_data:
    if not User.objects.filter(username=username).exists():
        first, last = full_name.split()
        u = User.objects.create_user(username, email, "pass1234", first_name=first, last_name=last)
        UserProfile.objects.create(user=u, role="seller", balance=Decimal(balance), is_verified=True)
        print(f"  ✔ Seller: {username} / pass1234")
    sellers[username] = User.objects.get(username=username)

# ── Buyers ──────────────────────────────────────────────────────────────────
buyers_data = [
    ("john_buyer", "john@tradehub.com", "John Smith",  1000),
    ("sara_buys",  "sara@tradehub.com", "Sara Miller", 2500),
    ("mike_shop",  "mike@tradehub.com", "Mike Brown",  800),
]
buyers = {}
for username, email, full_name, balance in buyers_data:
    if not User.objects.filter(username=username).exists():
        first, last = full_name.split()
        u = User.objects.create_user(username, email, "pass1234", first_name=first, last_name=last)
        UserProfile.objects.create(user=u, role="buyer", balance=Decimal(balance), is_verified=True)
        print(f"  ✔ Buyer:  {username} / pass1234")
    buyers[username] = User.objects.get(username=username)

# ── Products ─────────────────────────────────────────────────────────────────
products_data = [
    ("alice_sells", "MacBook Pro M3",         "Electronics",  1299.99, 5,  "Top-spec laptop with Apple M3 chip, 18hr battery, Liquid Retina display."),
    ("alice_sells", "Wireless Noise-Cancel Headphones", "Electronics", 249.99, 12, "Studio-grade sound with 30hr battery and active noise cancellation."),
    ("alice_sells", "Python Programming Guide", "Books",       39.99, 50, "Comprehensive Python 3 guide from beginner to advanced."),
    ("bob_store",   "Running Shoes Pro",       "Sports",       89.99, 20, "Lightweight carbon-plate running shoes for marathon training."),
    ("bob_store",   "Yoga Mat Premium",        "Sports",       45.00, 30, "Eco-friendly non-slip yoga mat, 6mm thick, includes carry strap."),
    ("bob_store",   "Vintage Denim Jacket",    "Clothing",     120.00, 8,  "90s-style denim jacket, stonewashed, unisex sizing."),
    ("carol_shop",  "Espresso Machine",        "Home & Garden",349.99, 4,  "Barista-quality espresso with built-in grinder and steam wand."),
    ("carol_shop",  "Artisan Cheese Set",      "Food",         65.00, 15, "Curated selection of 6 imported artisan cheeses with crackers."),
    ("carol_shop",  "Smart LED Desk Lamp",     "Home & Garden", 59.99, 25, "USB-C charging, 5 color temps, memory function, eye-care mode."),
]
prods = {}
for seller_uname, name, cat_name, price, stock, desc in products_data:
    if not Product.objects.filter(name=name).exists():
        p = Product.objects.create(
            seller=sellers[seller_uname],
            name=name,
            description=desc,
            price=Decimal(str(price)),
            stock=stock,
            category=cat_objs[cat_name],
            status="active",
        )
        prods[name] = p
        print(f"  ✔ Product: {name} (${price})")

# ── Transactions ─────────────────────────────────────────────────────────────
txns_data = [
    # (buyer, seller, product_name, qty, status)
    ("john_buyer", "alice_sells", "MacBook Pro M3",             1, "completed"),
    ("john_buyer", "alice_sells", "Wireless Noise-Cancel Headphones", 1, "completed"),
    ("sara_buys",  "bob_store",   "Running Shoes Pro",           2, "completed"),
    ("sara_buys",  "carol_shop",  "Espresso Machine",            1, "pending"),
    ("mike_shop",  "alice_sells", "Python Programming Guide",    1, "completed"),
    ("mike_shop",  "bob_store",   "Yoga Mat Premium",            1, "disputed"),
    ("john_buyer", "carol_shop",  "Smart LED Desk Lamp",         2, "completed"),
    ("sara_buys",  "alice_sells", "Python Programming Guide",    1, "refunded"),
]
for buyer_uname, seller_uname, prod_name, qty, status in txns_data:
    prod = prods.get(prod_name)
    if prod and not Transaction.objects.filter(
        buyer=buyers[buyer_uname], product=prod, status=status
    ).exists():
        total = prod.price * qty
        Transaction.objects.create(
            buyer=buyers[buyer_uname],
            seller=sellers[seller_uname],
            product=prod,
            quantity=qty,
            unit_price=prod.price,
            total_amount=total,
            status=status,
        )
        print(f"  ✔ Transaction: {buyer_uname} → {prod_name} × {qty} [{status}]")

print("\n✅ Seeding complete!")
print("\n📋 Login credentials:")
print("   Admin:   admin / admin123  →  /admin/")
print("   Sellers: alice_sells, bob_store, carol_shop  /  pass1234")
print("   Buyers:  john_buyer, sara_buys, mike_shop    /  pass1234")
