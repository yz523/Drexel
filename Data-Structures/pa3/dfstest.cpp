#include <iostream>

#include "dfs.h"
#include "digraph.h"

using namespace std;


int main()
{
	// create an empty digraph
	DIGRAPH G = CREATE_EMPTY_GRAPH();

	// populate the graph (Fig. 6.38)
	ADD_VERTEX('a', G);
	ADD_VERTEX('b', G);
	ADD_VERTEX('c', G);
	ADD_VERTEX('d', G);
	ADD_VERTEX('e', G);
	ADD_VERTEX('f', G);
	
	ADD_EDGE('a','f', G);
	ADD_EDGE('a','d', G);
	ADD_EDGE('a','b', G);
	ADD_EDGE('b','c', G);
	ADD_EDGE('b','f', G);
	ADD_EDGE('c','d', G);
	ADD_EDGE('d','b', G);
	ADD_EDGE('e','f', G);
	ADD_EDGE('e','d', G);
	ADD_EDGE('f','d', G);
	
	// run DFS on the digraph starting with vertex 'a'
	cout << endl << "Running dfs('a', G) " << endl;
	dfs(G, 'a');

	return 0;
}