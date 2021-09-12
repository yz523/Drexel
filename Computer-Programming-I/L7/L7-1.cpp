//
//  L7.cpp
//  L7
//
//  Created by Benny on 2/20/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include<iostream>
#include<cstdlib>
#include<ctime>

using namespace std;

int n;
int a;

int Random_number(int n){
    return rand() % n;
}

void Vowel(int n){
    switch (n) {
        case 0: cout<<"A";break;
        case 1: cout<<"E";break;
        case 2: cout<<"I";break;
        case 3: cout<<"O";break;
        case 4: cout<<"U";break;
    }
}

void Consonants(int n){
    switch (n) {
        case 0: cout<<"B";break;
        case 1: cout<<"C";break;
        case 2: cout<<"D";break;
        case 3: cout<<"F";break;
        case 4: cout<<"G";break;
        case 5: cout<<"H";break;
        case 6: cout<<"J";break;
        case 7: cout<<"K";break;
        case 8: cout<<"L";break;
        case 9: cout<<"M";break;
        case 10: cout<<"N";break;
        case 11: cout<<"P";break;
        case 12: cout<<"Q";break;
        case 13: cout<<"R";break;
        case 14: cout<<"S";break;
        case 15: cout<<"T";break;
        case 16: cout<<"V";break;
        case 17: cout<<"W";break;
        case 18: cout<<"X";break;
        case 19: cout<<"Y";break;
        case 20: cout<<"Z";break;
            
    }
}


int main ()
{
    cout << "Enter the first value(4):";
    cin >> n;
    cout << "Enter the second value(20):";
    cin >> a;
    int seed = static_cast<int>( time( 0 ));
    srand( seed );
    for(int i=0;i<=5;i++){
        Consonants(Random_number(a));
        Vowel(Random_number(n));
     
    }
}
