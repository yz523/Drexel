//
//  genkey.c
//  g2
//
//  Created by Yiyun Zhang on 8/15/17.
//  Copyright © 2017 Yiyun Zhang. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

//miniRSA library

int coprime(int a, int h)
{
    int temp;
    while(1)
    {
        temp = a%h;
        if(temp==0)
            return h;
        a = h;
        h = temp;
    }
}

int nth(int n)
{
    int i,j,c=0;
    
    if (n == 1) {
        return 2;
    }
    for(i=3;i<=10000;i+=2)
    {
        int b=1;
        int m = sqrt(i);
        for(j=3;j<=m;j+=2)
        {
            if(i%j==0)
            {
                b=0;
                break;
            }
        }
        if(b)
        {
            if(++c==n)
            {
                return i;
            }
        }
    }
    return 0;
}

int gcd(int a, int b)
{
    int t;
    while (b != 0)
    {
        t = a % b;
        a = b;
        b = t;
    }
    return a;
}

int cale(int m, int c)
{
    int e=m*2;
    while(1){
        if(coprime(e, m)==coprime(e, c)==1){
            if(gcd(e,m)==1){
                if(e % m >1){
                    return e;
                }
            }
            
        }
        e++;
    }
    return -1;
}

int mod_inverse(int e, int m){
    e = e % m;
    for (int d=1; d<m; d++){
        if ((e*d) % m == 1){
            return d;
        }
    }
    return -1;
}

//key generation
int main(int argc, char* argv[]){
    int num1 = atoi(argv[1]);
    int num2 = atoi(argv[2]);
    int p1 = nth(num1);
    int p2 = nth(num2);
    int c = p1*p2;
    int m = (p1-1)*(p2-1);
    int e = cale(m,c);
    int d = mod_inverse(e, m);
    printf("%dth prime=%d %dth prime=%d c=%d m=%d e=%d d=%d\n",num1,p1,num2,p2,c,m,e,d);
    printf("Public Key:(%d,%d)\n",e,c);
    printf("Private Key:(%d,%d)\n",d,c);
    return 0;
}
