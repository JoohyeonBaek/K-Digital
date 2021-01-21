# 대각선이 3이고 그 사이각이 45도 라면 밑변의 길이와 높이를 구하시오

import math

width = 3 * math.cos(45)
height = math.sqrt(math.pow(3,2)-math.pow(width,2))

print(width, height)