//
//  Lottery.cpp
//  HW4
//
//  Created by Benny on 5/3/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
#include <vector>
using namespace std;

int main(){
    vector<int>count(100);
    //set each vector's default value to 0
    for(int i=0;i<100;i++){
        count[i]=0;
    }
    //read file fin and count the value
    while(!fin.eof()){
    int value=0;
    fin>>value;
    count[value]+=1;
    }
    //output all vector's value
    for(int i=0;i<100;i++){
        cout << "Count["<<i<<"]:"<<count[i]<<endl;
    }
}
