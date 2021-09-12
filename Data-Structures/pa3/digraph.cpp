#include "digraph.h"

DIGRAPH& CREATE_EMPTY_GRAPH()
{
	int i, j;
	DIGRAPH* g = new DIGRAPH();
	for(i=1; i < MAX_VERTICES; i++)
	{
		for(j=1; j < MAX_VERTICES; j++)
		{
			g->adjMatrix[i][j] = false;
		}
	}
	g->numVertices = 0;
	g->vertexLabels = new map<int,char>();
	return *g;
}

void ADD_EDGE(char vlabel, char wlabel, DIGRAPH& G)
{
	int vIndex = VERTEX_FROM_LABEL(vlabel, G);
	int wIndex = VERTEX_FROM_LABEL(wlabel, G);
	G.adjMatrix[vIndex][wIndex] = true;
}

void ADD_VERTEX(char vlabel, DIGRAPH& G)
{
	(G.numVertices)++;
	G.vertexLabels->insert(pair<int,char>(G.numVertices,vlabel));
	
}

int FIRST(int v, DIGRAPH& G)
{
	int i;
	for(i=1; i < MAX_VERTICES; i++)
	{
		if(G.adjMatrix[v][i])
			return (i);
	}

	return 0;
}

int NEXT(int v, int i, DIGRAPH& G)
{
	int j;
	for(j=i+1; j < MAX_VERTICES; j++)
	{
		if(G.adjMatrix[v][j])
			return (j);
	}

	return 0;
}

char VERTEX(int v, int i, DIGRAPH& G)
{
	return G.vertexLabels->at(i);
}

int VERTEX_FROM_LABEL(char vLabel, DIGRAPH& G)
{
	//cout << G.vertexLabels->size() << endl;
	map<int,char>::iterator it = G.vertexLabels->begin();
	for(; it != G.vertexLabels->end(); it++)
	{
		if(it->second == vLabel)
			return it->first;
	}
	return 0;
}
