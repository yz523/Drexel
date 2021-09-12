//
//  Grid.cpp
//  HW4
//
//  Created by Benny on 5/3/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
#include <vector>
#include <fstream>
using namespace std;
#include "Grid.h"

Grid::Grid(){
    for(int i = 0; i < 10; i++){
        vector<int>temp;
        for(int j = 1; j < 10; j++){
            temp.push_back(0);
        }
        point.push_back(temp);
    }
}

void Grid::input(){
    fstream fin;
    int temp;
    fin.open("Grid_input.txt",ios::in);
    for(int i = 0; i < 9; i++){
        for(int j = 0; j < 9; j++){
            fin >> temp;
            point[i][j]=temp;
        }
    }
    fin.close();
}

void Grid::display(ostream &os, Grid &g){
    while(!g.finished(os,g)){
        
        char c='A';
        os<<"    0 1 2   3 4 5   6 7 8"<<endl;
        os<<"  +-------+-------+-------+"<<endl;
        for(int i=0;i<9;i++){
            os<<c<<" | ";
            c++;
            for(int j=0;j<9;j++){
                if(g[i][j]==0){
                    os<<"- ";
                }
                else{
                    os<<g[i][j]<<" ";
                }
                if(j==2||j==5||j==8){
                    os<<"| ";
                }
                if(j==8){
                    os<<endl;
                }
            }
            if(c=='D'|c=='G'||c=='J'){
                os<<"  +-------+-------+-------+"<<endl;
            }
        }
        g.output(g);
        g.start(cout, g);
    }
}

void Grid::output(Grid &g){
    fstream fs;
    fs.open("grid_output.txt",ios::out|ios::app);
    char c='A';
    fs<<"    0 1 2   3 4 5   6 7 8"<<endl;
    fs<<"  +-------+-------+-------+"<<endl;
    for(int i=0;i<9;i++){
        fs<<c<<" | ";
        c++;
        for(int j=0;j<9;j++){
            if(g[i][j]==0){
                fs<<"- ";
            }
            else{
                fs<<g[i][j]<<" ";
            }
            if(j==2||j==5||j==8){
                fs<<"| ";
            }
            if(j==8){
                fs<<endl;
            }
        }
        if(c=='D'|c=='G'||c=='J'){
            fs<<"  +-------+-------+-------+"<<endl;
        }
    }
    fs<<endl;
    fs<<"==============================="<<endl;
    fs<<endl;
}

