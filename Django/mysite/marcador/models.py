from django.db import models
from django.contrib.auth.models import User
from django.utils.timezone import now

#custom manager : 장고/개발자

class PublicBookmarkManager(models.Manager): #누구나 볼 수 있는것만 작업
    def get_queryset(self): # 오버라이딩
        qs=super(PublicBookmarkManager, self).get_queryset()
        return qs.filter(is_public=True)
# relation 관계를 맺고있음
class Tag(models.Model): # 테이블
    name = models.CharField(max_length=50, unique=True)
    class Meta:
        verbose_name ='tag'
        verbose_name_plural = 'tags'
        ordering =['name']
    def __str__(self):
        return self.name

class Bookmark(models.Model): # create(insert, save(update), get(1개의 데이터를 가지고 온다는 전제조건,, all(), filter(조건)
    url = models.URLField() # http://www.naver.com
    title = models.CharField('title', max_length=255) # 네이버
    description = models.TextField('description', blank=True) # 일반적으로 검색 할떄 사용
    is_public = models.BooleanField('public', default=True) # 공개 여부
    date_created = models.DateTimeField('date created')
    date_updated = models.DateTimeField('date updated')
    # createsuperuser : username, email, password, group, is_staff, is_active, is_superuser, last_login, date_joined
    owner = models.ForeignKey(User, verbose_name='owner', related_name='bookmarks', on_delete=models.CASCADE)
    tags = models.ManyToManyField(Tag, blank=True) #  검색 , 통계학습, 머신러닝, 딥러닝, 4차산업
    object = models.Manager()
    public = PublicBookmarkManager() # 여러개의 매니저가 가능

    class Meta:
        verbose_name = 'bookmark'
        verbose_name_plural = 'bookmarks'
        ordering = ['-date_created']
    def __str__(self):
        return '%s (%s)' % (self.title, self.url)
    def save(self, *args, **kwargs):
        if not self.id:
            self.date_created = now()
        self.date_updated = now()
        super(Bookmark,self).save(*args,**kwargs)

# Create your models here.