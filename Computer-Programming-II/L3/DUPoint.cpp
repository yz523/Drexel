//----------------------------------------------------------------------------
//
//  DU Point class
//    Implementation
//
//  This class represents an ordered pair (x,y).
//
//----------------------------------------------------------------------------
//
//  Author:         Hoi Man Chang
//  Course:         MCS172
//  Date:           02/06/98
//
//  Modified:       JL Popyack: 04/28/98, 5/13/98, 4/22/99, 4/15/2
//
//----------------------------------------------------------------------------

	#include <iostream>
	#include <string>
	#include <sstream>

	#include "DUPoint.h"
	using namespace std ;
	

//----------------------------------------------------------------------------
//----- Constructors ---------------------------------------------------------
//----------------------------------------------------------------------------

	DUPoint::DUPoint() { }

	DUPoint::DUPoint(int x, int y)
	{
		x_ = x;
		y_ = y;
	}

	DUPoint::DUPoint(const DUPoint & p)
	{
		x_ = p.getX() ;
		y_ = p.getY() ;
	}

//----------------------------------------------------------------------------
//----- Destructor -----------------------------------------------------------
//----------------------------------------------------------------------------

	DUPoint::~DUPoint() { }

//----------------------------------------------------------------------------
//----- Inspectors -----------------------------------------------------------
//----------------------------------------------------------------------------

	int DUPoint::getX() const
	{
		return x_;
	}

	int DUPoint::getY () const
	{
		return y_;
	}
	  
//----------------------------------------------------------------------------
//----- Mutators -------------------------------------------------------------
//----------------------------------------------------------------------------

	void DUPoint::setX (int x)
	{
		x_ = x;
	}

	void DUPoint::setY (int y)
	{
		y_ = y;
	}

//----------------------------------------------------------------------------
//----- Facilitators ---------------------------------------------------------
//----------------------------------------------------------------------------

	string DUPoint::toString()
	{
		//---------------------------------------------------------------------
		//  The ostringstream type allows output to be directed to
		//  a string in the same style as usually done with a stream.
		//---------------------------------------------------------------------

		ostringstream os;
		os << "(" << x_ << "," << y_ << ")";
		string s = os.str();
		return s;
	}


	//----------------------------------------------------------------------------

	void DUPoint::output(ostream &out) const
	{
		out << "(" << x_ << "," << y_ << ")" ;
	}

    void DUPoint::in(istream &in)
{
    char a,b,c;
    int x,y;
    in >> a >> x>> b >> y>> c;
    x_=x;
    y_=y;
}

string DUPoint::typeConvert(unsigned &x, string &y){
    string s;
    stringstream ss;
    ss << x;
    ss >> s;
    y = s;
    return y;
}


//----------------------------------------------------------------------------
//----- DUPoint: auxiliary operator descriptions -----------------------------
//----------------------------------------------------------------------------


	ostream& operator<< (ostream& out, const DUPoint &p)
	{
		p.output(out) ;
		return out;
	}

    istream& operator>> (istream&in, DUPoint &p)
    {
        p.in(in);
        return in;
    }
    DUPoint operator+(const DUPoint &left, const DUPoint &right){
        int tempx=left.getX()+right.getX();
        int tempy=left.getY()+right.getY();
        DUPoint temp(tempx,tempy);
        return temp;
    }
    DUPoint operator/(const DUPoint &p, int x){
        int tempx=p.getX()/x;
        int tempy=p.getY()/x;
        DUPoint temp(tempx,tempy);
        return temp;
    }
