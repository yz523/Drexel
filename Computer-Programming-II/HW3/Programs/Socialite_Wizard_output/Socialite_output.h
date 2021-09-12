//
//Author: Yiyun Zhang
//Date: Apr 19 2015
//Version: 1.00
//

#ifndef __Socialite_H__
#define __Socialite_H__

#include <iostream>
#include <string>
#include <fstream>
using namespace std;

class Socialite
{
public:
//Constructors
Socialite();
//Destructors
~Socialite();
//Inspectors
string LAST_NAME() const;
string FIRST_NAME() const;
string USER_ID() const;
string USER_PICTURE() const;
string WEBSITE_SHARE() const;
string WEBSITE_DESCRIPTION() const;
string cliques() const;
int numCliques() const;
//Mutators
void add_LAST_NAME(int amt_to_add) ;
void add_FIRST_NAME(int amt_to_add) ;
void add_USER_ID(int amt_to_add) ;
void add_USER_PICTURE(int amt_to_add) ;
void add_WEBSITE_SHARE(int amt_to_add) ;
void add_WEBSITE_DESCRIPTION(int amt_to_add) ;
void add_cliques(int amt_to_add) ;
void add_numCliques(int amt_to_add) ;
void set_LAST_NAME() ;
void set_FIRST_NAME() ;
void set_USER_ID() ;
void set_USER_PICTURE() ;
void set_WEBSITE_SHARE() ;
void set_WEBSITE_DESCRIPTION() ;
void set_cliques() ;
void set_numCliques() ;
void get_LAST_NAME(string &line) ;
void get_FIRST_NAME(string &line) ;
void get_USER_ID(string &line) ;
void get_USER_PICTURE(string &line) ;
void get_WEBSITE_SHARE(string &line) ;
void get_WEBSITE_DESCRIPTION(string &line) ;
void get_cliques(string &line) ;
void get_numCliques(string &line) ;
void Text_Output();
void Html_Output(ofstream &fs);
//Facilitators
string toString() const;
void out(ostream &os);

private:
string LAST_NAME_;
string FIRST_NAME_;
string USER_ID_;
string USER_PICTURE_;
string WEBSITE_SHARE_;
string WEBSITE_DESCRIPTION_;
string cliques_;
int numCliques_;
};

#endif

ostream& operator<<(ostream &os, Socialite &s);
ofstream& operator<<(ostream &of, Socialite &s);
