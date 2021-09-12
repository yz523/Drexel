//
//  power.cpp
//  L6
//
//  Created by Benny on 5/10/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
#include <functional>
#include <vector>
#include <algorithm>
using namespace std;

int i;

double fastPower( int x, int n, int k )
{
    //------ return values for special cases ----------
    
    if( x==0 || x==1 || n==1 ) // no calculation here
        return x ;
    
    if( n==0 ) // no calculation here
        return 1;
    
    if( n<0 ) // negative exponent means reciprocal
        return( 1.0 / fastPower( x, -n , k));
    
    //-------- powering done here ---------
    if( n%2 == 0 ) // n is even
    {
        i++;
        int temp = fastPower( x , n/2 , k);
        return (temp % k) * (temp % k);
    }
    else // n is odd
        i++;
        return (x % k) * fastPower( x, n-1 , k );
}

void songC(){
    cout<<1;
    songC();
}
int main(){
    songC();
}
