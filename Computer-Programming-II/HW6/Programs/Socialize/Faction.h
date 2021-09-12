//
//  Faction.h
//  HW6
//
//  Created by Benny on 6/2/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#ifndef __HW6__Faction__
#define __HW6__Faction__

#include <iostream>
#include <vector>
using namespace std;
#include "Node.h"
#include "List.h"
#include "Socialite.h"

class Socialite;

class Faction{
public:
    Faction();
    Node<Socialite>*SocialitePointer;
    string toString();
    private:
    string name;
    vector<Socialite>*SocialiteS;

};

#endif /* defined(__HW6__Faction__) */
