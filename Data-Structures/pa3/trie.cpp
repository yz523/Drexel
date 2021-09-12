#include <iostream>
#include <string>
#include <ctype.h>

using namespace std;

#ifndef _TRIE_NODE_
#define _TRIE_NODE_

class Trienode {
	private:
		char value;
		Trienode* child; //leftmost child
		Trienode* next; //right sibling
	public:
		Trienode();
		Trienode(char c);
		char GETVAL();
		Trienode* GETCHILD();
		Trienode* GETNEXT();
		void SETCHILD(Trienode* n);
		void SETNEXT(Trienode* n);
		void INSERT(string s);
		int GETSIZE();
};

	Trienode::Trienode(){
		value = '$';
		child = NULL;
		next = NULL;
	}
	
	Trienode::Trienode(char c){
		value = c;
		child = NULL;
		next = NULL;
	}
	
	char Trienode::GETVAL(){
		return value;
	}
	
	Trienode* Trienode::GETCHILD(){
		return child;
	}
	
	Trienode* Trienode::GETNEXT(){
		return next;
	}
	
	void Trienode::SETCHILD(Trienode* n){
		child = n;
	}
	
	void Trienode::SETNEXT(Trienode* n){
		next = n;
	}
	
	void Trienode::INSERT(string s){
		char c;
		if (s.length() > 0)
			c = s[0];
		else
			c = '$';
		
		if (GETCHILD() == NULL){
			SETCHILD(new Trienode(c));
			if (c != '$')
				GETCHILD()->INSERT(s.substr(1));
		}
		else{
			Trienode* p = child;
			while (p->GETVAL() != c && p->GETNEXT() != NULL)
				p = p->GETNEXT();
			if (p->GETVAL() != c){
				p->SETNEXT(new Trienode(c));
				p = p->GETNEXT();
			}
			if (c != '$')
					p->INSERT(s.substr(1));
		}
	}
	
	int Trienode::GETSIZE(){
		int count = 1;
		Trienode* p = GETCHILD();
		while (p != NULL){
			count = count + p->GETSIZE();
			p = p->GETNEXT();
		}
		return count;
	}

#endif

string clean(string x);

int main(void){
	string x;
	Trienode trie(' '); //root of trie
	
	while (cin >> x){
		x = clean(x);
		trie.INSERT(x);
	}
	
	cout << "Trie Complete" << endl;
	cout << "Trie Size: " << trie.GETSIZE() << endl;
	cout << "Size counts all nodes, including root and end of word characters" << endl;
	return 0;
}

string clean(string x){
	string s;
	for (int i = 0; i < x.length(); i++)
		if (isalpha(x[i]))
			s = s + (char)tolower(x[i]);
	return s;
}
