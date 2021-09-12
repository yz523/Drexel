#!usr/bin/python

from timeit import Timer

def InsertFront() :
	L = [0]*n
	for i in range(0, n) :
		L.insert(0, 1)

def InsertBack() :
	L = [0]*n
	for i in range(0, n) :
		L.append(1)

def TRAVERSAL() :
	L = [0]*n
	for i in range(len(L)) :
		x = L[i]

def DeleteFront() :
	L = [0]*n
	for i in range(0, n) :
		del L[0]

def DeleteBack() :
	L = [0]*n
	for i in range(0, n) :
		del L[-1]

def PUSHTIMING() :
    S = [0]*n
    for i in range(0,n) :
        S.append(i)

def POPTIMING() :
    S = [0]*n
    for i in range(0,n) :
        S.append(i)
    for i in range(0,n) :
        S.pop()

def TIMING() :
	L = [0]*n

maxlength = 500
n=500

print "When input n = 500, python list library is: "

t = Timer("TIMING()", "from __main__ import TIMING")
inputtime = t.timeit(maxlength)/(maxlength*n)
    
t = Timer("InsertFront()", "from __main__ import InsertFront")
InsertFronttime = t.timeit(maxlength)/(maxlength*n)
print "Front insert: \t", InsertFronttime-inputtime
	
t = Timer("InsertBack()", "from __main__ import InsertBack")
InsertBacktime = t.timeit(maxlength)/(maxlength*n)
print "Back insert: \t", InsertBacktime-inputtime
	
t = Timer("TRAVERSAL()", "from __main__ import TRAVERSAL")
TRAVERSALtime = t.timeit(maxlength)/(maxlength*n)
print "TRAVERSAL: \t", TRAVERSALtime-inputtime
	
t = Timer("DeleteFront()", "from __main__ import DeleteFront")
DeleteFronttime = t.timeit(maxlength)/(maxlength*n)
print "Front delete: \t", DeleteFronttime-inputtime
	
t = Timer("DeleteBack()", "from __main__ import DeleteBack")
DeleteBacktime = t.timeit(maxlength)/(maxlength*n)
print "Back delete: \t", DeleteBacktime-inputtime
print

print "When input n = 500, arraylist implementation of ADT is: "

t = Timer("TIMING()", "from arraylist import TIMING")
inputtime = t.timeit(maxlength)/(maxlength*n)

t = Timer("InsertFront()", "from arraylist import InsertFront")
InsertFronttime = t.timeit(maxlength)/(maxlength*n)
print "Front insert: \t", InsertFronttime-inputtime

t = Timer("InsertBack()", "from arraylist import InsertBack")
InsertBacktime = t.timeit(maxlength)/(maxlength*n)
print "Back insert: \t", InsertBacktime-inputtime

t = Timer("TRAVERSAL()", "from arraylist import TRAVERSAL")
TRAVERSALtime = t.timeit(maxlength)/(maxlength*n)
print "TRAVERSAL: \t", TRAVERSALtime-inputtime

t = Timer("DeleteFront()", "from arraylist import DeleteFront")
DeleteFronttime = t.timeit(maxlength)/(maxlength*n)
print "Front delete: \t", DeleteFronttime-inputtime

t = Timer("DeleteBack()", "from arraylist import DeleteBack")
DeleteBacktime = t.timeit(maxlength)/(maxlength*n)
print "Back delete: \t", DeleteBacktime-inputtime
print

print "When input n = 500, pointerlist implementation of ADT is: "

t = Timer("TIMING()", "from __main__ import TIMING")
inputtime = t.timeit(maxlength)/(maxlength*n)

t = Timer("InsertFront()", "from pointerlist import InsertFront")
InsertFronttime = t.timeit(maxlength)/(maxlength*n)
print "Front insert: \t", InsertFronttime-inputtime

t = Timer("InsertBack()", "from pointerlist import InsertBack")
InsertBacktime = t.timeit(maxlength)/(maxlength*n)
print "Back insert: \t", InsertBacktime-inputtime

t = Timer("TRAVERSAL()", "from pointerlist import TRAVERSAL")
TRAVERSALtime = t.timeit(maxlength)/(maxlength*n)
print "TRAVERSAL: \t", TRAVERSALtime-InsertFronttime

t = Timer("DeleteFront()", "from pointerlist import DeleteFront")
DeleteFronttime = t.timeit(maxlength)/(maxlength*n)
print "Front delete: \t", DeleteFronttime-InsertFronttime

t = Timer("DeleteBack()", "from pointerlist import DeleteBack")
DeleteBacktime = t.timeit(maxlength)/(maxlength*n)
print "Back delete: \t", DeleteBacktime-InsertFronttime
print

print "When input n =500, python stack library is: "

t = Timer("PUSHTIMING()", "from __main__ import PUSHTIMING")
pushtime = t.timeit(maxlength)/(maxlength*n)
print "push: \t", pushtime-inputtime

t = Timer("POPTIMING()", "from __main__ import POPTIMING")
poptime = t.timeit(maxlength)/(maxlength*n)
print "pop: \t", poptime-inputtime
print

print "When input n = 500, arraystack implementation of ADT is: "
t = Timer("TIMING()", "from arraystack import TIMING")
inputtime = t.timeit(maxlength)/(maxlength*n)

t = Timer("PUSHTIMING()", "from arraystack import PUSHTIMING")
pushtime = t.timeit(maxlength)/(maxlength*n)
print "push: \t", pushtime-inputtime


t = Timer("POPTIMING()", "from arraystack import POPTIMING")
poptime = t.timeit(maxlength)/(maxlength*n)
print "pop: \t", poptime-inputtime
print

print "When input n = 500, pointerstack implementation of ADT is: "
t = Timer("TIMING()", "from pointerstack import TIMING")
inputtime = t.timeit(maxlength)/(maxlength*n)

t = Timer("PUSHTIMING()", "from pointerstack import PUSHTIMING")
pushtime = t.timeit(maxlength)/(maxlength*n)
print "push: \t", pushtime-inputtime


t = Timer("POPTIMING()", "from pointerstack import POPTIMING")
poptime = t.timeit(maxlength)/(maxlength*n)
print "pop: \t", poptime-inputtime
print