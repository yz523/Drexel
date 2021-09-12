//
//  Units.cpp
//  HW1
//
//  Created by Benny on 1/21/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
using namespace std;
   int a;
   int gill;
   int cup;
   int pint;
   int quart;
   int gallon;
   int barrel;
   int tablespoons;

int main(){
    cout << "How many fluid ounces do you have? ";
    cin >> a;
    cout << a << " fluid ounces can be divided into: " << endl;
    if(a/5376 > 0){
        barrel = a / 5376;
        a = a % 5376;
    
        a = a;
    }
    if(a/128 > 0){
        gallon = a /128;
        a = a % 128;
    }
    if(a/32 > 0){
        quart = a / 32;
        a = a % 32;
    }
    if(a/16 > 0){
        pint = a /16;
        a = a % 16;
    }
    if(a /8 > 0){
        cup = a / 8;
        a = a % 8;
    }
    if(a/4 > 0){
        gill = a / 4;
        a = a % 4;
    }
    if(a/0.5 > 0){
        tablespoons = a/0.5;
        a = a % 1/2;
    }
    cout << barrel << " barrel(s)" << endl;
    cout << gallon << " gallon(s)" << endl;
    cout << quart << " quart(s)" << endl;
    cout << pint << " pint(s)" << endl;
    cout << cup << " cup(s)" << endl;
    cout << gill << " gill(s)" << endl;
    cout << tablespoons << " tablespoons" << endl;
}
