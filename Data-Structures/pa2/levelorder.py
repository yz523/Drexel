#!usr/bin/python

#node
class Node(object):
  def __init__(self, value, left=None, right=None):
    self.value = value
    self.left = left
    self.right = right

#levelorder implementation
def levelorder(root):
  current = [root]
  level = 1
  while current:
    next = list()
    print 'level %d' % level
    for i in current:
      print i.value,
      #use queue to store visited nodes
      if i.left: next.append(i.left)
      if i.right: next.append(i.right)
    print
    current = next
    level = level + 1

#the tree is
#      1
#    2   3
#  4  (5   6)
#(7 8)
t = Node(1, Node(2, Node(4, Node(7), Node(8))), Node(3, Node(5), Node(6)))

#execution
levelorder(t)
