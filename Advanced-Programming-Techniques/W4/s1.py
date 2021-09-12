#!/usr/bin/python

import sys

#input students file
f = open("students", "r")

#start reading file
l = f.readline()

while l :
   #split each data by a space
   w = l.split(" ")
   #get the number part's length
   s = len(w[1:])
   #get the name of each line
   name = w[:1]
   #initialize the counter from 1
   i = 1
   total = 0
   #add each number to total, increase counter by 1
   while i<=s :
      total += float(w[i])
      i+=1
   #calculate the average
   average = int(round(total/s))

   #output
   for n in name:
      print(n)," ",(average)
#read next linen
   l = f.readline()
