#!/usr/bin/python

import random
import timeit
import problem1
import problem2
import sys
mytime = timeit.Timer( 'main', 'from problem1 import main' )
delta = mytime.timeit( 1 )
print "Fib-normal("+sys.argv[1]+", " + str( delta ) + " seconds)"
mytime = timeit.Timer( 'main', 'from problem2 import main' )
delta = mytime.timeit( 1 )
print "Fib-memo("+sys.argv[1]+", " + str( delta ) + " seconds)"
