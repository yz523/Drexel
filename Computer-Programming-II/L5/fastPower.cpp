//----------------------------------------------------------------------------
//
//-------------------------------- Fast Power --------------------------------
// 
//----------------------------------------------------------------------------
//
// Name    : Fast Power
// Version : 1.31
//
// This program demonstrates two approaches to computing the n-th power of x.
//   A straightforward iterative approach requires n multiplications
//   A divide-and-conquer recursive approach requires roughly log n operations.
//
// P Zoski, 2002
// Reformatted JL Popyack April 2006, April 2009
//----------------------------------------------------------------------------

	#include <iostream>
	#include <ciso646>
	using namespace std;
	
	
//----------------------------------------------------------------------------
//
//-------------------------------- Prototypes --------------------------------
//
//----------------------------------------------------------------------------


	double fastPower(double x, int n);
	double slowPower(double x, int n);


//----------------------------------------------------------------------------
//
//------------------------------- Main Program -------------------------------
//
//----------------------------------------------------------------------------

	int main(void)
	{
		double base = 2.0 ;
		int exponent;
		for (exponent = 8; exponent <= 10; exponent++ )
		{
			cout << "fastPower( " << base << ", " << exponent << ") = "
				 << fastPower(base, exponent) << endl;
				 
			cout << "slowPower( " << base << ", " << exponent << ") = "
				 << slowPower(base, exponent) << endl;
		}
	
		exponent = -8 ;
		cout << "fastPower( " << base << ", " << exponent << ") = "
			 << fastPower(base, exponent) << endl;

		return 0;
	}
	

//----------------------------------------------------------------------------
//
//-------------------------- Subprogram Definitions --------------------------
//
//----------------------------------------------------------------------------

	double fastPower(double x, int n)
	{
		//-------------------------------------------------
		//------ return values for special cases ----------
		//-------------------------------------------------
		
			cout << "Entering fastPower, n=" << n << endl ;
			
			if (x == 0 or x == 1 or n == 1) // no calculation here
				return x;
		
			if (n == 0) // no calculation here
				return 1;
		
			if (n < 0 ) // negative exponent means reciprocal
				return (1.0 / fastPower(x, -n)); 
		
		//-------------------------------------------------
		//-------- powering done here ---------
		//-------------------------------------------------
		
			if ( n % 2 == 0 ) // n is even
			{
				double temp = fastPower(x , n / 2);
				return temp * temp;
			}
			else // n is odd
				return x * fastPower(x, n - 1);
	}
	
//----------------------------------------------------------------------------
//
	double slowPower(double x, int n)
	{
		//-------------------------------------------------
		//------ return values for special cases ----------
		//-------------------------------------------------
		
			if (x == 0 or x == 1 or n == 1) // no calculation here
				return x;
		
			if (n == 0) // no calculation here
				return 1;
		
			if (n < 0 ) // negative exponent means reciprocal
				return (1.0 / slowPower(x, -n)); 
		
		//-------------------------------------------------
		//-------- powering done here ---------
		//-------------------------------------------------
		
			double productToReturn = 1.0;
			int count;
			for ( count = 1; count <= n; count++ ) // multiply x times itself n times
				productToReturn *= x;
		
			return productToReturn;
	}
	
	
			
