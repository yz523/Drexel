//
//  test_Socialite.cpp
//  HW2
//
//  Created by Benny on 4/5/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
#include <string>
#include <fstream>
using namespace std;
#include "Socialite.h"


int main(void){
    Socialite s1;
    fstream fs;
    ofstream of;
    string line;
    fs.open("datafile.txt",ios::in);
        while(getline(fs,line)){
            while(line!="$$$$"){
        s1.Get_UserID(line);
        getline(fs,line);
        s1.Get_FirstName(line);
        getline(fs,line);
        s1.Get_LastName(line);
        getline(fs,line);
        s1.Get_UserPicture(line);
        getline(fs,line);
        s1.Get_WebsiteShare(line);
        getline(fs,line);
        s1.Get_WebsiteDescription(line);
        getline(fs,line);
        while(line!="$$$$"){
        s1.Get_Cliques(line);
        getline(fs,line);
                    }
        s1.Text_Output();
                of<<s1;
        s1.Set_Default();
        }
    }
    cout<<"Done!";
}