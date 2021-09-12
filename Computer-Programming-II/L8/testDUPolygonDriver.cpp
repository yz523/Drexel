//----------------------------------------------------------------------------
//
//------------------------ DUPolygon Linked List Tester ----------------------
//
//----------------------------------------------------------------------------
//
//  Program Name: testDUPolygonDriver
//
//  This program investigates pointer concepts through the DUPoint and DULine 
//  classes.
//
//  Author:         JL Popyack
//  Course:         CS172
//  Date:           5/13/98
//
//  Modified:       Paul Zoski 		05/15/00
//	                modified for Visual C++
//  Modified:       JL Popyack: 5/14/2
//					reformatted
//
//----------------------------------------------------------------------------

	#include <iostream>
	#include <ciso646>
	using namespace std ;

	#include "DUPoint.h"
	#include "DUPolygon.h"
	
//----------------------------------------------------------------------------
//
//------------------------------- Main Program -------------------------------
//
//----------------------------------------------------------------------------

	int main(void)
	{

	//----------------------------------------------------------------------------
	//	Test DUPolygon creation and output
	//----------------------------------------------------------------------------

	    DUPoint p1(1,2), p2(4,5), p3(6,9), p4(-5,-1);
	    DUPolygon polygon;
	    
	    polygon.addPoint(p1) ;
	    cout << "Polygon after adding first point: " << polygon << endl;
	    polygon.addPoint(p2) ;
	    cout << "Polygon after adding next point: " << polygon << endl;
	    polygon.addPoint(p3) ;
	    cout << "Polygon after adding next point: " << polygon << endl;
	    polygon.addPoint(p4) ;
	    cout << "Polygon after adding next point: " << polygon << endl;
	    cout << endl ;
	
	//----------------------------------------------------------------------------
	//	Test DUPolygon inspectors and mutators
	//----------------------------------------------------------------------------

	    cout << "There are " << polygon.numPoints() << " points in this polygon:" << endl ;
	    
	    int i ;
	    for(i=0; i< polygon.numPoints(); i++)
	    	cout << "  Point #" << i << ": " << polygon.getPoint(i) << endl ;
	    cout << endl ;
	    
	    polygon.closePolygon() ;
	    cout << "After closing the polygon, it has " 
	         << polygon.numPoints() << " points:" << endl ;
	    cout << " " << polygon << endl << endl ;    
	    
		cout << "Creating a user-defined polygon :" << endl ;	
		

	//----------------------------------------------------------------------------
	//	Test DUPolygon creation via user input
	//----------------------------------------------------------------------------

		DUPolygon q ;
        cout<<q;
		DUPoint pt ;
		char response ;
        
	    cout << "Before starting, there are " << q.numPoints() 
	         << " points in this polygon:" << endl ;
	    cout << " " << q << endl << endl ;    

		cout << "Input points, one per line :" << endl ;
		do {
			cin >> pt ;
			q.addPoint(pt) ;
			cout << " Add another? (y/n) : " ;
			cin >> response ;
		} while ( response != 'n' and response != 'N' ) ;

	    cout << "There are " << q.numPoints() << " points in this polygon:" << endl ;
	    cout << " " << q << endl << endl ;    


	//----------------------------------------------------------------------------
	//	Test dynamic DUPolygon creation.
	//----------------------------------------------------------------------------
	//	This section should be almost identical to the section above.
	//  However, the section above creates a polygon named q.  
	//	In this section, you will create a pointer to a polygon.
	//	The pointer will be named Q and you will create a new polygon
	//	that Q points at.
	//	You will do the same things with the new polygon as are
	//	done in the code above.  The difference is that the code
	//	will need to be rewritten to handle the fact that Q is a 
	//	pointer to a DUPolygon, not a DUPolygon.
	//----------------------------------------------------------------------------


		//----------------------------------------------------------------------------
		// 1. Insert a line here that declares Q as a 
		//    pointer to a DUPolygon.
		//----------------------------------------------------------------------------
        DUPolygon *Q;
     
		//----------------------------------------------------------------------------
		// 2. Insert a line here that creates a new DUPolygon 
		//    with Q pointing at it.
		//----------------------------------------------------------------------------
		
        Q = new DUPolygon;
		    cout << "Testing dynamic DUPolygon creation" << endl; 
		    cout << "Before starting, there are " << 
	    
		//----------------------------------------------------------------------------
		// 3. How many points are in the DUPolygon that Q points at?
		//    Insert an expression here which has this value.
		//----------------------------------------------------------------------------
	    
		       Q->numPoints()  << " points in this polygon:" << endl ;
		         
		         
		    cout << " " << 
	    
		//----------------------------------------------------------------------------
		// 4. We want to print the polygon that Q points at.
		//    Insert an expression here which has this value.
		//----------------------------------------------------------------------------

		        *Q << endl << endl ;

		//----------------------------------------------------------------------------
		//	Test DUPolygon* creation via user input
		//----------------------------------------------------------------------------

			cout << "Input points, one per line :" << endl ;
			do {
				cin >> pt ;
				Q->addPoint(pt) ;
				cout << " Add another? (y/n) : " ;
				cin >> response ;
			} while ( response != 'n' and response != 'N' ) ;

		    cout << "There are " << Q->numPoints() << " points in this polygon:" << endl ;
		    cout << " " << *Q << endl << endl ;
        
        

		return 0 ;
	}
