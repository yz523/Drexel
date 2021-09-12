//
//  L7-2.cpp
//  L7
//
//  Created by Benny on 2/20/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
#include <cstdlib>
#include <ctime>
#include <cmath>
using namespace std;

double Random_number(double i){
    i = (rand() % 200) - 100 ;
    i /= 100;
    return i;
}

double Polar_coodinate(double x,double y, double r,double o){
    x = Random_number();
    y = Random_number();
    r = sqrt(x*x+y*y);
    o = atan(y/x);
    return r;
}

int main(){
    double result_1;
    double result_2;
    int seed = static_cast<int>( time( 0 ));
    srand( seed );
    for(int i=0;i<100000;i++){
        if(Polar_coodinate(x,y)<=1){
            result_1 +=1;
        }
        else{
            result_2 +=1;
        }
    }
    cout <<4*(result_1/100000);
}