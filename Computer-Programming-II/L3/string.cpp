//
//  string.cpp
//  L3
//
//  Created by Benny on 4/16/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include "string.h"
#include <iostream>
#include <string>
using namespace std;

Mystring::Mystring(string s, int n){
    s_=s;
    n_=n;
}

string Mystring::toString(){
    string temp;
    if(n_>0){
    temp = s_ + to_string(n_);
    }
    if(n_==0){
    temp = s_;
    }
    if(n_<0){
    n_*=(-1);
    temp = "-" +s_+to_string(n_);
    }
    return temp;
}

void Mystring::output(ostream &out){
    out << toString();
}

ostream& operator<< (ostream& out, Mystring &s){
    s.output(out);
    return out;
}
