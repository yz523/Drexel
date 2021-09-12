//
//  Grid.h
//  HW4
//
//  Created by Benny on 5/3/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#ifndef HW4_Grid_h
#define HW4_Grid_h
#include <iostream>
#include <fstream>
#include <vector>
using namespace std;

class Grid{
public:
    Grid();
    vector<int>&operator[](int k);
    void input();
    void output(Grid &g);
    void display(ostream &os, Grid &g);
    bool finished(ostream &os, Grid &g) const;
    void start(ostream &os, Grid &g);
private:
    vector<vector<int> > point;
};

#endif
