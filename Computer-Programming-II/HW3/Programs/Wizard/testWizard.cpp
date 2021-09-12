//
//  testWizard.cpp
//  HW3
//
//  Created by Benny on 4/19/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
#include <fstream>
using namespace std;
#include "Wizard.h"

int main(){
    Wizard w;
     w.getClassName();
    w.getObjects();
    w.toH();
    w.toCpp();
}
