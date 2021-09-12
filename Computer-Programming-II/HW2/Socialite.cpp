//
//  Socialite.cpp
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

string cliques;

Socialite::Socialite(){
    LAST_NAME_="";
    FIRST_NAME_="";
    USER_ID_="";
    USER_PICTURE_="";
    WEBSITE_SHARE_="";
    WEBSITE_DESCRIPTION_="";
    cliques_="";
    numCliques_=0;
}

Socialite::~Socialite(){}

void Socialite::Set_Default(){
    LAST_NAME_="";
    FIRST_NAME_="";
    USER_ID_="";
    USER_PICTURE_="";
    WEBSITE_SHARE_="";
    WEBSITE_DESCRIPTION_="";
    cliques_="";
    numCliques_=0;
}

void Socialite::Get_UserID(string &line){
    USER_ID_=line;
    cout<<USER_ID_<<endl;
}

void Socialite::Get_FirstName(string &line){
    FIRST_NAME_=line;
    cout<<FIRST_NAME_<<endl;
}

void Socialite::Get_LastName(string &line){
    LAST_NAME_=line;
    cout<<LAST_NAME_<<endl;
}

void Socialite::Get_UserPicture(string &line){
    USER_PICTURE_=line;
    cout<<USER_PICTURE_<<endl;
}

void Socialite::Get_WebsiteDescription(string &line){
    WEBSITE_DESCRIPTION_=line;
    cout<<WEBSITE_DESCRIPTION_<<endl;
}

void Socialite::Get_WebsiteShare(string &line){
    WEBSITE_SHARE_=line;
    cout<<WEBSITE_SHARE_<<endl;
}

void Socialite::Get_Cliques(string &line){
    cliques_+=line+";";
    cout<<line<<endl;
}
void Socialite::Set_LastName(){
    cout<<"Plese Enter your LastName:";
    cin >> LAST_NAME_;
}

void Socialite::Set_FirstName(){
    cout<<"Plese Enter your FirstName:";
    cin >> FIRST_NAME_;
}

void Socialite::Set_UserID(){
    cout<<"Plese Enter your User ID:";
    cin >> USER_ID_;
}

void Socialite::Set_UserPicture(){
    cout<<"Plese Enter your Picture:";
    cin >> USER_PICTURE_;
}

void Socialite::Set_WebsiteShare(){
    cout <<"Please Enter your Website Share Link:";
    cin >> WEBSITE_SHARE_;
}

void Socialite::Set_WebsiteDescription(){
    cout <<"Please Enter your Website Description:";
    cin >> WEBSITE_DESCRIPTION_;
}

void Socialite::Text_Output(){
    fstream fs;
    string clique=cliques_,temp;
    fs.open("textoutput.txt", ios::out|ios::app);
    fs << "Last Name:"<<LAST_NAME_<<endl;
    fs << "First Name:"<<FIRST_NAME_<<endl;
    fs << "UserID:"<<USER_ID_<<endl;
    fs << "Picture:"<<USER_PICTURE_<<endl;
    fs << "Website Share Link:"<<WEBSITE_SHARE_<<endl;
    fs << "Website Description:"<<WEBSITE_DESCRIPTION_<<endl;
    fs << "Cliques:"<<endl;
    while(clique!=""){
    temp=clique.substr(0,clique.find(";"));
    fs<<temp<<endl;
    clique=clique.substr(clique.find(";")+1,clique.length()-clique.find(";"));
    }
    fs << endl;
    fs.close();
}

int Socialite::Retrieve_NumberOfCliques(){
    cout <<"Please Enter the number of the cliques:";
    cin >> numCliques_;
    return numCliques_;
}

void Socialite::Retrieve_NameOfCliques(){
    if(numCliques_>=0){
    cout <<"Please Enter the name of the cliques:";
    cin >> cliques;
    }
}

void Socialite::Add_Clique(){
    cliques_+=cliques+";";
    numCliques_+=1;
}

void Socialite::HTML_Output(){
    fstream fs;
    string filename;
    cout<<"Enter the html file name:";
    cin >>filename;
    fs.open(filename,ios::out);
    string clique=cliques_,temp;
    fs << "<html>"<<endl;
    fs << "<head>"<<endl;
    fs << "<title>"<<FIRST_NAME_<<" "<<LAST_NAME_<<"'s Socialite Page</title>"<<endl;
    fs<<"</head>"<<endl;
    fs<<"<body>"<<endl;
    fs<<"<img SRC=\""<<USER_PICTURE_<<"\" ALIGN='Right' height=\"370\" width=\"250\"/>"<<endl;
    fs<<"<h1>"<<USER_ID_<<"</h1>"<<endl;
    fs<<"<h2>"<<FIRST_NAME_<<" "<<LAST_NAME_<<"</h2>"<<endl;
    fs<<"<hr />"<<endl;
    fs<<"<p>"<<FIRST_NAME_<<" wants to share a <a HREF=\""<<WEBSITE_SHARE_<<"\">link</a>("<<WEBSITE_SHARE_<<") with you</p>"<<endl;
    fs<<"<hr />"<<endl;
    fs<<"<p><i>Cliques:</i></p>"<<endl;
    fs<<"<ul>"<<endl;
    while(clique!=""){
        temp=clique.substr(0,clique.find(";"));
        fs<<"<li>"<<temp<<"</li>"<<endl;
        clique=clique.substr(clique.find(";")+1,clique.length()-clique.find(";"));
    }
    fs<<"</ul>"<<endl;
    fs<<"</body>"<<endl;
    fs<<"</html>"<<endl;
    fs.close();
}