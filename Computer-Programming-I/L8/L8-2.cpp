//
//  L8-2.cpp
//  L8
//
//  Created by Benny on 2/27/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
#include <string>
using namespace std;

void isvowel(string input, bool &i){
    if(input.substr(0,1)=="A")
        i=true;
    else if(input.substr(0,1)=="E")
        i=true;
    else if(input.substr(0,1)=="I")
        i=true;
    else if(input.substr(0,1)=="O")
        i=true;
    else if(input.substr(0,1)=="U")
        i=true;
    else if(input.substr(0,1)=="a")
        i=true;
    else if(input.substr(0,1)=="e")
        i=true;
    else if(input.substr(0,1)=="i")
        i=true;
    else if(input.substr(0,1)=="o")
        i=true;
    else if(input.substr(0,1)=="u")
        i=true;
    else{
        i=false;
    }
}

void findfirstvovwel(string input, int &temp){
    temp=input.find('A');
    if(temp>input.find('E'))
        temp=input.find('E');
    if(temp>input.find('I'))
        temp=input.find('I');
   if(temp>input.find('O'))
        temp=input.find('O');
    if(temp>input.find('U'))
        temp=input.find('U');
    if(temp>input.find('a'))
        temp=input.find('a');
    if(temp>input.find('e'))
        temp=input.find('e');
    if(temp>input.find('i'))
        temp=input.find('i');
    if(temp>input.find('o'))
        temp=input.find('o');
    if(temp>input.find('u'))
        temp=input.find('u');
}

int main(){
    string input;
    string f;
    int temp;
    bool i;
    while(input!="$$"){
        cout << "Enter the word:";
        cin >> input;
        isvowel(input, i);
        findfirstvovwel(input, temp);
        if(i==true){
            cout << input<<"way"<<endl;
        }
        if(i==false){
            cout <<input.substr(temp,input.length()-temp)<<input.substr(0,temp)<<"ay"<<endl;
        }
    }
}