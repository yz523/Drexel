//---------------------------------------------------------------------
//
// Valid Date Validator
//
//---------------------------------------------------------------------
//
// This program prompts the user to input a date, and validates that it
// is indeed a valid date.
// 
// Based heavily on "prog4-5.cpp" by James P. Cohoon and Jack W. Davidson
// from programs accompanying their text, C++ Program Design, 2nd Edition
// Mc-Graw Hill.
//
// Modifications:  JL Popyack, Mar. 2003.
//
//---------------------------------------------------------------------


	#include <iostream>
	#include <string>
	using namespace std; 

	enum MonthsOfYear { JANUARY =  1, FEBRUARY =  2, MARCH     =  3, 
	                    APRIL   =  4, MAY      =  5, JUNE      =  6,
	                    JULY    =  7, AUGUST   =  8, SEPTEMBER =  9,
	                    OCTOBER = 10, NOVEMBER = 11, DECEMBER  = 12
	                  } ;

	                  
	int main(void)
	{	
		cout << "Enter a date in the format (mm dd yyyy): ";
		
		int month;
		int day;
		int year;
		cin >> month >> day >> year;

	//-----------------------------------------------------------
	// Determine the number of days in February, based on the year
	//-----------------------------------------------------------
		int daysInFebruary;
		if ((year % 4) != 0)
			daysInFebruary = 28;
		else if ((year % 400) == 0)
			daysInFebruary = 29;
		else if ((year % 100) == 0)
			daysInFebruary = 28;
		else
			daysInFebruary = 29;

	//-----------------------------------------------------------
	// Determine the number of days in the given month
	//-----------------------------------------------------------
		int daysInMonth;
		switch (month) {
			case JANUARY: case MARCH: case MAY: case JULY:
			case AUGUST: case OCTOBER: case DECEMBER:
				daysInMonth = 31;
                break;
			case APRIL: case JUNE: case SEPTEMBER:
			case NOVEMBER:
				daysInMonth = 30;
				break;
			case FEBRUARY:
				daysInMonth = daysInFebruary;
				break;
			default:
				cout << "Invalid month: " << month << endl;
				exit(1) ;
		}

	//-----------------------------------------------------------
	// Determine whether the day input is valid
	//-----------------------------------------------------------
		if ((day < 1) || (day > daysInMonth)) {
			cout << "Invalid day of month: " << day << endl;
			exit(1) ;
		}

	//-----------------------------------------------------------
	// If we get here, the date input must be valid
	//-----------------------------------------------------------
		cout << month << "/" << day << "/" << year
		     << " is a valid date" << endl;

		return 0;
	}