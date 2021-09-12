#!usr/bin/python

#node
class Node:
    def __init__(self):
        self.element = None
        self.next = None
    def __str__(self):
        return str(self.element)

#queue
class Queue:
    def __init__(self):
        self.first = None
        self.next = None

#return first element on queue
    def FRONT(q) :
        return q.first

#insert element x at the end of queue q
    def ENQUEUE(self,x, q) :
        t = Node()
        t.element = x
        t.next = None
        if q.first is None :
            q.first = t
            q.next = t
        else :
            temp = q.first
            while temp.next:
                temp = temp.next
            temp.next = t
            q = temp

#delete the first element of queue q
    def DEQUEUE(q) :
        q.first = q.first.next
        q.next = q.first

#return true is it is a empty queue
    def EMPTY(q) :
        if q.first is None :
            return True
        else :
            return False

#make q an empty list
    def MAKENULL(q) :
        q.first = None
        q.next = None

#test case start here !!!
q = Queue()
q.ENQUEUE(1,q)
print '\n[TEST]\t\tpointerqueue.FRONT()'
assert (q.FRONT().element == 1)
print '\n[TEST]\t\tpointerqueue.ENQUEUE()'
q.ENQUEUE(2,q)
assert (q.FRONT().next.element == 2)
print '\n[TEST]\t\tpointerqueue.DEQUEUE()'
q.DEQUEUE()
assert (q.FRONT().element == 2)
print '\n[TEST]\t\tpointerqueue.EMPTY()'
assert (q.EMPTY() == False)
print '\n[TEST]\t\tpointerqueue.MAKENULL()'
q.MAKENULL()
assert (q.FRONT() == None)
print '\n[PASSED]\t5 TEST\n'