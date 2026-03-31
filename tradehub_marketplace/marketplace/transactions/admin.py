from django.contrib import admin
from django.contrib.auth.admin import UserAdmin as BaseUserAdmin
from django.contrib.auth.models import User
from django.utils.html import format_html
from django.db.models import Sum, Count
from django.utils import timezone
from .models import UserProfile, Product, Transaction, Category, Dispute


# ─── Inline: UserProfile inside User ───────────────────────────────────────
class UserProfileInline(admin.StackedInline):
    model = UserProfile
    can_delete = False
    verbose_name_plural = 'Profile'
    fields = ('role', 'balance', 'phone', 'address', 'is_verified')


class UserAdmin(BaseUserAdmin):
    inlines = (UserProfileInline,)
    list_display = ('username', 'email', 'get_role', 'get_balance', 'get_verified', 'date_joined', 'is_active')
    list_filter = ('profile__role', 'profile__is_verified', 'is_active', 'date_joined')
    search_fields = ('username', 'email', 'first_name', 'last_name')

    def get_role(self, obj):
        try:
            role = obj.profile.role
            colors = {'buyer': '#3b82f6', 'seller': '#10b981', 'both': '#8b5cf6'}
            color = colors.get(role, '#6b7280')
            return format_html(
                '<span style="background:{};color:white;padding:2px 8px;border-radius:12px;font-size:11px;font-weight:600">{}</span>',
                color, obj.profile.get_role_display()
            )
        except UserProfile.DoesNotExist:
            return '-'
    get_role.short_description = 'Role'

    def get_balance(self, obj):
        try:
            balance = obj.profile.balance
            color = '#10b981' if balance > 0 else '#ef4444'
            return format_html('<span style="color:{};font-weight:600">${}</span>', color, balance)
        except UserProfile.DoesNotExist:
            return '-'
    get_balance.short_description = 'Balance'

    def get_verified(self, obj):
        try:
            if obj.profile.is_verified:
                return format_html('<span style="color:#10b981;font-size:16px">✔</span>')
            return format_html('<span style="color:#ef4444;font-size:16px">✘</span>')
        except UserProfile.DoesNotExist:
            return '-'
    get_verified.short_description = 'Verified'


admin.site.unregister(User)
admin.site.register(User, UserAdmin)


# ─── Category Admin ──────────────────────────────────────────────────────────
@admin.register(Category)
class CategoryAdmin(admin.ModelAdmin):
    list_display = ('icon', 'name', 'get_product_count')
    search_fields = ('name',)

    def get_product_count(self, obj):
        count = obj.product_set.count()
        return format_html('<strong>{}</strong> products', count)
    get_product_count.short_description = 'Products'


# ─── Product Admin ───────────────────────────────────────────────────────────
@admin.register(Product)
class ProductAdmin(admin.ModelAdmin):
    list_display = ('name', 'get_seller', 'category', 'get_price', 'stock', 'get_status_badge', 'created_at')
    list_filter = ('status', 'category', 'created_at')
    search_fields = ('name', 'seller__username', 'description')
    readonly_fields = ('created_at', 'updated_at')
    list_editable = ('stock',)
    date_hierarchy = 'created_at'

    fieldsets = (
        ('Product Info', {'fields': ('name', 'description', 'category')}),
        ('Pricing & Stock', {'fields': ('price', 'stock', 'status')}),
        ('Seller', {'fields': ('seller',)}),
        ('Timestamps', {'fields': ('created_at', 'updated_at'), 'classes': ('collapse',)}),
    )

    def get_seller(self, obj):
        return format_html(
            '<a href="/admin/auth/user/{}/change/">{}</a>',
            obj.seller.pk, obj.seller.username
        )
    get_seller.short_description = 'Seller'

    def get_price(self, obj):
        return format_html('<strong style="color:#10b981">${}</strong>', obj.price)
    get_price.short_description = 'Price'

    def get_status_badge(self, obj):
        colors = {
            'active': ('#d1fae5', '#065f46'),
            'sold': ('#dbeafe', '#1e3a8a'),
            'suspended': ('#fee2e2', '#7f1d1d'),
            'draft': ('#f3f4f6', '#374151'),
        }
        bg, fg = colors.get(obj.status, ('#f3f4f6', '#374151'))
        return format_html(
            '<span style="background:{};color:{};padding:2px 10px;border-radius:12px;font-size:11px;font-weight:600">{}</span>',
            bg, fg, obj.get_status_display()
        )
    get_status_badge.short_description = 'Status'


