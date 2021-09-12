#!/usr/bin/python

import random
import timeit
import sys


def swap(l, i, j):
	t = l[i]
	l[i] = l[j]
	l[j] = t

def down(l, a, b):
	large = 2 * a + 1
	while large <= b:
		if (large < b) and (l[large] < l[large + 1]):
			large += 1
		if l[large] > l[a]:
			swap(l, large, a)
			a = large;
			large = 2 * a + 1
		else:
			return

def make_heap(l):
	length = len(l) - 1
	small = length / 2
	for n in range (small, -1, -1):
		down(l, n, length )
	for i in range (length, 0, -1):
		if l[0] > l[i]:
			swap( l, 0, i )
			down( l, 0, i - 1 )

s = [2,0,1]
mytime = timeit.Timer( 'make_heap(s)', 'from __main__ import make_heap, s' )
delta = mytime.timeit( 1 )
print "n = 3   T(3) = " + str( delta ) + " seconds)"

s = [2,3,0,1]
mytime = timeit.Timer( 'make_heap(s)', 'from __main__ import make_heap, s' )
delta = mytime.timeit( 1 )
print "n = 4   T(4) = " + str( delta ) + " seconds)"

s = [3,2,4,0,1]
mytime = timeit.Timer( 'make_heap(s)', 'from __main__ import make_heap, s' )
delta = mytime.timeit( 1 )
print "n = 5   T(5) = " + str( delta ) + " seconds)"

s = [2,3,0,1,5,4]
mytime = timeit.Timer( 'make_heap(s)', 'from __main__ import make_heap, s' )
delta = mytime.timeit( 1 )
print "n = 6   T(6) = " + str( delta ) + " seconds)"

s = [4,5,3,2,6,0,1]
mytime = timeit.Timer( 'make_heap(s)', 'from __main__ import make_heap, s' )
delta = mytime.timeit( 1 )
print "n = 7   T(7) = " + str( delta ) + " seconds)"

s = [2,0,6,7,1,3,5,4]
mytime = timeit.Timer( 'make_heap(s)', 'from __main__ import make_heap, s' )
delta = mytime.timeit( 1 )
print "n = 8   T(8) = " + str( delta ) + " seconds)"

s = [8,2,0,1,6,7,5,4,3]
mytime = timeit.Timer( 'make_heap(s)', 'from __main__ import make_heap, s' )
delta = mytime.timeit( 1 )
print "n = 9   T(9) = " + str( delta ) + " seconds)"

s = [2,9,0,8,1,3,7,6,4,5,]
mytime = timeit.Timer( 'make_heap(s)', 'from __main__ import make_heap, s' )
delta = mytime.timeit( 1 )
print "n = 10   T(10) = " + str( delta ) + " seconds)"

s = [9,8,6,7,4,10,5,3,2,0,1]
mytime = timeit.Timer( 'make_heap(s)', 'from __main__ import make_heap, s' )
delta = mytime.timeit( 1 )
print "n = 11   T(11) = " + str( delta ) + " seconds)"

s = [2,0,5,6,4,7,3,8,1,11,9,10]
mytime = timeit.Timer( 'make_heap(s)', 'from __main__ import make_heap, s' )
delta = mytime.timeit( 1 )
print "n = 12   T(12) = " + str( delta ) + " seconds)"

s = [1,0,3,2,4,7,9,6,10,8,11,5,12]
mytime = timeit.Timer( 'make_heap(s)', 'from __main__ import make_heap, s' )
delta = mytime.timeit( 1 )
print "n = 13   T(13) = " + str( delta ) + " seconds)"

s = [1,0,13,3,12,2,11,4,10,9,6,8,5,7]
mytime = timeit.Timer( 'make_heap(s)', 'from __main__ import make_heap, s' )
delta = mytime.timeit( 1 )
print "n = 14   T(14) = " + str( delta ) + " seconds)"

s = [2,0,1,11,3,12,10,9,13,8,5,14,7,4,6]
mytime = timeit.Timer( 'make_heap(s)', 'from __main__ import make_heap, s' )
delta = mytime.timeit( 1 )
print  "n = 15   T(15) = " + str( delta ) + " seconds)"
