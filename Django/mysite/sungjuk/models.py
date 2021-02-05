from django.db import models
from django.urls import reverse

class Sungjuk(models.Model):
    name = models.CharField("이름", max_length=50, unique=False)
    kor = models.IntegerField("국어", default=0)
    mat = models.IntegerField("수학", default=0)
    eng = models.IntegerField("영어", default=0)
    tot = models.IntegerField("총점", default=0)
    avg = models.FloatField("평균",  default=0)

    def __str__(self):
        return self.name
    @property
    def tot(self):
        return self.kor + self.mat + self.eng
    @property
    def avg(self):
        return round((self.kor + self.mat + self.eng) / 3, 2)
    def get_absolute_url(self):
        return reverse('server_edit', kwargs={'pk': self.pk})
    class Meta:
        verbose_name = '성적'
        verbose_name_plural = '성적셋'
        ordering = ['name']
