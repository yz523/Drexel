//
//  CardSuit.cpp
//  L3
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
    cpp<<"using namespace std;"<<endl;
    cpp<<"#include \"CardSuit.h\""<<endl;
    cpp<<"ostream &operator<<(ostream&os, const CardSuit &stone){"<<endl;
    cpp<<"switch (stone) {"<<endl;
    fs.open("my_enum.txt",ios::in);
    while(getline(fs,line)){
        cpp<<"case "<<line<<":os<<\""<<line<<"\";break;"<<endl;
    }
    fs.close();
    cpp<<"}"<<endl;
    cpp<<"return os;"<<endl;
    cpp<<"}"<<endl;
}