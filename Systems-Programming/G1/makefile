cc = gcc
VIEWER = less
PAGER = less

.PHONY : clean run view test

run :
		-@gcc g1.c -o g1
		chmod u+x g1
view:
		-@\less g1.c

clean:
		-@\rm -f *.out
		-@\rm -f *.o

test:
		-@gcc g1.c -o g1
		chmod u+x g1
		./g1 SELECT FROM test WHERE ID=1
		./g1 INSERT INTO test \(ID=5,String=\!,F3=50\)
		./g1 UPDATE test SET ID=6 WHERE ID=5
		./g1 DELETE FROM test WHERE ID=6
		./g1 DROP TABLE test
		./g1 CREATE TABLE test1 FIELDS [A,B,C,D]
