#!/usr/bin/python

import sys

arg = int(sys.argv[1])
memo = {}
def Fib(arg) :
	if (arg == 0 or arg == 1) :
		return arg
	if arg in memo :
		return memo[arg]
	else :
		memo[arg] = Fib(arg - 1) + Fib(arg - 2)
		return memo[arg]

def main() :
	Fib(arg)
	del memo[:]

if __name__ == "__main__":
	main()
