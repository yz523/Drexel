#include <iostream>

using namespace std;

const int ARRAYSIZE = 7; //size of arrays. # of vertices = arraysize-1

bool contains (int x, int (&a)[ARRAYSIZE]);
void fillzeros (int (&a)[ARRAYSIZE]);

int main(void){
	
	int adjacency[ARRAYSIZE][ARRAYSIZE];
	int vertex[ARRAYSIZE];
	int dist[ARRAYSIZE];
	
	fillzeros(vertex);
	
	int x;
	for (int i = 1; i < ARRAYSIZE; i++)
		for (int j = 1; j < ARRAYSIZE; j++){
			cin >> x;
			adjacency[i][j] = x;
		}
			
	
	vertex[0] = 1; //initialize vertex set
	
	for (int i = 2; i < ARRAYSIZE; i++) //initialize distance array
		dist[i] = adjacency[1][i];
	
	
	for (int i = 1; i < ARRAYSIZE-1; i++){
		int w = 0;
		int dw = 100;
		for (int j = 1; j < ARRAYSIZE; j++)
			if ( contains(j, vertex) == false ) //choose smallest w
				if ( dist[j] < dw ){
					dw = dist[j];
					w = j;
				}
		vertex[i] = w;
		
		for (int j = 1; j < ARRAYSIZE; j++)
			if ( contains(j, vertex) == false )
				if ( dist[w] + adjacency[w][j] < dist[j] ){
					dist[j] = dist[w] + adjacency[w][j];
				}
	}
	
	for (int i = 2; i < ARRAYSIZE; i++)
		cout << "D[1," << i << "]: " << dist[i] << endl;
	cout << "{ ";
	for (int i = 0; i < ARRAYSIZE; i++)
		if (vertex[i] != 0)
			cout << vertex[i] << " ";
	cout << "}" << endl;
	//output
	
	return 0;
}

bool contains (int x, int (&a)[ARRAYSIZE]){
	bool test = false;
	for (int i = 0; i < ARRAYSIZE; i++){
		if (a[i] == x)
			test = true;
	}
	return test;
}

void fillzeros (int (&a)[ARRAYSIZE]){
	for (int i = 0; i < ARRAYSIZE; i++)
		a[i] = 0;
}
