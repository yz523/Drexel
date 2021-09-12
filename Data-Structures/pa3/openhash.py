#!usr/bin/python

#using simpest rehash strategy, called linear hashing(from the example 4.3 in the book)
def rehash(x) :
    return hash(x) % B

#node
class Node :
    def __init__(self) :
        self.element = None
        self.next_ = None

    def __str__(self) :
        return str(self.element)

#make the dictionary null
def MAKENULL() :
    temp = []
    for i in range(B) :
        temp.append(None)
    return temp

#member function implememtation from the book, check if x is in dictionary y
def MEMBER(x, y) :
    global lx
    cp = 1
    c = y[rehash(x)]
    while c is not None :
        if c.element == x :
            lx.append(cp)
            return True
        else :
            c = c.next_
            cp += 1
    lx.append(cp)
    return False

#insert function implementation, insert the element x to dictionary y
def INSERT(x, y) :
    if not MEMBER(x, y) :
        a = rehash(x)
        b = y[a]
        n = Node()
        n.element = x
        n.next_ = b
        y[a] = n
    return

#delete function implementation, delete x from dictionary y
def DELETE(x, y) :
    global ly
    cp = 1
    a = rehash(x)
    if y[a] is not None :
        if y[a].element == x :
            y[a] = y[a].next_
            ly.append(cp)
            return
        else :
            b = y[a]
            while b.next_ is not None :
                if b.next_.element == x :
                    b.next_ = b.next_.next_
                    ly.append(cp)
                else :
                    b = b.next_
                    cp += 1
            ly.append(cp)
            return

#global variables will be used
global lx #list x
lx = []
global ly #list y
ly = []
line = []
bl = [] #list b
plx = []#probes of list x - insert
ply = []#probes of list y - delete
avglx = []#average probes of list x
avgly = []#average probes of list y

#execution code start here

#input the file from stdin
import sys
for x in sys.stdin.readlines():
    line.append(x)

#set the bucket from 1 to 10000, 500 per level
for B in range(1, 5000, 200) :
    if B != 1 :
        B = B - 1
    D = MAKENULL()

    lx = []
    for x in line :
        l = x.strip().split(' ')
        for y in l :
            INSERT(y, D)
	
    tx = 0 #total x
    for i in lx :
        tx += i

    ly = []
    for x in line :
        l = x.strip().split(' ')
        for y in l :
            DELETE(y, D)
    ty = 0 #total y
    for i in ly :
        ty += i
    
    bl.append(B)
    plx.append(tx)
#calculate the average probes of insert
    avglx.append(float(tx/float(len(lx))))
    ply.append(ty)
#calculate the average probes of delete
    avgly.append(float(ty/float(len(ly))))

#output the chart
print "B \tInsert average \t\tDelete average"
print "-" *50
for i in range(len(bl)) :
    print str(bl[i]) +  "\t", avglx[i], "\t\t", avgly[i]
print "When bucket higher than 1600, the average delete probes is O(1+a)"
print "When bucket higher than 2400, the average insert probes is O(1+a)"
print "Therefore the best numerical constant for this chart is 1600"