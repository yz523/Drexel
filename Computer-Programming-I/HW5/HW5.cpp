//
//  main.cpp
//  HW5
//
//  Created by Benny on 3/15/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
#include <fstream>
#include <cmath>
#include <iomanip>
using namespace std;

string promptForString(string &message){
    cin>>message;
    return message;
}

double promptForDouble(double &data){
    cin>>data;
    return data;
}


void introduction(istream &is, ostream &os, string target, string replacement)
{
    string line;
    while (getline(is,line)) {
       	while(line.find(target) != -1) {
            line.replace(line.find(target), target.length(),replacement);
        }
        os << line << endl;
    }
}

void updateStatus(double &velocity, double burnAmount, double &fuelRemaining, double &height){
    fuelRemaining-=burnAmount;
    velocity+=5.0-burnAmount;
    height-=(2.0*velocity-5.0+burnAmount)/2.0;
}

void touchdown(double &elapsedTime, double &velocity, double &burnAmount, double &height){
    float delta,oldVelocity,oldHeight;
    oldVelocity=velocity+5-burnAmount;
    oldHeight=height+(velocity+oldVelocity)/2.0;
    if(burnAmount==5){
        delta=oldHeight/oldVelocity;
    }
    else{
        delta=(sqrt((oldVelocity*oldVelocity)+oldHeight*(10.0-(2.0*burnAmount)))-oldVelocity)/(5.0-burnAmount);
    }
    elapsedTime+=+delta-1.0;
    velocity=oldVelocity+(5.0-burnAmount)*delta;
}

void finalAnalysis(ostream &os, double velocity){
    if(velocity==0){
        os<<"Congratulations! A perfect landing!! Your license will be renewed...later.";
    }
    if(velocity>0&&velocity<2){
        os<<"A little bumpy.";
    }
    if(velocity>=2&&velocity<5){
        os<<"You blew it!!!!!! Your family will be notified...by post.";
    }
    if(velocity>=5&&velocity<10){
        os<<"Your ship is a heap of junk !!!!! Your family will be notified...by post.";
    }
    if(velocity>=10&&velocity<30){
        os<<"You blasted a huge crater !!!!! Your family will be notified...by post.";
    }
    if(velocity>=30&&velocity<50){
        os<<"Your ship is a wreck !!!!! Your family will be notified...by post.";
    }
    if(velocity>=50){
        os<<"You totaled an entire mountain !!!!! Your family will be notified...by post.";
    }
}

int main(){
    string target="$SPACECRAFT",replacement,line;
    char intro,play,again='y';
    filebuf infile;
    infile.open("input.txt",ios::in);
    istream is(&infile);
    cout<<"Welcome to my World! Do you want some advises?(y/n):";
    cin>>intro;
    cout<<"\n";
    if(intro=='y'){
    cout<<"Enter you SPACECRAFT name:";
    replacement=promptForString(replacement);
    cout<<"\n";
    introduction(is, cout, target,replacement);
    cout<<"\n";
    }
    cout<<"Are you ready to landing right now?(y/n):";
    cin>>play;
    cout<<"\n";
    if(play=='n'){
        cout<<"See you next time!";
        exit(0);
    }
    while(again=='y'){
        double height=1000.0,time=0.0,velocity=50.0,fuelRemaining=150.0,burnAmount=0.0;
    while(fuelRemaining>0&&height>0){
        cout<<"Status of you "<<replacement<<" spacecraft:"<<endl;
        cout<<"Time: "<<time<<" seconds"<<endl;
        cout<<"Height: "<<height<<" feet"<<endl;
        cout<<"Speed: "<<velocity<<" ft/sec"<<endl;
        cout<<"Fuel: "<<fuelRemaining<<endl;
        cout<<"Enter fuel burn amount:";
        burnAmount=promptForDouble(burnAmount);
        updateStatus(velocity,burnAmount,fuelRemaining,height);
        time++;
        cout<<"\n";
        }
        if(fuelRemaining<=0||height<=0){
        fuelRemaining=0.0;
        cout<<"Status of you "<<replacement<<" spacecraft:"<<endl;
        cout<<"Time: "<<time<<" seconds"<<endl;
        cout<<"Height: "<<height<<" feet"<<endl;
        cout<<"Speed: "<<velocity<<" ft/sec"<<endl;
        cout<<"Fuel: "<<fuelRemaining<<endl;
        cout<<"\n";
        touchdown(time, velocity, burnAmount, height);
        cout<<"**** OUT OF FUEL ****"<<endl<<endl;
        cout<<"***** CONTACT *****"<<endl;
        cout<<"Touchdown at "<<setprecision(5)<<time<<" seconds."<<endl;
        cout<<"Landing velocity = "<<setprecision(5)<<velocity<<" ft/sec."<<endl;
        cout<<fuelRemaining<<" units of fuel remaining"<<endl;
        finalAnalysis(cout, velocity);
    }
            cout<<"\n";
    cout<<"\n";
    cout<<"Try again?(y/n):";
    cin>>again;
    cout<<"\n";
    }
}
