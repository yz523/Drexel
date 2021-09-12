//
//  Grade2.cpp
//  L2
//
//  Created by Benny on 1/20/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include<iostream>
using namespace std;

int main(){
double gpa;
    cout << "Enter your gpa: " << endl;
    cin >> gpa;
    if(gpa >= 0 && gpa < 0.7){
        cout << gpa << " " << "F" <<endl;
    }
    if(gpa >= 0.7 && gpa < 1){
        cout << gpa << " " << "D-" <<endl;
    }
    if(gpa >= 1 && gpa < 1.3){
        cout << gpa << " " << "D" <<endl;
    }
    if(gpa >= 1.3 && gpa < 1.7){
        cout << gpa << " " << "D+" <<endl;
    }
    if(gpa >= 1.7 && gpa < 2){
        cout << gpa << " " << "C-" <<endl;
    }
    if(gpa >= 2 && gpa < 2.3){
        cout << gpa << " " << "C" <<endl;
    }
    if(gpa >= 2.3 && gpa < 2.7){
        cout << gpa << " " << "C+" <<endl;
    }
    if(gpa >= 2.7 && gpa < 3){
        cout << gpa << " " << "B-" <<endl;
    }
    if(gpa >= 3 && gpa < 3.3){
        cout << gpa << " " << "B" <<endl;
    }
    if(gpa >= 3.3 && gpa < 3.7){
        cout << gpa << " " << "B+" <<endl;
    }
    if(gpa >= 3.7 && gpa < 4){
        cout << gpa << " " << "A-" <<endl;
    }
    if(gpa == 4){
        cout << gpa << " " << "A" <<endl;
    }
}

