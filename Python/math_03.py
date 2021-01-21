# 입력되는 두변의 길이를 이용해서 그 사이각을 구하시오

import math

a = int(input())
b = int(input())
tan = b/a
theta = 0
for i in range(1,91):
    if(math.tan(i) == tan):
        theta = i
        break


print(theta)