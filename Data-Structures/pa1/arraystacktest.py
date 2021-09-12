#!usr/bin/python

from arraystack import arraystack

L = arraystack()
L.element = [0,0,0,1,2,3]
L.last = 5
print '\n[TEST]\t\tarraystack.TOP()'
assert (L.TOP() == 3)
print '\n[TEST]\t\tarraystack.POP()'
L.POP()
assert (L.TOP() == 2)
print '\n[TEST]\t\tarraystack.PUSH()'
L.PUSH(3,L)
assert (L.TOP() == 3)
print '\n[TEST]\t\tarraystack.EMPTY()'
assert (L.EMPTY(L) == False)
print '\n[TEST]\t\tarraystack.MAKENULL()'
assert (L.MAKENULL().last == 0)
print '\n[PASSED]\t5 TEST\n'