//
//  Grade.cpp
//  L2
//
//  Created by Benny on 1/20/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include<iostream>

using namespace std;

   double gpa = 0;
   double x = 0.0;
int main(){
    char grade[3];
    
     cout << "Enter a grade: " << endl;
    cin >> grade;
     
   switch(grade[0]){
       case'A': gpa = 4;
           break;
       case'B': gpa = 3;
           break;
       case'C': gpa = 2;
           break;
       case'D': gpa = 1;
           break;
       default:
            cout << "0w0" << endl;
           break;
    }
     if(grade[0]=='A'){
         x = 0;
     }
     else if (grade[1]=='-'){
         x = -0.3;
     }
     else if (grade[1]=='+'){
         x = +0.3;
     }
     else {
         x = 0;
     }
     gpa += x;
     cout << "The numeric value is " << gpa << endl;
 }
