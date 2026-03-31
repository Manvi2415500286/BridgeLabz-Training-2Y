#!/bin/bash
# ─────────────────────────────────────────────────────────────
#  TradeHub Marketplace — One-command setup script
# ─────────────────────────────────────────────────────────────
set -e

echo ""
echo "╔══════════════════════════════════════════╗"
echo "║    🛒  TradeHub Marketplace Setup         ║"
echo "╚══════════════════════════════════════════╝"
echo ""

# 1. Install Django
echo "📦 Installing Django..."
pip install django --break-system-packages -q

# 2. Migrations
echo "🗄️  Running migrations..."
python manage.py makemigrations transactions
python manage.py migrate

# 3. Seed data
echo "🌱 Seeding sample data..."
python manage.py shell < seed_data.py

echo ""
echo "╔══════════════════════════════════════════╗"
echo "║  ✅  Setup complete! Start with:          ║"
echo "║  python manage.py runserver               ║"
echo "║                                           ║"
echo "║  Admin:  http://127.0.0.1:8000/admin/     ║"
echo "║  Login:  admin / admin123                 ║"
echo "╚══════════════════════════════════════════╝"
echo ""
