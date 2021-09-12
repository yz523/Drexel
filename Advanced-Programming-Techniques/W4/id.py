#!/usr/bin/python

import sys

#input ids file
f = open("ids", "r")

#start reading file
l = f.readline()
#create a set variable d
d = {}

while l:
	#split each line to two parts: the key and the name, by first space
	s = l.split(" ",1)
	#create the set for each set of data
	d[int(s[0])] = s[1]
	
	#read next line
	l = f.readline()

#output
for k in sorted(d):
	print(k)," ",(d[k])
