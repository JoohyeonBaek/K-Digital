import sys
from random import randint

def userInput():
    user = int(input("숫자를 입력하세요 ( 가위(0), 바위(1), 보(2) ) : "))
    return user

def judge(com, person):
    result = ""
    win = 0
    lose = 0
    draw = 0

    if(person == com):
        result = 'draw'
        draw +=1
                
    elif(person+1 == com):
        result = 'lose'
        lose += 1
               
    else:
        result = 'win'
        win += 1

    resultPrint(com,person,result)
    return win, draw, lose

def resultPrint(com, person, result):
    print("com :",com,"you :",person)
    print("결과 :",result)



def finalPrint(win, draw, lose):
    print("10전",win,"승",draw,"무",lose,"패")

def main():
    win = 0
    lose = 0
    draw = 0

    for i in range(0,10):
        com = randint(1,3)
        user = userInput()
            
        thisWin, thisDraw, thisLose = judge(com, user)
        win += thisWin
        draw += thisDraw
        lose += thisLose
        
        

    finalPrint(win, draw, lose)
    

main()

