GCC = gcc
VIEWER = less
PAGER = less

.PHONY : run clean

run:
	gcc first.c -o first.out -lpthread
	./first.out
	gcc second.c -o second.out -lpthread
	./second.out
	gcc third.c -o third.out -lpthread
	./third.out
	
clean:
	rm *.out 
	rm *.out.dSYM