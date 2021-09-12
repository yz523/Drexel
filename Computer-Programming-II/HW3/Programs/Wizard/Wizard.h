//
//  Wizard.h
//  HW3
//
//  Created by Benny on 4/19/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#ifndef __HW3__Wizard__
#define __HW3__Wizard__

#include <iostream>
#include <vector>
using namespace std;

class Wizard{
public:
    bool createNewFile(ofstream &out, string filename);
    void getClassName();
    void getObjects();
    void toCpp();
    void toH();
private:
    string classname_;
    int numOfObjects_;
    vector<string> type_;
    vector<string> object_;
};

#endif /* defined(__HW3__Wizard__) */
