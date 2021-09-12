#!/usr/bin/env python

from lexer import *


stack = []
stackpre = []
stackin = []
stackpost = []
res = " "
while get_expression():
    t = get_next_token()
    while t:
        if str.isdigit( t[0] ) :
            stack.append(t)
        else:
            right = stack.pop()
            if right in ['+', '-', '*', '\\'] :
                right = ""
            left = stack.pop()
            if left in ['+', '-', '*', '\\'] :
                left = ""
            stackpre.append(t)
            stackpre.append(left)
            stackpre.append(right)
            stackin.append(left)
            stackin.append(t)
            stackin.append(right)
            stackpost.append(left)
            stackpost.append(right)
            stackpost.append(t)
            stack.append(left)
            stack.append(right)
            stack.append(t)
        t = get_next_token()

for x in stackpre:
    res = res + " " + x
print "pre:" + res
res = ""

for x in stackin:
    res = res + " " + x
print "in:" + res
res = ""

for x in stackpost:
    res = res + " " + x
print "post:" + res
res = ""