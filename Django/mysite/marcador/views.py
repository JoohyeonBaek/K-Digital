from django.shortcuts import render
from django.contrib.auth.decorators import login_required
from django.contrib.auth.models import User
from django.core.exceptions import PermissionDenied
from django.shortcuts import get_object_or_404, redirect

from django.core.paginator import Paginator, EmptyPage, PageNotAnInteger
from .forms import BookmarkForm
from .models import Bookmark

def bookmark_list(request):
    bookmarks = Bookmark.public.all()
    page = request.GET.get('page', 1)
    paginator = Paginator(bookmarks, 5) # 한 페이지당 5개
    try:
        bookmarks_page = paginator.page(page)
    except PageNotAnInteger:
        bookmarks_page = paginator.page(1)
    except EmptyPage:
        bookmarks_page = paginator.page(paginator.num_pages)
    context = {'bookmarks': bookmarks_page}
    return render(request, 'marcador/bookmark_list.html', context)

def bookmark_user(request, username):
    user = get_object_or_404(User, username=username)
    if request.user == user:
        bookmarks = user.bookmarks.all()
    else:
        bookmarks = Bookmark.public.filter(owner__username=username)
    context = {'bookmarks': bookmarks, 'owner': user}
    return render(request, 'marcador/bookmark_user.html', context)

@login_required
def bookmark_create(request):
    if request.method == 'POST':
        form = BookmarkForm(data=request.POST)
        if form.is_valid():
            bookmark = form.save(commit=False)
            bookmark.owner = request.user
            bookmark.save()
            form.save_m2m()
            return redirect('marcador:marcador_bookmark_user', username=request.user.username)
    else:
        form = BookmarkForm()
    context = {'form': form, 'create': True}
    return render(request, 'marcador/form.html', context)

@login_required
def bookmark_edit(request, pk):
    bookmark = get_object_or_404(Bookmark, pk=pk)
    if bookmark.owner != request.user and not request.user.is_superuser:
        raise PermissionDenied
    if request.method == 'POST':
        form = BookmarkForm(instance=bookmark, data =request.POST)
        if form.is_valid():
            form.save()
            return redirect('marcador:marcador_bookmark_user',
                            username = request.user.username)
    else:
        form = BookmarkForm(instance=bookmark)
    context = {'form': form, 'create':False}
    return render(request, 'marcador/form.html', context)