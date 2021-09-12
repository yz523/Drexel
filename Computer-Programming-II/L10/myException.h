//-----------*-*-C++-*-*-------------------------------------------
// myException.h -- just a sample exception class
//
// Kurt Schmidt
// 8/03
//
// Note:  For use w/lab.  So, will be modified, guided by instructions
// 		and comments
//

#ifndef __KS_EXCEPTION_H_
#define __KS_EXCEPTION_H_

#include <string>

class myException
{
	protected:
		short _id;
		std::string _desc;
		bool _dyn;

		myException();
	
	public:
		myException( short id, const std::string desc, bool dyn=false )
			: _id( id ), _desc( desc ) {}

		short id() const { return _id; }
		const std::string& what() const { return _desc; }

		void destroy()
		{	if( _dyn ) delete this; }

};	// class myException

#endif	// __KS_EXCEPTION_H_
