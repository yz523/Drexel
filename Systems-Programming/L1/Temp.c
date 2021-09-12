//
//  Temp.c
//  L1
//
//  Created by Yiyun Zhang on 7/3/17.
//  Copyright © 2017 Yiyun Zhang. All rights reserved.
//


#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void myfree(char** str, int size){
    int i = 0;
    for(i=0;i<size;i++){
        free(str[i]);
        str[i] = NULL;
    }
    free(str);
    str = NULL;
}
void myprint(char* str){
    int i;
    while(str[i] != NULL){
        printf("%c %d\n", str[i], str[i]);
        i++;
    }
}
void mystrcpy(char* dst, char* src){
    int i = 0;
    while(src[i] != NULL){
        src[i] = src[i];
        i++;
    }
}

int main(void) {
    char** ptr = (char**) malloc(10*sizeof(char*));
    int = 0;
    for(i=0;i<10;i++){
        ptr[i] = (char*) malloc(6*sizeof(char));
    }
    for(i=0;i<10;i++){
        mystrcpy(ptr[i], "Hello");
        myprint(ptr[i]);
    }

    myfree(ptr, 10);
}