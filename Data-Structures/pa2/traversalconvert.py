#!usr/bin/python

#preorder listing of T into postorder listing
def pretopost(T) :
    if len(T) == 3 :
        x = T[:]
        x[0:2] = T[1:3]
        x[2] = T[0]
        return x
    else :
        x = T[:]
        #divide the preorder list to groups of three, put the first element of each group to the back
        #and return the combination of groups, put the root in the back
        # [1,2,4,5,3,6,7] -> [2,4,5, 3,6,7, 1] -> [4,5,2, 6,7,3, 1]
        x = pretopost(T[1:((len(T)+1)/2)]) + pretopost(T[((len(T)+1)/2):]) + [T[0]]
        return x

#postorder listing of T into preorder listing
def posttopre(T) :
    if len(T) == 3 :
        x = T[:]
        x[1:3] = T[0:2]
        x[0] = T[2]
        return x
    else :
        #basically is the reverse of pretopost function
        #divide the preorder list to groups of three, put the first element of each group to the front
        #and return the combination of groups, put the root in the front
        # [4,5,2,6,7,3,1] -> [1, 4,5,2, 6,7,3] -> [1, 2,4,5, 3,6,7]
        x = [T[-1]] + posttopre(T[0:((len(T)-1)/2)]) + posttopre(T[((len(T)-1)/2):-1])
        return x

#preorder listing of T into inorder listing
def pretoin(T) :
    if len(T) == 3 :
        x = T[:]
        t = x[0]
        x[0] = T[1]
        x[1] = t
        return x
    else :
        x = T
        #basically is the another kind of pretopost function
        #divide the preorder list to groups of three, put the first element of each group to the middle
        #and return the combination of groups, put the root in the middle
        # [1,2,4,5,3,6,7] -> [2,4,5, 1, 3,6,7] -> [4,2,5, 1, 6,3,7]
        x = pretoin( T[1:((len(T)+1)/2)]) + [T[0]] + pretoin(T[((len(T)+1)/2):])
        return x

#the tree is
#     1
#  2     3
#(4 5) (6 7)

pre = [1, 2, 4, 5, 3, 6, 7]
post = pretopost(pre)
print 'preorder is'
print pre
print 'into postorder is'
print post
print

pre2 = posttopre(post)
print 'postorder is'
print post
print 'into preorder is'
print pre2
print

in_ = pretoin(pre)
print 'preorder is'
print pre
print 'into inorder is'
print in_
print
