from django.db import models
# 테이블 생성
# Create your models here.
from django.db import models
import datetime
from django.utils import timezone
# model/ field / argument(max_length, default)
class Question(models.Model):
    question_text = models.CharField(max_length=200)  #필드
    pub_date = models.DateTimeField('date published') # 날짜 자동입력
    def __str__(self):
        return self.question_text
    def was_published_recently(self): # new
        now = timezone.now()
        return now - datetime.timedelta(days=1) <= self.pub_date <= now # True/False
class Choice(models.Model): #
    question = models.ForeignKey(# 1:n
        'Question',  on_delete=models.CASCADE, # 질문이 지워지면 같이 지워라
    )
    choice_text = models.CharField(max_length=200)
    votes = models.IntegerField(default=0)
    def __str__(self):
        return self.choice_text