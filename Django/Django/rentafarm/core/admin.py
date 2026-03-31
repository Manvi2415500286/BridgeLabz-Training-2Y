from django.contrib import admin
from .models import User, Land, Booking

admin.site.register(User)
admin.site.register(Land)
admin.site.register(Booking)