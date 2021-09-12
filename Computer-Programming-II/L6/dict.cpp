//
//  dict.cpp
//  L6
//
//  Created by Benny on 5/9/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
#include <vector>
#include <string>
#include <fstream>
#include <sstream>
using namespace std;

void exchange(string &a, string &b, int &moves)
{
    string temp = a ;
    a = b ;
    b = temp ;
    
    moves += 3 ;
}

int min_position(vector<string> & a, int fromIndex, int toIndex, int &comparisons)
{
	   int min_pos = fromIndex;
	   for(int i = fromIndex + 1; i <= toIndex ; i++)
       {
           comparisons++ ;

           char left,right;
           string l,r;
           l=a[i].substr(0,1);
           r=a[min_pos].substr(0,1);
           stringstream ss;
           ss <<l;
           ss >> left;
           ss <<r;
           ss >>right;
           if ( left<right )
               min_pos = i;
       }
	   
	   return min_pos;
}

void selectSort(vector<string> & a, int fromIndex, int toIndex, int &comparisons, int &moves)
{
	   for(int next = fromIndex; next < toIndex; next++)
       {
           int min_pos = min_position(a, next, toIndex, comparisons);
           
           if (min_pos != next)
               exchange(a[min_pos], a[next], moves);
       }
}

int main(){
    vector<string>v;
    string in;
    fstream fs;
    fs.open("DICTIONARY_Chambers's Edinburgh Journal, No.307 by Various.txt",ios::in);
    while(!fs.eof()){
        getline(fs,in);
        v.push_back(in);
    }
        fs.close();
    
    fs.open("DICTIONARY_diamond.txt",ios::in);
    while(!fs.eof()){
        getline(fs,in);
        v.push_back(in);
    }
    fs.close();
    
    int comparisons, moves;
    int toIndex=v.size();
    selectSort(v, 0, toIndex, toIndex, moves);
    fs.open("output.txt",ios::out);
    for(int i=0;i<toIndex;i++)
    {
        fs<<v[i]<<endl;
    }
}