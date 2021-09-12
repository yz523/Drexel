//
//  testname.cpp
//  L4
//
//  Created by Benny on 4/23/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
#include <vector>
#include <string>
using namespace std;

#define convertArray(x) convertedArray(x,sizeof(x)/sizeof(x[0]))
#define showVector(x) showVec(x,#x)

template<typename someType>
void showVec( vector<someType>& v, int i ) ;

template<typename someType>
vector<someType> convertedArray(someType x[], unsigned int n) ;

int main(void){
    string firstname[]={"Stinky","Lumpy","Buttercup","Gidget","Crusty","Greasy","Fluffy","Cheeseball","Chim-Chim","Poopsie","Flunky","Booger","Pinky","Zippy","Goober","Doofus","Slimy","Loopy","Snotty","Falafel","Dorkey","Squeezit","Oprah","Skipper","Dinky","Zsa-Zsa"};
    string lastname_F[]={"Diaper","Toilet","Giggle","Bubble","Girdle","Barf","Lizard","Waffle","Cootie","Monkey","Potty","Liver","Banana","Rhino","Burger","Hamster","Toad","Gizzard","Pizza","Gerbil","Chicken","Pickle","Chuckle","Tofu","Gorilla","Stinker"};
    string lastname_L[]={"head","mouth","face","nose","tush","breath","pants","shorts","lips","honker","butt","brain","tushie","chunks","hiney","biscuits","toes","buns","fanny","sniffer","sprinkles","kisser","squirt","humperdinck","brains","juice"};
    
    vector<string>firstname_=convertArray(firstname);
    vector<string>lastname_F_=convertArray(lastname_F);
    vector<string>lastname_L_=convertArray(lastname_L);
    
    cout <<"Enter your name:";
    string fn,ln;
    cin>>fn>>ln;
    char fn_=fn[0];
    char ln_f_=ln[0];
    char ln_l_=ln.back();
    int a = fn_ - 'A';
    int b = ln_f_ - 'A';
    int c = ln_l_ - 'a';
    showVec(firstname_,a);
    showVec(lastname_F_,b);
    showVec(lastname_L_,c);
    return 0;
}

template<typename someType>
vector<someType> convertedArray(someType x[], unsigned int n){
    vector<string>v;
    for(unsigned int i=0;i<n;i++){
        v.push_back(x[i]);
        cout << "pushing back v[" << i << "]=" << v[i] << endl;
    }
    cout<<"Done!"<<endl;
    return v;
}

template<typename someType>
void showVec( vector<someType>& v, int i )
{
    cout << v[i]<<" ";
}