from django.shortcuts import render

from django.views.generic import TemplateView, ListView, DetailView
from django.views.generic.edit import CreateView, UpdateView, DeleteView
from django.urls import reverse_lazy
from .models import Sungjuk


class SungjukList(ListView): # select -> 자동으로 db이름_list
    model = Sungjuk

class SungjukCreate(CreateView):
    model = Sungjuk
    success_url = reverse_lazy('sungjuk:sungjuk_list') # 클래스에서 로딩전에 주소를 알아야 할 경우에 저장
    fields = ['name', 'kor', 'mat', 'eng']

class SungjukUpdate(UpdateView): # 폼을 보여주는데 데이터를 달아서 보여줌
    model = Sungjuk
    success_url = reverse_lazy('sungjuk:sungjuk_list')
    fields = ['name', 'kor', 'mat', 'eng']

class SungjukDelete(DeleteView):
    model = Sungjuk
    success_url = reverse_lazy('sungjuk:sungjuk_list')

class SungjukGraph(DetailView):
    model = Sungjuk
    success_url = reverse_lazy('sungjuk:sungjuk_list') # 클래스에서 로딩전에 주소를 알아야 할 경우에 저장
    fields = ['name', 'kor', 'mat', 'eng']

# class sungjukdetail(DetailView):
#     model = Sungjuk
#     field = ['name', 'kor', 'mat', 'eng', 'tot', 'avg']
#     template_name = 'sungjuk/detail.html'
#     context_object_name = 'sungjuk'
#
# from django.http import HttpResponse
# import matplotlib
# matplotlib('Agg')
# import matplotlib.pyplot as plt
# import pandas as pd
# import io
# from matplotlib.backends.backend_agg import FigureCanvasAgg
# import numpy
# def sunggraph():
#     fig = plt.figure(figsize=(6, 4.5), dpi=80, facecolor='w', edgecolor='w')
#     ax = fig.add_subplot(111)
#     chdata = Sungjuk.objects.get(pk=pe_id)
#     print(type(chdata))
#     print(chdata)
#     sel = [chdata.kor, chdata.mat, chdata.eng]
#     print(sel)
#     df = pd