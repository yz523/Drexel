//
//  Header.h
//  HW3
//
//  Created by Benny on 4/18/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#ifndef TIMEB_Header_h
#define TIMEB_Header_h

#include<iostream>
using namespace std;

class Time
{
public:
    Time& operator++(int unused);
private:
    int seconds_;
};

Time& Time::operator++(){
    Time clone(seconds_,1)
    seconds_+=1;
    return clone;
}
#endif
