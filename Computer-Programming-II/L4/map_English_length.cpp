//----------------------------------------------------------------------------
//
//--------------------------------- Map Test ---------------------------------
//
//----------------------------------------------------------------------------
//
// Map Test
//
// This program demonstrates use of the map<> container class:
//   - building maps between strings and English_length 
//     and between English_length and string 
//   - manipulating elements of the map
//
// JL Popyack, April 2006 
//
//----------------------------------------------------------------------------

#include <iostream>
#include <string>
#include <map>
#include <fstream>
#include "English_length.h"
using namespace std ;

int main(void)
{
//---------------------------------------------
//	Create a map that allows us to convert text
//  to English lengths:
//---------------------------------------------
	map<string,English_length> equivalent ;

	equivalent["inch"] = English_length(1) ;
	equivalent["foot"] = 12*equivalent["inch"] ;

	//---------------------------------------------
	//	In this space, create similar declarations
	//  for yard, furlong, and mile.
	//---------------------------------------------
    equivalent["yard"] = 3*equivalent["foot"] ;
    equivalent["furlong"] = 220*equivalent["yard"];
    equivalent["mile"] = 5280*equivalent["foot"];

//---------------------------------------------
//	Now the inverse map, that allows us to find
//  the text description of an English length:
//---------------------------------------------

	//---------------------------------------------
	//	In this space, declare the map, named
	//  description, and assign it descriptions for 
	//  inch, foot, yard, furlong, and mile.
	//---------------------------------------------
    map<English_length,string>description;
	description[English_length(1)] = "inch" ;


//---------------------------------------------
//	Investigate contents of map by allowing the
//  user to input a text description of a length
//  e.g., "3 feet" and return an English_length
//  e.g., 3*equivalent["foot"] .
//---------------------------------------------
	int n ;
	string len ;
	do
	{
		cout << "Input a measurement (e.g., '3 foot'): " ;
		cin >> n >> len ;
		English_length el = n*equivalent[len] ;
		cout << el << endl ;
        if(el.yards()/1==1){
            cout << el.yards()/1<<" yards"<<endl;
        }
        else if(el.yards()/220==1){
            cout << el.yards()/220<<" furlong"<<endl;
        }

		//---------------------------------------------
		//	In this space, check whether el is a 'known
		//  unit of measurement' (e.g., 1 mile) by
		//  checking whether it is defined in the map.
		//  If so, print its text description ("1 mile").
		//---------------------------------------------


	} while( n!=0 ) ;


	return 0 ;
}