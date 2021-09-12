#!usr/bin/python

def evalpost(l) :
	if len(l) == 3 :
		if l[-1] == '+' :
			return l[0] + l[1]
		elif l[-1] == '-' :
			return l[0] - l[1]
		elif l[-1] == '*' :
			return l[0] * l[1]
		elif l[-1] == '/' :
			return l[0] / l[1]
		elif l[-1] == '%' :
			return l[0] % l[1]
	else :
        #get the root operation first(the last element in the list)
        #and then divide the rest to small groups with 3-elements
        #the last element of the group is operation, the first two are numbers
        #evaluate the small groups and use the previous level's operation to calculate
		if l[-1] == '+' :
			return evalpost(l[:((len(l)-1)/2)]) + evalpost(l[((len(l)-1)/2):-1])
		elif l[-1] == '-' :
			return evalpost(l[:((len(l)-1)/2)]) - evalpost(l[((len(l)-1)/2):-1])
		elif l[-1] == '*' :
			return evalpost(l[:((len(l)-1)/2)]) * evalpost(l[((len(l)-1)/2):-1])
		elif l[-1] == '/' :
			return evalpost(l[:((len(l)-1)/2)]) / evalpost(l[((len(l)-1)/2):-1])
		elif l[-1] == '%' :
			return evalpost(l[:((len(l)-1)/2)]) % evalpost(l[((len(l)-1)/2):-1])

#the tree is
#     +
#  -     *
#(1 2) (3 4)

post = [1, 2, '-', 3, 4, '*', '+']
print 'The postorder is'
print post
print 'The evaluation is'
print evalpost(post)
