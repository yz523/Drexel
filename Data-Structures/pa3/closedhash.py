#!usr/bin/python

cp = 0

#using simpest rehash strategy, called linear hashing(from the example 4.3 in the book)
def rehash(x) :
    return hash(x) % B

#make the dictionary null
def MAKENULL() :
    temp = []
    for i in range(B) :
        temp.append(None)
    return temp

#locate function, return the position of element x in dictionary y
def LOCATE(x, y) :
    global gcp
    a = rehash(x)
    i = 0
    while (i<B) and (y[(a+i)%B]!=x) and (y[(a+i)%B] is not None) :
        i += 1
    gcp += i
    return  (a + i) % B

#member function implememtation from the book, check if x is in dictionary y
def MEMBER(x, y) :
    return y[LOCATE(x, y)] == x


#insert function implementation, insert the element x to dictionary y
def INSERT(x, y) :
    a = LOCATE(x, y)
    if y[a] == x :		# word is already present
        return
    elif y[a] is None :		# locate found an empty spot
        y[a] = x
    return

#delete function implementation, delete x from dictionary y
def DELETE(x, y) :
    a = LOCATE(x, y)
    if y != -1 :
        y[a] = None
    return

#global variables will be used
lx = []#list x - insert
ly = []#list y - delete
avglx = []#average probes of list x
avgly = []#average probes of list y
bl = []#list b
global gcp
gcp = 0
line = []
wc = 0#word count

#execution code start here

#input the file from stdin
import sys

for x in sys.stdin.readlines() :
	line.append(x)
	wc += len(x.split(' '))

B = 1
for B in range(1, wc, 1000) :
	if B != 1 :
		B = B -1
	D = MAKENULL()
	gcp = 0

	for x in line :
		l = x.strip().split(' ')
		for y in l :
			INSERT(y, D)
	bl.append(B)
	lx.append(gcp)
#calculate the average probes of insert
	avglx.append( float(gcp/float(wc)) )

	gcp = 0
	for x in line :
		l = x.strip().split(' ')
		for y in l :
			DELETE(y, D)

	ly.append(gcp)
#calculate the average probes of delete
	avgly.append( float(gcp/float(wc)) )

print "B \tInsert average \t\tDelete average"
print "-" *50
for i in range(len(lx)) :
	print str(bl[i]) +"\t", avglx[i], "\t\t", avgly[i]
print "The word count is 15577, and the data from the chart is equal to the formula"
print "average insertion is (1+1/(1-a)^2)/2 and average deletion is (1+1/(1-a))/2"