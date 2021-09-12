//
//  BAC.cpp
//  HW3
//
//  Created by Benny on 2/21/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
#include <iomanip>
using namespace std;

const double safe = 0.00;
const double someImpairment = 0.04;
const double significantAffected = 0.08;
const double someCriminalPenalties = 0.10;
const double deathPossible = 0.30;
const string SAFE = "Safe To Drive";
const string SOMEIMPAIR = "Some Impairment";
const string SIGNIFICANT = "Driving Skills Significantly Affected";
const string MOST_STATES = "Criminal Penalties in Most US States";
const string ALL_STATES = "Legally Intoxicated - Criminal Penalties in All US States";
const string YOURE_DEAD = "Death is Possible!";

void computeBloodAlcoholConcentration(int numDrinks, int weight,int duration, double &maleBAC, double &femaleBAC){
    double maleBAC_Constant = 3.8;
    double femaleBAC_Constant = 4.5;
    double num = numDrinks;
    double wer = weight;
    double dur = duration;
    maleBAC = (num/wer)*maleBAC_Constant-((dur/40)*0.01);
    femaleBAC = (num/wer)*femaleBAC_Constant-((dur/40)*0.01);
    if(maleBAC<0){
        maleBAC = 0;
    }
    if(femaleBAC<0){
        femaleBAC = 0;
    }
}

string impairment(double bac){
    string temp;
    bac>deathPossible?temp=YOURE_DEAD:
    bac>=someCriminalPenalties?temp=ALL_STATES:
    bac>=significantAffected?temp=MOST_STATES:
    bac>=someImpairment?temp=SIGNIFICANT:
    bac>safe?temp=SOMEIMPAIR:temp=SAFE;
    return temp;
}

int promptForInteger(string const &message, int lower, int upper){
    int temp;
    do{
        cout << "Enter the number of drinks(0~20):";
        cin >>temp;
    }while(temp>lower && temp>upper);
    return temp;
}

char promptForMorF(string const &message){
    bool temp = 1;
    string y = message;
    while(y!="M"&&y!="F"){
        cout << "Invaild sex value, Enter again(M/F):";
        cin >> y;
    }
    if(y=="M"){
        temp=1;
    }
    if(y=="F"){
        temp=0;
    }
    return temp;
}

void showImpairmentChart(int weight, int duration, bool isMale){
    cout <<"  " <<weight << " pounds, ";
    if(isMale==1){
        cout << "male"<<endl;
    }
    if(isMale==0){
        cout << "female"<<endl;
    }
}

int main(){
    int weight;
    int duration;
    int drinks;
    string message;
    double maleBAC;
    double femaleBAC;
    string sex;
    cout << "Enter the weight(in pounds):";
    cin >> weight;
    cout << "Enter the sex(M/F):";
    cin >> sex;
    cout << "Enter the time since last drink(in minutes):";
    cin >> duration;
    drinks = promptForInteger("0", 0, 20);
    showImpairmentChart(weight,duration, promptForMorF(sex));
    cout <<"# drinks  BAC   Status"<<endl;
    for(int i=0;i<=drinks;i++){
        if(sex=="M"){
            computeBloodAlcoholConcentration(i, weight, duration, maleBAC, femaleBAC);
            cout<<setw(7)<<i<<setprecision(2)<<setw(6)<<maleBAC<<"  "<<impairment(maleBAC)<<endl;
        }
        else{
            computeBloodAlcoholConcentration(i, weight, duration, maleBAC, femaleBAC);
            cout<<setw(7)<<i<<setprecision(2)<<setw(6)<<femaleBAC<<"  "<<impairment(femaleBAC)<<endl;
        }
    }
}

