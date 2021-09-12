//----------------------------------------------------------------------------
//
//  DU Point class
//    Header
//
//  This class represents an ordered pair (x,y).
//
//----------------------------------------------------------------------------
//
//  Author:         Hoi Man Chang
//  Course:         MCS172
//  Date:           02/06/98
//
//  Modified:       JL Popyack: 04/28/98, 5/13/98, 4/22/99
//  Modified:       Paul Zoski 04/18/00
//                   -removed spurious spaces to fix
//					  "unexpected class" error
//  Modified:       JL Popyack, 4/15/2002
//
//----------------------------------------------------------------------------

	#ifndef _DUPoint_h_
	#define _DUPoint_h_

	#include <string>
	using namespace std ;

//----------------------------------------------------------------------------
//----------------------------------------------------------------------------

	class DUPoint
	{
	  public:
	  	
		//------------------------------------------------------
		//----- Constructors -----------------------------------
		//------------------------------------------------------
		
		  	DUPoint() ;
		  	DUPoint(int x, int y);
		  	DUPoint(const DUPoint & p) ;
		  	
		//------------------------------------------------------
		//----- Destructor -------------------------------------
		//------------------------------------------------------
		
		  	~DUPoint() ;
	  	
		//------------------------------------------------------
		//----- Inspectors -------------------------------------
		//------------------------------------------------------
	  	
		  	int getX() const;
		  	int getY() const;
	  	
		//------------------------------------------------------
		//----- Mutators ---------------------------------------
		//------------------------------------------------------
		  	
		  	void setX(int x);
		  	void setY(int y);
		  	
		//------------------------------------------------------
		//----- Facilitators -----------------------------------
		//------------------------------------------------------
		
			//------------------------------------------------------
			// return DUPoint in string form

			   string toString ();    

			//------------------------------------------------------
			// insert DUPoint in output stream

		  	   void output(ostream &sout) const ;
                void in(istream &in);
        string typeConvert(unsigned &x, string &y);
	  private:
		int x_ ;
		int y_ ;
	};


//----------------------------------------------------------------------------
//----- DUPoint: auxiliary operator descriptions -----------------------------
//----------------------------------------------------------------------------

	ostream& operator<< (ostream& out, const DUPoint &p) ;
    istream& operator>> (istream&in, DUPoint &p) ;
    DUPoint operator+(const DUPoint &left, const DUPoint &right);
    DUPoint operator/(const DUPoint &p, int x);
#endif