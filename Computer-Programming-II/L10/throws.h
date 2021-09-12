//-----------*-*-C++-*-*-------------------------------------------
// throws.h -- i/f for functions that throw exceptions
//
// Kurt Schmidt
// 8/03
//
// Note:  For use w/lab.  So, will be modified, guided by instructions
// 		and comments
//

#ifndef __KS_THROWS_H_
#define __KS_THROWS_H_

void throwLong( long l ) throw( long );
void throwShort( short s ) throw( short );
void throwFloat( float l ) throw( float );
void throwString( const char *s ) throw( const char* );


#endif	// __KS_THROWS_H_
