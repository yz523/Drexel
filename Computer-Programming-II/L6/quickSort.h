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
//         : based on algorithm as described in Algorithms by 
//         : Cormen, Rivest, and Shapiro.  
// Date    : May, 2002
//
//----------------------------------------------------------------------------


#ifndef __QSORT_H__
#define __QSORT_H__

	#include <vector>
	using namespace std;

	void quickSort(vector<int> &a, int &comparisons, int &moves) ;
	void quickSort(vector<int> &a, int left, int right, int &comparisons, int &moves) ;
	
	int partition(vector<int> &v, int from, int to, int &comparisons, int &moves) ;

#endif

