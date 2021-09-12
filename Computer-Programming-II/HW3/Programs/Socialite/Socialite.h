//
//  Socialite.h
//  HW1
//
//  Created by Benny on 4/5/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#ifndef __yz523__Socialite__
#define __yz523__Socialite__

#include <iostream>
#include <fstream>
#include <string>
using namespace std;

class Socialite {
public:
    //------------------------------------------------------
    //----- Constructors -----------------------------------
    //------------------------------------------------------
    //default constructor
    Socialite();
    //copy constructor
    Socialite(const Socialite &s1);
    //------------------------------------------------------
    //----- Destructor -----------------------------------
    //------------------------------------------------------
    ~Socialite();
    
    //------------------------------------------------------
    //----- Inspectors -------------------------------------
    //------------------------------------------------------
    
    //------------------------------------------------------
    //----- Mutators ---------------------------------------
    //------------------------------------------------------
    //set all string to default
    void Set_Default();
    //set methods for each attribute
    void Set_LastName();
    void Set_FirstName();
    void Set_UserID();
    void Set_UserPicture();
    void Set_WebsiteShare();
    void Set_WebsiteDescription();
    //get methods for each attribute
    void Get_LastName(string &line);
    void Get_FirstName(string &line);
    void Get_UserID(string &line);
    void Get_UserPicture(string &line);
    void Get_WebsiteShare(string &line);
    void Get_WebsiteDescription(string &line);
    void Get_Cliques(string &line);
    //text output - outputs values of attributes in text format
    void Text_Output();
    //HTML output - outputs values of attributes as an HTML file
    void HTML_Output(ofstream &fs);
    //retrieve the number of cliques in the socialite
    int Retrieve_NumberOfCliques();
    //retrieve the name of clique if legal;
    void Retrieve_NameOfCliques();
    //add a clique to the socialite
    void Add_Clique();
    //------------------------------------------------------
    //----- Facilitators -----------------------------------
    //------------------------------------------------------
    //output the information
    void out(ostream &os);
    
private:
    string LAST_NAME_; //last name (string containing the user's last name)
    string FIRST_NAME_; //first name (string containing the user's first name)
    string USER_ID_; //userid (string containing a unique userid)
    string USER_PICTURE_; //picture (string containing the name of an image file)
    string WEBSITE_SHARE_; //website to share (string containing a URL)
    string WEBSITE_DESCRIPTION_; //website description (string containing a brief description of the website)
    string cliques_; //contain the name of each of the socialite's cliques, separated b semicolons
    int numCliques_; //the correct number of cliques
};

ostream& operator<<(ostream &os, Socialite &s);
ofstream& operator<<(ofstream &of, Socialite &s);

#endif /* defined(__yz523__Socialite__) */
