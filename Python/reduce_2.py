def salary(time):
    return 10000 + time*15000
timeList = [160,150,120,180,300,400]
salList = list(map(salary, timeList))

print(salList)
reduce(lambda x,y: x+y, salList)