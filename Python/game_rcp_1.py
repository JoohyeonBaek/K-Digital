# 가위바위보 게임1

import sys
from random import randint


com = randint(1,3)
person = int(input("숫자를 입력하세요 ( 가위(0), 바위(1), 보(2) ) : "))

if(person == 0):
    if(com==0):
        print("You draw")
    elif(com==1):
        print("You lose")
    else:
        print("You win")

elif(person == 1):
    if(com==0):
        print("You win")
    elif(com==1):
        print("You draw")
    else:
        print("You lose")

else:
    if(com==0):
        print("You lose")
    elif(com==1):
        print("You win")
    else:
        print("You draw")

