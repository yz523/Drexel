#!usr/bin/python

class Node:
	def __init__(self):
		self.element = None
		self.next_ = None
	
	def __str__(self):
		return str(self.element)

class pointerlist:
    def __init__(self):
        self.head = None
        self.current = None

#return the last position on list L
    def END(self) :
        if self.head is None and self.current is None:
            return None
        else :
            temp = self.head
            while temp.next_:
                temp = temp.next_
            return temp

#return the first position on list L
    def FIRST(self) :
        return self.head

#return the element at position p on list L
    def RETREIVE(self,p, L) :
        temp = L.FIRST()
        for k in range(0, p) :
            if temp.next_ != None :
                temp = temp.next_
                return temp.element

#return the position of x on list L
    def LOCATE(self,x, L) :
        count = 0
        temp = L.FIRST()
        while temp :
            if temp.element == x :
                return count
            else :
                count += 1
                temp = temp.next_;
        return -1

#return the position following position p on list L
    def NEXT_(self,n) :
        return n.next_

#return the preceding following position p on list L
    def PREVIOUS(self,L) :
        temp = L.FIRST()
        while temp :
            if temp.next_ == L.current :
                return temp
            else :
                temp = temp.next_
        return None

#insert x at position p in list L
    def INSERT(self,x, p, L) :
        n = Node()
        n.element = x
        if p is None :
            n.next_ = None
            L.head = n
            L.current = L.head
            return
        elif (p == L.FIRST() and L.FIRST() != L.END()) or (p == 0):
            n.next_ = L.head
            L.head = n
            L.current = L.head
            return
        else :
            if L.head is None :
                L.head = n
                L.current = n
            else :
                temp = L.FIRST()
                while temp and p > 1 :
                    temp = temp.next_
                    p -= 1
                n.next_ = temp.next_
                temp.next_ = n
            return

#cause the list to be an empty list
    def MAKENULL(self) :
        self.element = None
        self.next_ = None
        self.head = None
        self.current = None
        return None

#delete the element at position p on list L
    def DELETE(self,p, L) :
        temp = L.FIRST()
        if p == 0 :
            L.head = temp.next_
        elif p == L.END() :
            if temp.next_ == None :
                L = L.MAKENULL()
            else :
                while (temp.next_).next_ :
                    temp = temp.next_
                temp.next_ = None
        else :
            while p - 1 > 0 :
                temp = temp.next_
                p -= 1
            first = temp
            second = temp.next_
            first.next_ = second.next_
        


#time testing functions start here !!!!!!!
def InsertFront() :
	L = pointerlist()
	for i in range(0, n) :
		L.INSERT(i, 0, L)

def InsertBack() :
	L = pointerlist()
	for i in range(0, n) :
		L.INSERT(i, L.END(), L)

def TRAVERSAL() :
	L = pointerlist()
	for i in range(0, n) :
		L.INSERT(i, 0, L)
	temp = L.FIRST()
	while temp :
		temp = L.NEXT_(temp)

def DeleteFront() :
	L = pointerlist()
	for i in range(0, n) :
		L.INSERT(i, 0, L)
	for i in range(0, n) :
		L.DELETE(0, L)

def DeleteBack() :
	L = pointerlist()
	for i in range(0, n) :
		L.INSERT(i, 0, L)
	for i in range(0, n) :
		L.DELETE(L.END(), L)


def TIMING() :
	L = pointerlist()

n = 500
maxlength = 500
	