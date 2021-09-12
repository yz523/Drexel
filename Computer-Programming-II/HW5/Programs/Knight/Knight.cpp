//
//  Knight.cpp
//  HW5
//
//  Created by Benny on 5/17/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
#include <vector>
#include <list>
#include "Knight.h"
using namespace std;

Knight::Knight(int row, int column){
    //initialize a chessboard with certain size, set each cell to the value -1
    row_=row;
    column_=column;
    for(int i=0;i<=row;i++){
        vector<int>temp;
        for(int j=0;j<=column;j++){
            temp.push_back(-1);
        }
        chessboard_.push_back(temp);
    }
}

vector<int> Knight::getMoves(int i, int j){
    if(i-2>0&&j-1>0&&chessboard_[i-2][j-1]==-1){
        cout<<"Possiable move:"<<i-2<<" "<<j-1<<endl;
        list_.push_back(i-2);
        list_.push_back(j-1);
    }
    if(i-2>0&&j+1<=column_&&chessboard_[i-2][j+1]==-1){
        cout<<"Possiable move:"<<i-2<<" "<<j+1<<endl;
        list_.push_back(i-2);
        list_.push_back(j+1);
    }
    if(i-1>0&&j-2>0&&chessboard_[i-1][j-2]==-1){
        cout<<"Possiable move:"<<i-1<<" "<<j-2<<endl;
        list_.push_back(i-1);
        list_.push_back(j-2);
    }
    if(i-1>0&&j+2<=column_&&chessboard_[i-1][j+2]==-1){
        cout<<"Possiable move:"<<i-1<<" "<<j+2<<endl;
        list_.push_back(i-1);
        list_.push_back(j+2);
    }
    if(i+1<=row_&&j-2>0&&chessboard_[i+1][j-2]==-1){
        cout<<"Possiable move:"<<i+1<<" "<<j-2<<endl;
        list_.push_back(i+1);
        list_.push_back(j-2);
    }
    if(i+1<=row_&&j+2<=column_&&chessboard_[i+1][j+2]==-1){
        cout<<"Possiable move:"<<i+1<<" "<<j+2<<endl;
        list_.push_back(i+1);
        list_.push_back(j+2);
    }
    if(i+2<=row_&&j-1>0&&chessboard_[i+2][j-1]==-1){
        cout<<"Possiable move:"<<i+2<<" "<<j-1<<endl;
        list_.push_back(i+2);
        list_.push_back(j-1);
    }
    if(i+2<=row_&&j+1<=column_&&chessboard_[i+2][j+1]==-1){
        cout<<"Possiable move:"<<i+2<<" "<<j+1<<endl;
        list_.push_back(i+2);
        list_.push_back(j+1);
    }
    return list_;
}

void Knight::display(){
    for(int i=1;i<=row_;i++){
        for(int j=1;j<=column_;j++){
            if(chessboard_[i][j]==-1)
            cout<<"- ";
            else
            cout<<chessboard_[i][j]<<" ";
        }
        cout<<endl;
    }
}

bool Knight::voyagingKnight(Knight k, int i, int j, int step){
    int total=0, x=0;
    
    //check if the chessboard is empty, if empty then place the start 0 at the beginning position
    for(int m=1;m<=row_;m++){
        for(int n=1;n<=column_;n++){
            total+=chessboard_[i][j];
        }
    }
    if(total==(-1*row_*column_)){
        chessboard_[i][j]=0;
    }
    
    //display the chessboard
    display();
    
    
    //recursive body
    //terminated the recursion, when steps equal the cells
    if(step<row_*column_){
        getMoves(i, j);
        i = list_[x];
        j = list_[x+1];
        
        //taking one of the moves (updating step and chessboard accordingly) and trying to solve the problem given this new position. If that works, return true, with the solution contained in chessboard.
        if(chessboard_[i][j]==-1){
            chessboard_[i][j]=step;
            list_.resize(0);
            voyagingKnight(k, i, j, step+1);
            return true;
        }
        
        //If that move did not work, try another one of the moves and try to solve the problem given that new position. If that works, return true, with the solution contained in chessboard.Continue this process by trying each one of the moves in the current list of moves, and returning the solution if it works.
        else{
            for(int z=0;z<getMoves(i, j).size();z++){
                if(chessboard_[z][z+1]==-1){
                    return true;
                }
            }
        //If all moves from this position have been exhausted without finding a solution, return false.
            return false;
        }
    }
    //To find the solution from the new position, trust voyagingKnight to work, and call it recursively!
    return voyagingKnight(k, i, j, step+1);;
}