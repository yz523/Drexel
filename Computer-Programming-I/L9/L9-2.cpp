//
//  main.cpp
//  L9
//
//  Created by Benny on 3/6/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
#include <fstream>
#include <iomanip>
#include <sstream>
using namespace std;

int sec=0;

int section(string line){
    sec+=1;
    return sec;
}

string special(string line){
    string temp;
    for(int i=0;i<(80-line.length())/2;i++){
        temp+=" ";
    }
    return temp;
}


int main(){
    int numLine=0,page=0;
    string line,filename,sentence,outfilename;
    ifstream myfile;
    cout <<"Enter the input file name(testtext.fmt):";
    getline(cin,filename);
    cout <<"Enter the output file name(output.fmt):";
    getline(cin,outfilename);
    ofstream outputfile("output.fmt");
    myfile.open(filename,ios::in);
    if(true){
        while(getline(myfile,line)){
             numLine++;
            if(numLine%46==0){
                page++;
            }
            if(line=="\n"){
                getline(myfile,line);
            }
            if(numLine==1){
                outputfile<<"\n";
                outputfile<<"\n";
                outputfile<<"\n";
                outputfile<<"\n";
                outputfile<<"\n";
            }
            if(line==".ce"){
                getline(myfile,line);
                outputfile<<special(line);
                outputfile<<line<<endl;
            }
            else if(line==".se"){
                outputfile<<"\n";
                outputfile<<"\n";
                getline(myfile,line);
                outputfile<<section(line)<<".";
                outputfile<<line<<endl;
                outputfile<<"\n";
            }
            else{
                istringstream iss;
                iss.str(line);
                for(int i=0;i<line.length();i++){
                    string words;
                    iss >> words;
                    if(words.empty()==true){
                        sentence=sentence;
                    }
                    else{
                    sentence+=words+" ";
                    }
                    if(sentence.length()>64){
                        outputfile<<"        "<<sentence<<endl;
                        sentence="";
                    }
                }
            }
            if(page!=0&&numLine%46==0){
                outputfile<<"\n";
                outputfile<<"\n";
                for(int i=0;i<30;i++){
                    outputfile <<" ";
                }
                outputfile<<page;
                outputfile<<"\n";
                outputfile<<"\n";
                outputfile<<"\n";
                outputfile<<"\n";
                outputfile<<"\n";
                outputfile<<"\n";
                outputfile<<"\n";
                outputfile<<"\n";
            }
            
        }
    }
}

