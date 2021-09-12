#ifndef DIGRAPH_H
#define DIGRAPH_H

#include <map>

#define MAX_VERTICES 100

using namespace std;

/* struct for the directed graph as adjacency matrix */
typedef struct digraph{
	
	bool adjMatrix[MAX_VERTICES][MAX_VERTICES];
	int numVertices;
	map<int, char>* vertexLabels;

} DIGRAPH;


/* create an empty directed graph */
DIGRAPH& CREATE_EMPTY_GRAPH();

/* add an edge vLabel -> wLabel in graph G*/
void ADD_EDGE(char vlabel, char wlabel, DIGRAPH& G);

/* add a vertex vLabel in graph G*/
void ADD_VERTEX(char vlabel, DIGRAPH& G);

/* get the index of first vertex adjacent to vertex v in graph G */
int FIRST(int v, DIGRAPH& G);

/* returns the index after index i for the vertices adjacent to v in graph G */
int NEXT(int v, int i, DIGRAPH& G);

/* get the label of the vertex after index i for the vertices adjacent to v in graph G */
char VERTEX(int v, int i, DIGRAPH& G);

/* get the vertex index from vertex label in graph G */
int VERTEX_FROM_LABEL(char vlabel, DIGRAPH& G);

#include "digraph.cpp"
#endif
