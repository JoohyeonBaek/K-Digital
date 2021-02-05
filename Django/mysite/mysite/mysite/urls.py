"""mysite URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/3.1/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
# 파이썬은 대소문자 구분함
from django.contrib import admin
from django.urls import path
from django.conf.urls import url, include
from mysite import views
from django.conf.urls.static import static
from django.conf import settings
# 정규표현식에서 ^:begin, $:end : http://127.0.0.1/
# http://127.0.0.1/admin


urlpatterns = [
    path('admin/', admin.site.urls),
    url(r'^$', views.HomeView.as_view(), name='home'),
    url(r'^pandasgraph', views.pandasgraph, name='pandasgraph'),
    url(r'^chart_csv/$', views.chart_csv, name='chart_csv'),
    url(r'^show_pandas', views.show_pandas, name='show_pandas'),
    url(r'^polls/', include('polls.urls')),
#   url(r'^polls/', include('polls', namespace='polls')),
]
urlpatterns += static(settings.STATIC_URL, document_root=settings.STATIC_ROOT)