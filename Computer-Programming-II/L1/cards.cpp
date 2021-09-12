//---------------------------------------------------------------------
//
// Random Card Generator
//
//---------------------------------------------------------------------
//
// This program generates a random number between 0 and 51 which is
// to be interpreted as a playing card from a regular bridge deck.
//
// The cards 0-12 are the Ace, Two, ..., Jack, Queen, King of Spades.
// The cards 13-25 are the corresponding cards in the suit of Hearts.
// Likewise, cards 26-38 and 39-51 are the corresponding cards in
// Clubs and Diamonds.
//
// Some of the implementation details have been left for the student.
// The purpose of this exercise is to learn about and understand the use
// of enumerated types and switch statements.
//
// Written:  JL Popyack, Mar. 2003.
//
//---------------------------------------------------------------------

	#include <iostream>
	#include <string>

//-----------------------------------------------------------
// These libraries are included for the initialization 
// and use of the random number generator:
//-----------------------------------------------------------
	#include <cstdlib>
	#include <ctime>
//-----------------------------------------------------------

	using namespace std; 

	enum CardSuit {SPADES, HEARTS, CLUBS, DIAMONDS} ;
    enum CardRank {ACE, TWO, THREE, FOUR, FIVE, SIX,
                   SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING} ;

//----------------------------------------------------------------------------
//
//-------------------------------- Prototypes --------------------------------
//
//----------------------------------------------------------------------------

	void translateCard(int card, CardSuit &suit, CardRank &rank) ;
	void printCard(CardSuit suit, CardRank rank) ;

//----------------------------------------------------------------------------
//
//------------------------------- Main Program -------------------------------
//
//----------------------------------------------------------------------------

int main(void)
{	
	//-----------------------------------------------------------
	// Initialize the random number generator
	//-----------------------------------------------------------
		srand( static_cast<unsigned int>(time(0)) ) ;	
		
		int card ;

		cout << "Ladies and Gentlemen, Mesdames et Messieurs" << endl
		     << "Welcome to Random Card Picker." << endl
		     << "What is your name, contestant? " ;

		string name ;
		getline(cin,name) ;
		
		cout << endl << "Bien, " << name << ", les jeux sont faits."
		     << endl << "Combiens des pamplemousses avez-vous, here is your card:"
		     << endl ;
	     
	//-----------------------------------------------------------
	// Generate a random choice in the interval [0,51]  
	//-----------------------------------------------------------
		card = (rand()*52.0L)/RAND_MAX ;

		cout << card << endl ;
		
		CardSuit suit ;
		CardRank rank ;
		
		translateCard(card,suit,rank) ;
		printCard(suit,rank) ;
		
		return 0 ;
}
	

//----------------------------------------------------------------------------
//
//-------------------------- Subprogram Definitions --------------------------
//
//----------------------------------------------------------------------------

	void translateCard(int card, CardSuit &suit, CardRank &rank)
	{
	//---------------------------------------------------------------------
	//  This routine is supposed to determine the suit and rank of a card,
	//  according to the following rules:
	//
	//  The cards 0-12 are the Ace, Two, ..., Jack, Queen, King of Spades.
	//  The cards 13-25 are the corresponding cards in the suit of Hearts.
	//  Likewise, cards 26-38 and 39-51 are the corresponding cards in
	//  Clubs and Diamonds.
	//---------------------------------------------------------------------
		suit = static_cast<CardSuit>(card/13);
		rank = static_cast<CardRank>(card%13);
	}
	

//----------------------------------------------------------------------------
//
	void printCard(CardSuit suit, CardRank rank)
	{
	//---------------------------------------------------------------------
	//  This routine should use switch statements to print the suit and
	//  rank of a card, e.g., "Ace of Spades".
	//---------------------------------------------------------------------
        string rank_result, suit_result;
        switch (rank) {
            case 0:
                rank_result="ACE";
                break;
            case 1:
                rank_result="TWO";
                break;
            case 2:
                rank_result="THREE";
                break;
            case 3:
                rank_result="FOUR";
                break;
            case 4:
                rank_result="FIVE";
                break;
            case 5:
                rank_result="SIX";
                break;
            case 6:
                rank_result="SEVEN";
                break;
            case 7:
                rank_result="EIGHT";
                break;
            case 8:
                rank_result="NINE";
                break;
            case 9:
                rank_result="TEN";
                break;
            case 10:
                rank_result="JACK";
                break;
            case 11:
                rank_result="QUEEN";
                break;
            case 12:
                rank_result="KING";
                break;
        }
        switch (suit){
            case 0:
                suit_result="SPADES";
                break;
            case 1:
                suit_result="HEARTS";
                break;
            case 2:
                suit_result="CLUBS";
                break;
            case 3:
                suit_result="DIAMONDS";
                break;
        }
		cout << rank_result << " of " << suit_result << endl ;
	}
	
