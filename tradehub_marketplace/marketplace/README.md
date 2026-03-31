# 🛒 TradeHub Marketplace — Django Project

A full-featured multi-role marketplace built with **pure Django** — no external frontend frameworks. Includes buyer/seller roles, product listings, wallet-based transactions, and a rich admin panel.

---

## 🚀 Quick Start

```bash
# 1. Install Django
pip install django

# 2. Run migrations
python manage.py makemigrations transactions
python manage.py migrate

# 3. Seed sample data (users, products, transactions)
python manage.py shell < seed_data.py

# 4. Start the server
python manage.py runserver
```

Then open **http://127.0.0.1:8000**

---

## 🔑 Demo Credentials

| Role    | Username      | Password  | Notes                    |
|---------|---------------|-----------|--------------------------|
| Admin   | `admin`       | `admin123`| Full admin panel access  |
| Seller  | `alice_sells` | `pass1234`| Electronics & Books      |
| Seller  | `bob_store`   | `pass1234`| Sports & Clothing        |
| Seller  | `carol_shop`  | `pass1234`| Home & Food              |
| Buyer   | `john_buyer`  | `pass1234`| $1000 starting balance   |
| Buyer   | `sara_buys`   | `pass1234`| $2500 starting balance   |
| Buyer   | `mike_shop`   | `pass1234`| $800 starting balance    |

---

## 📂 Project Structure

```
marketplace/
├── manage.py
├── setup.sh              ← One-command setup
├── seed_data.py          ← Sample data seeder
│
├── marketplace/          ← Django project config
│   ├── settings.py
│   └── urls.py
│
├── transactions/         ← Main app
│   ├── models.py         ← All data models
│   ├── admin.py          ← Rich admin panel
│   ├── views.py          ← All page views
│   └── forms.py          ← Registration & product forms
│
└── templates/
    ├── base.html          ← Shared layout & navbar
    ├── registration/
    │   ├── login.html
    │   └── register.html
    ├── marketplace/
    │   ├── home.html
    │   ├── dashboard.html
    │   ├── product_list.html
    │   ├── product_detail.html
    │   ├── product_form.html
    │   └── buy_product.html
    └── transactions/
        ├── list.html
        └── detail.html
```

---

## 🗄️ Data Models

### `UserProfile`
Extends Django's built-in `User` with:
- **role**: `buyer` | `seller` | `both`
- **balance**: wallet balance (Decimal)
- **is_verified**: admin-toggleable verification flag

### `Category`
Product categories with icon, name, description.

### `Product`
- Linked to a seller (`User`)
- Status: `active` | `sold` | `suspended` | `draft`
- Tracks stock quantity

### `Transaction`
Core model — records every purchase:
- Links buyer → seller → product
- Stores `quantity`, `unit_price`, `total_amount`
- Status: `pending` | `completed` | `failed` | `refunded` | `disputed`
- Auto-sets `completed_at` when status changes to completed

### `Dispute`
One-to-one with Transaction. Admin can review, add notes, and resolve.

---

## ⚙️ Admin Panel Features (`/admin/`)

| Section           | Capabilities                                                   |
|-------------------|----------------------------------------------------------------|
| **Users**         | View role badge, wallet balance, verification; edit inline profile |
| **Transactions**  | Color-coded status badges, bulk actions (complete/refund/dispute), summary card |
| **Products**      | Inline stock editing, status badges, seller links              |
| **Disputes**      | Status tracking, admin notes field                             |
| **Categories**    | Product count per category                                     |
| **User Profiles** | Inline-editable verification, balance display                  |

### Admin Bulk Actions
- ✅ Mark selected transactions as **Completed**
- ↩️ Mark selected transactions as **Refunded**
- ⚠️ Mark selected transactions as **Disputed**

---

## 🌐 URL Routes

| URL                        | View                     | Access   |
|----------------------------|--------------------------|----------|
| `/`                        | Home / landing page      | Public   |
| `/register/`               | Registration form        | Public   |
| `/login/`                  | Login                    | Public   |
| `/logout/`                 | Logout                   | Auth     |
| `/dashboard/`              | Role-based dashboard     | Auth     |
| `/products/`               | Browse marketplace       | Auth     |
| `/products/new/`           | List a product           | Sellers  |
| `/products/<id>/`          | Product detail           | Auth     |
| `/products/<id>/buy/`      | Purchase flow            | Buyers   |
| `/transactions/`           | My transaction history   | Auth     |
| `/transactions/<id>/`      | Transaction detail       | Auth     |
| `/admin/`                  | Django admin panel       | Staff    |

---

## 💡 Key Features

- **Role-based access control** — buyers, sellers, and dual-role users
- **Wallet system** — atomic balance transfers between buyer and seller on purchase
- **Stock management** — auto-marks product as `sold` when stock hits 0
- **Self-purchase prevention** — sellers cannot buy their own products
- **Transaction audit trail** — every purchase is logged with timestamps
- **Admin monitoring** — full oversight of all transactions, disputes, users
- **Color-coded admin UI** — status badges, balance indicators, role badges
- **Dark-themed frontend** — modern UI with Syne + DM Sans typography

---

## 🔒 Security Notes (for production)

1. Change `SECRET_KEY` in `settings.py`
2. Set `DEBUG = False`
3. Configure `ALLOWED_HOSTS`
4. Use PostgreSQL instead of SQLite
5. Add `django-environ` for environment variables
6. Enable HTTPS / configure `SECURE_SSL_REDIRECT`
