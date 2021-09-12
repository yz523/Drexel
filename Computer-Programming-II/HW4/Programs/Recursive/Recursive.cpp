//
//  Recursive.cpp
//  HW4
//
//  Created by Benny on 5/3/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <vector>
#include <iostream>
using namespace std;

double sum(const vector<double>& x, int lo, int hi){
    int mid;
    mid = (lo+hi)/2;
    if(hi==lo){
        return x[hi];
    }
    else{
    return sum(x,lo,mid)+sum(x,mid+1,hi);
    }
}

int main(){
    vector<double>x(10);
    for(int i=0;i<10;i++){
    x[i]=1;
    }
    cout<<sum(x,0,5);
}
