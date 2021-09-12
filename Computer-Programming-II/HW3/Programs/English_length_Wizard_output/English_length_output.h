//
//Author: Yiyun Zhang
//Date: Apr 19 2015
//Version: 1.00
//

#ifndef __English_length_H__
#define __English_length_H__

#include <iostream>
#include <string>
#include <fstream>
using namespace std;

class English_length
{
public:
//Constructors
English_length();
//Destructors
~English_length();
//Inspectors
int inches() const;
int feet() const;
int yards() const;
//Mutators
void add_inches(int amt_to_add) ;
void add_feet(int amt_to_add) ;
void add_yards(int amt_to_add) ;
void set_inches() ;
void set_feet() ;
void set_yards() ;
void get_inches(string &line) ;
void get_feet(string &line) ;
void get_yards(string &line) ;
void Text_Output();
void Html_Output(ofstream &fs);
//Facilitators
string toString() const;
void out(ostream &os);

private:
int inches_;
int feet_;
int yards_;
};

#endif

ostream& operator<<(ostream &os, English_length &s);
ofstream& operator<<(ostream &of, English_length &s);
