//
//  Wizard.cpp
//  HW3
//
//  Created by Benny on 4/19/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include "Wizard.h"
#include <iostream>
#include <fstream>

bool Wizard::createNewFile(ofstream &out, string filename){
    out.open(filename);
    if(out.is_open()){
        char r;
        cout << "The file already exists, Do you want to overwrite it?(y/n)";
        cin >> r;
        if(r=='y'){
            out.open(filename,ios::out);
            out.close();
            return true; //overwrite the file and return true
        }
        else{
            return false; //cancel the action and return false
        }
    }
    else{
        out.open(filename,ios::out);
          out.close();
        return true; //create a new file and return true
    }
}

void Wizard::toCpp(){
    ofstream out;
    if(createNewFile(out, "c.cpp")==true){
        out.open("c.cpp",ios::out);
        out<<"//"<<endl;
        out<<"//Author: Yiyun Zhang"<<endl;
        out<<"//Date: Apr 19 2015"<<endl;
        out<<"//Version: 1.00"<<endl;
        out<<"//"<<endl<<endl;
        out<<"#include <iostream>"<<endl;
        out<<"#include <string>"<<endl;
        out<<"#include <fstream>"<<endl;
        out<<"using namespace std;"<<endl<<endl;
        out<<"string cliques;"<<endl;
        out<<"//Constructors"<<endl;
        out<<classname_<<"::"<<classname_<<"(){"<<endl;
        for(int i=1;i<=numOfObjects_;i++){
        out<<object_[i]<<"_=\"\""";"<<endl;
        }
        out<<"//Destructors"<<endl;
        out<<classname_<<"::~"<<classname_<<"(){}"<<endl;
        out<<"//Inspectors"<<endl;
        for(int i=1;i<=numOfObjects_;i++){
            out<<type_[i]<<" "<<classname_<<"::"<<object_[i]<<"() const{"<<endl;
            out<<"return "<<object_[i]<<"_;"<<endl;
             out<<"}"<<endl;
        }
        out<<"//Mutators"<<endl;
        for(int i=1;i<=numOfObjects_;i++){
            out<<"void "<<classname_<<"::add_"<<object_[i]<<"(int amt_to_add){"<<endl;
            out<<"//insert your code here"<<endl;
            out<<"}"<<endl;
        }
        for(int i=1;i<=numOfObjects_;i++){
            out<<"void "<<classname_<<"::set_"<<object_[i]<<"(){"<<endl;
            out<<"cout<<\"Please Enter your "<<object_[i]<<":\";"<<endl;
            out<<"cin >>"<<object_[i]<<"_;"<<endl;
             out<<"}"<<endl;
        }
        for(int i=1;i<=numOfObjects_;i++){
            out<<"void "<<classname_<<"::get_"<<object_[i]<<"(string &line){"<<endl;
            out<<object_[i]<<"_=line;"<<endl;
            out<<"cout<<"<<object_[i]<<"_<<endl;"<<endl;
             out<<"}"<<endl;
        }
        out<<"void Text_Output(){"<<endl;
        out<<"//insert your code here;"<<endl;
        out<<"}"<<endl;
        out<<"//void Html_Output(ofstream &fs){"<<endl;
        out<<"insert your code here;"<<endl;
        out<<"}"<<endl;
        out<<"//Facilitators"<<endl;
        out<<"string "<<classname_<<"::toString() const{"<<endl;
        out<<"//insert your code here"<<endl;
        out<<"}"<<endl;
        out<<"void out(ostream &os){"<<endl;
        out<<"//insert your code here"<<endl;
        out<<"}"<<endl<<endl;
        out<<"ostream& operator<<(ostream &os, "<<classname_<<" &s){"<<endl;
        out<<"//inset your code here"<<endl;
         out<<"}"<<endl;
        out<<"ofstream& operator<<(ostream &of, "<<classname_<<" &s){"<<endl;
        out<<"//inset your code here"<<endl;
        out<<"}"<<endl;
        out.close();
        cout << ".cpp file done!"<<endl;
    }
}

void Wizard::toH(){
    ofstream out;
    if(createNewFile(out, "h.h")==true){
        out.open("h.h",ios::out);
        out<<"//"<<endl;
        out<<"//Author: Yiyun Zhang"<<endl;
        out<<"//Date: Apr 19 2015"<<endl;
        out<<"//Version: 1.00"<<endl;
        out<<"//"<<endl<<endl;
        out<<"#ifndef "<<"__"<<classname_<<"_H__"<<endl;
        out<<"#define "<<"__"<<classname_<<"_H__"<<endl<<endl;
        out<<"#include <iostream>"<<endl;
        out<<"#include <string>"<<endl;
        out<<"#include <fstream>"<<endl;
        out<<"using namespace std;"<<endl<<endl;
        out<<"class "<<classname_<<endl;
        out<<"{"<<endl;
        out<<"public:"<<endl;
        out<<"//Constructors"<<endl;
        out<<classname_<<"();"<<endl;
        out<<"//Destructors"<<endl;
        out<<"~"<<classname_<<"();"<<endl;
        out<<"//Inspectors"<<endl;
        for(int i=1;i<=numOfObjects_;i++){
        out<<type_[i]<<" "<<object_[i]<<"() const;"<<endl;
        }
        out<<"//Mutators"<<endl;
        for(int i=1;i<=numOfObjects_;i++){
            out<<"void add_"<<object_[i]<<"(int amt_to_add) ;"<<endl;
        }
        for(int i=1;i<=numOfObjects_;i++){
            out<<"void set_"<<object_[i]<<"() ;"<<endl;
        }
        for(int i=1;i<=numOfObjects_;i++){
            out<<"void get_"<<object_[i]<<"(string &line) ;"<<endl;
        }
        out<<"void Text_Output();"<<endl;
        out<<"void Html_Output(ofstream &fs);"<<endl;
        out<<"//Facilitators"<<endl;
        out<<"string toString() const;"<<endl;
        out<<"void out(ostream &os);"<<endl<<endl;
        out<<"private:"<<endl;
        for(int i=1;i<=numOfObjects_;i++){
        out<<type_[i]<<" "<<object_[i]<<"_;"<<endl;
        }
        out<<"};"<<endl<<endl;
        out<<"#endif"<<endl;
        out<<""<<endl;
        out<<"ostream& operator<<(ostream &os, "<<classname_<<" &s);"<<endl;
        out<<"ofstream& operator<<(ostream &of, "<<classname_<<" &s);"<<endl;
        out.close();
        cout << ".h file done!"<<endl;
    }
}

void Wizard::getClassName(){
    fstream fs;
    string line;
    fs.open("English_length_input.txt",ios::in); //or "Socialite_input.txt"
        while(getline(fs,line)){
            classname_=line;
            while(getline(fs,line)){
                 numOfObjects_++;
            }
        }
}
void Wizard::getObjects(){
    int n;
    vector<string>type(n);
    vector<string>object(n);
    n=numOfObjects_;
    type_=type;
    object_=object;
    fstream fs;
    string line;
    fs.open("English_length_input.txt",ios::in); //or "Socialite_input.txt"
    getline(fs,line);
    for(int i=1;i<=n;i++){
        getline(fs,line);
        type_[i] = line.substr(0,line.find(" "));
        object_[i] = line.substr(line.find(" ")+1,line.length()-line.find(" "));
    }
}
