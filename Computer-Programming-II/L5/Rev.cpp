//
//  Rev.cpp
//  L5
//
//  Created by Benny on 5/2/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
#include <sstream>
#include <string>
using namespace std;

string removeChar( string s,char ch )
{
    if( s.length() == 0 )
        return "" ;
    else
    {
        stringstream ss;
        string temp;
        ss<<ch;
        ss>>temp;
        int last = s.length() - 1 ;
        string t = s.substr(last,1) ;
        string u = s.substr(0,last) ;
        if(t==temp){
            return removeChar(u,ch) + "";
        }
        else{
        return removeChar(u,ch) + t ;
        }
    }
}

int main(){
    string s="Mississippi";
    char ch='i';
    cout << removeChar(s,ch);
}