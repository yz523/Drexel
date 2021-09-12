//
//  main.cpp
//  L10
//
//  Created by Benny on 3/13/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
#include <fstream>
using namespace std;

void menu(){
    cout<<"\n";
    cout<<"Main Menu:"<<endl;
    cout<<"1.Add a contact"<<endl;
    cout<<"2.Delete a contact"<<endl;
    cout<<"3.List all contacts"<<endl;
    cout<<"4.Search for a contact"<<endl;
    cout<<"5.Exit"<<endl;
    cout<<"\n";
    cout<<"Enter the number of your action:";
}

void Add_contact(string filename){
    fstream myfile;
    string info;
    string act="y";
    myfile.open(filename,ios::out|ios::app);
    while(act=="y"){
        cout<<"\n";
        cout<<"Enter the name:";
        cin>>info;
        myfile<<"Name: "<<info<<endl;
        cout<<"Enter the phone number:";
        cin>>info;
        myfile<<"Phone number: "<<info<<endl;
        cout<<"Enter the e-mail address:";
        cin>>info;
        myfile<<"E-mail address: "<<info<<endl<<"\n";
        cout<<"\n";
        cout<<"Continue Adding?(y/n)";
        cin >>act;
        if(act=="n"){
            break;
        }
    }
}

void Delete_contact(string filename){
    string line;
    int count=0;
    fstream temp("tempfile.fmt");
    temp.open("tempfile.fmt",ios::out);
    fstream myfile;
    myfile.open(filename,ios::in);
    string name;
    cout<<"\n";
    cout<<"Enter the person's name you want delete:";
    cin>>name;
    cout<<"\n";
    while(getline(myfile,line)){
        if(line=="Name: "+ name){
            count=1;
            for(int i=0;i<4;i++){
                getline(myfile,line);
            }
        }
        temp<<line<<endl;
    }
    if(count==0){
        cout<<"No result found!";
        cout<<"\n";
    }
    else{
         cout<<"Delete completed!";
        cout<<"\n";
    }
    myfile.close();
    temp.close();
    myfile.open(filename,ios::out);
    temp.open("tempfile.fmt",ios::in);
    while(getline(temp,line)){
        myfile<<line<<endl;
    }
    temp.close();
    myfile.close();
    remove("tempfile.fmt");
}

void List_contact(string filename){
    string line;
    cout<<"\n";
    fstream myfile;
    myfile.open(filename,ios::in);
    while(getline(myfile,line)){
        cout<<line<<endl;
    }
}

void Search_contact(string filename){
    string line;
    int temp=0;
    fstream myfile;
    myfile.open(filename,ios::in);
            string name;
            cout<<"\n";
            cout<<"Enter the name you want search:";
            cin>>name;
            cout<<"\n";
            while(getline(myfile,line)){
            if(line=="Name: "+ name){
                for(int i=0;i<4;i++){
                    cout<<line<<endl;
                    getline(myfile,line);
                    temp=1;
                }
            }
            }
            if(temp==0){
                cout<<"No result found!";
                cout<<"\n";
            }
}

int main(){
    string filename;
    int action=0;
    fstream myfile;
    cout<<"Enter the file name:";
    cin>>filename;
    myfile.open(filename);
    if(myfile.is_open()==true){
        cout<<"\n";
        cout<<"File Open Success!";
        myfile.open("filename",ios::in|ios::out);
    }
    else{
        cout<<"\n";
        cout<<"File not exist, Creating new file..."<<endl;
        cout<<"File creat successful!";
        myfile.open(filename,ios::out);
    }
    while(myfile.is_open()==true){
        cout<<"\n";
        menu();
        cin>>action;
        if(action!=1&&action!=2&&action!=3&&action!=4&action!=5){
            cout<<"Invaild number, Enter again:";
            cin>>action;
        }
        else{
            switch (action) {
                case 1:Add_contact(filename);break;
                case 2:Delete_contact(filename);break;
                case 3:List_contact(filename);break;
                case 4:Search_contact(filename);break;
                case 5:cout<<"Closing...";
                        myfile.close();
                    break;
            }
        }
    }
}
