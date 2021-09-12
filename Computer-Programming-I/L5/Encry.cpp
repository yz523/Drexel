//
//  wheel.cpp
//  L5
//
//  Created by Benny on 2/6/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
#include <stdio.h>
#include <stdlib.h>

using namespace std;

int WHEEL_POS_1;
int WHEEL_POS_2;
char a[2];
int x;

int oneEncry(){
    return (7*WHEEL_POS_1+(25-x))%26;
}

int oneDecry(){
    return 25-(x+7*(26-WHEEL_POS_1))%26;
}

int secEncry(){
    return (x+23*WHEEL_POS_2)%26;
}

int secDecry(){
    x = (x-23*WHEEL_POS_2)%26;
    if(x<0){
        x+=26;
    }
    return x;
}

int main(){
    cout << "Enter first wheel position:";
    cin >> WHEEL_POS_1;
    cout << "Enter second wheel position:";
    cin >> WHEEL_POS_2;
    cin.getline(a,2);
    while(a[0]!='$'){
        cout << "Input letter:";
        cin >> a;
        if(a[0]=='$'){
            break;
        }
        else if(a[0]+0>=97 && a[0]+0<=122){
            cout << "#" << endl;
        }
        else if(a[0]+0>=65 && a[0]+0<=90 && a[1] =='\0'){
            x = a[0]-65;
            x=  oneEncry();
            if(WHEEL_POS_1>=25){
                WHEEL_POS_1 = -1;
                WHEEL_POS_1++;
            }
            else{
                WHEEL_POS_1++;
            }
            x=secEncry();
            if(x<13){
                x = 2*x+1;
            }
            else{
                x = 2*(x-13);
            }
            cout << char(x+65)<< " ";
        }
        else if(atoi(a)>=0 && atoi(a)<=25){
            cout << char(atoi(a)+65)<<endl;
        }
        else{
            cout << "#" << endl;
        }
    }
}