from django.urls import path 
from .views import customLoginView, RegisterPage
from django.contrib.auth.views import LogoutView

urlpatterns = [
    path('login/', customLoginView.as_view(), name = 'login'),
    path('logout/', LogoutView.as_view(next_page='login'), name = 'logout'),
    path('register/', RegisterPage.as_view(), name = 'register'),
]