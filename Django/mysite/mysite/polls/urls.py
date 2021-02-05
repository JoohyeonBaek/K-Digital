from django.urls import path
from polls import views
app_name = "polls"
urlpatterns = [
    path('', views.index, name='index'), # 질문 리스트
    # ex: /polls/5/vote
    # tag-extension를 확장하여 사용하는 방법으로 변경
    path('<int:question_id>/', views.detail, name='detail'), # 한개의 질문과 응답에 대한 선택 화면
    path('<int:question_id>/results/', views.results, name='results'), # 결과를 표현
    path('<int:question_id>/vote/', views.vote, name='vote'), # 선택한 것을 누적
#    path('choice_graph/', views.choice_graph, name='choice_graph'), # 그라프로 출력
]