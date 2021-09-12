CC=g++
.PHONY: clean openhash closedhash trie dijkstra floyd dfs fft
		
clean:
	rm -f trie dijkstra floyd	
	rm -f dfstest fft *.o *~core
	@\rm -f *.pyc
dfs: clean dfs.h dfs.cpp digraph.h digraph.cpp dfstest.cpp
	$(CC) dfstest.cpp -o dfstest
	./dfstest

fft: clean fft.cpp
	$(CC) fft.cpp -o fft
	./fft

openhash:
	chmod u+x openhash.py
	python openhash.py <input.txt

closedhash:
	chmod u+x closedhash.py
	python closedhash.py <input.txt

trie:
	g++ -otrie -std=c++11 trie.cpp
	./trie < alice30.txt

dijkstra:
	g++ -odijkstra -std=c++11 dijkstra.cpp
	./dijkstra < adjmatrix.txt

floyd:
	g++ -ofloyd -std=c++11 floyd.cpp
	./floyd < adjmatrix.txt
