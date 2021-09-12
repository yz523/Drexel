//----------------------------------------------------------------------------
//
//-------------------------------- Select Sort -------------------------------
//
//----------------------------------------------------------------------------
//
// Name    : Select Sort
//
// Sorts vector using Select Sort
//
// Author   : JL Popyack
// Date     : May, 2002
// Revisions: May, 2011 -- renamed parameters
//
//----------------------------------------------------------------------------

	#include <iostream>
	#include <vector>
	using namespace std ;

	#include "utilities.h"
	#include "selectSort.h"

//----------------------------------------------------------------------------
//
	void selectSort(vector<int> & a, int &comparisons, int &moves)
	{
	//------------------------------------------------------
	// driver subprogram to sort an entire vector into
	// ascending order with selectSort.
	//------------------------------------------------------
		selectSort(a,0,a.size()-1, comparisons, moves) ;	
	}

//----------------------------------------------------------------------------
//
	int min_position(vector<int> & a, int fromIndex, int toIndex, int &comparisons)
	{
	//------------------------------------------------------
	// determine position of the smallest item in the
	// subvector a[fromIndex].. a[toIndex].
	//------------------------------------------------------
	   int min_pos = fromIndex;
	   for(int i = fromIndex + 1; i <= toIndex ; i++)
	   {
		  comparisons++ ;
	      if ( a[i] < a[min_pos] )
	         min_pos = i;
	   }
	   
	   return min_pos;
	}

//----------------------------------------------------------------------------
//
	void selectSort(vector<int> & a, int fromIndex, int toIndex, int &comparisons, int &moves)
	{
	//------------------------------------------------------
	// sort elements a[fromIndex].. a[toIndex] into ascending order
	//------------------------------------------------------
	    
	   for(int next = fromIndex; next < toIndex; next++)
	   {
		  // next is the next position to be set to the minimum
	      
		  int min_pos = min_position(a, next, toIndex, comparisons);

	      if (min_pos != next)
	         exchange(a[min_pos], a[next], moves);
	   }
	}
