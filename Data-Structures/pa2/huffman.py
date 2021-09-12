#!usr/bin/python

from heapq import heapify, heappop, heappush

#the main function of huffman algorithm
def huffmancode(p, res = ''):
    if len(p) < 3:
        print('%s: %s' % (p[1], res))
    else:
        huffmancode(p[1], res + '0')
        huffmancode(p[2], res + '1')

#test tree in text book 3.20
t = [[0.07, 'a'],[0.09, 'b'],[0.12, 'c'],[0.22, 'd'],[0.23, 'e']]
#transform the list in to heap
heapify(t)

#huffman tree
while len(t) > 1:
    #left leaf
    a = heappop(t)
    #right leaf
    b = heappop(t)
    #the combined probility
    c = a[0] + b[0]
    heappush(t, (c, a, b))

#execution
huffmancode(t[0])