void Grid::start(ostream &os, Grid &g){
    char fi;
    int row=0,col=0,num=0;
    os<<"*Enter the location you want to change by enter"<<endl;
    os<<"\"row+column\", seperate by a blank (i.e: A 0):";
    cin >> fi >> col;
    
    
    while(fi<'A'||fi>'I'||col<0||col>8){
        os<<"*Invaild position, Please enter again:";
        cin >> fi >> col;
    }
    
    row=fi-65;
    
    while(g[row][col]>0){
        os<<"*The position already exist a number, Please choose a different position:";
        cin >> fi >> col;
    }
    
    os<<"*Enter the number you want to add(1-9):";
    cin >> num;
    while(num<0||num>9){
        os<<"*Invaild number, Please enter again:";
        cin >> num;
    }
    while(num==g[row][0]||num==g[row][1]||num==g[row][2]||num==g[row][3]||num==g[row][4]||
          num==g[row][5]||num==g[row][6]||num==g[row][7]||num==g[row][8]||num==g[row][9]){
        os<<"Your number has conflict with current column, Please enter another number:";
        cin >> num;
    }
    while(num==g[0][col]||num==g[1][col]||num==g[2][col]||num==g[3][col]||num==g[4][col]||
          num==g[5][col]||num==g[6][col]||num==g[7][col]||num==g[8][col]||num==g[9][col]){
        os<<"Your number has conflict with current row, Please enter another number:";
        cin >> num;
    }
    if(row>=0&&row<=2&&col>=0&&col<=2){
        while(num==g[0][0]||num==g[0][1]||num==g[0][2]||num==g[1][0]||num==g[1][1]||num==g[1][2]||
              num==g[2][0]||num==g[2][1]||num==g[2][2]){
            os<<"Your number has conflict with current 3x3 grid, Please enter another number:";
            cin >> num;
        }
    }
    if(row>=3&&row<=5&&col>=0&&col<=2){
        while(num==g[3][0]||num==g[3][1]||num==g[3][2]||num==g[4][0]||num==g[4][1]||num==g[4][2]||
           num==g[5][0]||num==g[5][1]||num==g[5][2]){
            os<<"Your number has conflict with current 3x3 grid, Please enter another number:";
            cin >> num;
        }
    }
    if(row>=6&&row<=8&&col>=0&&col<=2){
        while(num==g[6][0]||num==g[6][1]||num==g[6][2]||num==g[7][0]||num==g[7][1]||num==g[7][2]||
           num==g[8][0]||num==g[8][1]||num==g[8][2]){
            os<<"Your number has conflict with current 3x3 grid, Please enter another number:";
            cin >> num;
        }
    }
    if(row>=0&&row<=2&&col>=3&&col<=5){
        while(num==g[0][3]||num==g[0][4]||num==g[0][5]||num==g[1][3]||num==g[1][4]||num==g[1][5]||
           num==g[2][3]||num==g[2][4]||num==g[2][5]){
            os<<"Your number has conflict with current 3x3 grid, Please enter another number:";
            cin >> num;
        }
    }
    if(row>=3&&row<=5&&col>=3&&col<=5){
        while(num==g[3][3]||num==g[3][4]||num==g[3][5]||num==g[4][3]||num==g[4][4]||num==g[4][5]||
           num==g[5][3]||num==g[5][4]||num==g[5][5]){
            os<<"Your number has conflict with current 3x3 grid, Please enter another number:";
            cin >> num;
        }
    }
    if(row>=6&&row<=8&&col>=3&&col<=5){
        while(num==g[6][3]||num==g[6][4]||num==g[6][5]||num==g[7][3]||num==g[7][4]||num==g[7][5]||
           num==g[8][3]||num==g[8][4]||num==g[8][5]){
            os<<"Your number has conflict with current 3x3 grid, Please enter another number:";
            cin >> num;
        }
    }
    if(row>=0&&row<=2&&col>=6&&col<=8){
        while(num==g[0][6]||num==g[0][7]||num==g[0][8]||num==g[1][6]||num==g[1][7]||num==g[1][8]||
           num==g[2][6]||num==g[2][7]||num==g[2][8]){
            os<<"Your number has conflict with current 3x3 grid, Please enter another number:";
            cin >> num;
        }
    }
    if(row>=3&&row<=5&&col>=6&&col<=8){
        while(num==g[3][6]||num==g[3][7]||num==g[3][8]||num==g[4][6]||num==g[4][7]||num==g[4][8]||
           num==g[5][6]||num==g[5][7]||num==g[5][8]){
            os<<"Your number has conflict with current 3x3 grid, Please enter another number:";
            cin >> num;
        }
    }
    if(row>=6&&row<=8&&col>=6&&col<=8){
        while(num==g[6][6]||num==g[6][7]||num==g[6][8]||num==g[7][6]||num==g[7][7]||num==g[7][8]||
           num==g[8][6]||num==g[8][7]||num==g[8][8]){
            os<<"Your number has conflict with current 3x3 grid, Please enter another number:";
            cin >> num;
        }
    }
        g[row][col]=num;
}

bool Grid::finished(ostream&os, Grid &g) const {
    int result=0;
    for(int i=0;i<9;i++){
        for(int j=0;j<9;j++){
            if(g[i][j]>0)
                result++;
        }
    }
    if(result==81){
        os<<"Finished!!!";
        return true;
    }
    return false;
}

vector<int>&Grid::operator[](int k){
    return point[k];
}
