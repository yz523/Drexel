
//----------------------------------------------------------------------------
//
//------------------------------ Class Headers -------------------------------
//
//----------------------------------------------------------------------------
#ifndef __DUPOINT_H__
#define __DUPOINT_H__

class DUPoint
{
public:
	  	
    //------------------------------------------------------
    //----- Constructors -----------------------------------
    //------------------------------------------------------
    
    DUPoint();
    DUPoint(int x, int y);
    
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
    
    void output(ostream &sout) ;
    
private:
    int x_;
    int y_;
};

#endif
