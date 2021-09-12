//----------------------------------------------------------------------------
//
//  English Length class
//    Implementation
//
//  This class represents an integer length in yards, feet, and inches
//
//	Version 2.0 -- with operator overloading
//----------------------------------------------------------------------------
//
//  Author:         Paul Zoski
//  Date:           March 2002
//  Modified:       JL Popyack, 4/7/2005 -- reformatted
//
//----------------------------------------------------------------------------

#ifndef _ENGLISH_LENGTH_
#define _ENGLISH_LENGTH_

#include <iostream>
#include <string>
using namespace std;

// set true when modifying/testing class
// set false for use in other programs.
const bool DEBUGGING = false; 

//----------------------------------------------------------------------------
//----------------------------------------------------------------------------

class English_length 
{
	public:
	  	
		//------------------------------------------------------
		//----- Constructors -----------------------------------
		//------------------------------------------------------
		
			English_length() ; // default constructor
				// initializes a newly created length 
				// to zero

			English_length(int inches, int feet=0, int yards=0);
			    // will convert lengths if appropriate
			    // e.g. English_length length(54);
				// sets yards_ to 1
				//		feet_ to 1
				//		inches_ to 6

			English_length(const English_length & el);
				// copy constructor
		  	
		//------------------------------------------------------
		//----- Destructor -------------------------------------
		//------------------------------------------------------
			
			~English_length(); // destructor
				// automatically called when an object
				// ceases to exist
				// probably not needed here, but fun to watch

		//------------------------------------------------------
		//----- Inspectors -------------------------------------
		//------------------------------------------------------
		  	
			int inches() const ;
				// returns inches "left over" (0-11)
				
			int totalInches() const ;
				// returns total inches in measurement
				// 2 feet 3 inches returns 27

			int feet() const ;
				// returns feet "left over" (0-2)
				
			int totalFeet() const ;
				// returns total feet in measurement
				// 1 yard 2 feet 3 inches returns 5

			int yards() const ;
				// returns total yards
			  	
		//------------------------------------------------------
		//----- Mutators ---------------------------------------
		//------------------------------------------------------
			  	
			void add_inches(int amt_to_add) ;
				// increases the length of the measure by inches
				
		//------------------------------------------------------
		//----- Facilitators -----------------------------------
		//------------------------------------------------------
		
			string toString() const ; 
				// return EnglishLength in string form
				// "x yards, y feet, and z inches"

			//--- helper methods to facilitate operator overloading

			bool is_equal(const English_length & E) const;
				// helps == operator

			bool is_greater_than(const English_length & E) const;
				// helps > operator

			English_length sum_with(const English_length & E) const;
				// helps + operator

			English_length scale(const int & s) const;
				// helps * for scalar multiplication

			void insert(ostream & out) const;
				// helps >> operator

	private:
		int inches_; // 0-11
		int feet_; // 0-2
		int yards_; // > 0
    int furlong_;
    int mile_;
};


//----------------------------------------------------------------------------
//----- English Length: auxiliary operator descriptions ----------------------
//----------------------------------------------------------------------------

// boolean operators-----------------

	bool operator==(const English_length & left, const English_length & right);
	bool operator!=(const English_length & left, const English_length & right);
	bool operator> (const English_length & left, const English_length & right);
	bool operator< (const English_length & left, const English_length & right);
	bool operator>=(const English_length & left, const English_length & right);
	bool operator<=(const English_length & left, const English_length & right);

// insertion operator

	ostream& operator<<(ostream & out, const English_length & E);

// math operators

	English_length operator+(const English_length & left, const English_length & right);
	English_length operator*(const English_length & E, const int & scalar);
	English_length operator*(const int & scalar, const English_length & E);

#endif
