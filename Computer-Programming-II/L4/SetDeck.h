//
//  Header.h
//  L2
//
//  Created by Benny on 4/9/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#ifndef L2_Header_h
#define L2_Header_h

#include <iostream>
#include <string>
#include <sstream>
#include <vector>
using namespace std;

class SetDeck {
public:
    SetDeck();
    void getDeck();
    void shuffleCard();
private:
    string card_[81];
};

#endif
