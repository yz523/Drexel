//----------------------------------------------------------------------------
//
//-------------------------------- Quick Sort --------------------------------
//
//----------------------------------------------------------------------------
//
// Name    : QuickSort
//
// Sorts vector using QuickSort
//
// Author  : JL Popyack
//         : based on algorithm as described in Introduction to Algorithms by 
//         : Cormen, Leiserson, and Rivest.  
// Date    : May, 2002
//
//----------------------------------------------------------------------------


	#include <iostream>
	#include <string>
	#include "utilities.h"

	#include "quickSort.h"
	using namespace std;

//----------------------------------------------------------------------------
//
	void quickSort(vector<int> &a, int &comparisons, int &moves)
	{
	//------------------------------------------------------
	// driver subprogram to sort an entire vector into
	// ascending order with quickSort.
	//------------------------------------------------------
		quickSort(a, 0, a.size()-1, comparisons, moves);
	}

//----------------------------------------------------------------------------
//
	void quickSort(vector<int> &a, int left, int right, int &comparisons, int &moves)
	{
	//------------------------------------------------------
	// quickSort(): a recursive partitioning-based sort
	//------------------------------------------------------

		if (left < right)
		{
 			int k = partition(a, left, right, comparisons, moves);
			quickSort(a, left, k, comparisons, moves);
			quickSort(a, k+1, right, comparisons, moves);
		}
	}

//----------------------------------------------------------------------------
//
	int partition(vector<int> &a, int left, int right, int &comparisons, int &moves)
	{
	//------------------------------------------------------
	// partition(): rearrange a into 3 sublists:
	// - a sublist a[left] ... a[j-1] of values at most a[j]
	// - a sublist a[j], and 
	// - a sublist a[j+1] ... a[right] of values at least a[j]
	//------------------------------------------------------
		int pivot = a[left];
		int i = left - 1;
		int j = right + 1;
		do {
			do
			{ 
				j-- ; 
				comparisons++ ;
			} while (a[j] > pivot) ;
			
			do
			{ 
				i++ ; 
				comparisons++ ;
			} while (a[i] < pivot);
			
			if (i < j)
				exchange(a[i], a[j], moves);
				
		} while (i < j);
		
		return j;
	}
