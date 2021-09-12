//----------------------------------------------------------------------------
//
//-------------------------- DUPoint, DULine Tester --------------------------
//
//----------------------------------------------------------------------------
//
//  Program Name: testDriver 
//
//  This program tests implementations of DUPoint and DULine classes.
//
//  Author:         Hoi Man Chang
//  Course:         MCS172
//  Date:           02/06/98
//
//  Modified:       JL Popyack: 04/28/98, 5/13/98, 4/22/99, 4/9/2
//
//
//----------------------------------------------------------------------------

	#include <iostream>
	#include <string>
	#include "DUPoint.h"
	#include "DULine.h"
	using namespace std;


//----------------------------------------------------------------------------
//
//-------------------------------- Prototypes --------------------------------
//
//----------------------------------------------------------------------------

	//------------------------------------------------------
	//	Reflect p about the x-axis by negating its y-component
	//------------------------------------------------------
		DUPoint reflectX(const DUPoint &p) ;

	//------------------------------------------------------
	//	Reflect p about the y-axis by negating its x-component
	//------------------------------------------------------
		DUPoint reflectY(DUPoint p) ;


//----------------------------------------------------------------------------
//
//------------------------------- Main Program -------------------------------
//
//----------------------------------------------------------------------------

	int main(void)
	{
	    DUPoint p1(1,2), p2(3,4), p3;

	    cout << "Output using accessor methods:" << endl;
		cout << "  p1: (" << p1.getX() << "," << p1.getY() << ")" << endl ;
		cout << "  p2: (" << p2.getX() << "," << p2.getY() << ")" << endl ;
		cout << "  p3: (" << p3.getX() << "," << p3.getY() << ")" << endl ;
		
	    cout << "\nOutput using facilitator method:" << endl ;
	   
		//----------------------------------------------------------------------------
		// Insert code here to output p1, p2, and p3 using the output() facilitator
		//----------------------------------------------------------------------------
        p1.output(cout);
        p2.output(cout);
        p3.output(cout);
			    
		DUPoint p4 = p1 ;
		DUPoint p5(p2) ;
		DUPoint p6 = reflectX(p4) ;
		DUPoint p7 = reflectY(p5) ;

		//----------------------------------------------------------------------------
		// Insert code here to output p4, p5, p6, p7 using the output() facilitator
		//----------------------------------------------------------------------------
        p4.output(cout);
        p5.output(cout);
        p6.output(cout);
        p7.output(cout);

		DULine line1(-5,-3,2,4) ;
		DULine line2(p1,p2) ;
		
	    cout << endl ;
	    
	    cout << "Output using output() method:" << endl;
        cout << "  line1: " ;
        line1.output(cout) ;
		cout << "  line2: ";
        line2.output(cout) ;
	    return 0;
	}


//----------------------------------------------------------------------------
//
//-------------------------- Subprogram Definitions --------------------------
//
//----------------------------------------------------------------------------

	DUPoint reflectX(const DUPoint &p)
	{
	//------------------------------------------------------
	//	Reflect p about the x-axis by negating its y-component
	//------------------------------------------------------
	
		int x = p.getX() ;
		int y = p.getY() ;
		
		DUPoint q ;
		q.setX(x) ;
		q.setY(-y) ;
		
		return q ;

	}

	DUPoint reflectY(DUPoint p)
	{
	//------------------------------------------------------
	//	Reflect p about the y-axis by negating its x-component
	//------------------------------------------------------

		return DUPoint( -p.getX(),p.getY() ) ; 

	}

