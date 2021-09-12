//----------------------------------------------------------------------------
//
//---------------------------- Recursion Examples ----------------------------
//
//----------------------------------------------------------------------------
//
//  Program Name: RecursionExamples 
//
//	This program demonstrates the use of recursion through 
//	some simple recursive subprograms.
//
//	  J. L. Popyack, 4/18/95
//	  Conversion to C++: JL Popyack, 4/12/98
//	  Ported to Visual C++: Paul Zoski, 4/2/00
//	  Reformatted: JL Popyack, 3/25/2
//
//----------------------------------------------------------------------------

	#include <iostream>
	#include <iomanip>
	#include <string>
	using namespace std ;

//----------------------------------------------------------------------------
//
//-------------------------------- Prototypes --------------------------------
//
//----------------------------------------------------------------------------

	string reverseString( string s ) ;
	void writeZeroFilledInteger( int n, int digits ) ;
	int factorial (int n) ;
	int nFactorial( int n ) ;

//----------------------------------------------------------------------------
//
//------------------------------- Main Program -------------------------------
//
//----------------------------------------------------------------------------


	int main(void)
	{
	 	int i, n  ;
		string s  ;

	//---------------------------------------------------------------------
	// The n-factorial demo:
	
	 	cout << "Computation of n!" << endl ;
		for(i=0;i<3;i++)
		{
			cout << "\nInput an integer between 0 and 10 : " ;
			cin >> n ;
            if(n<0){
                cout<<0<<endl;
            }
            else{
			cout <<  nFactorial(n) << endl ;
            }
		}

		cout << endl ;
		
	//---------------------------------------------------------------------
	// The zero-filled integer output demo:

		cout << "Zero-filled integer output" << endl ;
		for(i=0;i<3;i++)
		{
			cout << "Input an integer between 0 and 9999 : " << endl ;
			cin >> n ;
            if(n>0){
			writeZeroFilledInteger(n,4) ;
            }
            else{
                cout<<"-";
                writeZeroFilledInteger(-n,4) ;
            }
			cout << endl ;
		} 

		cout << endl ;
		
	//---------------------------------------------------------------------
	// The string reversal demo:

		cout << "String reversal" << endl ;
		for(i=0;i<3;i++)
		{
			cout << "Input a string containing no spaces : " ;
			cin >> s ;
			cout << reverseString(s) << endl;
		}

		return 0 ;
	}



//----------------------------------------------------------------------------
//
//-------------------------- Subprogram Definitions --------------------------
//
//----------------------------------------------------------------------------

	int factorial (int n) 
	{
	//---------------------------------------------------------------------
	//	This is a recursive function which computes n! (n factorial).
	//	While hardly an efficient way to do this, it is nevertheless
	//	a "classical simple recursive function".
	//	
	//		n! = n * (n-1) * ... * 1
	//	
	//	Because n! grows large very quickly, this routine will only
	//	produce a correct answer for small values of n.
	//---------------------------------------------------------------------

		cout << setw(2*n+1) << " " ;
		cout << "Entering factorial, n=" << n << endl ;
		if( n == 0 )
		{
			cout << "factorial(" << n << ")=1" << endl;
			return 1;
		} 
		else
		{
			int Temp = n * factorial(n - 1);
			cout << setw(2*n+1) << " " ;
			cout << "factorial(" << n << ")=" << Temp << endl;
			return Temp;
		} 
		cout << setw(2*n+1) << " " ;
		cout << "Exiting factorial, n=" << n << endl;
	}

//----------------------------------------------------------------------------
//
	int nFactorial( int n )
	{
	//---------------------------------------------------------------------
	//	This is identical to "factorial()", but without output tracing.
	//---------------------------------------------------------------------

		if( n == 0 )
			return 1 ;
		else
			return n * nFactorial(n-1) ;
	} 

//----------------------------------------------------------------------------
//
	void writeZeroFilledInteger( int n, int digits ) 
	{
	//---------------------------------------------------------------------
	//	This is a recursive procedure which will print an integer n,
	//	zero-filled if necessary, so that it fits in the prescribed
	//	number of digits.  
	//	
	//	It is assumed that n is nonnegative and is not larger than 
	//	the prescribed number of digits.
	//	
	//	This routine is useful for printing fixed-width numbers that
	//	require leading 0"s, such as course section numbers,
	//	e.g. "CS 172 - 001" .
	//---------------------------------------------------------------------
		if(digits>0)
		{
			writeZeroFilledInteger( n/10, digits - 1 ) ;
			cout << n % 10 ;
        }
        else{
            if(n%10>0){
            writeZeroFilledInteger( n/10, digits - 1 ) ;
            cout<<n%10;
            }
        }
    }



