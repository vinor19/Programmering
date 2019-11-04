import numpy as np
import matplotlib.pyplot as plt
import random as random
points = [[2,3],[3,4],[1,5],[6,8],[7,8],[7,9],[10,1]]
Clusterpoint1 = [1,1]
Clusterpoint2 = [0,5]
Clusterpoint3 = [10,0]
cluster1 = []
cluster2 = []
cluster3 = []
i = 0
while i<len(points):
    Statement1 = (Clusterpoint1[0]-points[i][0])*(Clusterpoint1[0]-points[i][0]) + (Clusterpoint1[1]-points[i][1])*(Clusterpoint1[1]-points[i][1]) < (Clusterpoint2[0]-points[i][0])*(Clusterpoint2[0]-points[i][0]) + (Clusterpoint2[1]-points[i][1])*(Clusterpoint2[1]-points[i][1])
    Statement2 = (Clusterpoint1[0]-points[i][0])*(Clusterpoint1[0]-points[i][0]) + (Clusterpoint1[1]-points[i][1])*(Clusterpoint1[1]-points[i][1]) < (Clusterpoint3[0]-points[i][0])*(Clusterpoint3[0]-points[i][0]) + (Clusterpoint3[1]-points[i][1])*(Clusterpoint3[1]-points[i][1])
    Statement3 = (Clusterpoint2[0]-points[i][0])*(Clusterpoint2[0]-points[i][0]) + (Clusterpoint2[1]-points[i][1])*(Clusterpoint2[1]-points[i][1]) < (Clusterpoint3[0]-points[i][0])*(Clusterpoint3[0]-points[i][0]) + (Clusterpoint3[1]-points[i][1])*(Clusterpoint3[1]-points[i][1])
    print(Statement1)
    if Statement1 and Statement2:
        cluster1 += [points[i]]
        print("cluster1")
        print(cluster1)
    else:
        if Statement3:
            cluster2 += [points[i]]
            print("cluster2")
            print(cluster2)
        else:
            cluster3 += [points[i]]
            print("cluster3")
            print(cluster3)
    i+=1
print(cluster1)
print(cluster2)
print(cluster3)
centroid1X = [0]
i = 0
while i<len():
    centroid1X[0] += cluster1[i][0]
    i+=1
centroid1X[0]=centroid1X[0]/len(cluster1)

centroid1Y = [0]
i = 0
while i<len():
    centroid1Y[0] += cluster1[i][1]
    i+=1
centroid1Y[0]=centroid1Y[0]/len(cluster1)
plt.plot(cluser1[0][0],cluser1[][1],'ro')
