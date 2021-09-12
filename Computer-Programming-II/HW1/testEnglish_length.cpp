//
//  testEnglish_length.cpp
//  HW1
//
//  Created by Benny on 4/4/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
#include <string>
#include "English_length.h"
using namespace std;

English_length min( English_length L, English_length L_){
    if(L.isLessThan(L_))
        return L;
    else
        return L_;
}
