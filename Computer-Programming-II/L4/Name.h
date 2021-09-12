//
//  Name.h
//  L4
//
//  Created by Benny on 4/23/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#ifndef __L4__Name__
#define __L4__Name__

#include <iostream>
#include <vector>
#include <string>
using namespace std;

class Convertname{
public:
    void get_name();
    void convert_name();
private:
    string first_name_;
    string last_name_;
};

#endif /* defined(__L4__Name__) */
