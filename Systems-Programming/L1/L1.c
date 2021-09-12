//
//  main.c
//  L1
//
//  Created by Yiyun Zhang on 6/26/17.
//  Copyright © 2017 Yiyun Zhang. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

struct ListNode{
    int data;
    struct ListNode* next;
};

//add function for question 5
void array_add(int* array, int size){
    int i;
    int* res = (int*) malloc(size*sizeof(int));
    
    for(i=0;i<100000;i++){
        if(i>size){
            //reallocate space to contain one more element
            res = realloc(res, i*sizeof(int));
        }
    }
    for(i=0;i<100000;i++){
        res[i] = i;
    }
}

//remove function for question 5
void array_remove(int* array, int i, int size){
    int j;
    //remove the target int pointer
    for(j=0;j<i;j++){
        array[j] = array[j+1];
    }
    for(j=i;j<size;j++){
        array[j] = array[j+1];
    }
    //resize the array
    array = (int*) realloc(array, size-1);
}

//get function for question 5
int array_get(int* array, int i){
    return array[i];
}

//helper funtction of sort function for question 4
void swap_list(struct ListNode* a, struct ListNode* b){
    int tmp = a->data;
    a->data = b->data;
    b->data = tmp;
}

//sort function for question 4
void list_sort(struct ListNode* l){
    int i;
    struct ListNode* new;
    struct ListNode* lst = NULL;
    do{
        i = 0;
        new = l;
        while(new->next!=lst){
            if(new->data>new->next->data){
                swap_list(new,new->next);
                i = 1;
            }
            new = new->next;
        }
        lst = new;
    }
    while(i);
}

//print function for question 4
void print_list(struct ListNode* l){
    struct ListNode* lst = l;
    while(lst!=NULL){
        printf("%i->", lst->data);
        lst = lst->next;
    }
    printf("NULL");
}

//sort funtion for question 3
void sort(int* a, int size){
    int i = 0, j=0, r[size], tmp;
    
    //use pointer arithmetic to store the pointers
    for(i=0;i<size;i++){
        r[i] = *a;
        a++;
    }
    //bubble sort
    for(i=size-1;i>=0;i--){
        for(j=1;j<=i;j++){
            if(r[j-1]>r[j]){
                tmp = r[j-1];
                r[j-1] = r[j];
                r[j] = tmp;
            }
        }
    }
    
    printf("\nAfter sort:");
   for(i=0;i<size;i++){
        printf("%i ", r[i]);
    }
}

int main(int argc, const char * argv[]) {
    //---------------Question 1------------------//
    printf("Question 1:\n");
    
    int* a = (int*) malloc(10*sizeof(int));
    int i;
    
    for(i=0;i<10;i++){
        *(a+i) = i;
        printf("Array[%i]: %i\n", i+1, *(a+i));
    }
    
    free(a);
    
    printf("\n");
    //---------------Question 2------------------//
    printf("Question 2:\n");
    
    char** ch = (char**) malloc(10*sizeof(char*));
    
    for(i=0;i<10;i++){
        ch[i] = malloc(15*sizeof(char));
        char r = 'A'+i;
        *ch[i] = r;
        printf("Char[%i]: %c\n", i+1, *ch[i]);
    }
    
    for(i=0;i<10;i++) {
        free(ch[i]);
    }
    free(ch);
    
    printf("\n");
    //---------------Question 3------------------//
    printf("Question 3:\nBefore sort:");
    
    int* z = (int*) malloc(5*sizeof(int));
    z[0] = 3;
    z[1] = 1;
    z[2] = 4;
    z[3] = 0;
    z[4] = 2;
    for(i=0;i<5;i++){
        printf("%i ", z[i]);
    }
    sort(z, 5);
    free(z);
    
    printf("\n");
    //---------------Question 4------------------//
    printf("\nQuestion 4:\n");
    
    struct ListNode* node1 = (struct ListNode*) malloc(sizeof(struct ListNode));
    struct ListNode* node2 = (struct ListNode*) malloc(sizeof(struct ListNode));
    struct ListNode* node3 = (struct ListNode*) malloc(sizeof(struct ListNode));
    struct ListNode* node4 = (struct ListNode*) malloc(sizeof(struct ListNode));
    struct ListNode* node5 = (struct ListNode*) malloc(sizeof(struct ListNode));
    node1->data = 3;
    node1->next = node2;
    node2->data = 1;
    node2->next = node3;
    node3->data = 4;
    node3->next = node4;
    node4->data = 0;
    node4->next = node5;
    node5->data = 2;
    node5->next = NULL;
    
    printf("Nodes before sort:");
    print_list(node1);
    list_sort(node1);
    printf("\nNodes after sort:");
    print_list(node1);
    
    free(node1);
    free(node2);
    free(node3);
    free(node4);
    free(node5);
    
    printf("\n");
    //---------------Question 5------------------//
    printf("\nQuestion 5:\n");
    
    clock_t start, end;
    double time_used;
    int* array1 = (int*) malloc(100*sizeof(int));
    int* array2 = (int*) malloc(200*sizeof(int));
    
    //timing initial 100000 adding
    start = clock();
    array_add(array1,100);
    end = clock();
    time_used = ((double) (end - start)) / CLOCKS_PER_SEC;
    printf("Time used for initial size:%fs", time_used);
    free(array1);
    
    //timing increased by factor of 2's 100000 adding
    start = clock();
    array_add(array2,200);
    end = clock();
    time_used = ((double) (end - start)) / CLOCKS_PER_SEC;
    printf("\nTime used for increased size(factor of 2):%fs", time_used);
    free(array2);
    
    printf("\n");
    return(0);

}
