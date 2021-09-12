//
//  test_string.cpp
//  L3
//
//  Created by Benny on 4/16/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
using namespace std;
#include "string.h"

int main(void){
    Mystring s1("yz", 523);
    cout << s1<<endl;
    Mystring s2("yz", -523);
    cout << s2<<endl;
    Mystring s3("yz",0);
    cout <<s3<<endl;
}