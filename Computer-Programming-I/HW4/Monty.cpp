//
//  main.cpp
//  HW4
//
//  Created by Benny on 2/25/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
#include <cstdlib>
#include <ctime>
#include <random>
#include <cmath>
#include <iomanip>
using namespace std;


void setupDoors(char &door1, char &door2, char &door3){
    random_device rand;
    mt19937 gen(rand());
    uniform_int_distribution<int>r(0,2);
    
    if(r(gen)==0||r(gen)==1){
        door1='G';
        int a=random()%2;
        if(a==0){
            door2='G';
            door3='C';
        }
        if(a==1){
            door2='C';
            door3='G';
        }
    }
    if(r(gen)==2){
        door1='C';
        door2=door3='G';
    }
}

void pickDoorChoices(char door1, char door2, char door3, int &doorPlayer, int &doorMonty){
    random_device rand;
    mt19937 gen(rand());
    uniform_int_distribution<int>r(0,1);
    uniform_int_distribution<int>p(1,3);
    doorPlayer=p(gen);
    if(doorPlayer==1){
        if(door1=='C'){
            if(r(gen)==0){
                doorMonty=2;
            }
            if(r(gen)==1){
                doorMonty=3;
            }
        }
        if(door2=='C'){
            doorMonty=3;
        }
        if(door3=='C'){
            doorMonty=2;
        }
    }
    if(doorPlayer==2){
        if(door2=='C'){
            if(r(gen)==0){
                doorMonty=1;
            }
            if(r(gen)==1){
                doorMonty=3;
            }
        }
        if(door3=='C'){
            doorMonty=1;
        }
        if(door1=='C'){
            doorMonty=3;
        }
    }
    if(doorPlayer==3){
        if(door3=='C'){
            if(r(gen)==0){
                doorMonty=1;
            }
            if(r(gen)==1){
                doorMonty=2;
            }
        }
        if(door2=='C'){
            doorMonty=1;
        }
        if(door1=='C'){
            doorMonty=2;
        }
    }
}

int main(){
    char door1,door2,door3;
    int doorPlayer,doorMonty,temp=0;
    double switch_win=0,stay_win=0;
    for(int i=0;i<=10000;i++){
        setupDoors(door1, door2, door3);
        if(door1=='C'){
            temp=1;
        }
        if(door2=='C'){
            temp=2;
        }
        if(door3=='C'){
            temp=3;
        }
        pickDoorChoices(door1, door2, door3, doorPlayer, doorMonty);
        if(doorMonty==1){
            if(doorPlayer==temp){
                stay_win++;
            }
            else{
                switch_win++;
            }
        }
        if(doorMonty==2){
            if(doorPlayer==temp){
                stay_win++;
            }
            else{
                switch_win++;
            }
        }
        if(doorMonty==3){
            if(doorPlayer==temp){
                stay_win++;
            }
            else{
                switch_win++;
            }
        }
    }
    cout << "Stay win:"<<stay_win/10000*100<<"%"<<endl;
    cout << "Switch win:" <<switch_win/10000*100<<"%"<<endl;
}
