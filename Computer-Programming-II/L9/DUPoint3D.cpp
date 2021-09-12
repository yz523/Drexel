//----------------------------------------------------------------------------
//
//  DU Point class
//    Implementation
//
//  This class represents an ordered triple (x,y,z).
//  It is derived from the DUPoint class.
//
//----------------------------------------------------------------------------
//
//  Author:         JL Popyack
//  Course:         CS172
//                  Derived from DUPoint class (by Hoi-Man Chang)
//  Date:           5/26/99
//
//  Modified:       JL Popyack: 5/20/2
//
//----------------------------------------------------------------------------

	#include <iostream>
	#include <string>
	#include <sstream>
	#include <ciso646>
	#include <cassert>
	using namespace std ;

	#include "DUPoint3D.h"
	

//----------------------------------------------------------------------------
//----- Constructors ---------------------------------------------------------
//----------------------------------------------------------------------------

	DUPoint3D::DUPoint3D() 
	         : DUPoint()
	{ }

	DUPoint3D::DUPoint3D(int x, int y, int z) 
	         : DUPoint(x,y)
	{ 
		z_ = z ;
	}
	 
	/*
	//------------------------------------------------------
	// Another form for this constructor
	
		DUPoint3D::DUPoint3D(int x, int y, int z) 
		         : DUPoint(x,y), z_(z) 
		{ }
	
	//------------------------------------------------------
	*/

	DUPoint3D::DUPoint3D(const DUPoint3D & p) 
	         : DUPoint()
	{ 
		setX( p.getX() ) ;
		setY( p.getY() ) ;
		setZ( p.getZ() ) ;
	}

	/*
	//------------------------------------------------------
	// Another form for this constructor

		DUPoint3D::DUPoint3D(const DUPoint3D & p) 
		         : DUPoint(p.getX(),p.getY()), z_(p.getZ())  
		{ }
	
	//------------------------------------------------------
	*/

//----------------------------------------------------------------------------
//----- Inspectors -----------------------------------------------------------
//----------------------------------------------------------------------------

	int DUPoint3D::getZ() const 
	{
		return z_;
	}
  
//----------------------------------------------------------------------------
//----- Mutators -------------------------------------------------------------
//----------------------------------------------------------------------------

	void DUPoint3D::setZ(int z) 
	{
		z_ = z;
	}

//----------------------------------------------------------------------------
//----- Facilitators ---------------------------------------------------------
//----------------------------------------------------------------------------

		
		string DUPoint3D::toString() const
		{
			ostringstream os;
			os << "(" << getX() << "," << getY() << "," << getZ() << ")";
			string s = os.str();
			return s;
		}


	//----------------------------------------------------------------------------

		void DUPoint3D::output(ostream &out) const 
		{
			out << toString() ;
		}


	//----------------------------------------------------------------------------

		void DUPoint3D::input(istream &in) 
		{
			char ch1, ch2, ch3, ch4;
			int x, y, z ;
			in >> ch1   // read "("
			   >> x 
			   >> ch2   // read ","
			   >> y 
			   >> ch3   // read ","
			   >> z
			   >> ch4 ; // read ")"
			    
			assert( ch1=='(' and ch2==',' and ch3==',' and ch4==')' ) ;
			
			setX(x) ;
			setY(y) ;
			setZ(z) ;
		}

//----------------------------------------------------------------------------
//----- Destructor -----------------------------------------------------------
//----------------------------------------------------------------------------

	DUPoint3D::~DUPoint3D() 
	{ }
	
//----------------------------------------------------------------------------
//----- DUPoint3D: auxiliary operator descriptions ---------------------------
//----------------------------------------------------------------------------

	
	ostream& operator<< (ostream& out, const DUPoint3D &p) 
	{
		p.output(out) ;
		return out;
	}

	istream& operator>> (istream& in, DUPoint3D &p) 
	{
		p.input(in) ;
	    return in;
	}