//
//  Set.cpp
//  L6
//
//  Created by Benny on 2/13/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <stdio.h>
#include <iostream>
#include <set>
#include <tuple>
#include <vector>
using namespace std;

char VEC_I,VEC_F, SET_PREFIX;
int VEC_SIZE;

void mytuple(int VEC_SIZE){
      vector<char> myvector;
      myvector.resize(VEC_SIZE);
    if(VEC_SIZE>0){
      for(myvector[VEC_SIZE]=VEC_I;myvector[VEC_SIZE]<=VEC_F;myvector[VEC_SIZE]++){
          cout <<myvector[VEC_SIZE];
          VEC_SIZE--;
          mytuple(VEC_SIZE);
      }
        cout<<" ";
    }
    else{
        return;
    }
}

int main(){
    cout << "Enter starting parameter:";
    cin >> VEC_I;
    cout << "Enter ending parameter:";
    cin >> VEC_F;
    cout << "Enter the size:";
    cin >> VEC_SIZE;
    mytuple(VEC_SIZE);
}