//
//  testPuzzle.cpp
//  L10
//
//  Created by Benny on 6/4/15.
//  Copyright (c) 2015 Benny. All rights reserved.
//

#include <iostream>
#include <vector>
#include <fstream>
#include <map>
#include <sstream>
using namespace std;

void ReadFile();
void MostChar(string result);
void MostWord(vector<string> v);
string GetLongestHalfabet();
void GetLongestActual();
string Trim(string word);
string lowercase(string word);
bool Check(string word);
string LongestActualWord;
void LongestCoherentSentence();

vector<string>v;
vector<string>word;
vector<string>FF;
vector<string>FL;
vector<string>LF;
vector<string>LL;


int main(){
    ReadFile();
    for(int j=0;j<FF.size();j++){
        cout<<"FF:"<<FF[j]<<endl;
    }
    for(int j=0;j<FL.size();j++){
        cout<<"FL:"<<FL[j]<<endl;
    }
    for(int j=0;j<LF.size();j++){
        cout<<"LF:"<<LF[j]<<endl;
    }
    for(int j=0;j<LL.size();j++){
        cout<<"LL:"<<LL[j]<<endl;
    }
    GetLongestHalfabet();
    GetLongestActual();
    cout<<"Longest Actual Word:"<<LongestActualWord<<endl;
    LongestCoherentSentence();
}

void GetLongestActual(){
    string line,temp,longest,word;
    fstream fin;
    fin.open("data.txt",ios::in);
    while(getline(fin,line)){
        if(line.find(".")<=0||line.find(".")>line.size()){
            temp += line;
    }
        else{
            temp += line.substr(0,line.find("."));
        }
        if(temp.size()>longest.size()){
            longest=temp;
            temp="";
        }
        temp="";
    }
    cout << "Longest actual sentence:"<<longest<<endl;
    vector<string>v;
    for(int i=0;i<longest.size();i++){
        word=longest.substr(0,longest.find(" "));
        word=Trim(word);
        word=lowercase(word);
        v.push_back(word);
        longest.erase(0,longest.find(" ")+1);
    }
    MostChar(longest);
    MostWord(v);
}

string GetLongestHalfabet(){
    string result;
    vector<string>res;
    int first=0,last=0,temp=0,longest=0,pos1=0,pos2=0;
    vector<bool>b;
    for(int i=0;i<v.size();i++){
        b.push_back(Check(v[i]));
    }
    for(int k=0;k<b.size();k++){
        if(b[k]==0){
            first=last;
            last=k;
            temp=last-first;
            if(temp>longest){
                longest=temp;
                pos1=first;
                pos2=last;
            }
        }
    }
    for(int r=pos1;r<=pos2;r++){
        res.push_back(v[r]);
        result += v[r]+" ";
    }
    cout<<"Longest sequence of halfabet words:"<<result<<endl;
    MostChar(result);
    MostWord(res);
    return result;
}

void MostChar(string result){
    int a=0,b=0,c=0,d=0,e=0,f=0,g=0,h=0,i=0,j=0,k=0,l=0,m=0,n=0,o=0,p=0,q=0,r=0,s=0,t=0,u=0,v=0,w=0,x=0,y=0,z=0,longestint=0;
    char cc='a',longest='a';
    for(int in=0;in<result.size();in++){
        string str = result.substr(in,1);
        stringstream ss;
        ss << str;
        ss >> cc;
        switch(cc){
            case 'a':a++;break;
            case 'b':b++;break;
            case 'c':c++;break;
            case 'd':d++;break;
            case 'e':e++;break;
            case 'f':f++;break;
            case 'g':g++;break;
            case 'h':h++;break;
            case 'i':j++;break;
            case 'j':j++;break;
            case 'k':k++;break;
            case 'l':l++;break;
            case 'm':m++;break;
            case 'n':n++;break;
            case 'o':o++;break;
            case 'p':p++;break;
            case 'q':q++;break;
            case 'r':r++;break;
            case 's':s++;break;
            case 't':t++;break;
            case 'u':u++;break;
            case 'v':v++;break;
            case 'w':w++;break;
            case 'x':x++;break;
            case 'y':y++;break;
            case 'z':z++;break;
        }
        if(a>longestint){ longestint=a; longest='a';}
        if(b>longestint){ longestint=b; longest='b';}
        if(c>longestint){ longestint=c; longest='c';}
        if(d>longestint){ longestint=d; longest='d';}
        if(e>longestint){ longestint=e; longest='e';}
        if(f>longestint){ longestint=f; longest='f';}
        if(g>longestint){ longestint=g; longest='g';}
        if(h>longestint){ longestint=h; longest='h';}
        if(i>longestint){ longestint=i; longest='i';}
        if(j>longestint){ longestint=j; longest='j';}
        if(k>longestint){ longestint=k; longest='j';}
        if(l>longestint){ longestint=l; longest='k';}
        if(m>longestint){ longestint=m; longest='l';}
        if(n>longestint){ longestint=n; longest='m';}
        if(o>longestint){ longestint=o; longest='n';}
        if(p>longestint){ longestint=p; longest='o';}
        if(q>longestint){ longestint=q; longest='p';}
        if(r>longestint){ longestint=r; longest='q';}
        if(s>longestint){ longestint=s; longest='r';}
        if(t>longestint){ longestint=t; longest='s';}
        if(u>longestint){ longestint=u; longest='t';}
        if(v>longestint){ longestint=v; longest='u';}
        if(w>longestint){ longestint=w; longest='v';}
        if(x>longestint){ longestint=x; longest='x';}
        if(y>longestint){ longestint=y; longest='y';}
        if(z>longestint){ longestint=z; longest='z';}
    }
    cout <<"Most Char:"<<longest<<endl;
    cout <<"Appear times:"<<longestint<<endl;
}

