#!usr/bin/python

class Node:
    def __init__(self):
        self.element = None
        self.next = None
        
    def __str__(self):
        return str(self.element)

class pointerstack:
    def __init__(self):
        self.top = None

#return the element at the top of stack S
    def TOP(self,S) :
        return S.top

#delete the top element of the stack S
    def POP(self,S) :
        S.top = S.top.next
        return

#insert the element x at the top of stack S
    def PUSH(self,x, S) :
        top = Node()
        top.element = x
        top.next = S.top
        S.top = top
        return

#return true if S is an empty stack
    def EMPTY(self,S) :
        if S.top is None :
            return True
        else :
            return False

#make stack S be an empty stack
    def MAKENULL(self) :
        temp = pointerstack()
        return temp


#time testing functions start here !!!!!!!
def PUSHTIMING() :
    S = pointerstack()
    for i in range(0, maxlength) :
        S.PUSH(i,S)

def POPTIMING() :
    S = pointerstack()
    for i in range(0, maxlength) :
        S.PUSH(i,S)
    for i in range(0, maxlength) :
        S.POP(S)

def TIMING() :
    S = pointerstack()

n = 500
maxlength = 500
