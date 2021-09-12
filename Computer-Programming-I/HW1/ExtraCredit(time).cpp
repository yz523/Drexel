//
//  ExtraCredit(time).cpp
//  HW1
//
//  Created by Benny on 1/21/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
#include <iomanip>
using namespace std;

int t;
int h;
int m;
int x;

int main(){
    cout << "What is the current time in Philadelphia? " <<endl;
    cin >> t;
    cout << "Current times in other cities:" << endl;
    h = t / 100;
    m = t % 100;
    x = h*60 + m;
    
}



