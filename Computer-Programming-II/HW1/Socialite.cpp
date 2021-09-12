//
//  Socialite.cpp
//  HW1
//
//  Created by Benny on 4/5/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//
#include <iostream>
#include <string>
#include <fstream>
using namespace std;
#include "Socialite.h"

void Socialite::Default_Constructor(){
    LAST_NAME_="";
    FIRST_NAME_="";
    USER_ID_="";
    USER_PICTURE_="";
    WEBSITE_SHARE_="";
    WEBSITE_DESCRIPTION_="";
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
    fs.open("text.txt", ios::out|ios::app);
    fs << "Last Name:"<<LAST_NAME_<<endl;
    fs << "First Name:"<<FIRST_NAME_<<endl;
    fs << "UserID:"<<USER_ID_<<endl;
    fs << "Picture:"<<USER_PICTURE_<<endl;
    fs << "Website Share Link:"<<WEBSITE_SHARE_<<endl;
    fs << "Website Description:"<<WEBSITE_DESCRIPTION_<<endl;
    fs << endl;
    fs.close();
}

void Socialite::HTML_Output(){
    fstream fs;
    fs.open("html.html", ios::out);
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
    fs<<"</body>"<<endl;
    fs<<"</html>"<<endl;
    fs.close();
}