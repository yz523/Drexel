//
//  main.cpp
//  L8
//
//  Created by Benny on 2/27/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
#include <string>
using namespace std;

string myfunction(string pattern, string replacement, string input){
    if(input.find(pattern)!=string::npos){
        return input.replace(input.find(pattern),pattern.length(),replacement);
    }
    else{
        return input;
    }
}

int main(){
    string pattern;
    string replacement;
    string input;
    cout << "Enter the pattern:";
    cin >> pattern;
    cout << "Enter the replacement:";
    cin >>replacement;
    while(input!="$$"){
        cout << "Enter the input:";
        cin >> input;
        if(input!="$$"){
        cout << myfunction(pattern, replacement, input)<<endl;
        }
    }
}