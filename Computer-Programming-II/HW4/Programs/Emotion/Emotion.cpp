//
//  Emotion.cpp
//  HW4
//
//  Created by Benny on 5/3/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
#include <map>
using namespace std;

int main(){
    //set relationships
    map<string, string>emotion;
    emotion["smile"]=":-)";
    emotion["wink"]=";-)";
    emotion["I am shocked"]="[8^0)";
    emotion["long-stemmed rose"]="--{---@";
    
    //checks if it is a known emotion and prints meaning
    map<string, string>meaning;
    meaning[":-)"]="smile";
    meaning[";-)"]="wink";
    meaning["[8^0)"]="I am shocked";
    meaning["--{---@"]="long-stemmed rose";
    
    cout<<"Enter the phrase:";
    string phrase;
    cin>>phrase;
    if(meaning[phrase].size()>0){
        cout << "Emotion Exists, the meaning is:"<<meaning[phrase]<<endl;
    }
    else{
        cout<<"Emotion not Exist";
    }
}
