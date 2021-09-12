//
//  trace.cpp
//  HW4
//
//  Created by Benny on 5/3/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
using namespace std;

int GCD( int m, int n )
{
    if ( m == 0 )
        return 0 ;
    else if ( m < 0 )
        return GCD( -m, n ) ;
    else if ( m > n )
        return GCD( n, m ) ;
    else if ( m == n )
        return m ;
    else
        return GCD( n - m, m ) ;
}

int main(){
    cout<< GCD(212,-371);
}
