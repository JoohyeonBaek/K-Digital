#가위바위보 게임2

import sys
from random import randint


com = randint(1,3)
person = int(input("숫자를 입력하세요 ( 가위(0), 바위(1), 보(2) ) : "))

if(person == com):
    print("you draw")
elif(person+1 == com):
    print("you lose")
else:
    print("you win")