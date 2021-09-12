//
//  Header.h
//  HW2
//
//  Created by Benny on 4/12/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//
//  create on 04/13/2015
//  version 1.00
//  revision history
//

#ifndef yz523_Header_h
#define yz523_Header_h

#include <iostream>
#include <sstream>
#include <string>
using namespace std;

//this function displays a prompt on the output console and returns a string.
string promptForString(string prompt);

static string promptForString(string prompt){ //the string promt here is the actual information display on the output console
    cout << prompt; //display a prompt
    return prompt; //return a string
}
#endif
