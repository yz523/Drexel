#include <iostream>
#include <iomanip>
#include <vector>
#include <string>
#include <cstdlib>
#include <ctime>
using namespace std;


int binary_search(vector<int> &v, int fromIndex, int toIndex, int key, int &compare) ;
void generateRandom(vector<int> &v) ;

int binary_search(vector<int> &v, int fromIndex, int toIndex, int key, int &compare)
{
    compare+=1;
   if (fromIndex > toIndex)
      return -1;

   int mid = (fromIndex + toIndex) / 2;

   int diff = v[mid] - key;

   if (diff == 0) /* v[mid] == key */
      return compare;
   else if (diff < 0){ /* v[mid] < key */
      return binary_search(v, mid + 1, toIndex, key, compare);

   }
   else
       return binary_search(v, fromIndex, mid - 1, key, compare);
}

void generateRandom(vector<int> &v)
{
    srand(time(0)) ;
    for(int i=0; i<v.size(); i++)
        v[i] = rand() % 200;
}

int min_position(vector<int> & a, int fromIndex, int toIndex, int &comparisons)
{

	   int min_pos = fromIndex;
	   for(int i = fromIndex + 1; i <= toIndex ; i++)
       {
           comparisons++ ;
           if ( a[i] < a[min_pos] )
               min_pos = i;
       }
	   
	   return min_pos;
}

void exchange(int &a, int &b, int &moves)
{

    int temp = a ;
    a = b ;
    b = temp ;
    
    moves += 3 ;
}

void selectSort(vector<int> & a, int fromIndex, int toIndex, int &comparisons, int &moves)
{
    
	   for(int next = fromIndex; next < toIndex; next++)
       {
           
           int min_pos = min_position(a, next, toIndex, comparisons);
           
           if (min_pos != next)
               exchange(a[min_pos], a[next], moves);
       }
}




int main(){
    int comparisons=0, moves=0,compare=0;
    vector<int>v(1000);
    generateRandom(v);
    selectSort(v, 0, 1000, comparisons, moves);
    int probe=binary_search(v,0,1000,50,compare);
    cout<<probe;
}
