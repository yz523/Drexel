//
//  Knight.h
//  HW5
//
//  Created by Benny on 5/17/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#ifndef __HW5__Knight__
#define __HW5__Knight__

#include <iostream>
#include <vector>
using namespace std;

class Knight{
public:
    Knight();
    Knight(int row, int column);
    vector<int> getMoves(int i, int j);
    void display();
    bool voyagingKnight(Knight chessboard, int i, int j, int step);
private:
    vector<vector<int> > chessboard_;
    vector<int> list_;
    int row_;
    int column_;
};

#endif /* defined(__HW5__Knight__) */
