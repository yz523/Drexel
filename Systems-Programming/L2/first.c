//
//  first.c
//  L2
//
//  Created by Yiyun Zhang on 8/18/17.
//  Copyright © 2017 Yiyun Zhang. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <time.h>

typedef struct {
    pthread_mutex_t mutex;
    unsigned long* counter;
} pthread;

void* threaded(void* v) {
    pthread* p = (pthread*) v;
    unsigned long* c = p->counter;
    int i;
    //increment counter 1000 times
    for(i=0;i<1000;i++) {
        (*c)++;
    }
    pthread_exit(0);
}

int main (int argc, char const *argv[])
{
    double average_time=0;
    int run_c=0;
    for(int i =0;i<10;i++){
        run_c++;
        printf("\nRun %i:\n", run_c);
        clock_t t;
        t = clock();
        
        unsigned long c = 0;
        pthread_t threads[100];
        pthread* p = (pthread*) malloc(sizeof(pthread));
        pthread_mutex_init(&(p->mutex), NULL);
        p->counter = &c;
        //create 100 pthreads
        for(int i=0; i < 100; i++) {
            pthread_create(&threads[i], NULL, threaded, p);
        }
        //invoke via 100 pthreads
        for(int i = 0; i < 100; i++) {
            pthread_join(threads[i], NULL);
        }
        printf("counter:%ld\n", c);
        pthread_mutex_destroy(&(p->mutex));
        free(p);
        
        t = clock() - t;
        double time_taken = ((double)t)/CLOCKS_PER_SEC;
        average_time+= time_taken;
        printf("Time took: %fs\n", time_taken);
    }
    printf("Average time run is %fs\n", average_time/10);
    return 0;
}

