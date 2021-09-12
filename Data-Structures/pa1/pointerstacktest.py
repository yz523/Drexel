#!usr/bin/python

from pointerstack import pointerstack

L = pointerstack()
for i in range(0,5) :
	L.PUSH(i,L)
print '\n[TEST]\t\tpointerstack.TOP()'
assert (L.TOP(L).element == 4)
print '\n[TEST]\t\tpointerstack.POP()'
L.POP(L)
assert (L.TOP(L).element == 3)
print '\n[TEST]\t\tpointerstack.PUSH()'
L.PUSH(3,L)
assert (L.TOP(L).element == 3)
print '\n[TEST]\t\tpointerstack.EMPTY()'
assert (L.EMPTY(L) == False)
print '\n[TEST]\t\tpointerstack.MAKENULL()'
assert (L.MAKENULL().top == None)
print '\n[PASSED]\t5 TEST\n'

