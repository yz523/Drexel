//
//  node.cpp
//  pa2
//
//  Created by Yiyun Zhang on 8/14/17.
//  Copyright © 2017 Yiyun Zhang. All rights reserved.
//

#include "node.hpp"
#include <iostream>
#include <string>
using namespace std;

#define FAILED NULL
string::iterator nextTerminal;
string::iterator ENDC;

node::node(char x, int nodes, ...){
    this->label = x;
    va_list ap;
    va_start(ap, nodes);
    node *current, *last;
    
    if (nodes > 0){
        current = va_arg(ap, node *);
        this->leftmostChild = current;
        last = current;
        
        for (int i = 1; i < nodes; i++){
            current = va_arg(ap, node *);
            last->rightSibling = current;
            last = current;
        }
    }
    va_end(ap);
}

node::~node(){
    if (this->rightSibling)
        delete this->rightSibling;
    if (this->leftmostChild)
        delete this->leftmostChild;
}

node *node4() {
    if (*nextTerminal != '1')
        return new node('4', 1, new node('5', 0));
    nextTerminal++;
    
    node *d1, *d2;
    
    if ((d1 = node4()) == FAILED)
        return FAILED;
    
    if (*nextTerminal != '0'){
        delete d1;
        return FAILED;
    }
    nextTerminal++;
    
    if ((d2 = node4()) == FAILED){
        delete d1;
        return FAILED;
    }
    
    return new node('4', 4, new node('1', 0), d1, new node('0', 0), d2);
}

node *node3() {
    if (*nextTerminal != '0')
        return new node('3', 1, new node('5', 0));
    nextTerminal++;
    
    node *c1, *c2;
    
    if ((c1 = node3()) == FAILED)
        return FAILED;
    
    if (*nextTerminal != '1'){
        delete c1;
        return FAILED;
    }
    nextTerminal++;
    
    if ((c2 = node3()) == FAILED){
        delete c1;
        return FAILED;
    }
    
    return new node('3', 4, new node('0', 0), c1, new node('1', 0), c2);
}

node *node2() {
    if (*nextTerminal != '1')
        return FAILED;
    nextTerminal++;
    
    node *d;
    
    if ((d = node4()) == FAILED)
        return FAILED;
    if (*nextTerminal != '0'){
        delete d;
        return FAILED;
    }
    nextTerminal++;
    return new node('2', 3, new node('1', 0), d, new node('0', 0));
}

node *node1() {
    if (*nextTerminal != '0')
        return FAILED;
    nextTerminal++;
    
    node *c;
    
    if ((c = node3()) == FAILED)
        return FAILED;
    if (*nextTerminal != '1'){
        delete c;
        return FAILED;
    }
    nextTerminal++;
    return new node('1', 3, new node('0', 0), c, new node('1', 0));
}

node *n(){
    if (nextTerminal == ENDC)
        return new node('n', 1, new node('5', 0));
    else if (*nextTerminal != '1' && *nextTerminal != '0')
        return FAILED;
    
    if (*nextTerminal == '0') {
        node *a, *s;
        if ((a = node1()) == FAILED)
            return FAILED;
        if ((s = n()) == FAILED){
            delete a;
            return FAILED;
        }
        return new node('n', 2, a, s);
    }
    node *b, *s;
    if ((b = node2()) == FAILED)
        return FAILED;
    if ((s = n()) == FAILED){
        delete b;
        return FAILED;
    }
    return new node('n', 2, b, s);
}

int main(int argc, char **argv) {
    string input;
    
    if (argc == 1) {
        cout << "Enter input: " << endl;
        getline(cin, input);
    } else
        input = string(argv[1]);
    nextTerminal = input.begin();
    ENDC = input.end();
    
    struct node *parseTree = n();
    
    if (!parseTree || nextTerminal != ENDC){
        cout << "Invalid input or failed to parsing" << endl;
        delete parseTree;
        return 1;
    }
    cout << "Parsing successful" << endl;
    delete parseTree;
    return 0;
}

