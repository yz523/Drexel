//
//  pre.h
//  L9
//
//  Created by Benny on 5/27/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#ifndef L9_pre_h
#define L9_pre_h

class Node
{
public:
    Node(int d = 0, Node * N = NULL);
    
    int Data() const;
    void Data(int d);
    
    Node * Next() const;
    void Next(Node * N);
private:
    int Data_;
    Node * Next_;
};

#endif
