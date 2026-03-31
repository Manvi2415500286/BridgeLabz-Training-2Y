from django.contrib.auth.models import AbstractUser
from django.db import models

# 👤 Custom User
class User(AbstractUser):
    ROLE_CHOICES = (
        ('buyer', 'Buyer'),
        ('seller', 'Seller'),
        ('admin', 'Admin'),
    )
    role = models.CharField(max_length=10, choices=ROLE_CHOICES)


# 🌾 Land Model
class Land(models.Model):
    seller = models.ForeignKey(User, on_delete=models.CASCADE)
    title = models.CharField(max_length=100)
    location = models.CharField(max_length=200)
    acres = models.FloatField()
    gunta = models.FloatField()
    price = models.IntegerField()
    description = models.TextField()
    is_available = models.BooleanField(default=True)

    def __str__(self):
        return self.title


# 📦 Booking Model
class Booking(models.Model):
    buyer = models.ForeignKey(User, on_delete=models.CASCADE)
    land = models.ForeignKey(Land, on_delete=models.CASCADE)
    type = models.CharField(max_length=10, choices=[('rent','Rent'), ('buy','Buy')])
    date = models.DateTimeField(auto_now_add=True)