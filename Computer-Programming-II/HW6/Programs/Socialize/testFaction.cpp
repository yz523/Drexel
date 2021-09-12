//
//  testFaction.cpp
//  HW6
//
//  Created by Benny on 6/2/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
#include <vector>
#include <fstream>
#include <sstream>
using namespace std;
#include "Faction.h"
#include "Node.h"
#include "List.h"

void exchange(string &a, string &b, int &moves);
void ReadData() ;
void selectSort(vector<string> & a, int fromIndex, int toIndex);
int min_position(vector<string> & a, int fromIndex, int toIndex);
void Link(Socialite *SocialitePointer, Faction *FactionPointer);

vector<Socialite*>ptrSocialite;
vector<Faction*>ptrFaction;


void exchange(string &a, string &b)
{
    string temp = a ;
    a = b ;
    b = temp ;
    
}

int min_position(vector<string> & a, int fromIndex, int toIndex)
{
	   int min_pos = fromIndex;
	   for(int i = fromIndex + 1; i <= toIndex ; i++)
       {
           char left,right;
           string l,r;
           l=a[i].substr(0,1);
           r=a[min_pos].substr(0,1);
           stringstream ss;
           ss << l;
           ss >> left;
           ss << r;
           ss >> right;
           if ( left<right )
               min_pos = i;
       }
	   
	   return min_pos;
}

void selectSort(vector<string> & a, int fromIndex, int toIndex)
{
	   for(int next = fromIndex; next < toIndex; next++)
       {
           int min_pos = min_position(a, next, toIndex);
           
           if (min_pos != next)
               exchange(a[min_pos], a[next]);
       }
}

void ReadData(){
    fstream fin;
    string line,temp;
    vector<string>v;
    int numLine=0;
    
   //input the data file and store them in vector
    fin.open("CS172_Spring2015_Socialites_data.txt",ios::in);
    while(getline(fin,line)){
        ptrSocialite.push_back(new Socialite);
        numLine++;
        while(line==""){
            getline(fin,line);
        }
        
        //let the pointer vectors private attributes point to each data line
        if(numLine==1){
            ptrSocialite[ptrSocialite.size()-1]->Set_UserID(line);
        }
        if(numLine==2){
            ptrSocialite[ptrSocialite.size()-1]->Set_FirstName(line);
        }
        if(numLine==3){
            ptrSocialite[ptrSocialite.size()-1]->Set_LastName(line);
            temp.insert(0, line);
            line="";
        }
        if(numLine==4){
            ptrSocialite[ptrSocialite.size()-1]->Set_UserPicture(line);
        }
        if(numLine==5){
            ptrSocialite[ptrSocialite.size()-1]->Set_WebsiteShare(line);
        }
        if(numLine==6){
            ptrSocialite[ptrSocialite.size()-1]->Set_WebsiteDescription(line);
        }
        if(numLine==7){
            ptrSocialite[ptrSocialite.size()-1]->Set_Cliques(line);
        }
        if(line=="$$$$"){
            line="";
            if(temp.substr(0,1)==" "){
                temp.erase(0, 1);
            }
            v.push_back(temp);
            temp="";
            numLine=0;
        }
        temp += line+" ";
    }
    fin.close();
    
     //Sort the data by Last name
    int toIndex=v.size();
    selectSort(v, 0, toIndex);
    
}

void Link(Socialite *SocialitePointer, class Faction *FactionPointer){
    if(SocialitePointer->FactionPointer==NULL){
        SocialitePointer->FactionPointer = new Node<class Faction>;
        (SocialitePointer->FactionPointer)->data(*FactionPointer);
        (SocialitePointer->FactionPointer)->link(NULL);
    }
    Node<class Faction>*FactionIterator;
    while(FactionIterator->link()!=NULL){
        FactionIterator=FactionIterator->link();
    }
    FactionIterator->link(new Node<class Faction>);
    (FactionIterator->link())->link(NULL);
    (FactionIterator->link())->data(*FactionPointer);
}


int main(){
    cout<<"Socialite:"<<endl;
    ReadData();
    for(int i=0;i<=ptrSocialite.size();i++){
        cout<<"Name:"<<ptrSocialite[i]->Get_LastName()<<endl;
        cout<<"Data"<<((ptrSocialite[i]->FactionPointer)->data()).toString()<<endl;
    }
}
