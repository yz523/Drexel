//----------------------------------------------------------------------------
//
//--------------------------------- Select Sort ------------------------------
//
//----------------------------------------------------------------------------
//
// Name    : Select Sort
//
// Sorts vector using Select Sort
//
// Author  : JL Popyack
// Date    : May, 2002
//
//----------------------------------------------------------------------------

#ifndef __SELECT_SORT_H__
#define __SELECT_SORT_H__

	#include <vector>
	#include "utilities.h"
	using namespace std ;


	int min_position(vector<int> & a, int fromIndex, int toIndex, int &comparisons) ;
	void selectSort(vector<int> & a, int &comparisons, int &moves) ;
	void selectSort(vector<int> & a, int fromIndex, int toIndex, int &comparisons, int &moves) ;

#endif