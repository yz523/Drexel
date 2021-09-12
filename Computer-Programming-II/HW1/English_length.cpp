//
//  English_Length.cpp
//  HW1
//
//  Created by Benny on 4/4/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
#include <string>
#include "English_length.h"
using namespace std;

//----------------------------------------------------------------------------
//----- Mutators -------------------------------------------------------------
//----------------------------------------------------------------------------

bool English_length::isLessThan(const English_length &L){
    double ImplicitLength=yards_+feet_/3.0+inches_/36.0;
    double ExplicitLength=L.yards_+L.feet_/3.0+L.inches_/36.0;
    if(ImplicitLength<ExplicitLength)
        return true;
    else
        return false;
}

English_length min( English_length L, English_length L_){
    if(L.isLessThan(L_))
        return L;
    else
        return L_;
}

