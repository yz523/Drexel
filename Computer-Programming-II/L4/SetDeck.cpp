//
//  SetCard.cpp
//  L2
//
//  Created by Benny on 4/9/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
#include <string>
#include <vector>
#include <sstream>

using namespace std;

#include "SetDeck.h"

SetDeck::SetDeck(){
    string number[]={"one","two","three"};
    string color[]={"red","purple","green"};
    string shading[]={"striped","solid","outlined"};
    string shape[]={"diamonds","squiggles","ovals"};
    int i=0;
    for(int a=0;a<3;a++){
        for(int b=0;b<3;b++){
            for(int c=0;c<3;c++){
                for(int d=0;d<3;d++){
                    card_[i]=number[a]+";"+color[b]+";"+shading[c]+";"+shape[d];
                    i++;
                }
            }
        }
    }
}

void SetDeck::getDeck(){
    for(int i=0;i<81;i++){
        cout<<"card"<<i<<":"<<card_[i]<<endl;
    }
}

