dcc = gcc
VIEWER = less
PAGER = less

.PHONY : clean run view test

run:
		-@g++ q3.cpp
		./a.out
view:
		-@\less q3.cpp

clean:
		-@\rm -f *.out
		-@\rm -f *.o
