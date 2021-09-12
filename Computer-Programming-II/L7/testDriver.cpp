//----------------------------------------------------------------------------
//
//-------------------------- DUPoint*, DULine* Tester ------------------------
//
//----------------------------------------------------------------------------
//
//  Program Name: testDriver cpp
//
//  This program investigates pointer concepts through the DUPoint and DULine 
//  classes.
//
//  Author:         JL Popyack
//  Course:         CS172
//  Date:           5/13/98
//
//  Modified:       JL Popyack: 5/8/2
//
//
//----------------------------------------------------------------------------

	#include <iostream>
	#include <string>
    #include <vector>
	#include "DUPoint.h"
	#include "DULine.h"
	using namespace std ;


//----------------------------------------------------------------------------
//
//-------------------------------- Prototypes --------------------------------
//
//----------------------------------------------------------------------------

	int  min_value  ( int &a, int &b ) ;
	int& min_element( int &a, int &b ) ;
	
//----------------------------------------------------------------------------
//
//------------------------------- Main Program -------------------------------
//
//----------------------------------------------------------------------------

	int main(void)
	{

		int i = 5, k = 7;
	
	//----------------------------------------------------------------------------
	// iPtr is a variable that can point to an integer
	//----------------------------------------------------------------------------
		int * iPtr ;	
					
	//----------------------------------------------------------------------------
	// iPtr is assigned the address of i
	// iPtr now "points at" i
	//----------------------------------------------------------------------------
		iPtr = &i ;
	
	//----------------------------------------------------------------------------
	// Printing iPtr reveals the address of i
	//----------------------------------------------------------------------------
		cout << "iPtr=" << iPtr << endl ;
	
	//----------------------------------------------------------------------------
	// The object pointed at by iPtr may be referenced
	// as *iPtr
	//----------------------------------------------------------------------------
		cout << "*iPtr=" << *iPtr << endl ;
		cout << "i=" << i << endl ;
	
	//----------------------------------------------------------------------------
	// jPtr is another 'integer pointer' variable
	//----------------------------------------------------------------------------
		int * jPtr ;
	
	//----------------------------------------------------------------------------
	// jPtr is assigned the value of iPtr
	// jPtr now holds the same address that iPtr holds
	//----------------------------------------------------------------------------
		jPtr = iPtr ;
		cout << "jPtr=" << jPtr << endl ;
        
        DUPoint p(3, 8);
        p.getX();
        p.getY();
        cout <<p;
	
        DUPoint * pPtr = & p;
        pPtr->getX();
        pPtr->getY();
        cout<<*pPtr;
        
        pPtr = new DUPoint(3,8) ;
        cout<<*pPtr;
        int temp;
        temp=pPtr->getY();
        pPtr->setY(pPtr->getX());
        pPtr->setX(temp);
        cout<<*pPtr;
        
        DULine L(p, *pPtr) ;
        cout << L << endl ;
        
        
        DUPoint q;
        q = L.getPoint1();
        DUPoint * qPtr = & q;
        cout << *qPtr;
        cout<<qPtr->getY()<<endl;
        
        vector<DUPoint>Triangle(3);
        Triangle[0]=*new DUPoint;
        Triangle[1]=*new DUPoint;
        Triangle[2]=*new DUPoint;
        for(int i=0;i<3;i++){
            int fir,sec;
            cout<<"Enter the points(seperate by blank):";
            cin >> fir >> sec;
            Triangle[i].setX(fir);
            Triangle[i].setY(sec);
        }
        
        for(int i=0;i<3;i++){
            cout<<Triangle[i];
        }
        int a,b;
    
        min_element(a,b)=0 ;

        
	    return 0;
	}


//----------------------------------------------------------------------------
//
//-------------------------- Subprogram Definitions --------------------------
//
//----------------------------------------------------------------------------

	int  min_value  ( int &a, int &b )
	{
		if( a < b )
			return a ;
		else
			return b ;
	}
	
//----------------------------------------------------------------------------
//
	int& min_element( int &a, int &b )
	{
		if( a < b )
			return a ;
		else
			return b ;
	}