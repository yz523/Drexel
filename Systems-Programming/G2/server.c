//
//  server.c
//  g2
//
//  Created by Yiyun Zhang on 8/15/17.
//  Copyright © 2017 Yiyun Zhang. All rights reserved.
//

#include <stdio.h>
#include <math.h>
#include "csapp.h"

//decrypt the message
void decryptmsg(int* m, int l, int d, int c, char* dm){
    for(int i=0; i<l; i++){
        int a = *m;
        int dd = d;
        int cc = c;
        int tmp = 1;
        while(dd){
            if(dd % 2){
                tmp = (tmp * a) % cc;
            }
            a = (a * a) % cc;
            dd = dd/2;
        }
        *dm = (char)tmp;
        dm++;
        m++;
    }
}


//server
int main(int argc, char* argv[]){
    int port = atoi(argv[1]);
    int c = atoi(argv[3]);
    int d = atoi(argv[4]);
    int listenfd = Open_listenfd(port);
    struct sockaddr_in clientaddr;
    int clientaddrlen = sizeof(clientaddr);
    int connfd, n;
    int Arr[256];
    int* m = Arr;
    int f = 0, ct = 0;
    rio_t r;
    char ch[MAXLINE];
    char* dm = (char*)malloc(256*sizeof(char));
    
    while(1){
        connfd = Accept(listenfd, (SA*)&clientaddr, &clientaddrlen);
        
        Rio_readinitb(&r, connfd);
        while((n = Rio_readlineb(&r, ch, MAXLINE)) != 0){
            if((int)ch[0]-'0' >= 0 && (int)ch[0]-'0' <= 9){
                *m = atoi(ch);
                m++;
                f = 1;
                ct++;
            }
            else{
                if(f == 1){
                    m = Arr;
                    char* tmp = dm;
                    decryptmsg(m, ct, d, c, tmp);
                    printf("\n\nEncrypted input: ");
                    int i = 0;
                    for(i=0; i<ct-1; i++){
                        printf("%d ", m[i]);
                    }
                    printf("\nDecrypte result: %s",dm);
                    f = 0;
                    m = Arr;
                    ct = 0;
                }
            }
        }
        close(connfd);
    }
    close(listenfd);
    return 0;
}
