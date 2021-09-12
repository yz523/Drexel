GCC = gcc
VIEWER = less
PAGER = less

.PHONY : test build clean
	
test: build
	./ipc.o $(GAMES) $(DIMENSION) 

build:
	$(CC) -o ipc.o ipc.c

clean:
	rm *.o 
	rm *.o.dSYM