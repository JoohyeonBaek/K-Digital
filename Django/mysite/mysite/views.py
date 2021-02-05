from django.shortcuts import render, get_object_or_404
from django.http import HttpResponseRedirect
from django.urls import reverse

from django.views.generic.base import TemplateView

class HomeView(TemplateView):
    template_name = 'home.html'
    def get_context_data(self, **kwargs):# 오버라이딩 ( 데이터 추가할 것을 매개변수로 전달함 )
        context = super(HomeView, self).get_context_data(**kwargs)
        return context

def show_pandas(request):
    return render(request, 'pandas_graph.html')

import matplotlib # 시각화 패키지 => seaborn( 모델 시각화 )
matplotlib.use('Agg') # backend agg buffer 를 이용
import matplotlib.pyplot as plt
from django.http import HttpResponse
import numpy as np  # 행렬 + 선형대수
import pandas as pd # numpy를 하부구조로 사람이 사용하는 분석데이터 저장\0 : Series(1차원:동질적 ), DataFrame( 열내 동질적 열간이질적)

import io
from matplotlib.backends.backend_agg import FigureCanvasAgg
def pandasgraph(request): # 메모리에서 이미지 생성
    fig=plt.figure(figsize=(6, 4.5), dpi=80, facecolor='w', edgecolor='w')
    ax=fig.add_subplot(111)# 화면분활 223 - 도화지
    f=pd.DataFrame({'y':np.random.randn(10),'z':np.random.randn(10)}, # normal 정규분포
                   index=pd.period_range('1-2000',periods=10))
    f.plot(ax=ax) # 산포도
#   plt.show()
    buf = io.BytesIO() # 메모리에 화일을 출력
    canvas = FigureCanvasAgg(fig)# 이미지를 화일로 변경하려면 agg 버퍼를 사용해야 함
    canvas.print_png(buf) # 메모리에다 화일을 만들어라
    fig.clear()
    # canvas=FigureCanvas(fig)
    response=HttpResponse(buf.getvalue(), content_type='image/png') # 이미지를 전송할 때는 사이즈도 같이 전송
    response['Content-Length'] = str(len(response.content)) # 숫자를 문자로 생성
    return response

def chart_csv(request):
    fig = plt.figure()
    ax = fig.add_subplot(111)# 도화지
    data_df = pd.read_csv("C:/djangowok/mysite/static/AirPassengers.csv")

    data_df = pd.DataFrame(data_df)
    data_df.plot(ax=ax)# 그라프를 내부에 파지
    buf = io.BytesIO()
    canvas = FigureCanvasAgg(fig)
    canvas.print_png(buf)
    fig.clear()
    response = HttpResponse(buf.getvalue(), content_type="image/png")
    response['Content-Length']=str(len(response.content))
    return response