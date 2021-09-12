#!usr/bin/python

from arraylist import arraylist

L = arraylist()
L.element = [3,2,1,0,0,0]
L.last = 5
print '\n[TEST]\t\tarraylist.END()'
assert (L.END() == 5)
print '\n[TEST]\t\tarraylist.FIRST()'
assert (L.FIRST() == 3)
print '\n[TEST]\t\tarraylist.RETRIEVE()'
assert (L.RETRIEVE(2,L) == 1)
print '\n[TEST]\t\tarraylist.LOCATE()'
assert (L.LOCATE(1,L) == 2)
print '\n[TEST]\t\tarraylist.NEXT()'
assert (L.NEXT(0,L) == 1)
print '\n[TEST]\t\tarraylist.PREVIOUS()'
assert (L.PREVIOUS(3,L) == 2)
print '\n[TEST]\t\tarraylist.INSERT()'
L.INSERT(5,4,L)
assert (L.RETRIEVE(4,L) == 5)
print '\n[TEST]\t\tarraylist.DELETE()'
L.DELETE(0,L)
assert (L.RETRIEVE(0,L) == 2)
print '\n[TEST]\t\tarraylist.MAKENULL()'
L.MAKENULL()
assert (L.last == 5 and L.FIRST() == None)
print '\n[PASSED]\t9 TEST\n'
