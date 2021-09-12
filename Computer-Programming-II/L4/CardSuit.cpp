#include <iostream>
#include <map>
#include <vector>
using namespace std;
#include "CardSuit.h"
ostream &operator<<(ostream&os, const CardSuit &stone){
map<CardSuit,string>mymap;
mymap[SPADES]="SPADES";
mymap[HEARTS]="HEARTS";
mymap[CLUBS]="CLUBS";
mymap[DIAMONDS]="DIAMONDS";
os<<mymap[stone];
return os;
}
