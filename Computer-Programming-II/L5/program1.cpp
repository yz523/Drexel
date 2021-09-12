//----------------------------------------------------------------------------
// MCS 172 (Lab program)
//
// Simple demo program to be used for exploration of the Visual C++ debugger
//   By Hoi Man Chang
//   Date: January 9, 1998.
//   Revisions April 1, 1998, April 1, 1999.
//   Revision JL Popyack March 28, 2002.
//   Reformatted JL Popyack April 29, 2006.
//----------------------------------------------------------------------------

	#include <iostream>
	#include <string>
	using namespace std ;

//----------------------------------------------------------------------------
//
//------------------------------- Main Program -------------------------------
//
//----------------------------------------------------------------------------

	int main(void)
	{
		int i, j ;

		for (i=4; i<7; i++) 
		{
			for (j=5; j>3; j--) 
			{
				cout << (i*j) << endl;
			}
		}
		
		return 0;
	}
