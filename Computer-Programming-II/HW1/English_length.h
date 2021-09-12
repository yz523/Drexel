//----------------------------------------------------------------------------
//
//  English Length class
//    Header
//
//  This class represents an integer length in yards, feet, and inches
//
//	Version 0.1 -- has only one (default) constructor
//----------------------------------------------------------------------------
//
//  Author:         Paul Zoski
//  Date:           March 2002
//  Modified:       JL Popyack, 4/7/2005 -- reformatted
//                  JL Popyack, 4/3/2007 -- reformatted for CppDoc
//
//----------------------------------------------------------------------------

#ifndef _ENGLISH_LENGTH_
#define _ENGLISH_LENGTH_

#include <iostream>
#include <string>
using namespace std;


//----------------------------------------------------------------------------
//----------------------------------------------------------------------------

class English_length 
{
	public:
	  	
		//------------------------------------------------------
		//----- Constructors -----------------------------------
		//------------------------------------------------------
		
			//---------------------------------- 
			// default constructor --
			// initializes a newly created length 
			// to zero
			//---------------------------------- 
			English_length() ; 

		//------------------------------------------------------
		//----- Inspectors -------------------------------------
		//------------------------------------------------------
		  	
			//---------------------------------- 
			// returns inches "left over" (0-11)
			//---------------------------------- 
			int inches() const ;
				
			//---------------------------------- 
			// returns total inches in measurement:
			// 2 feet 3 inches returns 27
			//---------------------------------- 
			int totalInches() const ;

			//---------------------------------- 
			// returns feet "left over" (0-2)
			//---------------------------------- 
			int feet() const ;
				
			//---------------------------------- 
			// returns total feet in measurement:
			// 1 yard 2 feet 3 inches returns 5
			//---------------------------------- 
			int totalFeet() const ;

			//---------------------------------- 
			// returns total yards
			//---------------------------------- 
			int yards() const ;
    
		//------------------------------------------------------
		//----- Mutators ---------------------------------------
		//------------------------------------------------------
			  	
			//---------------------------------- 
			// increases the length of the measure by amt_to_add
			//---------------------------------- 
			void add_inches(int amt_to_add) ;
            //----------------------------------
            // returns if it is shorter
            //----------------------------------
            bool isLessThan(const English_length &L);
            //----------------------------------
            // returns the smallest one
            //----------------------------------
            English_length min(const English_length &L,const English_length &L_);
		//------------------------------------------------------
		//----- Facilitators -----------------------------------
		//------------------------------------------------------
		
			//---------------------------------- 
			// return EnglishLength in string form:
			// "x yards, y feet, and z inches"
			//---------------------------------- 
			string toString() const ; 
		  	
	private:
		int inches_; // 0-11
		int feet_;   // 0-2
		int yards_;  // > 0
};

#endif
