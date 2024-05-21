from django.urls import path
from . import views
urlpatterns = [
    path('', views.home, name='app_home'),
    path('login/', views.login, name='app_login'),
    path('employes', views.employes, name='app_employes')

]