#!/usr/bin/python

import sys

fileName = ''

#check if expression is an operator
def isoperator(o):
	if o=='+' or o=='-' or o=='*' or o=='/' or o=='^':
		return 1
	else :
		return 0

#do the calculation base on the operation type
def oper(o,x,y):
	res=0
	if o=="+":
		res = float(x)+float(y)
	if o=="-":
		res = float(x)-float(y)
	if o=="*":
		res = float(x)*float(y)
	if o=="/":
		res = float(x)/float(y)
	if o=="^":
		res = pow(float(x),float(y))
	return res    	

#main algorithm for evaluating postfix expression
def cal(char):
	stack = []
	result = 0
	for i in char:
#check if the expression is an operand
		if i.isdigit() or str(i).find('.')>0:
#push the operand on the stack
			stack.append(i)
#check if the expression is an operator
		elif isoperator(i):
#if stack is empty here, y will be error, break the loop and print -E-
			if not stack:
				result = '-E-'
				break
			else:
#pop top value to y
				y = stack.pop()
#check if it is a binary operator
			if isoperator(i):
#if stack is empty here, x will be error, break the loop and print -E-
				if not stack:
					result = '-E-'
					break
				else:
#pop top value to x
					x = stack.pop()
				result = oper(i,x,y)
#if it is not a binary operator, do (oper)y
			else:
				result = oper(i,result,y)
#push result to stack
			stack.append(result)
#if there is more than 1 operand on the stack, input is invalid, print -E-
	if len(stack)>1:
		result = '-E-'
	return result

#read input from stdin
if len(sys.argv) <2:
	fileName = sys.stdin
	while 1:
		l = fileName.readline()
		l = l.strip("\n")
#EOF is the signal to quit
		if l!='EOF':
			char = l.split( ' ' )
			print cal(char)
		else:
			break
#read input from file
else:
   fileName = sys.argv[1]
   f = open(fileName, "r")
   for l in f:
		l = l.strip("\n")
		char = l.split( ' ' )
		print cal(char)
