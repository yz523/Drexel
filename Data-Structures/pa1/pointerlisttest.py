#!usr/bin/python

from pointerlist import pointerlist

L = pointerlist()
L.INSERT(1,0,L)
L.INSERT(2,0,L)
L.INSERT(3,0,L)
L.INSERT(4,0,L)
print '\n[TEST]\t\tpointerlist.END()'
assert (L.END().element == 1)
print '\n[TEST]\t\tpointerlist.FIRST()'
assert (L.FIRST().element == 4)
print '\n[TEST]\t\tpointerlist.RETREIVE()'
assert (L.RETREIVE(2,L) == 3)
print '\n[TEST]\t\tpointerlist.LOCATE()'
assert (L.LOCATE(1,L) == 3)
print '\n[TEST]\t\tpointerlist.NEXT_()'
assert (L.NEXT_(L.FIRST()).element == 3)
print '\n[TEST]\t\tpointerlist.PREVIOUS()'
assert (L.PREVIOUS(L) == None)
print '\n[TEST]\t\tpointerlist.INSERT()'
L.INSERT(1,1,L)
assert (L.RETREIVE(1,L) == 1) 
print '\n[TEST]\t\tpointerlist.DELETE()'
L.DELETE(0,L)
assert (L.RETREIVE(0,L) == None)
print '\n[TEST]\t\tpointerlist.MAKENULL()'
L.MAKENULL()
assert (L.END() == None)
print '\n[PASSED]\t9 TEST\n'

