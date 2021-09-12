//
//  CardSuit.cpp
//  L4
//
//  Created by Benny on 4/16/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
#include <string>
#include <fstream>
using namespace std;

int main(){
    string line;
    fstream fs,cpp,h;
    
    h.open("CardSuit.h",ios::out);
    h<<"#include <iostream>"<<endl;
    h<<"#include <map>"<<endl;
    h<<"#include <vector>"<<endl;
    h<<"using namespace std;"<<endl;
    h<<"#ifndef __CardSuit__"<<endl;
    h<<"#define __CardSuit__"<<endl;
    h<<"enum CardSuit {";
    fs.open("my_enum.txt",ios::in);
    while(getline(fs,line)){
        h<<line<<",";
    }
    fs.close();
    h<<"};"<<endl;
    h<<"ostream &operator<<(ostream&os, const CardSuit &stone);"<<endl;
    fs.close();
    h<<"#endif";
    
    cpp.open("CardSuit.cpp",ios::out);
    cpp<<"#include <iostream>"<<endl;
    cpp<<"#include <map>"<<endl;
    cpp<<"#include <vector>"<<endl;
    cpp<<"using namespace std;"<<endl;
    cpp<<"#include \"CardSuit.h\""<<endl;
    cpp<<"ostream &operator<<(ostream&os, const CardSuit &stone){"<<endl;
    cpp<<"map<CardSuit,string>mymap;"<<endl;
    fs.open("my_enum.txt",ios::in);
    while(getline(fs,line)){
        cpp<<"mymap["<<line<<"]="<<"\""<<line<<"\";"<<endl;
    }
    fs.close();
    cpp<<"os<<mymap[stone];"<<endl;
    cpp<<"return os;"<<endl;
    cpp<<"}"<<endl;
}