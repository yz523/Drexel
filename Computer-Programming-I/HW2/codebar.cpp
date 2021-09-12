//
//  main.cpp
//  HW2
//
//  Created by Benny on 2/7/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
using namespace std;

const string HALFBAR = ":";
const string FULLBAR = "|";
const string ONEBAR = "00011";
const string TWOBAR =  "00101";
const string THREEBAR =  "00110";
const string FOURBAR =  "01001";
const string FIVEBAR =  "01010";
const string SIXBAR =  "01100";
const string SEVENBAR =  "10001";
const string EIGHTBAR =  "10010";
const string NINEBAR =  "10100";
const string ZEROBAR =  "11000";
const int NUMBER_OF_DIGITS_IN_A_ZIP_CODE = 5;
const string ZERO_DIGIT = "0";
const string ONE_DIGIT = "1";

string convertDigit(int value){
    string BINARY_STRING; //Define a string to fit different bars
    string BAR; //Equal to "|"(1) or ":"(0)
    string SUM;
    switch(value){
        case 1:
            BINARY_STRING = ONEBAR;
            break;
        case 2:
            BINARY_STRING = TWOBAR;
            break;
        case 3:
            BINARY_STRING =	THREEBAR;
            break;
        case 4:
            BINARY_STRING =	FOURBAR;
            break;
        case 5:
            BINARY_STRING =	FIVEBAR;
            break;
        case 6:
            BINARY_STRING =	SIXBAR;
            break;
        case 7:
            BINARY_STRING =	SEVENBAR;
            break;
        case 8:
            BINARY_STRING =	EIGHTBAR;
            break;
        case 9:
            BINARY_STRING =	NINEBAR;
            break;
        case 0:
            BINARY_STRING= ZEROBAR;
            break;
        default:
            break;
    }  //Fit each number to the binary string bar.
    
    for(int i=0;i<5;i++){
        if(BINARY_STRING.substr(i,1)==ZERO_DIGIT){
            BAR = HALFBAR;
        }
        else{
            BAR = FULLBAR;
        }
        SUM += BAR; //Add bars together
    }
    
    return SUM; //Output the sum
}

int makeCheckDigit(int value){
    int INPUT;
    INPUT = value; //Define a int variable equal to the input value
    int REM=0; //Set initial remainder value to 0
    int SUM=0;
    int i=0;//Set loop initial constant to 0
    int checkDigit=0;//Set initial check digit to 0
    
    do{
        REM=INPUT%10;
        SUM+=REM;
        INPUT/=10;
        i++;
    } //Abstract each digit of the zipcode and then add them together
    while(i<5);
    if(SUM%10!=0){
        checkDigit = 10 - (SUM%10);
    }//If the check is 10, return initial value checkDigit which is 0, otherwise return the value as formula
    return checkDigit;
}

string  barcode(int zipcode){
    int checkDigit;
    int i = 10000;//Set the loop comstant from 10000
    string CHECK_DIGIT_BAR;
    string DIGIT_BAR;
    checkDigit = makeCheckDigit(zipcode);//Get the checkdigit of the zipcode
    CHECK_DIGIT_BAR = convertDigit(checkDigit);//Get the checkdigit bar
    while(i>0){
        zipcode = (zipcode/i)%10;
        DIGIT_BAR+=convertDigit(zipcode);
        i/=10;
    } //Abstract the digit of the zipcode from the first one to the last one
      //convert the number to bars and add them together
    DIGIT_BAR = FULLBAR+ DIGIT_BAR + CHECK_DIGIT_BAR + FULLBAR;
      //There are two single fullbar at the beginning and the end of the digit bars.
    return DIGIT_BAR;
}

int main(){
    int zipcode;
    cout << "Enter the zipcode:";
    cin >> zipcode;
    cout << barcode(zipcode)<<endl;
}