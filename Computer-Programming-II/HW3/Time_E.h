//
//  Header.h
//  HW3
//
//  Created by Benny on 4/18/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#ifndef TIMEE_Header_h
#define TIMEE_Header_h

#include<iostream>
using namespace std;

class Time
{
public:
    Time& operator++();
    Time& operator--();
private:
    int hour_;
};

Time& Time::operator++(){
    hour_+=1;
    return *this;
}

Time& Time::operator--(){
    hour_-=1;
    return *this;
}
#endif
