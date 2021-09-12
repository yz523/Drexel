//----------------------------------------------------------------------------
//
//-------------------------- Bode's Law Calculation --------------------------
//
//----------------------------------------------------------------------------
//
// Name   : Bode's Law
// Version : 2.0b
// Purpose: Demonstration program to be used for 
//          examining output in scientific notation.
//          This program uses Bode's formula for 
//          estimating the distance between the Sun
//          and the planets in our solar system.
//
// Author  : Jeffrey L. Popyack
// Date    : Feb. 5, 1998
// Modified: Feb. 26, 2001; April 22, 2002; April 20, 2003
//
//
//----------------------------------------------------------------------------

	#include <iostream>
	#include <string>
    #include <vector>
	#include <iomanip>
    #include <cmath>
	using namespace std;


//----------------------------------------------------------------------------
//
//-------------------------------- Prototypes --------------------------------
//
//----------------------------------------------------------------------------

//	Draw column guides up to NumColumns wide
	void columnGuides(int NumColumns) ;



//----------------------------------------------------------------------------
//
//------------------------------- Main Program -------------------------------
//
//----------------------------------------------------------------------------

	int main(void)
	{
	//------------------------------------------------------------------------
	// Bode's formula estimates the distance from planet n
	// to the Sun according to the following formula:
	//                   (n-2)
	//    dist = (4 + 3*2     )/10,
	// where dist is given in astronomical units, and
	// one astronomical unit equals 93,000,000 miles.
	//------------------------------------------------------------------------

	//------------------------------------------------------------------------
	// PLANET_2, PLANET_3, etc. are the names of the planets.
	//------------------------------------------------------------------------
		
        vector<string>PLANET(11);
        PLANET[1] = "Mercury";
        PLANET[2] = "Venus",
        PLANET[3] = "Earth" ,
        PLANET[4] = "Mars" ;
        PLANET[6] = "Jupiter";
        PLANET[7] = "Saturn";
        PLANET[8] = "Uranus";
        PLANET[9] = "Neptune";
        PLANET[10] = "Pluto";

	//------------------------------------------------------------------------
	//  dist2, dist 3, etc. are estimated distances of
	//  planets from the Sun, using Bode's Law:
	//  e.g., dist2 is the distance from PLANET_2 to the Sun.
	//------------------------------------------------------------------------

        vector<double>dist(11);
        for(int i=1;i<=10;i++){
            if(i==5){
                i++;
            }
            dist[i] =(4+3*(pow(2,i-2)))/10.0;
        }
        
        vector<double>actualDis(11);
        actualDis[1]=0.39;
        actualDis[2]=0.72;
        actualDis[3]=1.00;
        actualDis[4]=1.52;
        actualDis[6]=5.20;
        actualDis[7]=9.54;
        actualDis[8]=19.18;
        actualDis[9]=30.06;
        actualDis[10]=39.44;
        
		
		columnGuides(60) ;
		
	//------------------------------------------------------------------------
	//  Output table of estimated distances from planets to the Sun.
	//------------------------------------------------------------------------
		cout << "Planet  Astro Units (est.)  Miles (est.)  Actual Dis" << endl ;
        for(int i=1;i<=10;i++){
            if(i==5){
                i++;
            }
		cout << left << setw(8) << PLANET[i] ;
		cout << right << fixed << setw(11) << setprecision(3) << dist[i] ;
		cout << scientific << setw(19) << setprecision(2) << dist[i]*93000000 ;
            cout << right << fixed << setw(11)<<setprecision(2)<<actualDis[i];
		cout << endl ;
        }
		
		return 0 ;
	}


//----------------------------------------------------------------------------
//
//-------------------------- Subprogram Definitions --------------------------
//
//----------------------------------------------------------------------------

	void columnGuides(int NumColumns)
	{
	//------------------------------------------------------------------------
	/**
	   This procedure draws column guides of the form
	  
	              1         2         3    
	     123456789012345678901234567890123 ...
	     ---------------------------------
	  
	     @param NumColumns - the desired column width  
	  
	*/
	//------------------------------------------------------------------------
		
		int i ;
		
		for(i=1; i<=NumColumns/10; i++)
			cout << setw(10) << i ;
		cout << endl ;

		for(i=1; i<=NumColumns; i++)
			cout << i%10 ;
		cout << endl ;
		
		cout << setfill('-') << setw(NumColumns) << right << "-" << endl ;
		cout << setfill(' ') << resetiosflags(ios::right) ;
	}