# ─── Transaction Admin ───────────────────────────────────────────────────────
@admin.register(Transaction)
class TransactionAdmin(admin.ModelAdmin):
    list_display = (
        'get_txn_id', 'get_buyer', 'get_seller', 'get_product',
        'quantity', 'get_amount', 'get_status_badge', 'created_at'
    )
    list_filter = ('status', 'created_at')
    search_fields = ('buyer__username', 'seller__username', 'product__name')
    readonly_fields = ('created_at', 'updated_at', 'completed_at', 'get_summary_card')
    date_hierarchy = 'created_at'
    list_per_page = 25

    fieldsets = (
        ('📋 Transaction Summary', {'fields': ('get_summary_card',)}),
        ('Parties', {'fields': ('buyer', 'seller')}),
        ('Product & Pricing', {'fields': ('product', 'quantity', 'unit_price', 'total_amount')}),
        ('Status & Notes', {'fields': ('status', 'notes')}),
        ('Timestamps', {'fields': ('created_at', 'updated_at', 'completed_at'), 'classes': ('collapse',)}),
    )

    actions = ['mark_completed', 'mark_refunded', 'mark_disputed']

    def get_txn_id(self, obj):
        return format_html('<code style="font-weight:700">TXN-{:06d}</code>', obj.pk)
    get_txn_id.short_description = 'Transaction ID'

    def get_buyer(self, obj):
        return format_html(
            '<span style="color:#3b82f6;font-weight:600">👤 {}</span>', obj.buyer.username
        )
    get_buyer.short_description = 'Buyer'

    def get_seller(self, obj):
        return format_html(
            '<span style="color:#10b981;font-weight:600">🏪 {}</span>', obj.seller.username
        )
    get_seller.short_description = 'Seller'

    def get_product(self, obj):
        if obj.product:
            return format_html('<em>{}</em>', obj.product.name)
        return format_html('<span style="color:#9ca3af">Deleted</span>')
    get_product.short_description = 'Product'

    def get_amount(self, obj):
        return format_html('<strong style="font-size:14px">${}</strong>', obj.total_amount)
    get_amount.short_description = 'Total'

    def get_status_badge(self, obj):
        styles = {
            'pending':   ('#fef3c7', '#92400e'),
            'completed': ('#d1fae5', '#065f46'),
            'failed':    ('#fee2e2', '#7f1d1d'),
            'refunded':  ('#ede9fe', '#4c1d95'),
            'disputed':  ('#ffedd5', '#7c2d12'),
        }
        bg, fg = styles.get(obj.status, ('#f3f4f6', '#374151'))
        icons = {'pending': '⏳', 'completed': '✅', 'failed': '❌', 'refunded': '↩️', 'disputed': '⚠️'}
        return format_html(
            '<span style="background:{};color:{};padding:3px 10px;border-radius:12px;font-size:11px;font-weight:700">{} {}</span>',
            bg, fg, icons.get(obj.status, ''), obj.get_status_display()
        )
    get_status_badge.short_description = 'Status'

    def get_summary_card(self, obj):
        return format_html(
            '''<div style="background:#f8fafc;border:1px solid #e2e8f0;border-radius:8px;padding:16px;max-width:500px">
                <div style="display:grid;grid-template-columns:1fr 1fr;gap:12px">
                    <div><small style="color:#64748b">Buyer</small><br><strong style="color:#3b82f6">{}</strong></div>
                    <div><small style="color:#64748b">Seller</small><br><strong style="color:#10b981">{}</strong></div>
                    <div><small style="color:#64748b">Product</small><br><strong>{}</strong></div>
                    <div><small style="color:#64748b">Amount</small><br><strong style="font-size:18px;color:#1e293b">${}</strong></div>
                </div>
            </div>''',
            obj.buyer.username,
            obj.seller.username,
            obj.product.name if obj.product else 'N/A',
            obj.total_amount,
        )
    get_summary_card.short_description = 'Overview'

    def mark_completed(self, request, queryset):
        updated = queryset.filter(status='pending').update(status='completed')
        self.message_user(request, f'{updated} transaction(s) marked as completed.')
    mark_completed.short_description = '✅ Mark selected as Completed'

    def mark_refunded(self, request, queryset):
        updated = queryset.exclude(status='refunded').update(status='refunded')
        self.message_user(request, f'{updated} transaction(s) marked as refunded.')
    mark_refunded.short_description = '↩️ Mark selected as Refunded'

    def mark_disputed(self, request, queryset):
        updated = queryset.exclude(status='disputed').update(status='disputed')
        self.message_user(request, f'{updated} transaction(s) marked as disputed.')
    mark_disputed.short_description = '⚠️ Mark selected as Disputed'


