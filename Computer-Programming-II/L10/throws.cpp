//-----------*-*-C++-*-*-------------------------------------------
// throws.cpp -- implementation for functions that throw exceptions
//
// Kurt Schmidt
// 8/03
//
// Note:  For use w/lab.  So, will be modified, guided by instructions
// 		and comments
//

void throwLong( long l ) throw( long )
{
	throw l;
}

void throwShort( short s ) throw( short )
{
	throw s;
}

void throwFloat( float f ) throw( float )
{
	throw f;
}

void throwString( const char *s ) throw( const char* )
{
	throw s;
}