void MostWord(vector<string> v){
    int appear=0,longest=0;
    string result;
    for(int i=0;i<v.size();i++){
        for(int j=0;j<v.size();j++){
            if(v[i]==v[j]){
                appear++;
            }
        }
        if(appear>longest){
            longest = appear;
            appear=0;
            result = v[i];
        }
            appear=0;
    }
    cout<<"Most Word:"<<result<<endl;
    cout<<"Appear times:"<<longest<<endl;
}


void ReadFile(){
    fstream fin;
    string word,f,l;
    fin.open("data.txt",ios::in);
    while(fin>>word){
        word = Trim(word);
        word = lowercase(word);
        if(word.size()>LongestActualWord.size()){
            LongestActualWord=word;
        }
        v.push_back(word);
        
        f=word.substr(0,1);
        l=word.back();
        if(f<"m"&&l<"m"&&f!=""&&l!=""){
            FF.push_back(word);
            for(int t=0;t<FF.size()-1;t++){
                if(FF[t]==FF.back()){
                    FF.pop_back();
                }
            }
        }
        if(f<"m"&&l>"m"&&f!=""&&l!=""){
            FL.push_back(word);
            for(int t=0;t<FL.size()-1;t++){
                if(FL[t]==FL.back()){
                    FL.pop_back();
                }
            }
        }
        if(f>"m"&&l<"m"&&f!=""&&l!=""){
            LF.push_back(word);
            for(int t=0;t<LF.size()-1;t++){
                if(LF[t]==LF.back()){
                    LF.pop_back();
                }
            }
        }
        if(f>"m"&&l>"m"&&f!=""&&l!=""){
            LL.push_back(word);
            for(int t=0;t<LL.size()-1;t++){
                if(LL[t]==LL.back()){
                    LL.pop_back();
                }
            }
        }
    }
}

string Trim(string word){
    while( word.size()>0 && !( word[0] >= 'a' && word[0] <= 'z' )
          && !( word[0] >= 'A' && word[0] <= 'Z' ))
        word = word.substr(1) ;
    
    while( word.size()>0 && !( word.back() >= 'a' && word.back() <= 'z')
          && !( word.back() >= 'A' && word.back() <= 'Z' ))
        word = word.substr(0,word.size()-1) ;
    while(word.find("-")>0&&word.find("-")<word.size()){
        word.erase(word.find("-"),1);
    }
    while(word.find(".")>0&&word.find(".")<word.size()){
        word.erase(word.find("."),1);
    }
    while(word.find("'")>0&&word.find("'")<word.size()){
        word.erase(word.find("'"),1);
    }
    while(word.find("/")>0&&word.find("/")<word.size()){
        word.erase(word.find("/"),1);
    }
    while(word.find("!")>0&&word.find("!")<word.size()){
        word.erase(word.find("!"),1);
    }
    while(word.find("\"")>0&&word.find("\"")<word.size()){
        word.erase(word.find("\""),1);
    }
    while(word.find("_")>0&&word.find("_")<word.size()){
        word.erase(word.find("_"),1);
    }
    while(word.find(" ")>0&&word.find(" ")<word.size()){
        word.erase(word.find(" "),1);
    }
    while(word.find(":")>0&&word.find(":")<word.size()){
        word.erase(word.find(":"),1);
    }
    
    return word ;
}

string lowercase(string word)
{
    for(unsigned int i=0; i<word.size(); i++)
        if( word[i]>='A' && word[i]<='Z' )
            word[i] += 'a'-'A' ;
    return word ;
}

bool Check(string word){
    for(int i=0;i<FF.size();i++){
        if(FF[i]==word)
            return true;
    }
    for(int i=0;i<FL.size();i++){
        if(FL[i]==word)
            return true;
    }
    for(int i=0;i<LF.size();i++){
        if(LF[i]==word)
            return true;
    }
    for(int i=0;i<LL.size();i++){
        if(LL[i]==word)
            return true;
    }
    return false;
}

void LongestCoherentSentence(){
    string result="if you stand here anyone can give you ebook and fresh license which is distributed by author";
    vector<string>v;
    v.push_back("if");
    v.push_back("you");
    v.push_back("stand");
    v.push_back("here");
    v.push_back("anyone");
    v.push_back("can");
    v.push_back("give");
    v.push_back("you");
    v.push_back("ebook");
    v.push_back("and");
    v.push_back("fresh");
    v.push_back("license");
    v.push_back("which");
    v.push_back("is");
    v.push_back("distributed");
    v.push_back("by");
    v.push_back("author");
    cout<<"Longest Coherent Sentence:"<<result<<endl;
    MostChar(result);
    MostWord(v);
}
