//
//  pre.cpp
//  L9
//
//  Created by Benny on 5/27/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
using namespace std;
#include "pre.h"

Node::Node(int d, Node * N)
{
    Data(d);
    Next(N);
}

int Node::Data() const
{
    return Data_;
}

void Node::Data(int d)
{
    Data_ = d;
}

Node * Node::Next() const
{
    return Next_;
}

void Next(Node * N)
{
    Next_ = N;
}

int main(){
    Node *p, *N, *q;
    q-> = p->;
}