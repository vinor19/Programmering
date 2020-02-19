import random
n = 2
listOfInts = list(range(0,n))
random.shuffle(listOfInts)
print(listOfInts)


tempList = listOfInts
print(tempList)

howMany = 0
for n in listOfInts:
    if(n!=-1):
        i=n
        while(i!=-1):
            temp=tempList[i]
            tempList[i]=-1
            i=temp
        howMany=howMany+1
print(howMany)