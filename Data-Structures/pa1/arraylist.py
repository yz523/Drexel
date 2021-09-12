#!usr/bin/python

class arraylist :
    def __init__(self) :
        self.element = [None]*maxlength
        self.last = 0
#return the last position on list L
    def END(self) :
        return self.last

#return the first position on list L
    def FIRST(self) :
        if self.last is 0 :
            return -1
        else :
            return self.element[0]

#return the element at position p on list L
    def RETRIEVE(self,p, L) :
        if p > L.last :
            return None
        else :
            return L.element[p]

#return the position of x on list L
    def LOCATE(self,x, L) :
        for i in range(L.last) :
            if L.element[i] == x :
                return i

#return the position following position p on list L
    def NEXT(self,p, L) :
        if p > L.last or p + 1 > L.last:
            return None
        else :
            return p + 1

#return the preceding following position p on list L
    def PREVIOUS(self,p, L) :
        if p > L.last or p == 0 :
            return None
        else :
            return p - 1

#insert x at position p in list L
    def INSERT(self, x, p, L) :
        if p > L.last:
            return
        elif p == L.last :
            L.element[p] = x
        else :
            L.element[p+1:L.last+1] = L.element[p:L.last]
            L.element[p] = x
            L.element = L.element[:maxlength]
        L.last += 1

#delete the element at position p on list L
    def DELETE(self,p, L) :
        if p == L.last :
            L.last -= 1
        else :
            L.element[p:L.last-1] = L.element[p+1:L.last]
            L.last -= 1

#cause the list to be an empty list
    def MAKENULL(self) :
        self.element = [None]*maxlength
        return self.last

#time testing functions start here !!!!!!!
def InsertFront() :
    L = arraylist()
    for i in range(0, n) :
        L.INSERT(i,0,L)

def InsertBack() :
    L = arraylist()
    for i in range(0, n) :
        L.INSERT(i, L.END(), L)

def TRAVERSAL() :
    L = arraylist()
    for i in range(0, n) :
        L.INSERT(i, L.END(), L)
    p = L.FIRST()
    while p :
        p = L.NEXT(p, L)

def DeleteFront() :
    L = arraylist()
    for i in range(0, n) :
        L.INSERT(i, L.END(), L)
    for i in range(0, n) :
        L.DELETE(0, L)

def DeleteBack() :
    L = arraylist()
    for i in range(0, n) :
        L.INSERT(i, L.END(), L)
    for i in range(0, n) :
        L.DELETE(L.END(), L)

def TIMING() :
    L = arraylist

n = 500
maxlength = 500