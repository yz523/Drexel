//
//  node.hpp
//  pa2
//
//  Created by Yiyun Zhang on 8/14/17.
//  Copyright © 2017 Yiyun Zhang. All rights reserved.
//

#ifndef node_hpp
#define node_hpp

#include <stdio.h>
#include <cstdarg>
#include <iostream>
using namespace std;

#ifndef NULL
#define NULL 0
#endif

class node {
public:
    node(char x, int nodes, ...);
    ~node();
private:
    char label;
    node *leftmostChild, *rightSibling;
};

#endif /* node_hpp */
