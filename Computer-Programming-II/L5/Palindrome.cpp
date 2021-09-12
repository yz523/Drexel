//----------------------------------------------------------------------------
//
//-------------------------------- Palindrome --------------------------------
// 
//----------------------------------------------------------------------------
//
// Name    : Palindrome
// Version : 1.1
//
// This program demonstrates a recursive divide-and-conquer approach to
// determining whether an input string is a palindrome, i.e. is the same
// backwards as forwards.
//
// P Zoski, 2002
// Reformatted JL Popyack April 2006
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

	bool palindrome(string s) ;


//----------------------------------------------------------------------------
//
//------------------------------- Main Program -------------------------------
//
//----------------------------------------------------------------------------

	int main(void)
	{
	
		string s ;
	
		cout << "Enter a string: " ;
		cin >> s ;
	
		if( palindrome(s) )
			cout << "it's a palindrome!!!" << endl ;
		else
			cout << "it's a loser!!!" << endl ;
	
		return 0 ;
	}
	

//----------------------------------------------------------------------------
//
//-------------------------- Subprogram Definitions --------------------------
//
//----------------------------------------------------------------------------

	bool palindrome(string s)
	{
		cout << "Entering palindrome, s=" << s << endl ;
		
		if( s.length()<=1 )
			return true ;
	
		if( s[0] != s[s.length()-1] )
			return false ;
	
		return palindrome( s.substr(1,s.length()-2) ) ;
	}
