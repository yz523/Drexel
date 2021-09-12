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

#above is the implementation of pa1
#here is the implementation of 2.4
    def CONCATENATE(l) :
        t = []
        for i in l.element :
            for x in i :
                t.append(x)
        l.element = t
        return l.element

n = 500
maxlength = 500

#test code
t = arraylist()
t.element = [[1,2],[3,4]]
print 'the initial list is'
print t.element
print 'after the CONCATENATE function'
print t.CONCATENATE()
