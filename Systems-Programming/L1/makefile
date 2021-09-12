cc = gcc
VIEWER = less
PAGER = less

.PHONY : clean run view

run :
		-@gcc L1.c
		-@./a.out
view:
		-@\less L1.c

clean:
		-@\rm -f *.out
		-@\rm -f *.o
