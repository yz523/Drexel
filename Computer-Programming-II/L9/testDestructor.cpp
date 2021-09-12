//----------------------------------------------------------------------------
//
//------------------------- DUPoint Destructor Tester ------------------------
//
//----------------------------------------------------------------------------
//
//  Program Name: testDestructorDriver
//
//  This program is designed for investigation of class destructor activities.
//
//  Author:         JL Popyack
//  Course:         CS172
//  Date:           5/21/99
//
//  Modified:       JL Popyack: 5/18/2
//                  reformatted
//
//----------------------------------------------------------------------------

	#include <iostream>
	#include "DUPoint.h"
	#include "DUPolygon.h"
	using namespace std ;


//----------------------------------------------------------------------------
//
//-------------------------------- Prototypes --------------------------------
//
//----------------------------------------------------------------------------

	void passByRef(DUPoint &p) ;
	void passByRefWithLocal(DUPoint &p) ;
	void passByVal(DUPoint p) ;
	void passByValWithLocal(DUPoint p) ;

	void pauseAndWaitForKeyClick() ;
	
//----------------------------------------------------------------------------
//
//------------------------------- Main Program -------------------------------
//
//----------------------------------------------------------------------------

	int main(void)
	{
	//----------------------------------------------------------------------------
	//	Test what happens when objects are passed to a subprogram by reference.
	//----------------------------------------------------------------------------

		cout << "Testing the DUPoint Destructor" << endl << endl ;

	    DUPoint p1(1,2), p2(4,5), p3(6,9), p4(-5,-1);

		cout << "The following points have been declared in main():" << endl 
		     << "  p1=" << p1 << ";\tp2=" << p2 << endl
		     << "  p3=" << p3 << ";\tp4=" << p4 << endl ;
		     
		passByRef(p1) ;
		passByRefWithLocal(p2) ;

		pauseAndWaitForKeyClick();

	//----------------------------------------------------------------------------
	//	Test what happens when objects are passed to a subprogram by value.
	//----------------------------------------------------------------------------

		passByVal(p3) ;
		passByValWithLocal(p4) ;
		
		pauseAndWaitForKeyClick();

	//----------------------------------------------------------------------------
	//	Test what happens when dynamically created objects are passed 
	//  to a subprogram - by value or by reference.
	//----------------------------------------------------------------------------

		DUPoint* p ;
		p = new DUPoint(4,2) ;
		cout << "Creating *p=" << *p << endl ;
		
		passByRef(*p) ;
		passByVal(*p) ;
		
		pauseAndWaitForKeyClick();

	//----------------------------------------------------------------------------
	//	Test what happens when dynamically created objects are deleted.
	//----------------------------------------------------------------------------

		cout << "Deleting *p=" << *p << endl ;
		delete p ;
		
		pauseAndWaitForKeyClick();

	//----------------------------------------------------------------------------
	//	Test polygon destructor.
	//----------------------------------------------------------------------------

	    DUPolygon polygon ;
	    
	    polygon.addPoint(p4) ;
	    cout << "Polygon after adding first point: " << polygon << endl;
	    polygon.addPoint(p2) ;
	    cout << "Polygon after adding next point: " << polygon << endl;
	    polygon.addPoint(p1) ;
	    cout << "Polygon after adding next point: " << polygon << endl;
	    polygon.addPoint(p3) ;
	    cout << "Polygon after adding next point: " << polygon << endl;
	    cout << endl ;
	

		pauseAndWaitForKeyClick();
		
	//----------------------------------------------------------------------------
	//	Test what happens when program ends.
	//----------------------------------------------------------------------------

		cout << endl << "Now it's time to say goodbye to all our company..." << endl ;
	
	    return 0;
	}


//----------------------------------------------------------------------------
//
//-------------------------- Subprogram Definitions --------------------------
//
//----------------------------------------------------------------------------


	void passByRef(DUPoint &p)
	{
	//------------------------------------------------------
	//	This procedure passes a DUPoint argument by reference.
	//------------------------------------------------------

		cout << endl << "  Entering passByRef( p=" << p << " )" << endl ;
		cout << "  Exiting passByRef( p=" << p << " )" << endl ;
	}

	void passByRefWithLocal(DUPoint &p)
	{
	//------------------------------------------------------
	//	This procedure passes a DUPoint argument by reference.
	//  This procedure has a local DUPoint variable.
	//------------------------------------------------------

		cout << endl << "  Entering passByRefWithLocal( p=" << p << " )" << endl ;
		DUPoint q( p.getX()+1, p.getY()+1 ) ;
		cout << "    Creating Local Variable q=" << q << endl ;
		cout << "  Exiting passByRefWithLocal( p=" << p << " )" << endl ;
	}

	void passByVal(DUPoint p)
	{
	//------------------------------------------------------
	//	This procedure passes a DUPoint argument by value.
	//------------------------------------------------------

		cout << endl << "  Entering passByVal( p=" << p << " )" << endl ;
		cout << "  Exiting passByVal( p=" << p << " )" << endl ;
	}

	void passByValWithLocal(DUPoint p)
	{
	//------------------------------------------------------
	//	This procedure passes a DUPoint argument by value.
	//  This procedure has a local DUPoint variable.
	//------------------------------------------------------

		cout << endl << "  Entering passByValWithLocal( p=" << p << " )" << endl ;
		DUPoint q( p.getX()+1, p.getY()+1 ) ;
		cout << "    Creating Local Variable q=" << q << endl ;
		cout << "  Exiting passByValWithLocal( p=" << p << " )" << endl ;
	}
	
	void pauseAndWaitForKeyClick()
	{
	//------------------------------------------------------
	//	Wait for the user to strike a letter key.
	//------------------------------------------------------

		string prompt = "Hit 'c' and <CR> to continue: " ;
		string line(prompt.size()+1,'=') ;	
		
		cout << endl << line << endl << prompt ;

		char ch;
		do {
			cin >> ch;
		} while ( ch != 'c' ) ;
		
		cout << endl;
	}
