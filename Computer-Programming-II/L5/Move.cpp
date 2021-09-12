//
//  Move.cpp
//  L5
//
//  Created by Benny on 5/2/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
using namespace std;

void Hanoi(int n, char fromPost, char toPost, char otherPost){
    if(n==1){
        cout <<"Move disk from post "<<fromPost<<" to "<<toPost<<endl;
    }
    else{
        Hanoi(n-1, fromPost, otherPost, toPost);
        cout <<"Move disk from pose "<< fromPost<<" to "<<toPost<<endl;
        Hanoi(n-1, otherPost, toPost, fromPost);
    }
}

int main(){
    int n;
    cout<<"Enter the number of the disk:";
    cin >> n;
    Hanoi(n, 'A', 'B', 'C');
    return 0;
}