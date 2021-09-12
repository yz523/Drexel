//
//  test.cpp
//  L3
//
//  Created by Benny on 4/17/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
#include <sstream>
#include "CardSuit.h"
using namespace std;

template <typename L, typename R>

void typeConvert(L &a, R &b){
    stringstream ss;
    ss << a;
    ss >> b;
}
int main(){
    int a = 2;
    string b = "abc";
    typeConvert(a,b);
    cout << b;
}