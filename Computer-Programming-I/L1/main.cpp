//
//  main.cpp
//  L1
//
//  Created by Benny on 1/9/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
using namespace std;

    int main(void)
{
    const double INCHES_PER_METER = 39.37;
    const double POUNDS_PER_KG = 2.24;
    
    int height;
    int weight;
    
    cout << "METRIC CONVERTER" << endl << endl ;
    cout << "Enter your height in inches " ;
    cout << "(No fractions, please!) : " ;
    cin >> height;
    
    cout << "Enter your weight in pounds" ;
    cout << "(No fractions, please!) : " ;
    cin >> weight;
    cout << endl ;
    
    double metric_height = height/INCHES_PER_METER;
    double metric_weight = weight/POUNDS_PER_KG;
    
    cout << "Your height is " << metric_height << " meters." << endl;
    cout << "Your weight is " << metric_weight << " kilograms." << endl;
    
    char name,age;
    cin >> name>> age;
    cout << "The age of " << name << " is " << age << endl;
    
    return 0;

}
