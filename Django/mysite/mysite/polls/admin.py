from django.contrib import admin
# 장고는 디폴트로 admin site를 가지고 있음 : 모델을 관리페이지에 등록 하는 곳
# Register your models here.
from django.contrib import admin
from .models import Question, Choice

class ChoiceInline(admin.TabularInline):# 표형식으로 인라인
    model = Choice
    extra = 3
class QuestionAdmin(admin.ModelAdmin):
    fieldsets = [
        ('Question Statement', {'fields': ['question_text']}),
        ('Date Information', {'fields': ['pub_date'], 'classes': ['collapse']}),
    ]
    inlines = [ChoiceInline]
    list_display = ('question_text', 'pub_date')
    list_filter = ['pub_date']
    search_fields = ['question_text']
admin.site.register(Question, QuestionAdmin)
admin.site.register(Choice)