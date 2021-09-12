//----------------------------------------------------------------------------
//
//------------------------------- Sorting Test -------------------------------
//
//----------------------------------------------------------------------------
//
// Name    : Sorting Test
// Version : 2.1
//
// This program is used as a driver to test sorting
// methods and count number of comparisons and moves
// used by them.
//
// Lists of integers are generated randomly and sorted,
// with performance statistics reported afterwards.
//
// Author  : JL Popyack
// Date    : May, 1999
// Modified: May, 2002; May, 2011 -- added timer
//
//----------------------------------------------------------------------------

	#include <iostream>
	#include <iomanip>
	#include <vector>
	#include <string>
	#include <cstdlib>
	#include <ctime>

	//---------------------------------------------------------------------
	// Global variables for #comparisons and #moves are
	// declared in utilities.h
	//---------------------------------------------------------------------

	#include "utilities.h"    
	#include "selectSort.h"
	#include "quickSort.h"
	using namespace std ;


//----------------------------------------------------------------------------
//
//-------------------------------- Prototypes --------------------------------
//
//----------------------------------------------------------------------------


	// Generate random integers in the range 0..RAND_MAX
	// and store them in v.
	void generateRandom(vector<int> &v) ;
	
	// Display elements of a vector, 10 per line
	void showVector(vector<int> &v) ;
	
	// An improved approach to sorting a list
	void fastSort(vector<int> &v, int left, int right, int &comparisons, int &moves) ;
void fasterSort(vector<int> &v, int left, int right, int &comparisons, int &moves);

//----------------------------------------------------------------------------
//
//------------------------------- Main Program -------------------------------
//
//----------------------------------------------------------------------------

	int main(void)
	{
		//---------------------------------------------------------------------
		// v is the list to be sorted; 
		// unsortedList holds the unsorted elements for re-use.
		// we don't display the vector elements if it exceeds MAX_REPORT_SIZE 
		//---------------------------------------------------------------------
			vector<int> v, unsortedList ; 
			int n ;
			const int MAX_REPORT_SIZE = 100 ;
			clock_t start,stop;
			int comparisons, moves ;
			double elapsedTime ;
			
			cout << "Number of elements in list to create: " ;
			cin >> n ;
		
		//---------------------------------------------------------------------
		// Once the desired list size is known, the lists 
		// are resized and a random list is generated. 
		//---------------------------------------------------------------------
			unsortedList.resize(n) ;
			generateRandom(unsortedList) ;
			v = unsortedList;
			
			if( n<=MAX_REPORT_SIZE )
			{
				cout << endl << "Unsorted list: " << endl;
				showVector(v) ;
			}

		//---------------------------------------------------------------------
		// Sort the list with selectSort and report the results
		//---------------------------------------------------------------------
		
			comparisons=0 ;
			moves=0 ;
			start = clock() ;
		    
			selectSort(v,comparisons,moves) ;	

			stop = clock() ;
			elapsedTime = ( clock() - start ) / (double)CLOCKS_PER_SEC;

			cout << endl << "Sorted by selectSort: " << endl;
			if( n<=MAX_REPORT_SIZE )
				showVector(v) ;

			cout << endl 
			     << "Used " << comparisons 
			     << " comparisons, " << moves 
			     << " moves, in " 
				 << elapsedTime
				 << " seconds"
				 << endl;

		//---------------------------------------------------------------------
		// Sort the list with quickSort and report the results
		//---------------------------------------------------------------------
		
			v = unsortedList;

			comparisons = 0;
			moves = 0;
			start = clock() ;

			quickSort(v,comparisons,moves) ;	

			stop = clock() ;
			elapsedTime = ( clock() - start ) / (double)CLOCKS_PER_SEC;

			cout << endl << "Sorted by quickSort: " << endl;
			if( n<=MAX_REPORT_SIZE )
				showVector(v) ;

			cout << endl 
			     << "Used " << comparisons 
			     << " comparisons, " << moves 
			     << " moves, in " 
				 << elapsedTime
				 << " seconds"
				 << endl;
			
			cout << endl << "Done." << endl;
        //---------------------------------------------------------------------
        // Sort the list with fastSort and report the results
        //---------------------------------------------------------------------
        
        v = unsortedList;
        comparisons=0 ;
        moves=0 ;
        start = clock() ;
        
        fastSort(v,1,n-1,comparisons,moves);
        
        stop = clock() ;
        elapsedTime = ( clock() - start ) / (double)CLOCKS_PER_SEC;
        
        cout << endl << "Sorted by fastSort: " << endl;
        if( n<=MAX_REPORT_SIZE )
            showVector(v) ;
        
        cout << endl
        << "Used " << comparisons
        << " comparisons, " << moves
        << " moves, in "
        << elapsedTime
        << " seconds"
        << endl;
        
        //
        v = unsortedList;
        comparisons=0 ;
        moves=0 ;
        start = clock() ;
        
        fasterSort(v,1,n-1,comparisons,moves);
        
        stop = clock() ;
        elapsedTime = ( clock() - start ) / (double)CLOCKS_PER_SEC;
        
        cout << endl << "Sorted by fasterSort: " << endl;
        if( n<=MAX_REPORT_SIZE )
            showVector(v) ;
        
        cout << endl
        << "Used " << comparisons
        << " comparisons, " << moves
        << " moves, in "
        << elapsedTime
        << " seconds"
        << endl;
        
        return 0;
	}




//----------------------------------------------------------------------------
//
//-------------------------- Subprogram Definitions --------------------------
//
//----------------------------------------------------------------------------


//----------------------------------------------------------------------------
//
	void generateRandom(vector<int> &v)
	{
	//------------------------------------------------------
	// Generate random integers in the range 0..RAND_MAX
	// and store them in v.
	// v random seed is chosen from the system clock so that
	// the list generated will be unique.
	//------------------------------------------------------
	
		srand(time(0)) ;
		for(int i=0; i<v.size(); i++)
			v[i] = rand() ;
	}

		
//----------------------------------------------------------------------------
//
	void showVector(vector<int> &v)
	{
	//------------------------------------------------------
	// Display elements of a vector, 10 per line
	//------------------------------------------------------
		vector<int> ::iterator it ;
		int count=0 ;
		for(it=v.begin(); it!=v.end(); it++)
		{
			cout << setw(6) << *it ;
			count = (count+1)%10 ;
			if( count==0 ) 
				cout << endl ;
		}
		cout << endl ;
	}
		

//----------------------------------------------------------------------------
//
	void fastSort(vector<int> &v, int left, int right, int &comparisons, int &moves)
	{
	//------------------------------------------------------
	// fastSort is an improved approach to sorting a list,
	// based on the following idea:
	//   - partition the list into two sublists, using
	//     Hoare's partition method.
	//   - Use selectSort on each of the sublists.
	//
	// Since selectSort uses roughly (n*n)/2 operations
	// for a list of size n, it will use roughly (n*n)/8
	// operations on a list of size n/2.
	// If the partitioning is near optimal (two sublists
	// of size n/2), fastSort will use roughly (n*n)/4
	// operations - half the work of selectSort
	//------------------------------------------------------
		int k = partition(v, left, right, comparisons, moves);
		selectSort(v, left, k, comparisons, moves);
		selectSort(v, k+1, right, comparisons, moves);
	}

void fasterSort(vector<int> &v, int left, int right, int &comparisons, int &moves){
    int k=partition(v,left,right,comparisons,moves);
    fastSort(v, left, k, comparisons, moves);
    fastSort(v, k+1, right, comparisons, moves);
}

