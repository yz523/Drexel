//
//  Header.h
//  L2
//
//  Created by Benny on 4/9/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#ifndef L2_Header_h
#define L2_Header_h

#include <iostream>
#include <string>
#include <sstream>
using namespace std;

class SetCard {
public:
    //------------------------------------------------------
    //----- Constructors -----------------------------------
    //------------------------------------------------------
    SetCard();
    
    //------------------------------------------------------
    //----- Inspectors -------------------------------------
    //------------------------------------------------------
    string Get_Color() const;
    string Get_Shape() const;
    string Get_Shading() const;
    string Get_Number() const;
    
    //------------------------------------------------------
    //----- Mutators ---------------------------------------
    //------------------------------------------------------
    void Set_Color(string color);
    void Set_Shape(string shape);
    void Set_Shading(string shading);
    void Set_Number(string number);
    
    //------------------------------------------------------
    //----- Facilitators -----------------------------------
    //------------------------------------------------------
    string toString();
    
    
private:
    string color_;
    string shape_;
    string shading_;
    string number_;
};

#endif
