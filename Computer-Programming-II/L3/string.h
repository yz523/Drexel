//
//  string.h
//  L3
//
//  Created by Benny on 4/16/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#ifndef __L3__string__
#define __L3__string__

#include <stdio.h>
#include <iostream>
#include <string>
using namespace std;

class Mystring{
    public:
    Mystring(string s, int n);
    void output(ostream &out);
    string toString();
    private:
    string s_;
    int n_;
};
    ostream& operator<< (ostream& out, Mystring &s) ;
#endif /* defined(__L3__string__) */
