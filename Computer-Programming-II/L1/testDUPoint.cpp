//----------------------------------------------------------------------------
//
//------------------------------ DUPoint Tester ------------------------------
//
//----------------------------------------------------------------------------
//
//  Program Name: testDUPoint 
//
//  This program introduces and demonstrates a simple class definition, for use  
//  and modification in CS172 (Computer Programming II) at Drexel University.
//
//  Author:              Hoi Man Chang
//  Course:              MCS172, 1998
//  Date:                02/06/98
//
//  Modified by          Modified Date   Comments
//  Hoi Man Chang        02/06/98
//  JL Popyack           04/29/98        Simplify the old version
//  JL Popyack           04/03/2002      Combine header and implementation of
//                                       DUPoint class into program; reformat. 
//
//----------------------------------------------------------------------------

	#include <iostream>
	#include <string>
	#include <sstream>

	using namespace std ;

    #include "DULine.h"


//----------------------------------------------------------------------------
//
//------------------------------- Main Program -------------------------------
//
//----------------------------------------------------------------------------


	int main (void)
	{
	    DUPoint p1(1,2), p2(4,5), p3(8,0);
        DULine line1(p1,p2), line2(5,6,8,9);
        
        DUPoint *p=&p1, *q;
        q = p;
        cout << q <<endl;
        cout << p <<endl;
        
        
        p1.output(cout);
	    cout << endl;
        cout << p2.toString() << endl;

	    p1 = DUPoint(5,6);
        p1.toString();
        p1.output(cout);
	    cout<< endl;

	    p2.setX(10);
	    cout << p2.toString() << endl;
        
        p3 = DUPoint(8,0);
        p3.toString();
        p3.output(cout);
        cout<< endl;
        
        cout<< "The coordinates of the triangle are "<<p1.toString()<<p2.toString()<<p3.toString()<<endl;
        
        line1.setPoint1(10, 10);
	    cout << "line1: "   << line1.toString()         << "; line2: " << line2.toString()         << endl;
        
        for(int i=0;i<10;i++){
            cout<<i;
        }
	    return 0;
	}
