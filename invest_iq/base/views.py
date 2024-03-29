from django.shortcuts import render, redirect
from django.views.generic.edit import FormView
from django.urls import reverse_lazy
from django.contrib.auth.views import LoginView
from django.contrib.auth.forms import UserCreationForm 
from django.contrib.auth import login 
from base.forms import RegisterForm
from django.http import HttpResponse

def homepage(request):
    return HttpResponse("success")


class customLoginView(LoginView):
    template_name = "base/login.html"
    fields = "__all__"
    redirect_authenticated_user = False 

    def get_success_url(self):
        return reverse_lazy('homepage')

class RegisterPage(FormView):
    template_name = "base/register.html"
    form_class = RegisterForm 
    redirect_authenticated_user = True
    success_url = reverse_lazy('login')

    def form_valid(self, form):
        user = form.save()
        if user is not None:
            login(self.request, user)
        return super(RegisterPage, self).form_valid(form)
    
    def get(self, request, *args, **kwargs):
        return render(request, self.template_name, {'form': self.form_class()})
    

# Create your views here.
