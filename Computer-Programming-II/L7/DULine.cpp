//----------------------------------------------------------------------------
//
//  DU Line class
//    Implementation
//
//  This class represents a line in two-dimensional space.
//
//----------------------------------------------------------------------------
//
//  Author:         Hoi Man Chang
//  Course:         MCS172
//  Date:           02/06/98
//
//  Modified:       JL Popyack: 04/28/98, 5/13/98, 4/22/99
//                  P Zoski:    5/5/00
//                    modified constructors to avoid references to untaught topics
//                  JL Popyack: 4/15/2, 5/8/2
//
//----------------------------------------------------------------------------

	#include <iostream>
	#include <string>
	#include "DULine.h"
	using namespace std ;
	

//----------------------------------------------------------------------------
//----- Constructors ---------------------------------------------------------
//----------------------------------------------------------------------------

	DULine::DULine () { } ;

	DULine::DULine (int x1, int y1, int x2, int y2)
	{ 
	      p1_ = DUPoint(x1,y1) ;
	      p2_ = DUPoint(x2,y2) ;
	}

	DULine::DULine (const DUPoint &p1, const DUPoint &p2)
	{ 
	      p1_ = p1 ;
	      p2_ = p2 ;
	}

//----------------------------------------------------------------------------
//----- Inspectors -----------------------------------------------------------
//----------------------------------------------------------------------------

	DUPoint DULine::getPoint1 () const
	{
		return p1_ ;
	}

	DUPoint DULine::getPoint2 () const
	{
		return p2_ ;
	}

//----------------------------------------------------------------------------
//----- Mutators -------------------------------------------------------------
//----------------------------------------------------------------------------

	void DULine::setLine (int x1, int y1, int x2, int y2)
	{
		setPoint1(x1,y1) ;
		setPoint2(x2,y2) ;
	}

	void DULine::setLine (const DUPoint &p1, const DUPoint &p2)
	{
		setPoint1(p1) ;
		setPoint2(p2) ;
	}

	void DULine::setPoint1 (int x, int y)
	{
		p1_ = DUPoint(x,y) ;
	}

	void DULine::setPoint2 (int x, int y)
	{
		p2_ = DUPoint(x,y) ;
	}

	void DULine::setPoint1 (const DUPoint &p)
	{
		p1_ = p ;
	}

	void DULine::setPoint2 (const DUPoint &p)
	{
		p2_ = p ;
	}


//----------------------------------------------------------------------------
//----- Facilitators ---------------------------------------------------------
//----------------------------------------------------------------------------

	string DULine::toString () const
	{
		string s = "[ " + getPoint1().toString() + "..." + getPoint2().toString() + " ]" ;
		return s ;
	}

	//----------------------------------------------------------------------------

	void DULine::output(ostream &out) const
	{
		out << toString() ;
	}

	//----------------------------------------------------------------------------

	void DULine::input(istream &in)
	{
		char ch ;
		in >> p1_ ;
		in >> ch ;   // read ","
		in >> p2_ ;
	}
	
//----------------------------------------------------------------------------
//----- DULine: auxiliary operator descriptions ------------------------------
//----------------------------------------------------------------------------


	istream& operator>> (istream& in, DULine &L)
	{
		L.input(in);
		return(in);
	}

	//----------------------------------------------------------------------------

	ostream& operator<< (ostream& out, const DULine &L)
	{
		L.output(out);
		return(out);
	}