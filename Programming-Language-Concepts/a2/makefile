dcc = gcc
VIEWER = less
PAGER = less

.PHONY : clean run view test

run:
		-@g++ node.cpp
		./a.out
view:
		-@\less node.cpp

clean:
		-@\rm -f *.out
		-@\rm -f *.o
test:
		-@g++ node.cpp
  		./a.out 10011010011001
		./a.out 011001
		./a.out 10101