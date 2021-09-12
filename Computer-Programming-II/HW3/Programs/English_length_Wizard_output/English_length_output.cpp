//
//Author: Yiyun Zhang
//Date: Apr 19 2015
//Version: 1.00
//

#include <iostream>
#include <string>
#include <fstream>
using namespace std;

string cliques;
//Constructors
English_length::English_length(){
inches_="";
feet_="";
yards_="";
//Destructors
English_length::~English_length(){}
//Inspectors
int English_length::inches() const{
return inches_;
}
int English_length::feet() const{
return feet_;
}
int English_length::yards() const{
return yards_;
}
//Mutators
void English_length::add_inches(int amt_to_add){
//insert your code here
}
void English_length::add_feet(int amt_to_add){
//insert your code here
}
void English_length::add_yards(int amt_to_add){
//insert your code here
}
void English_length::set_inches(){
cout<<"Please Enter your inches:";
cin >>inches_;
}
void English_length::set_feet(){
cout<<"Please Enter your feet:";
cin >>feet_;
}
void English_length::set_yards(){
cout<<"Please Enter your yards:";
cin >>yards_;
}
void English_length::get_inches(string &line){
inches_=line;
cout<<inches_<<endl;
}
void English_length::get_feet(string &line){
feet_=line;
cout<<feet_<<endl;
}
void English_length::get_yards(string &line){
yards_=line;
cout<<yards_<<endl;
}
void Text_Output(){
//insert your code here;
}
//void Html_Output(ofstream &fs){
insert your code here;
}
//Facilitators
string English_length::toString() const{
//insert your code here
}
void out(ostream &os){
//insert your code here
}

ostream& operator<<(ostream &os, English_length &s){
//inset your code here
}
ofstream& operator<<(ostream &of, English_length &s){
//inset your code here
}
