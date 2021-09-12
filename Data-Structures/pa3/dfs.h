#ifndef DFS_H
#define DFS_H


#include "digraph.h"

using namespace std;

/* recursive dfs helper function to perform dfs starting from vertex v */
void dfsRecursion(DIGRAPH G, int v, int& vertexNum, map<int,int>& visited);

/* DFS search algorithm in a directed graph  */
void dfs(DIGRAPH G, char startVertex);

#include "dfs.cpp"

#endif
