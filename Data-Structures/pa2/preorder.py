#!usr/bin/python

def evalpre(l) :
	if len(l) == 3 :
		if l[0] == '+' :
			return l[1] + l[2]
		elif l[0] == '-' :
			return l[1] - l[2]
		elif l[0] == '*' :
			return l[1] * l[2]
		elif l[0] == '/' :
			return l[1] / l[2]
		elif l[0] == '%' :
			return l[1] % l[2]
	else :
        #get the root operation first, and then divide the rest to small groups with 3-elements
        #the first element of the group is operation, the rest two are numbers
        #evaluate the small groups and use the previous level's operation to calculate
		if l[0] == '+' :
			return evalpre(l[1:((len(l)+1)/2)]) + evalpre(l[(len(l)+1)/2:])
		elif l[0] == '-' :
			return evalpre(l[1:((len(l)+1)/2)]) - evalpre(l[(len(l)+1)/2:])
		elif l[0] == '*' :
			return evalpre(l[1:((len(l)+1)/2)]) * evalpre(l[(len(l)+1)/2:])
		elif l[0] == '/' :
			return evalpre(l[1:((len(l)+1)/2)]) / evalpre(l[(len(l)+1)/2:])
		elif l[0] == '%' :
			return evalpre(l[1:((len(l)+1)/2)]) % evalpre(l[(len(l)+1)/2:])

#the tree is
#     +
#  -     *
#(1 2) (3 4)

pre = ['+', '-', 1, 2, '*', 3, 4]
print 'The preorder is'
print pre
print 'The evaluation is'
print evalpre(pre)
