#include <iostream>

using namespace std;

const int ARRAYSIZE = 7; //size of arrays. # of vertices = arraysize-1

int main(void){
	
	int adjacency[ARRAYSIZE][ARRAYSIZE];
	int shortpath[ARRAYSIZE][ARRAYSIZE];
	int midpoint[ARRAYSIZE][ARRAYSIZE];
	
	int x;
	for (int i = 1; i < ARRAYSIZE; i++)
		for (int j = 1; j < ARRAYSIZE; j++){
			cin >> x;
			adjacency[i][j] = x;
		}
			
	for (int i = 1; i < ARRAYSIZE; i++) //initialize matrices
		for (int j = 1; j < ARRAYSIZE; j++){
			shortpath[i][j] = adjacency[i][j];
			midpoint[i][j] = 0;
	}
	for (int i = 1; i < ARRAYSIZE; i++) //validate that self-pointing paths have cost 0
		shortpath[i][i] = 0;
	
	for (int i = 1; i < ARRAYSIZE; i++)
		for (int j = 1; j < ARRAYSIZE; j++)
			for (int k = 1; k < ARRAYSIZE; k++)
				if (shortpath[j][k] + shortpath[i][k] < shortpath[j][k]){
					shortpath[j][k] = shortpath[j][k] + shortpath[i][k];
					midpoint[j][k] = i;
				}
	
	cout << "Shortest Distance Matrix:" << endl;
	for (int i = 1; i < ARRAYSIZE; i++){
		for (int j = 1; j < ARRAYSIZE; j++)
			cout << shortpath[i][j] << " ";
		cout << endl;
	}
	
	cout << endl << endl;
	
	cout << "Predecessor Matrix:" << endl;
	for (int i = 1; i < ARRAYSIZE; i++){
		for (int j = 1; j < ARRAYSIZE; j++)
			cout << midpoint[i][j] << " ";
		cout << endl;
	}
	
	return 0;
}

