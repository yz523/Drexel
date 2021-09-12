//
//  ipc.c
//  G3
//
//  Created by Yiyun Zhang on 8/31/17.
//  Copyright © 2017 Yiyun Zhang. All rights reserved.
//

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <sys/types.h>
#include <semaphore.h>
#include <signal.h>
#include <unistd.h>
#include <time.h>
#include "ipc.h"

int main(int argc, char* argv[]){
    int games = atoi(argv[1]);
    int dimension = atoi(argv[2]);
    int play = 0;
    int fd[games][2][2];
    pid_t pid[games];
    int child_status;
    Board** board = (Board**) malloc(sizeof(Board*) * games);
    Move* move = NULL;
    char c[256];
    int i,j;
    long n;
    for(i = 0; i < games; i++){
        initboard(&(board[i]), dimension);
        pipe(fd[i][0]);
        pipe(fd[i][1]);
        pid[i] = fork();
        if(pid[i] == 0){
            srand(getpid());
            for (j = 0; j <=i; j++){
                close(fd[j][0][1]);
                close(fd[j][1][0]);
            }
            while(!board[i]->end){
                n = read(fd[i][0][0], &c, sizeof(Move));
                if(n <= 0){
                    break;
                }
                move = (Move*) c;
                move = playmove(board[i], 1, move->row, move->col);
                if(!(board[i]->end = win(board[i], 1))){
                    if(play){
                        move = randpos(board[i], 2);
                    }
                    else{
                        wait(&child_status);
                        move = colpos(board[i], 2, rand() % board[i]->dimension);
                    }
                    board[i]->end = win(board[i], 2);
                    write(fd[i][1][1], move, sizeof(Move));
                    if (board[i]->end){
                        close(fd[i][0][0]);
                        close(fd[i][1][1]);
                        break;
                    }
                }
                else{
                    write(fd[i][1][1], move, sizeof(Move));
                    close(fd[i][0][0]);
                    close(fd[i][1][1]);
                    break;
                }
            }
            free(board[i]);
            exit(0);
        }
    }
    
    int counter = 0;
    Move* mm;
    for (i = 0; i < games; i++){
        close(fd[i][0][0]);
        close(fd[i][1][1]);
        move = randpos(board[i], 1);
        write(fd[i][0][1], move, sizeof(Move));
    }
    while (counter != games){
        for (i = 0; i < games; i++){
            if(!board[i]->end){
                n = read(fd[i][1][0], &c, sizeof(Move));
                if(n == 0){
                    counter++;
                    break;
                }
                mm = (Move*) c;
                if(mm->row == move->row && mm->col == move->col){
                    kill(pid[i], SIGKILL);
                }
                playmove(board[i], 2, move->row, move->col);
                board[i]->end = win(board[i], 2);
                if (!board[i]->end){
                    move = randpos(board[i], 1);
                    board[i]->end = win(board[i], 1);
                    write(fd[i][0][1], move, sizeof(Move));
                    if(board[i]->end){
                        close(fd[i][1][0]);
                        close(fd[i][0][1]);
                        counter++;
                        printf("GAME %d finished: parent win\n",counter);
                    }
                }
                else{
                    write(fd[i][0][1], move, sizeof(Move));
                    close(fd[i][0][1]);
                    close(fd[i][1][0]);
                    counter++;
                    printf("GAME %d finished: parent win\n",counter);
                }
            }
        }
    }
    return 0;
}
