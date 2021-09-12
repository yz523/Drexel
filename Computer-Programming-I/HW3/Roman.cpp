//
//  Roman.cpp
//  HW3
//
//  Created by Benny on 2/16/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include<iostream>
#include<string>
using namespace std;

int value(string number){
    int value=0;
    if(number=="I"){value=1;}
    if(number=="V"){value=5;}
    if(number=="X"){value=10;}
    if(number=="L"){value=50;}
    if(number=="C"){value=100;}
    if(number=="D"){value=500;}
    if(number=="M"){value=1000;}
    return value;
}

int convertRomanNumber(string number){
    int sum=0;
    string rest=number;
    for(int i=1;rest.length()!=0;i++){
        string first = rest.substr(0,1);
        string second = rest.substr(1,1);
        if(value(first)>=value(second) && value(first)!=0){
            sum =sum + value(first);
            rest=rest.substr(1,rest.length()+1);
        }
        else if(value(first)<value(second)&& value(first)!=0){
            sum = sum + (value(second)-value(first));
            rest=rest.substr(2,rest.length()+2);
        }
        else{
            cout << number;
            break;
        }
    }
    return sum;
}

int main(){
    string number;
    cin >> number;
    cout << convertRomanNumber(number);
}
