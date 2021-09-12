//
//  Faction.cpp
//  HW6
//
//  Created by Benny on 6/2/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include "Faction.h"
using namespace std;

Faction::Faction(){
    SocialitePointer=NULL;
}

string Faction::toString(){
    return name;
}