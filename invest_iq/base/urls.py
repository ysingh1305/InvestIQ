from django.urls import path
from . import views

urlpatterns = [path('login/', customLoginView.as_view(), name = 'login'),
    path('logout/', LogoutView.as_view(next_page='login'), name = 'logout'),
    path('register/', RegisterPage.as_view(), name = 'register'),
    path('', taskList.as_view(), name = 'tasks'),
]