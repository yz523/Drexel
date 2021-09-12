//----------------------------------------------------------------------------
//
//  DU Polygon class
//    Implementation
//
//	  Includes DUPolygonNode implementation
//
//  This class represents a polygon in two dimensions as a
//  list of ordered pairs (x,y).
//
//  A DUPolygonNode consists of a DUPoint and a link.
//  A DUPolygon is a linked list of DUPolygonNode elements.
//
//----------------------------------------------------------------------------
//
//  Author:  JL Popyack
//  Course:  MCS172, 1998
//  Date:    05/18/98
//
//  Modified:       Paul Zoski 		05/15/00
//	                modified for Visual C++
//  Modified:       JL Popyack: 5/14/2
//					reformatted
//
//----------------------------------------------------------------------------		

	#include <iostream>
	#include <string>
	#include <ciso646>
	#include "DUPolygon.h"
	using namespace std ;


//----------------------------------------------------------------------------
//----------------------------------------------------------------------------



//----------------------------------------------------------------------------
//----- DUPolygonNode Implementation -----------------------------------------
//----------------------------------------------------------------------------

	//----------------------------------------------------------------------------
	//----- Constructors ---------------------------------------------------------
	//----------------------------------------------------------------------------

	  	DUPolygonNode::DUPolygonNode(DUPoint pt)
	  	{
	  		pt_ = pt ;
	  		link_ = NULL ;
	  	}

	  	DUPolygonNode::DUPolygonNode()
	  	{
	  		link_ = NULL ;
	  	}

	//----------------------------------------------------------------------------
	//----- Destructor -----------------------------------------------------------
	//----------------------------------------------------------------------------

	  	DUPolygonNode::~DUPolygonNode()
	  	{
	  		cout << "Say goodbye to the node containing " << *this << endl ;
	  		if( link_ != NULL )
	  			delete link_ ;	
	  	}
  	
	//----------------------------------------------------------------------------
	//----- Inspectors -----------------------------------------------------------
	//----------------------------------------------------------------------------

	  	DUPoint DUPolygonNode::getPoint() const
	  	{
	  		return pt_ ;
	  	}

	  	DUPolygonNode* DUPolygonNode::link() const
	  	{
	  		return link_ ;
	  	}
  	
	//----------------------------------------------------------------------------
	//----- Mutators -------------------------------------------------------------
	//----------------------------------------------------------------------------

		void DUPolygonNode::setLink(DUPolygonNode* target)
		{
			link_ = target;
		}
	  
	//----------------------------------------------------------------------------
	//----- Facilitators ---------------------------------------------------------
	//----------------------------------------------------------------------------

		void DUPolygonNode::output(ostream& out) const
		{
			out << pt_ << " ";
		}
		
	//----------------------------------------------------------------------------
	//----- DUPolygonNode: auxiliary operator descriptions -----------------------
	//----------------------------------------------------------------------------

		ostream& operator<< (ostream& out, const DUPolygonNode& pn)
		{
			pn.output(out) ;
			return out ;
		}

		ostream& operator<< (ostream& out, const DUPolygonNode* ptr)
		{
			if( ptr != NULL )
				ptr->output(out) ;
			return out ;
		}
	


//----------------------------------------------------------------------------
//----------------------------------------------------------------------------



//----------------------------------------------------------------------------
//----- DUPolygon Implementation ---------------------------------------------
//----------------------------------------------------------------------------

	//----------------------------------------------------------------------------
	//----- Constructors ---------------------------------------------------------
	//----------------------------------------------------------------------------

	  	DUPolygon::DUPolygon()
	  	{
	  		numPoints_ = 0 ;
	  		closed_polygon_ = false ;
	  		first_ = NULL ;
	  		last_ = NULL ;
	  	}
  	
	//----------------------------------------------------------------------------
	//----- Destructor -----------------------------------------------------------
	//----------------------------------------------------------------------------

	  	DUPolygon::~DUPolygon()
	  	{
	  		if( first_ != NULL )
	  			delete first_ ;
	  		first_ = NULL ;
	  		last_ = NULL ;
	  	}
  	
	//----------------------------------------------------------------------------
	//----- Inspectors -----------------------------------------------------------
	//----------------------------------------------------------------------------

		int DUPolygon::numPoints() const
		{
	  		return numPoints_ ;  		
	  	}
  	
  	
	  	DUPoint DUPolygon::getPoint(int i) const
	  	{
		//---------------------------------------------------------------------
		//  Retrieves point i from the polygon.
		//---------------------------------------------------------------------

	  		DUPolygonNode* ptr ;
	  		
			if( i<0 or i>numPoints_ )
				return DUPoint(0,0) ;

			ptr = first_ ;
			while( i>0 and ptr != NULL )
			{
				ptr = ptr->link() ;
				i-- ;
			}
				if( ptr == NULL )
				return DUPoint(0,0) ;
			else
				return ptr->getPoint() ;
	  	}
	  	
	  	
	  	bool DUPolygon::isClosed () const
	  	{
	  		return closed_polygon_ ;  		
	  	}
  	

	//----------------------------------------------------------------------------
	//----- Mutators -------------------------------------------------------------
	//----------------------------------------------------------------------------

	  	void DUPolygon::addPoint(const DUPoint &p)
	  	{
		//---------------------------------------------------------------------
		//  Adds a new point to the end of the polygon.
		//---------------------------------------------------------------------

	  		DUPolygonNode* ptr ;
	  		ptr = new DUPolygonNode(p) ;
	  		if( last_ != NULL )
		  			last_->setLink(ptr) ;
	  		last_ = ptr ;
	  		if( first_ == NULL )
	  			first_ = last_ ;
	  		numPoints_++ ;
	  	}
  	

	  	void DUPolygon::closePolygon()
	  	{
	  		if( first_ != NULL )
	  		{
		  		addPoint( getPoint(0) ) ;
		  		closed_polygon_ = true;
		  	}	
	  	}
  	
	//----------------------------------------------------------------------------
	//----- Facilitators ---------------------------------------------------------
	//----------------------------------------------------------------------------

		void DUPolygon::output(ostream& out) const
		{
			DUPolygonNode* ptr ;
			ptr = first_ ;
			while( ptr != NULL )
			{
				out << *ptr ;
				ptr = ptr->link() ;
	            if( ptr != NULL )
	            	out << "-->" ;
			}
		}
		
	//----------------------------------------------------------------------------
	//----- DUPolygon: auxiliary operator descriptions ---------------------------
	//----------------------------------------------------------------------------
		
		ostream& operator<< (ostream& out, const DUPolygon &polygon)
		{
			polygon.output(out) ;
			return out ;
		}
