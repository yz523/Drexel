#!/usr/bin/python

import sys

arg = int(sys.argv[1])

def Fib(arg) :
   if (arg == 0 or arg == 1) :
      return arg
   else :
      return Fib(arg - 1) + Fib(arg - 2)

def main():
	Fib(arg)

if __name__ == "__main__":
	main()
