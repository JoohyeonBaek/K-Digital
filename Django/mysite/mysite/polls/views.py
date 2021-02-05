from django.shortcuts import render
from django.shortcuts import render, get_object_or_404
from django.http import HttpResponseRedirect
from django.urls import reverse
from django.views.generic.list import ListView
from .models import Question, Choice
from django.utils import timezone

from django.http import HttpResponse
import matplotlib
matplotlib.use('Agg')
import matplotlib.pyplot as plt
import pandas as pd
# 디폴트 매니져 objects
def index(request):
    latest_question_list = Question.objects.all().order_by('-pub_date')[:5] # 역순정렬
    context = {'latest_question_list': latest_question_list}
    return render(request, 'polls/index.html', context)

def detail(request, question_id):
    question = get_object_or_404(Question, pk=question_id) # 조인연산  choice_set
    return render(request, 'polls/detail.html', {'question': question})

def results(request, question_id):
    question = get_object_or_404(Question, pk=question_id) # dictionary 형태로 데이터 전달
    return render(request, 'polls/results.html', {'question': question})

def vote(request, question_id):
    p = get_object_or_404(Question, pk=question_id)
    try:
        selected_choice = p.choice_set.get(pk=request.POST['choice'])# form은 POST방식으로
    except (KeyError, Choice.DoesNotExist):
        return render(request, 'polls/detail.html', {
            'question': p,
            'error_message': "선택하지 않았습니다.",
        })
    else:
        selected_choice.votes += 1 # 투표한 회수가 거장
        selected_choice.save() # update
        return HttpResponseRedirect(reverse('polls:results', args=(p.id,)))

