// ----------------------------------------------------------------------------
//
// -------------------------------- Map Tester --------------------------------
// 
// ----------------------------------------------------------------------------
//
//  Program Name: Map Tester 
//
//  This program demonstrates simple usage of the map container class.
//	Version 1.01 -- retrieval using iterators
//
//  Author:         JL Popyack
//  Date:           November 2003
//  Modified:       JL Popyack, 4/15/2005 -- commented
//                  JL Popyack, 4/21/2011 -- added lowercase, trim routines
//
// ----------------------------------------------------------------------------

	#include <iostream>
	#include <string>
	#include <map>
	#include <algorithm>
	#include <fstream>
	using namespace std ;

// ----------------------------------------------------------------------------
//
// -------------------------------- Prototypes --------------------------------
//
// ----------------------------------------------------------------------------

	string lowercase(string word) ;
	string trim(string word) ;

// ----------------------------------------------------------------------------
//
// ------------------------------- Main Program -------------------------------
//
// ----------------------------------------------------------------------------

	int main (void) 
	{
	// ----------------------------------------------------------------------------
	// count is a map from string to int.
	// The int will be a count of the number of occurrences of the string
	// in a text file provided by the user.
	// ----------------------------------------------------------------------------
	// The code below shows how to store and retrieve values.
	// ----------------------------------------------------------------------------
	//	count["hello"] = 1 ;
	//	cout << count["hello"] << endl ;
	//	
	//	count["hello"]++ ;
	//	cout << count["hello"] << endl ;	
	// ----------------------------------------------------------------------------

		map<string,int> count ;

		ifstream fin("Jack the Fire Dog.txt") ;
		if( fin.fail() )
			cerr << "File not found" << endl ;

	// ---------------------------------------------
	//	Read the file, one word at a time.
	//	Put each word in a map, and count it.
	// ---------------------------------------------
		string word ;
		while( fin >> word )
		{
            			word = trim(word) ;
			word = lowercase(word) ;
            
			if( word.size()>0)
				count[word]++ ;
       
			cout << "word=" << word 
				<< "\tcount[\"" << word << "\"]=" << count[word]
				<< endl ;
		}
		fin.close() ;

	// ---------------------------------------------
	//	Print all words in the map
	//	in the order they are stored.
	// ---------------------------------------------
		cout << endl << "All words, with number of occurrences:" << endl;
		map<string,int>::iterator it = count.begin() ;
		while( it != count.end() )
		{
			cout << it->first << "\t" << it->second << endl;
			it++ ;
		}

	// ---------------------------------------------
	//	Find maximum number of occurrences
	// ---------------------------------------------
		it = count.begin() ;
		int max=0 ;
		while( it != count.end() )
		{
			if( it->second > max )
				max = it->second ;
			it++ ;
		}

		cout << endl << max << " occurrences:" << endl ;
		
	// ---------------------------------------------
	//	Find words with maximum number of occurrences
	// ---------------------------------------------
		it = count.begin() ;
		while( it != count.end() )
		{
			if( it->second == max )
				cout << it->first << endl ;
			it++ ;
		}
		

		return 0 ;
	}
	
// ----------------------------------------------------------------------------
//
// -------------------------- Subprogram Definitions --------------------------
//
// ----------------------------------------------------------------------------


// ----------------------------------------------------------------------------
//
//  Return lower-case version of string
//
// ----------------------------------------------------------------------------
	string lowercase(string word)
	{
		for(unsigned int i=0; i<word.size(); i++)
			if( word[i]>='A' && word[i]<='Z' )
				word[i] += 'a'-'A' ;
		return word ;
	}
	

// ----------------------------------------------------------------------------
//
//  Remove leading and trailing symbols from a string.
//  Words can still contain symbols, e.g., "can't", "co-op"
//
// ----------------------------------------------------------------------------
	string trim(string word)
	{
		while( word.size()>0 && !( word[0] >= 'a' && word[0] <= 'z' )
			                 && !( word[0] >= 'A' && word[0] <= 'Z' ))
			word = word.substr(1) ;

		while( word.size()>0 && !( word.back() >= 'a' && word.back() <= 'z')
			                 && !( word.back() >= 'A' && word.back() <= 'Z' ))
			word = word.substr(0,word.size()-1) ;
        while(word.find("’")>0&&word.find("’")<word.size()){
            word.erase(word.find("’"),1);
        }
        while(word.find("-")>0&&word.find("-")<word.size()){
            word.erase(word.find("-"),1);
        }
        while(word.find(".")>0&&word.find(".")<word.size()){
            word.erase(word.find("."),1);
        }
        while(word.find("'")>0&&word.find("'")<word.size()){
            word.erase(word.find("'"),1);
        }
        while(word.find("/")>0&&word.find("/")<word.size()){
            word.erase(word.find("/"),1);
        }
        while(word.find("!")>0&&word.find("!")<word.size()){
            word.erase(word.find("!"),1);
        }
        while(word.find("\"")>0&&word.find("\"")<word.size()){
            word.erase(word.find("\""),1);
        }
        while(word.find("_")>0&&word.find("_")<word.size()){
            word.erase(word.find("_"),1);
        }
        while(word.find(" ")>0&&word.find(" ")<word.size()){
            word.erase(word.find(" "),1);
        }
        while(word.find(":")>0&&word.find(":")<word.size()){
            word.erase(word.find(":"),1);
        }

		return word ;
	}