# ─── Dispute Admin ───────────────────────────────────────────────────────────
@admin.register(Dispute)
class DisputeAdmin(admin.ModelAdmin):
    list_display = ('get_dispute_id', 'get_transaction', 'raised_by', 'get_status_badge', 'created_at')
    list_filter = ('status', 'created_at')
    search_fields = ('transaction__buyer__username', 'transaction__seller__username', 'reason')
    readonly_fields = ('created_at', 'resolved_at')

    def get_dispute_id(self, obj):
        return format_html('<code style="font-weight:700">DSP-{:06d}</code>', obj.pk)
    get_dispute_id.short_description = 'Dispute ID'

    def get_transaction(self, obj):
        return format_html('<code>TXN-{:06d}</code>', obj.transaction.pk)
    get_transaction.short_description = 'Transaction'

    def get_status_badge(self, obj):
        colors = {
            'open': ('#fee2e2', '#7f1d1d'),
            'under_review': ('#fef3c7', '#92400e'),
            'resolved': ('#d1fae5', '#065f46'),
            'closed': ('#f3f4f6', '#374151'),
        }
        bg, fg = colors.get(obj.status, ('#f3f4f6', '#374151'))
        return format_html(
            '<span style="background:{};color:{};padding:2px 10px;border-radius:12px;font-size:11px;font-weight:600">{}</span>',
            bg, fg, obj.get_status_display()
        )
    get_status_badge.short_description = 'Status'


# ─── UserProfile standalone admin ────────────────────────────────────────────
@admin.register(UserProfile)
class UserProfileAdmin(admin.ModelAdmin):
    list_display = ('user', 'get_role_badge', 'get_balance', 'is_verified', 'created_at')
    list_filter = ('role', 'is_verified')
    search_fields = ('user__username', 'user__email')
    readonly_fields = ('created_at',)
    list_editable = ('is_verified',)

    def get_role_badge(self, obj):
        colors = {'buyer': '#3b82f6', 'seller': '#10b981', 'both': '#8b5cf6'}
        color = colors.get(obj.role, '#6b7280')
        return format_html(
            '<span style="background:{};color:white;padding:2px 10px;border-radius:12px;font-size:11px;font-weight:600">{}</span>',
            color, obj.get_role_display()
        )
    get_role_badge.short_description = 'Role'

    def get_balance(self, obj):
        color = '#10b981' if obj.balance > 100 else '#ef4444'
        return format_html('<strong style="color:{}">${}</strong>', color, obj.balance)
    get_balance.short_description = 'Balance'
