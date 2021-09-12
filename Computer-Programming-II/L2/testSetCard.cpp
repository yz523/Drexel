//
//  testSetCard.cpp
//  L2
//
//  Created by Benny on 4/10/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
#include <string>
#include <sstream>
using namespace std;
#include "SetCard.h"

bool IsSet(SetCard set1,SetCard set2,SetCard set3){
    if(set1.Get_Number()!=set2.Get_Number()&&set2.Get_Number()!=set3.Get_Number()&&
       set1.Get_Shading()!=set2.Get_Shading()&&set2.Get_Shading()!=set3.Get_Shading()&&
       set1.Get_Shape()!=set2.Get_Shape()&&set2.Get_Shape()!=set3.Get_Shape()&&
       set1.Get_Color()!=set2.Get_Color()&&set2.Get_Color()!=set3.Get_Color()){
        return true;
    }
    if(set1.Get_Number()==set2.Get_Number()&&set2.Get_Number()==set3.Get_Number()&&
       set1.Get_Shading()!=set2.Get_Shading()&&set2.Get_Shading()!=set3.Get_Shading()&&
       set1.Get_Shape()!=set2.Get_Shape()&&set2.Get_Shape()!=set3.Get_Shape()&&
       set1.Get_Color()!=set2.Get_Color()&&set2.Get_Color()!=set3.Get_Color()){
        return true;
    }
    if(set1.Get_Number()!=set2.Get_Number()&&set2.Get_Number()!=set3.Get_Number()&&
       set1.Get_Shading()==set2.Get_Shading()&&set2.Get_Shading()==set3.Get_Shading()&&
       set1.Get_Shape()!=set2.Get_Shape()&&set2.Get_Shape()!=set3.Get_Shape()&&
       set1.Get_Color()!=set2.Get_Color()&&set2.Get_Color()!=set3.Get_Color()){
        return true;
    }
    if(set1.Get_Number()!=set2.Get_Number()&&set2.Get_Number()!=set3.Get_Number()&&
            set1.Get_Shading()!=set2.Get_Shading()&&set2.Get_Shading()!=set3.Get_Shading()&&
            set1.Get_Shape()==set2.Get_Shape()&&set2.Get_Shape()==set3.Get_Shape()&&
            set1.Get_Color()!=set2.Get_Color()&&set2.Get_Color()!=set3.Get_Color()){
        return true;
    }
    if(set1.Get_Number()!=set2.Get_Number()&&set2.Get_Number()!=set3.Get_Number()&&
            set1.Get_Shading()!=set2.Get_Shading()&&set2.Get_Shading()!=set3.Get_Shading()&&
            set1.Get_Shape()!=set2.Get_Shape()&&set2.Get_Shape()!=set3.Get_Shape()&&
            set1.Get_Color()==set2.Get_Color()&&set2.Get_Color()==set3.Get_Color()){
        return true;
    }
    return false;
}
int main(void){
    SetCard set1;
    set1.Set_Number("one");
    set1.Set_Shading("solid");
    set1.Set_Shape("ovals");
    set1.Set_Color("red");
    cout << "set1:"<<set1.toString()<<endl;
    
    SetCard set2;
    set2.Set_Number("two");
    set2.Set_Shading("striped");
    set2.Set_Shape("squiggles");
    set2.Set_Color("purple");
    cout << "set2:"<<set2.toString()<<endl;
    
    SetCard set3;
    set3.Set_Number("three");
    set3.Set_Shading("outlined");
    set3.Set_Shape("diamonds");
    set3.Set_Color("green");
    cout << "set3:"<<set3.toString()<<endl;
    
    if(IsSet(set1,set2,set3)==true){
        cout << "Result:is set";
    }
    else{
        cout << "Result:not set";
    }
}
