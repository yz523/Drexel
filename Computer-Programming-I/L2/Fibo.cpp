//
//  Fibo.cpp
//  L2
//
//  Created by Benny on 1/18/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>

using namespace std;

int f(int n)
{
    if(n == 1  ||  n == 2)
    {
        return 1;
    }
    else
    {
        return f(n-2) + f(n-1);
    }
    
}

int main()
{
    for(int i=1; i<11; i++)
    {
         cout << "F" << i << " = " << f(i) << endl;
    }
    return 0;
}
