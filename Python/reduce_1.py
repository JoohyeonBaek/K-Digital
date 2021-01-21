# 1) 50까지의 수중에 3의 배수의 합을 구하시오

def odd(k):
    return not k%3
myList = list(filter(odd,range(1,51)))
from functools import reduce
reduce(lambda x,y: x+y, myList)



