//
//  L8-3.cpp
//  L8
//
//  Created by Benny on 2/27/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
#include <string>
using namespace std;

bool test(string input){
    int i=0;
    int f=input.length()-1;
    while(i<f){
        if(input.substr(i,1)<input.substr(f,1)){
            return false;
        }
        i++;
        f--;
    }
    return true;
}


int main(){
    string input;
    while(input!="$$"){
        cout << "Enter the word:";
        cin >> input;
        if(test(input)==true){
            cout << input<<endl;
        }
        if(test(input)==false){
            string temp;
            for(int i=0;i<=input.length()/2+1;i++){
                temp += input.substr(input.length()-(i+1),1);
            }
            input = input + temp;
        }
         cout << input<<endl;
            }
}
