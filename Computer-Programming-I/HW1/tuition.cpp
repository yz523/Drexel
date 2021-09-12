//
//  main.cpp
//  HW1
//
//  Created by Benny on 1/21/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
#include <cmath>
using namespace std;

   int tuition = 15000;
   double rate = 0.05;
   int year = 1;
   int total;

int main(){
    cout << "Please enter your tuition amount (Hint: $15,000): " << endl;
    cin >> tuition;
    cout << "Please enter the tuition increase rate(Hint: 0.05): " << endl;
    cin >> rate;
    for(int year = 1; year <= 5; year++){
        tuition = (pow((1+rate),year)) * 15000;
        cout << "The " << year << " year's tuition is: " << tuition << " dollars." << endl;
        total += tuition;
    }
        cout << "The five year's total tuition is: " << total << " dollars." << endl;
}