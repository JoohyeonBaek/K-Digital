#가위바위보 게임2

import sys
from random import randint

win = 0
lose = 0
draw = 0
for i in range(0,10):
    com = randint(1,3)
    person = int(input("숫자를 입력하세요 ( 가위(0), 바위(1), 보(2) ) : "))
    print("com :",com,"you :",person)

    if(person == com):
        print("you draw")
        draw+=1
    elif(person+1 == com):
        print("you lose")
        lose += 1
    else:
        print("you win")
        win +=1

print("10전" + win,"승",draw,"무",lose,"패")