//
//  Binary.cpp
//  HW5
//
//  Created by Benny on 5/16/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
#include <vector>
using namespace std;

int step=0;

int binary_search(const vector<int>& v,
                  int start, int finish, int key)
{
    step++;
    if (start > finish)
        return -1;
    
    int mid = (start + finish) / 2;
    
    cout << "missing["<<mid<<"]="<<step << endl;
    
    if (v[mid] == key){
        return mid;
    }
    else if (v[mid] < key){
        return binary_search(v, mid + 1, finish, key);
    }
    else{
        return binary_search(v, start, mid - 1, key);
    }
}

int main(){
    vector<int>v(15);
    for(int i=0;i<15;i++){
        v[i]=2*i;
    }
    for(int k=0;k<=15;k++){
        cout<<endl;
        cout<<2*k-1<<" is not in the vector"<<endl;
    binary_search(v,0,15,2*k-1);
        step=0;
    }
    
    cout<<endl;
}

int revised_linear_search(const vector<int>& v, int key, int startLocation = 0){
    if(v[startLocation]>=key)
        return -1;
    else
        return revised_linear_search(v, key, startLocation+1);
}

vector<int>::iterator revised_linear_search_iterator(vector<int>& v, int key){
    if(*v.begin()>=key)
        return v.end();
    else
        return v.begin();
}
