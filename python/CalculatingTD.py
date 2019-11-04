import numpy as np
import matplotlib.pyplot as plt
from math import pow
x = [1,2,2,3,7]
y = [3,2,4,3,3]
plt.plot(x, y, 'ro')
plt.show()
centroidX = [0]
i = 0
while i<len(x):
    centroidX[0] += x[i]
    i+=1
centroidX[0]=centroidX[0]/len(x)
centroidY = [0]
i = 0
while i<len(y):
    centroidY[0] += y[i]
    i+=1
centroidY[0]=centroidY[0]/len(y)
x += centroidX
y += centroidY
print(centroidX)
print(centroidY)
plt.plot(x,y,'ro')
plt.show()
j = 0
dist = 0
while j<len(x)-1:
    dist += (pow(x[j]-x[len(x)-1],2)+pow(y[j]-y[len(y)-1],2))
print(dist)
    j+=1