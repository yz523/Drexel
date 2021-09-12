//----------------------------------------------------------------------------
//
//--------------------------------- Utilities --------------------------------
//
//----------------------------------------------------------------------------
//
// Name    : Utilities
// Version : 1.0
//
// Provides code used by multiple program units:
//   - global variables used for operation counts
//   - exchange routine used by sorting routines
//
// Author  : JL Popyack
// Date    : May, 2002
//
//----------------------------------------------------------------------------

#ifndef __UTILITIES_H__
#define __UTILITIES_H__

	#include <iostream>
	#include <iomanip>
	#include <vector>
	using namespace std ;
	

//----------------------------------------------------------------------------
//
//-------------------------------- Prototypes --------------------------------
//
//----------------------------------------------------------------------------

	template<class type>
	void exchange(type &a, type &b, int &moves) ; 

//----------------------------------------------------------------------------
//
//-------------------------- Subprogram Definitions --------------------------
//
//----------------------------------------------------------------------------

	template<class type>
	void exchange(type &a, type &b, int &moves) 
	{
	//------------------------------------------------------
	// swaps the values of arguments a and b
	// this counts as 3 moves
	//------------------------------------------------------
		type temp = a ;
		a = b ;
		b = temp ;
		
		moves += 3 ;
	}

#endif