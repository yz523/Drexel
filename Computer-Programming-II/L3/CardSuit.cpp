#include <iostream>
using namespace std;
#include "CardSuit.h"
ostream &operator<<(ostream&os, const CardSuit &stone){
switch (stone) {
case SPADES:os<<"SPADES";break;
case HEARTS:os<<"HEARTS";break;
case CLUBS:os<<"CLUBS";break;
case DIAMONDS:os<<"DIAMONDS";break;
}
return os;
}
