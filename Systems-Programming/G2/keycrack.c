//
//  keycrack.c
//  g2
//
//  Created by Yiyun Zhang on 8/15/17.
//  Copyright © 2017 Yiyun Zhang. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include "csapp.h"
#include <math.h>

//helper functions
char decryptchar(int in, int d, int c){
    int a = in;
    int dd = d;
    int cc = c;
    int tmp = 1;
    while(dd){
        if(dd % 2){tmp = (tmp * a) % cc;}
        a = (a * a) % cc;
        dd = dd/2;
    }
    return tmp;
}

void isvalid(int a, int *b, int *c){
    int i = 2;
    for(i=2; i<(a/2); i++){
        if(a%i == 0){
            *b = i;
            *c = a/i;
            return;
        }
    }
    printf("Key not valid\n");
}

int gcd(int a, int b)
{
    int temp;
    while (b != 0)
    {
        temp = a % b;
        
        a = b;
        b = temp;
    }
    return a;
}

int calc(int c){
    int i = 2;
    for(i=2; i<c; i++){
        if(gcd(i, c)==1){
            return i;
        }
    }
    return -1;
}

int cald(int e, int i){
    int d = 1;
    for(d=1; d<10000; d++){
        if((e*d)%i == 1){
            return d;
        }
    }
    return -1;
}

//crack
int main(int argc, char* argv[]){
    int a = 0;
    int b = 0;
    int c = atoi(argv[2]);
    isvalid(c, &a, &b);
    int m = (a-1)*(b-1);
    int e = calc(m);
    int d = cald(e, m);
    printf("c=%d m=%d e=%d d=%d\n",c,m,e,d);
    printf("Public Key:(%d,%d)\n",e,c);
    printf("Private Key:(%d,%d)\n",d,c);
    while(1){
        char input[MAXLINE];
        printf("\nEnter the value to decrypt:");
        fgets(input, MAXLINE, stdin);
        int in = atoi(input);
        char res = decryptchar(in,d,c);
        printf("The value is:%c",res);
    }
    return 0;
}
