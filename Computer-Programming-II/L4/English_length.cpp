//----------------------------------------------------------------------------
//
//  English Length class
//    Implementation
//
//  This class represents an integer length in yards, feet, and inches
//
//	Version 2.2 -- with operator overloading
//----------------------------------------------------------------------------
//
//  Author:         Paul Zoski
//  Date:           March 2002
//  Modified:       JL Popyack, 4/7/2005 -- reformatted
//                  JL Popyack, 4/28/2005 -- rewrote add_inches()
//                  JL Popyack, 4/27/2006 -- modified copy constructor
//
//----------------------------------------------------------------------------

	#include "English_length.h"
	#include <cstdlib>
	#include <string>
	#include <ciso646>
	#include <cassert>
	#include <sstream> // used to convert streams to strings
	using namespace std;

	//---------------------------------------------------------------------
	//--- global constants used for English_length class
	//---------------------------------------------------------------------
	const int FEET_PER_YARD = 3;
	const int INCHES_PER_FOOT = 12;
	const int INCHES_PER_YARD = INCHES_PER_FOOT * FEET_PER_YARD;
	

//----------------------------------------------------------------------------
//----- Constructors ---------------------------------------------------------
//----------------------------------------------------------------------------

	English_length::English_length()
	{
		inches_ = 0 ;
		feet_   = 0 ;
		yards_  = 0 ;
	}
	
	English_length::English_length(int inches, int feet, int yards)
	{
	//---------------------------------------------------------------------
	// make sure that construction parameters are valid
	//---------------------------------------------------------------------
		assert(inches >=0);
		assert(feet >= 0);
		assert(yards >=0);
		
	//---------------------------------------------------------------------
	// initialize attributes to valid values
	// convert if necessary
	//---------------------------------------------------------------------
		inches_ = inches % INCHES_PER_FOOT;
		feet_   = ( feet + inches / INCHES_PER_FOOT ) % FEET_PER_YARD;
		yards_  = yards + ( feet + inches / INCHES_PER_FOOT) / FEET_PER_YARD;	
	}

	English_length::English_length(const English_length & el)
	{
		if (DEBUGGING)
			cout << "English_length: " << el.toString() << " being copied" << endl;

	//---------------------------------------------------------------------
	// just a shallow copy
	//---------------------------------------------------------------------
		inches_ = el.inches_;
		feet_   = el.feet_;
		yards_  = el.yards_;
	}


//----------------------------------------------------------------------------
//----- Destructor -----------------------------------------------------------
//----------------------------------------------------------------------------

	English_length::~English_length()
	{
		if (DEBUGGING)
			cout << "English_length: " << toString() << " bites the dust..." << endl;
	}


//----------------------------------------------------------------------------
//----- Inspectors -----------------------------------------------------------
//----------------------------------------------------------------------------

	int English_length::inches() const 
	{
		return inches_ ;
	}

	int English_length::totalInches() const
	{
		return INCHES_PER_YARD * yards_ + INCHES_PER_FOOT * feet_ + inches_ ;
	}

	int English_length::feet() const 
	{
		return feet_ ;
	}

	int English_length::totalFeet() const 
	{
		return FEET_PER_YARD * yards_ + feet_ ;
	}

	int English_length::yards() const 
	{
		return yards_ ;
	}
  
//----------------------------------------------------------------------------
//----- Mutators -------------------------------------------------------------
//----------------------------------------------------------------------------

	void English_length::add_inches(int amt_to_add)
	{
	//---------------------------------------------------------------------
	// This code has been revised so that code that normalizes
	// "yards, feet, inches" into a canonical form is
	// localized to one location (the alternate constructor).
	// Previous code appears below (in comments)
		
		// inches_ += to_add;                    // add inches to length
		// feet_   += inches_ / INCHES_PER_FOOT; // update feet if more than 11 inches
		// inches_ %= INCHES_PER_FOOT;           // remove excess feet from inches
		// yards_  += feet_ / FEET_PER_YARD;     // update yards if more than 2 feet
		// feet_   %= FEET_PER_YARD;             // remove excess yards from feet
	//---------------------------------------------------------------------
		
		English_length temp( totalInches() + amt_to_add ) ;

		inches_ = temp.inches_ ;
		feet_   = temp.feet_ ;
		yards_  = temp.yards_ ;
	}

//----------------------------------------------------------------------------
//----- Facilitators ---------------------------------------------------------
//----------------------------------------------------------------------------


	string English_length::toString() const
	{
	//---------------------------------------------------------------------
	//  The ostringstream type allows output to be directed to
	//  a string in the same style as usually done with a stream.
	//---------------------------------------------------------------------

		ostringstream os; 

	//---------------------------------------------------------------------
	//  output yards_, feet_, and inches_ followed by "yard" or "yards",
	//  "foot" or "feet", and "inch" or "inches" as appropriate.
	//---------------------------------------------------------------------

		os << yards_  << ( ( yards_  != 1 ) ? " yards, " : " yard, " ) ;
		os << feet_   << ( ( feet_   != 1 ) ? " feet, "  : " foot, " ) ;
		os << inches_ << ( ( inches_ != 1 ) ? " inches"  : " inch"   ) ;

	//---------------------------------------------------------------------
	//  convert stream to string and return
	//---------------------------------------------------------------------

		string return_string = os.str();
		return return_string; 
	}	


	//----------------------------------------------------------------------------
	//--- helper methods for operators ---

		bool English_length::is_equal(const English_length & E) const
		{
			return totalInches() == E.totalInches();
		}

		bool English_length::is_greater_than(const English_length & E) const
		{
			return totalInches() > E.totalInches();
		}

		English_length English_length::sum_with(const English_length & E) const
		{
			int new_total_length = totalInches() + E.totalInches();
			return English_length(new_total_length);
		}

		English_length English_length::scale(const int & s) const
		{
			int new_total_length = s * totalInches();
			return English_length(new_total_length);
		}

		void English_length::insert(ostream & out) const
		{
			out << toString();
		}

	
//----------------------------------------------------------------------------
//----- English Length: auxiliary operator descriptions ----------------------
//----------------------------------------------------------------------------

	
//----------------------------------------------------------------------------
// boolean operators

	bool operator==(const English_length & left, const English_length & right)
	{
		return left.is_equal(right);
	}

	bool operator!=(const English_length & left, const English_length & right)
	{
		return !(left.is_equal(right));
	}

	bool operator>(const English_length & left, const English_length & right)
	{
		return left.is_greater_than(right);
	}

	bool operator<(const English_length & left, const English_length & right)
	{
		return !(left >= right);
	}

	bool operator>=(const English_length & left, const English_length & right)
	{
		return ((left > right) || (left == right));
	}

	bool operator<=(const English_length & left, const English_length & right)
	{
		return !(left > right);
	}

//----------------------------------------------------------------------------
// insertion operator

	ostream& operator<<(ostream & out, const English_length & E)
	{
		E.insert(out);
		return out;
	}

//----------------------------------------------------------------------------
// math operators

	English_length operator+(const English_length & left, const English_length & right)
	{
		return left.sum_with(right);
	}

	English_length operator*(const English_length & E, const int & scalar)
	{
		return E.scale(scalar);
	}

	English_length operator*(const int & scalar, const English_length & E)
	{
		return E.scale(scalar);
	}


