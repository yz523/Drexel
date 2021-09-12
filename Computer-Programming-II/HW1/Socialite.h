//
//  Socialite.h
//  HW1
//
//  Created by Benny on 4/5/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#ifndef __HW1__Socialite__
#define __HW1__Socialite__

#include <iostream>
#include <fstream>
#include <string>
using namespace std;

class Socialite {
public:
    //------------------------------------------------------
    //----- Constructors -----------------------------------
    //------------------------------------------------------
    
    //------------------------------------------------------
    //----- Inspectors -------------------------------------
    //------------------------------------------------------
    
    //------------------------------------------------------
    //----- Mutators ---------------------------------------
    //------------------------------------------------------
    //default constructor (set all string fields to the empty string)
    void Default_Constructor();
    //set methods for each attribute
    void Set_LastName();
    void Set_FirstName();
    void Set_UserID();
    void Set_UserPicture();
    void Set_WebsiteShare();
    void Set_WebsiteDescription();
    //get methods for each attribute
    void Get_LastName(ostream &os);
    void Get_FirstName(ostream &os);
    void Get_UserID(ostream &os);
    void Get_UserPicture(ostream &os);
    void Get_WebsiteShare(ostream &os);
    void Get_WebsiteDescription(ostream &os);
    //text output - outputs values of attributes in text format
    void Text_Output();
    //HTML output - outputs values of attributes as an HTML file
    void HTML_Output();
    //------------------------------------------------------
    //----- Facilitators -----------------------------------
    //------------------------------------------------------
    
private:
    string LAST_NAME_; //last name (string containing the user's last name)
    string FIRST_NAME_; //first name (string containing the user's first name)
    string USER_ID_; //userid (string containing a unique userid)
    string USER_PICTURE_; //picture (string containing the name of an image file)
    string WEBSITE_SHARE_; //website to share (string containing a URL)
    string WEBSITE_DESCRIPTION_; //website description (string containing a brief description of the website)
};

#endif /* defined(__HW1__Socialite__) */
