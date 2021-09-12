//
//  main.cpp
//  pa1++
//
//  Created by Yiyun Zhang on 7/27/17.
//  Copyright © 2017 Yiyun Zhang. All rights reserved.
//

#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
using namespace std;
#define FAILED NULL

typedef struct NODE *TREE;
struct NODE {
    char label;
    TREE leftmostChild, rightSibling;
};
TREE makeNode0(char x);
TREE makeNode1(char x, TREE t);
TREE makeNode4(char x, TREE t1, TREE t2, TREE t3, TREE t4);
TREE B();
TREE parseTree; /* holds the result of the parse */
char const *nextTerminal; /* current position in input string */

int height(struct NODE* node)
{
    if (node==NULL)
    return 0;
    else
    {
        int l = height(node->leftmostChild);
        int r = height(node->rightSibling);
        if (l > r)
        return(l+1);
        else return(r+1);
    }
}

void Preorder(NODE* node)
{
    if ( node )
    {
        cout << node->label << " ";
        Preorder(node->leftmostChild);
        Preorder(node->rightSibling);
    }
}

void Postorder(NODE* node)
{
    if ( node )
    {
        Postorder(node->leftmostChild);
        Postorder(node->rightSibling);
        cout << node->label << " ";
    }
}

int main()
{
    nextTerminal = "()()"; /* in practice, a string of terminals would be read from input */
    parseTree = B();
    cout << "Pre-order:";
    Preorder(parseTree);
    cout<<endl;
    cout << "Post-order";
    Postorder(parseTree);
    cout<<endl;
    cout << "Height:";
    cout << height(parseTree);
    cout<<endl;
    
}


TREE makeNode0(char x)
{
    TREE root;
    root = (TREE) malloc(sizeof(struct NODE));
    root->label = x;
    root->leftmostChild = NULL;
    root->rightSibling = NULL;
    return root;
}
TREE makeNode1(char x, TREE t)
{
    TREE root;
    root = makeNode0(x);
    root->leftmostChild = t;
    return root;
}
TREE makeNode4(char x, TREE t1, TREE t2, TREE t3, TREE t4)
{
    TREE root;
    root = makeNode1(x, t1);
    t1->rightSibling = t2;
    t2->rightSibling = t3;
    t3->rightSibling = t4;
    return root;
}

TREE B()
{
    TREE firstB, secondB;
    if(*nextTerminal == '(') /* follow production 2 */ {
        nextTerminal++;
        firstB = B();
        if(firstB != FAILED && *nextTerminal == ')') {
            nextTerminal++;
            secondB = B();
            if(secondB == FAILED)
            return FAILED;
            else
            return makeNode4('B', makeNode0('('), firstB, makeNode0(')'), secondB);
        }
        else /* first call to B failed */
        return FAILED;
    }
       else /* follow production 1 */
       return makeNode1('B', makeNode0('e'));
}
