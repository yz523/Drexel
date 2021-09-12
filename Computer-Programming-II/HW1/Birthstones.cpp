//
//  Birthstones.cpp
//  HW1
//
//  Created by Benny on 4/5/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
#include <string>
using namespace std;

enum Birthstone{Garnet, Amethyst, Aquamarine, Diamond, Emerald,
    Moonstone, Ruby, Peridot, Sapphire, Opal, Topaz, Turquoise
};

Birthstone nextStone(Birthstone stone){
    Birthstone nextStone;
    switch(stone){
        case 0: nextStone=Amethyst;break;
        case 1: nextStone=Aquamarine;break;
        case 2: nextStone=Diamond;break;
        case 3: nextStone=Emerald;break;
        case 4: nextStone=Moonstone;break;
        case 5: nextStone=Ruby;break;
        case 6: nextStone=Peridot;break;
        case 7: nextStone=Sapphire;break;
        case 8: nextStone=Opal;break;
        case 9: nextStone=Topaz;break;
        case 10: nextStone=Turquoise;break;
        case 11: nextStone=Garnet;break;
    }
    
    return nextStone;
}

int main(){
    cout<<nextStone(Topaz);
}
