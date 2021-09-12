//
//  SetCard.cpp
//  L2
//
//  Created by Benny on 4/9/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
#include <string>
#include <sstream>

using namespace std;

#include "SetCard.h"

//------------------------------------------------------
//----- Constructors -----------------------------------
//------------------------------------------------------
SetCard::SetCard(){}

//------------------------------------------------------
//----- Inspectors -------------------------------------
//------------------------------------------------------
string SetCard::Get_Color() const{
    return color_;
}
string SetCard::Get_Shape() const{
    return shape_;
}
string SetCard::Get_Shading() const{
    return shading_;
}
string SetCard::Get_Number() const{
    return number_;
}

//------------------------------------------------------
//----- Mutators ---------------------------------------
//------------------------------------------------------
void SetCard::Set_Color(string color){
    color_=color;
}
void SetCard::Set_Shape(string shape){
    shape_=shape;
}
void SetCard::Set_Shading(string shading){
    shading_=shading;
}
void SetCard::Set_Number(string number){
    number_=number;
}

//------------------------------------------------------
//----- Facilitators -----------------------------------
//------------------------------------------------------
string SetCard::toString(){
    string out= number_ + " " + color_ + " " + shape_ + " "+shading_;
    return out;
}
