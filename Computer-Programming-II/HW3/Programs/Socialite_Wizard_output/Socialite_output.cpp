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
Socialite::Socialite(){
LAST_NAME_="";
FIRST_NAME_="";
USER_ID_="";
USER_PICTURE_="";
WEBSITE_SHARE_="";
WEBSITE_DESCRIPTION_="";
cliques_="";
numCliques_="";
//Destructors
Socialite::~Socialite(){}
//Inspectors
string Socialite::LAST_NAME() const{
return LAST_NAME_;
}
string Socialite::FIRST_NAME() const{
return FIRST_NAME_;
}
string Socialite::USER_ID() const{
return USER_ID_;
}
string Socialite::USER_PICTURE() const{
return USER_PICTURE_;
}
string Socialite::WEBSITE_SHARE() const{
return WEBSITE_SHARE_;
}
string Socialite::WEBSITE_DESCRIPTION() const{
return WEBSITE_DESCRIPTION_;
}
string Socialite::cliques() const{
return cliques_;
}
int Socialite::numCliques() const{
return numCliques_;
}
//Mutators
void Socialite::add_LAST_NAME(int amt_to_add){
//insert your code here
}
void Socialite::add_FIRST_NAME(int amt_to_add){
//insert your code here
}
void Socialite::add_USER_ID(int amt_to_add){
//insert your code here
}
void Socialite::add_USER_PICTURE(int amt_to_add){
//insert your code here
}
void Socialite::add_WEBSITE_SHARE(int amt_to_add){
//insert your code here
}
void Socialite::add_WEBSITE_DESCRIPTION(int amt_to_add){
//insert your code here
}
void Socialite::add_cliques(int amt_to_add){
//insert your code here
}
void Socialite::add_numCliques(int amt_to_add){
//insert your code here
}
void Socialite::set_LAST_NAME(){
cout<<"Please Enter your LAST_NAME:";
cin >>LAST_NAME_;
}
void Socialite::set_FIRST_NAME(){
cout<<"Please Enter your FIRST_NAME:";
cin >>FIRST_NAME_;
}
void Socialite::set_USER_ID(){
cout<<"Please Enter your USER_ID:";
cin >>USER_ID_;
}
void Socialite::set_USER_PICTURE(){
cout<<"Please Enter your USER_PICTURE:";
cin >>USER_PICTURE_;
}
void Socialite::set_WEBSITE_SHARE(){
cout<<"Please Enter your WEBSITE_SHARE:";
cin >>WEBSITE_SHARE_;
}
void Socialite::set_WEBSITE_DESCRIPTION(){
cout<<"Please Enter your WEBSITE_DESCRIPTION:";
cin >>WEBSITE_DESCRIPTION_;
}
void Socialite::set_cliques(){
cout<<"Please Enter your cliques:";
cin >>cliques_;
}
void Socialite::set_numCliques(){
cout<<"Please Enter your numCliques:";
cin >>numCliques_;
}
void Socialite::get_LAST_NAME(string &line){
LAST_NAME_=line;
cout<<LAST_NAME_<<endl;
}
void Socialite::get_FIRST_NAME(string &line){
FIRST_NAME_=line;
cout<<FIRST_NAME_<<endl;
}
void Socialite::get_USER_ID(string &line){
USER_ID_=line;
cout<<USER_ID_<<endl;
}
void Socialite::get_USER_PICTURE(string &line){
USER_PICTURE_=line;
cout<<USER_PICTURE_<<endl;
}
void Socialite::get_WEBSITE_SHARE(string &line){
WEBSITE_SHARE_=line;
cout<<WEBSITE_SHARE_<<endl;
}
void Socialite::get_WEBSITE_DESCRIPTION(string &line){
WEBSITE_DESCRIPTION_=line;
cout<<WEBSITE_DESCRIPTION_<<endl;
}
void Socialite::get_cliques(string &line){
cliques_=line;
cout<<cliques_<<endl;
}
void Socialite::get_numCliques(string &line){
numCliques_=line;
cout<<numCliques_<<endl;
}
void Text_Output(){
//insert your code here;
}
//void Html_Output(ofstream &fs){
insert your code here;
}
//Facilitators
string Socialite::toString() const{
//insert your code here
}
void out(ostream &os){
//insert your code here
}

ostream& operator<<(ostream &os, Socialite &s){
//inset your code here
}
ofstream& operator<<(ostream &of, Socialite &s){
//inset your code here
}
