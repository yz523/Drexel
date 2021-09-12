//
//  test_Socialite.cpp
//  HW1
//
//  Created by Benny on 4/5/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
#include <string>
using namespace std;
#include "Socialite.h"

int main(void){
    Socialite test;
    test.Default_Constructor(); //set all string variables to empty
    test.Set_LastName(); //set last name
    test.Set_FirstName(); //set first name
    test.Set_UserID(); //set user id
    test.Set_UserPicture(); //set user picture
    test.Set_WebsiteShare(); //set website share link
    test.Set_WebsiteDescription(); //set website description
    test.Text_Output(); //output information as text
    test.HTML_Output(); //output the html file
}