//
//  client.c
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

//encrypt the message
void encryptmsg(char* m, int l, int e, int c, int* arr){
    for(int i=0; i<l; i++){
        int a = (int)*m;
        int ee = e;
        int cc = c;
        int t = 1;
        while(ee){
            if(ee % 2){
                t = (t * a) % cc;
            }
            a = (a * a) % cc;
            ee = ee/2;
        }
        
        arr[i] = t;
        m++;
    }
    arr[l] = -1;
}

//client
int main(int argc, char* argv[]){
    char* host = argv[1];
    int port = atoi(argv[2]);
    int e = atoi(argv[3]);
    int c = atoi(argv[4]);
    int* m = (int*)malloc(256*sizeof(int));
    int clientfd = Open_clientfd(host, port);
    char start[MAXLINE];
    strcpy(start, "\n");
    char end[MAXLINE];
    strcpy(end, "\n");
    rio_t rio;
    
    Rio_readinitb(&rio, clientfd);
    while(1){
        char input[MAXLINE];
        printf("\n\nEnter the input: ");
        fgets(input, MAXLINE, stdin);
        Rio_writen(clientfd, start, strlen(start));
        long len = strlen(input);
        encryptmsg(input, len, e, c, m);
        printf("Encrypt result: ");
        int i = 0;
        for(i=0; i<len-1; i++){
            printf("%d ",m[i]);
        }
        while(*m != -1){
            sleep(1);
            char tmp[MAXLINE];
            sprintf(tmp, "%d\n", *m);
            Rio_writen(clientfd, tmp, strlen(tmp));
            m++;
        }
        Rio_writen(clientfd, end, strlen(end));
    }
    
    close(clientfd);
    return 0;
}
