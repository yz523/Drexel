#!usr/bin/python

class arraystack :
    def __init__(self) :
        self.element = [None]*maxlength
        self.last = 0
        return

#return the element at the top of stack S
    def TOP(self) :
        return self.element[self.last]

#delete the top element of the stack S
    def POP(self) :
        self.last -= 1
        return

#insert the element x at the top of stack S
    def PUSH(self,x, S) :
        S.element[S.last] = x
        S.last += 1
        return

#return true if S is an empty stack
    def EMPTY(self,S) :
        if S.last == 0 :
            return True
        else :
            return False

#make stack S be an empty stack
    def MAKENULL(self) :
        temp = arraystack()
        temp.element = [0]*maxlength
        temp.last = 0
        return temp

#time testing functions start here !!!!!!!
def PUSHTIMING() :
    S = arraystack()
    for i in range(0, maxlength) :
        S.PUSH(i,S)

def POPTIMING() :
    S = arraystack()
    for i in range(0, maxlength) :
        S.PUSH(i,S)
    for i in range(0, maxlength) :
        S.POP()

def TIMING() :
    S = arraystack()

n = 500
maxlength = 500
