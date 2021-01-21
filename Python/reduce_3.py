import math


myList = [1,2,3,4,5]
sqrtList = list(map(math.sqrt,myList))

reduce(lambda x,y: x*y, sqrtList)