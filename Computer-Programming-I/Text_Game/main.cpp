//
//  main.cpp
//  Text_Game
//
//  Created by Benny on 2/25/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
#include <fstream>
#include <iomanip>
#include <cassert> // needed for assert()
using namespace std;

double invert( double x );

int main()
{
    fstream infile("in.txt");
    string word1,word2,word3;
    infile>>word1>>word2>>word3;
    cout<<word1<<" "<<word2<<" "<<word3;
}
