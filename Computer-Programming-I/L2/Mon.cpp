//
//  Mon.cpp
//  L2
//
//  Created by Benny on 1/20/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>

using namespace std;

int month;
int main(void){
    cout << "Enter the month" << endl;
    cin >> month;
    if(month == 2){
        cout << "28 or 29 days";
    }
    else if(((month + 1) % 2 == 0 && month < 9) || ((month % 2 == 0) && (month >= 8))){
        cout << "31 days";
    }
    else{
        cout << "30 days";
    }
}