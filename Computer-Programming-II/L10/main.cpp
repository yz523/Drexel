//-----------*-*-C++-*-*-------------------------------------------
// TCT.cpp -- playing around w/the C++ exception-handling mechanism
//
// Kurt Schmidt
// 8/03
//
// Needed files:
//
// Note:  For use w/lab.  So, will be modified, guided by instructions
// 		and comments
//

#include <iostream>

using namespace std;

#include "throws.h"
#include "myException.h"

char getMenuResp();
void down1( char );
void down2( char );

int main()
{
	char resp;

	do
	{
		resp = getMenuResp();
        
        
      try
		{
            down1(resp);
            down2(resp);

			switch( resp )
			{
				case 'i':
				case 'I':
					throw 42; break;
				case 'l':
				case 'L':
					throw 99L; break;
				case 'f':
				case 'F':
					throw 6.022F; break;
				case 'm':
				case 'M':
					throw myException( 10, "just lookin' around" ); break;
				case 'c':
				case 'C':
					throw "Here's a character array bein' thrown"; break;
				case 'q':
				case 'Q':
					break;
				default:
					cout << "\nInvalid Input!\n";
			}	// switch

			cout << "\nmain> Before the catch block\n";

		}	// try
		catch( long e )
		{
			cerr << "\nmain> Caught the long: " << e << endl;
		}
		catch( int e )
		{
			cerr << "\nmain> Caught the integer: " << e << endl;
		}
        catch( float e )
        {
            cerr << "\nmain> Caught the float: " << e << endl;
        }
        catch( long e )
        {
            cerr << "\nmain> Caught the long: " << e << endl;
        }
		catch( myException e )
		{
			cerr << "\nmain> Caught myException, error # " << e.id()
				<< " and the message:\n\t***  " << e.what() << "  ***\n";
			e.destroy();
		}
		catch( const char *e )
		{
			cerr << "\nmain> Caught the C-string:\n\t***  "
				<< e << "  ***\n";
		}
		catch(...)
		{
			cerr << "\nmain> Caught unknown exception!  Exiting.\n\n";
			// do panic clean-up here
			resp = 'q';
		}

		cout << "\nmain> After the catch block\n";

	} while( resp!='q' && resp!='Q' );


	return 0;
}
	
	
char getMenuResp()
{
	char r;

	cout << "\n\tThrow i)nt\n";
	cout << "\tThrow l)ong\n";
	cout << "\tThrow f)loat\n";
	cout << "\tThrow m)yException\n";
	cout << "\tThrow c)-string\n";
	cout << "\n\tQ)uit\n\n";

	cout << "Enter your choice => ";
	cin >> r;
	
	return r;
}


void down1( char c )
{
	// you will leave this be for a moment, see what happens when an exception
	// is thrown.
	//
	// You will then put in handlers here, and see what happens

	down2( c );

}	// down1


void down2( char c )
{
	switch( c )
	{
		case 'i':
		case 'I':
			throw 81; break;
		case 'l':
		case 'L':
			throw 121; break;
		case 'f':
		case 'F':
			throw 22.4F; break;
		case 'm':
		case 'M':
			throw myException( 36, "thrown from down2" ); break;
		case 'c':
		case 'C':
			throw "Here's a character array bein' thrown from down2"; break;
	}	// switch
}	// down2
