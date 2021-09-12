//
//  Moon.cpp
//  L4
//
//  Created by Benny on 1/30/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
using namespace std;

const double g = -1.63;
double v;
doubl   e h;
double h_i;
double t=1;
double f;
double total=0;

int main(){
    cout << "Enter the initial altitude(meter): " << endl;
    cin >> h;
    cout << "Enter the initial velocity(m/s^2): " << endl;
    cin >> v;
    while(h>0){
        if(total<50){
            cout << "Enther the number of fuel units to burn ("<< 50-total <<" Units left)" << endl;
        cin >> f;
            if(f<0){
                    cout << "Invaild number, please enter positive number: ";
                cin >> f;
            }
            v += (g+0.1*f)*t;
            total += f;
        }
        else v += g*t;
        h += v*t;
        cout << "When he time = " << t << "s, the altitute is " << h <<"m, the velocity is " << v <<"m/s." <<endl;
        t++;
        if(v>-2)
            cout<< "Safe"<<endl;
        else
            cout<<"Crushed"<<endl;
    }
}