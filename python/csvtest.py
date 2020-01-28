import numpy as np
import matplotlib.pyplot as plt
from math import pow
import csv

def init(filename):
    x = []
    y = []
    file = filename
    with open(file) as csv_file:
        csv_reader = csv.reader(csv_file, delimiter=',')
        line_count = 0
        for row in csv_reader:
            i=0
            while i<2:
                x.append(int(row[i]))
                i=i+1
                y.append(int(row[i]))
                i=i+1
            line_count += 1
    return x
def init2(filename):
    x = []
    y = []
    file = filename
    with open(file) as csv_file:
        csv_reader = csv.reader(csv_file, delimiter=',')
        line_count = 0
        for row in csv_reader:
            i=0
            while i<2:
                x.append(int(row[i]))
                i=i+1
                y.append(int(row[i]))
                i=i+1
            line_count += 1
    return y
def main(file):
    y=init2(file)
    x=init(file)
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
        j+=1
    print(dist)
    return dist