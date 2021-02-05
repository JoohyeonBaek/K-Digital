from django.conf.urls import url
from sungjuk import views

app_name = 'sungjuk'
urlpatterns = [
    url(r'^$', views.SungjukList.as_view(), name="sungjuk_list"),
    url(r'^new$', views.SungjukCreate.as_view(), name="sungjuk_new"),
    url(r'^edit/(?P<pk>\d+)$', views.SungjukUpdate.as_view(), name="sungjuk_edit"),
    url(r'^delete/(?P<pk>\d+)$', views.SungjukDelete.as_view(), name="sungjuk_delete"),
    url(r'^graph/(?P<pk>\d+)$', views.SungjukGraph.as_view(), name="sungjuk_graph"),
]
