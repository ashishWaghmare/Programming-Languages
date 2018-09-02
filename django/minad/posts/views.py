from django.shortcuts import render
from django.http import HttpResponse
# Create your views here.
from .models import Posts

def index(request):
    posts =Posts.objects.all()[:10]  

    context = {
        'title':'Awesome Blog',
        'posts':posts
    }
    return render(request, 'posts/index.html',context)

def details(request,id):
    post = Posts.object.get(id=id)
    context = {
        'post':post
    }