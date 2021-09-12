#include "dfs.h"
#include <map>

using namespace std;

void dfs(DIGRAPH G, char startVertex)
{
	// list of visited nodes
	map<int,int> visited;

	// vertex to start with 
	int v = VERTEX_FROM_LABEL(startVertex, G);

	// to label each visited nodes starting from 0
	int vertexNumber = 0;

	// call dfs helper function
	dfsRecursion(G, v, vertexNumber, visited);
}

void dfsRecursion(DIGRAPH G, int v, int& vertexNumber, map<int,int>& visited)
{
	int i;

	// print the current vertex
	cout << "visited node #" << vertexNumber << ": " << VERTEX(v, v, G) << endl;

	// mark the current vertex as VISITED
	visited[v] = v;

	// get the next adjacent vertex to v
	i = FIRST(v, G);
	vertexNumber++;

	// loop over all adjacent vertices of v
	while(i != 0)
	{
		// if i is not yet VISITED
		if(visited.find(i) == visited.end())
		{
			// recursive call
			dfsRecursion(G, i, vertexNumber, visited);
		}
		// go to the next adjacent vertex to v
		i = NEXT(v, i, G);
	}
}

