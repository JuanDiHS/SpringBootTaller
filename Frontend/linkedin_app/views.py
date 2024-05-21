from django.shortcuts import render

# Create your views here.
def home(request):
    return render(request,'linkedin_app/Home.html')

def login(request):
    return render(request, 'linkedin_app/Login.html')

def employes(request):
    return render(request, 'linkedin_app/Employes.html')
