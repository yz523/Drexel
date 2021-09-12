#include <iostream>
#include <map>
#include <vector>
using namespace std;
#ifndef __CardSuit__
#define __CardSuit__
enum CardSuit {SPADES,HEARTS,CLUBS,DIAMONDS,};
ostream &operator<<(ostream&os, const CardSuit &stone);
#endif