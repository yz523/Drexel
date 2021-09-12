//
//  g1.c
//  G1
//
//  Created by Yiyun Zhang on 7/29/17.
//  Copyright © 2017 Yiyun Zhang. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
extern FILE *stdin;
extern FILE *stdout;
extern FILE *stderr;

int main(int argc, char * argv[]){
    //create table
    if(strcmp(argv[1],"CREATE")==0){
        FILE *fp;
        fp = fopen(argv[3] ,"a");
        
        char *pch;
        char** ch = (char**) malloc(256*sizeof(char*));
        for(int i=0;i<256;i++){
            ch[i] = malloc(256*sizeof(char));
        }
        pch=strtok(argv[5],",[]");
        int i=0;
        printf("Table after create\n");
        while (pch != NULL)
        {
            strcpy(ch[i],pch);
            printf("%-7s",ch[i]);
            fprintf(fp, "%s;",ch[i]);
            pch = strtok (NULL,",[]");
            i++;
        }
        printf("\n");
        for(i=0;i<256;i++) {
            free(ch[i]);
        }
        free(ch);
        fclose(fp);
    }
    
    //drop table
    if(strcmp(argv[1],"DROP") == 0){
        int i=0,j=0,k=0,l=0,row=0,column=0;
        char data[256];
        char** ch = (char**) malloc(256*sizeof(char*));
        for(int i=0;i<256;i++){
            ch[i] = malloc(256*sizeof(char));
        }
        char ***tab = malloc(256*sizeof(char**));
        for(int z=0;z<256;z++) {
            tab[z]=malloc(256*sizeof(char*));
            for(int x=0; x<256;x++)
            tab[z][x]=malloc(256);
        }
        
        char *pch;
        char *pch2;
        char *pch3;
        FILE *fp;
        fp = fopen(argv[3] ,"r+");
        if(fp){
            fscanf(fp,"%s",data);
            pch = strtok (data,";");
            while (pch!=NULL)
            {
                strcpy(*tab[k],pch);
                pch = strtok (NULL,";");
                k++;
            }
            row = k;
            while(i<k){
                j=0;
                pch2 = strtok (*tab[i],":");
                while (pch2!=NULL) {
                    strcpy(tab[i][j],pch2);
                    j++;
                    pch2=strtok (NULL,":");
                }
                i++;
            }
            column = j+1;
            
            pch3=strtok(argv[5],"=");
            while (pch3!=NULL) {
                strcpy(ch[l],pch3);
                pch3=strtok (NULL,"=");
                l++;
            }
            fclose(fp);
            
            int x=0,y=0;
            int m = 1;
            printf("Table before drop\n");
            for(int t1=0;t1<row;t1++){
                printf("%-7s",tab[t1][0]);
            }
            printf("\n");
            while(m<column){
                for(int t2=0;t2<row;t2++){
                    printf("%-7s",tab[t2][m]);
                }
                printf("\n");
                m++;
            }
            while(x<row){
                while(y<column){
                    for(int o=0;o<row;o++){
                        strcpy(tab[o][y+1],"");
                    }
                    y++;
                }
                x++;
            }
            fp = fopen(argv[3] ,"w");
            for(int q=0;q<row;q++){
                for(int e=0;e<column;e++){
                    fprintf(fp, "%s:",tab[q][e]);
                }
                fprintf(fp, ";");
            }
            fclose(fp);
            int n = 1;
            printf("Table after drop\n");
            for(int t1=0;t1<row;t1++){
                printf("%-7s",tab[t1][0]);
            }
            printf("\n");
            while(n<column){
                for(int t2=0;t2<row;t2++){
                    printf("%-7s",tab[t2][n]);
                }
                printf("\n");
                n++;
            }
        }
        
        else{
            printf("table not exist");
        }
        
        
        for(int g=0;g<256;g++) {
            for(int h=0;h<256;h++) {
                free(tab[g][h]);
            }
            free(tab[g]);
        }
        free(tab);
        
        for(i=0;i<256;i++) {
            free(ch[i]);
        }
        free(ch);
        
    }
    
    
    //delete operation
    if(strcmp(argv[1],"DELETE") == 0){
        int i=0,j=0,k=0,l=0,row=0,column=0;
        char data[256];
        char** ch = (char**) malloc(256*sizeof(char*));
        for(int i=0;i<256;i++){
            ch[i] = malloc(256*sizeof(char));
        }
        char ***tab = malloc(256*sizeof(char**));
        for(int z=0;z<256;z++) {
            tab[z]=malloc(256*sizeof(char*));
            for(int x=0; x<256;x++)
            tab[z][x]=malloc(256);
        }
        char *pch;
        char *pch2;
        char *pch3;
        FILE *fp;
        fp = fopen(argv[3] ,"r+");
        if(fp){
            fscanf(fp,"%s",data);
            pch = strtok (data,";");
            while (pch!=NULL)
            {
                strcpy(*tab[k],pch);
                pch = strtok (NULL,";");
                k++;
            }
            row = k;
            while(i<k){
                j=0;
                pch2 = strtok (*tab[i],":");
                while (pch2!=NULL) {
                    strcpy(tab[i][j],pch2);
                    j++;
                    pch2=strtok (NULL,":");
                }
                i++;
            }
            column = j+1;
            
            pch3=strtok(argv[5],"=");
            while (pch3!=NULL) {
                strcpy(ch[l],pch3);
                pch3=strtok (NULL,"=");
                l++;
            }
            fclose(fp);
            int x=0,y=0;
            int m=1;
            printf("Table before delete\n");
            for(int t1=0;t1<row;t1++){
                printf("%-7s",tab[t1][0]);
            }
            printf("\n");
            while(m<column){
                for(int t2=0;t2<row;t2++){
                    printf("%-7s",tab[t2][m]);
                }
                printf("\n");
                m++;
            }
            
            while(x<row){
                if(strcmp(tab[x][0],ch[0])==0){
                    while(y<column){
                        if(strcmp(tab[x][y],ch[1])==0){
                            for(int o=0;o<row;o++){
                                strcpy(tab[o][y],"");
                            }
                        }
                        y++;
                    }
                }
                x++;
            }
            
            int n=1;
            printf("Table after delete\n");
            for(int t1=0;t1<row;t1++){
                printf("%-7s",tab[t1][0]);
            }
            printf("\n");
            while(n<column){
                for(int t2=0;t2<row;t2++){
                    printf("%-7s",tab[t2][n]);
                }
                printf("\n");
                n++;
            }
            
            fp = fopen(argv[3] ,"w");
            for(int q=0;q<row;q++){
                for(int e=0;e<column;e++){
                    fprintf(fp, "%s:",tab[q][e]);
                }
                fprintf(fp, ";");
            }
            fclose(fp);
        }
        else{
            printf("table not exist");
        }
        for(int g=0;g<256;g++) {
            for(int h=0;h<256;h++) {
                free(tab[g][h]);
            }
            free(tab[g]);
        }
        free(tab);
        
        for(i=0;i<256;i++) {
            free(ch[i]);
        }
        free(ch);
    }
    
    //update operation
    if(strcmp(argv[1],"UPDATE") == 0){
        int i=0,j=0,k=0,l=0,row=0,column=0;
        char data[256];
        char** ch = (char**) malloc(256*sizeof(char*));
        for(int i=0;i<256;i++){
            ch[i] = malloc(256*sizeof(char));
        }
        char ***tab = malloc(256*sizeof(char**));
        for(int z=0;z<256;z++) {
            tab[z]=malloc(256*sizeof(char*));
            for(int x=0; x<256;x++)
            tab[z][x]=malloc(256);
        }
        char *pch;
        char *pch2;
        char *pch3;
        char *pch4;
        FILE *fp;
        fp = fopen(argv[2] ,"r+");
        if(fp){
            fscanf(fp,"%s",data);
            pch = strtok (data,";");
            while (pch!=NULL)
            {
                strcpy(*tab[k],pch);
                pch = strtok (NULL,";");
                k++;
            }
            row = k;
            
            while(i<k){
                j=0;
                pch2 = strtok (*tab[i],":");
                while (pch2!=NULL) {
                    strcpy(tab[i][j],pch2);
                    j++;
                    pch2=strtok (NULL,":");
                }
                i++;
            }
            column = j+1;
            
            pch3=strtok(argv[4],"=");
            while (pch3!=NULL) {
                strcpy(ch[l],pch3);
                l++;
                pch3=strtok (NULL,"=");
            }
            pch4=strtok(argv[6],"=");
            while (pch4!=NULL) {
                strcpy(ch[l],pch4);
                l++;
                pch4=strtok (NULL,"=");
            }
            fclose(fp);
            int x=0,y=0;
            
            int m = 1;
            printf("Table before update\n");
            for(int t1=0;t1<row;t1++){
                printf("%-7s",tab[t1][0]);
            }
            printf("\n");
            while(m<column){
                for(int t2=0;t2<row;t2++){
                    printf("%-7s",tab[t2][m]);
                }
                printf("\n");
                m++;
            }
            
            while(x<column){
                if(strcmp(tab[0][x],ch[3])==0){
                    while(y<row){
                        if(strcmp(tab[y][0],ch[0])==0){
                            strcpy(tab[y][x],ch[1]);
                        }
                        y++;
                    }
                }
                x++;
            }
            int n=1;
            printf("Table after update\n");
            for(int t1=0;t1<row;t1++){
                printf("%-7s",tab[t1][0]);
            }
            printf("\n");
            while(n<column){
                for(int t2=0;t2<row;t2++){
                    printf("%-7s",tab[t2][n]);
                }
                printf("\n");
                n++;
            }
            
            fp = fopen(argv[2] ,"w");
            for(int q=0;q<row;q++){
                for(int e=0;e<column;e++){
                    fprintf(fp, "%s:",tab[q][e]);
                }
                fprintf(fp, ";");
            }
            fclose(fp);
            
            
        }
        else{
            printf("table not exist");
        }
        for(int g=0;g<256;g++) {
            for(int h=0;h<256;h++) {
                free(tab[g][h]);
            }
            free(tab[g]);
        }
        free(tab);
        
        for(i=0;i<256;i++) {
            free(ch[i]);
        }
        free(ch);
        
    }
    
    //select from operation
    if(strcmp(argv[1],"SELECT") == 0){
        int i=0,j=0,k=0,l=0,row=0,column=0;
        char data[256];
        char** ch = (char**) malloc(256*sizeof(char*));
        for(int i=0;i<256;i++){
            ch[i] = malloc(256*sizeof(char));
        }
        char ***tab = malloc(256*sizeof(char**));
        for(int z=0;z<256;z++) {
            tab[z]=malloc(256*sizeof(char*));
            for(int x=0; x<256;x++)
            tab[z][x]=malloc(256);
        }
        char *pch;
        char *pch2;
        char *pch3;
        FILE *fp;
        fp = fopen(argv[3] ,"r+");
        if(fp){
            fscanf(fp,"%s",data);
            pch = strtok (data,";");
            while (pch!=NULL)
            {
                strcpy(*tab[k],pch);
                pch = strtok (NULL,";");
                k++;
            }
            row = k;
            while(i<k){
                j=0;
                pch2 = strtok (*tab[i],":");
                while (pch2!=NULL) {
                    strcpy(tab[i][j],pch2);
                    j++;
                    pch2=strtok (NULL,":");
                }
                i++;
            }
            column = j+1;
            
            pch3=strtok(argv[5],"=");
            while (pch3!=NULL) {
                strcpy(ch[l],pch3);
                pch3=strtok (NULL,"=");
                l++;
            }
            fclose(fp);
            int x=0,y=0;
            int m=1;
            printf("Table before select\n");
            for(int t1=0;t1<row;t1++){
                printf("%-7s",tab[t1][0]);
            }
            printf("\n");
            while(m<column){
                for(int t2=0;t2<row;t2++){
                    printf("%-7s",tab[t2][m]);
                }
                printf("\n");
                m++;
            }
            
            printf("Table after select\n");
            while(x<row){
                if(strcmp(tab[x][0],ch[0])==0){
                    while(y<column){
                        if(strcmp(tab[x][y],ch[1])==0){
                            for(int o=0;o<row;o++){
                                printf("%-7s",tab[o][y]);
                            }
                             printf("\n");
                        }
                        y++;
                    }
                }
                x++;
            }
        }
        else{
            printf("table not exist");
        }
        for(int g=0;g<256;g++) {
            for(int h=0;h<256;h++) {
                free(tab[g][h]);
            }
            free(tab[g]);
        }
        free(tab);
        
        for(i=0;i<256;i++) {
            free(ch[i]);
        }
        free(ch);
        
    }
    
    //insert into operation
    if(strcmp(argv[1],"INSERT") == 0){
        int i=0,j=0,k=0,l=0,w=0,row=0,column=0;
        char data[256];
        char** tempd = (char**) malloc(256*sizeof(char*));
        for(int i=0;i<256;i++){
            tempd[i] = malloc(256*sizeof(char));
        }
        char** da = (char**) malloc(256*sizeof(char*));
        for(int i=0;i<256;i++){
            da[i] = malloc(256*sizeof(char));
        }
        char** ch = (char**) malloc(256*sizeof(char*));
        for(int i=0;i<256;i++){
            ch[i] = malloc(256*sizeof(char));
        }
        char ***tab = malloc(256*sizeof(char**));
        for(int z=0;z<256;z++) {
            tab[z]=malloc(256*sizeof(char*));
            for(int x=0; x<256;x++)
            tab[z][x]=malloc(256);
        }
        char *pch;
        char *pch2;
        char *pch3;
        char *pch4;
        FILE *fp;
        fp = fopen(argv[3] ,"r+");
        if(fp){
            fscanf(fp,"%s",data);
            pch = strtok (data,";");
            while (pch!=NULL)
            {
                strcpy(*tab[k],pch);
                pch = strtok (NULL,";");
                k++;
            }
            row = k;
            while(i<k){
                j=0;
                pch2 = strtok (*tab[i],":");
                while (pch2!=NULL) {
                    strcpy(tab[i][j],pch2);
                    j++;
                    pch2=strtok (NULL,":");
                }
                i++;
            }
            column = j;
            
            pch3=strtok(argv[4],",()");
            while (pch3!=NULL) {
                strcpy(tempd[l],pch3);
                pch3=strtok (NULL,",()");
                l++;
            }
            int lr=0;
            
            while(w<l){
                pch4=strtok(tempd[w],"=");
                while (pch4!=NULL) {
                    strcpy(ch[lr],pch4);
                    lr++;
                    pch4=strtok (NULL,"=");
                }
                w++;
            }
            printf("\n");
            for(int j=0;j<lr;j++){
                strcpy(da[j],ch[2*j]);
            }
            
            for(int h=0;h<lr;h++){
                strcpy(ch[h],ch[(2*h)+1]);
            }
            
            fclose(fp);
            int m=1;
            printf("Table before insert\n");
            for(int t1=0;t1<row;t1++){
                printf("%-7s",tab[t1][0]);
            }
            printf("\n");
            while(m<column){
                for(int t2=0;t2<row;t2++){
                    printf("%-7s",tab[t2][m]);
                }
                printf("\n");
                m++;
            }
            
            for(int ct=0;ct<lr;ct++){
                for(int x=0;x<row;x++){
                    if(strcmp(tab[x][0],da[ct])==0){
                        strcpy(tab[x][column],ch[ct]);
                    }
                }
            }
            
            column++;
            
            int n=1;
            printf("Table after insert\n");
            for(int t1=0;t1<row;t1++){
                printf("%-7s",tab[t1][0]);
            }
            printf("\n");
            while(n<column){
                for(int t2=0;t2<row;t2++){
                    printf("%-7s",tab[t2][n]);
                }
                printf("\n");
                n++;
            }
            
            fp = fopen(argv[3] ,"w");
            for(int q=0;q<row;q++){
                for(int e=0;e<column+1;e++){
                    fprintf(fp, "%s:",tab[q][e]);
                }
                fprintf(fp, ";");
            }
            fclose(fp);
            
        }
        else{
            printf("table not exist");
        }
        for(int g=0;g<256;g++) {
            for(int h=0;h<256;h++) {
                free(tab[g][h]);
            }
            free(tab[g]);
        }
        free(tab);
        
        for(i=0;i<256;i++) {
            free(ch[i]);
        }
        free(ch);
        for(i=0;i<256;i++) {
            free(tempd[i]);
        }
        free(tempd);
        for(i=0;i<256;i++) {
            free(da[i]);
        }
        free(da);
        
    }
    
    return(0);
}