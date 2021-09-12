//
//  ipc.h
//  G3
//
//  Created by Yiyun Zhang on 8/31/17.
//  Copyright © 2017 Yiyun Zhang. All rights reserved.
//

#ifndef ipc_h
#define ipc_h

#include <stdio.h>
#include <stdlib.h>

//four-in-a-row library
typedef struct row{
    int* pos;
} Row;

typedef struct move{
    int row;
    int col;
} Move;

typedef struct board{
    int end;
    int dimension;
    Row* rows;
} Board;

//initialize board
void initboard(Board** b, int size){
    int i, j;
    *b = (Board*) malloc(sizeof(Board));
    (*b)->dimension = size;
    (*b)->end = 0;
    (*b)->rows = (Row*) malloc(sizeof(Row) * size);
    for(i=0;i<size;i++){
        (*b)->rows[i].pos = (int*) malloc(sizeof(int) * size);
        for(j=0;j<size;j++){
            (*b)->rows[i].pos[j] = 0;
        }
    }
}

int findpos1(Board* b, int i);
void printb(Board* b);

// play for win
Move* playmove(Board* b, int val, int row, int col){
    if((row < 0 || row > b->dimension) || (col < 0 || col > b->dimension)){
        return NULL;
    }
    if(val < 0 || val > 2){
        return NULL;
    }
    int topRow = findpos1(b, col);
    if (topRow == -1){
        return NULL;
    }
    b->rows[topRow].pos[col] = val;
    Move* m = (Move*) malloc(sizeof(Move));
    m->row = topRow;
    m->col = col;
    if(val == 1){
        printf("Parent placed piece in square %d, %d\n",col+1, 8-topRow);
        printb(b);
    }
    if(val == 2){
        printf("Child placed piece in square %d, %d\n", col+1, 8-topRow);
    }
    return m;
}

Move* colpos(Board* b, int val, int col){
    return playmove(b, val, 0, col);
}

//random positiom
Move* randpos(Board* b, int val){
    srand((unsigned int) time(NULL));
    int r = rand() % (b->dimension), rr = rand() % (b->dimension);
    int t = 4;
    int i, j, k;
    for(i=0;i<b->dimension;i++){
        int f = findpos1(b, i);
        if(f != (b->dimension - 1)){
            int tt = 4;
            for(j=f;j<b->dimension;j++){
                if(b->rows[j].pos[i] == val){
                    tt--;
                }
                else{
                    break;
                }
            }
            if(tt < t){
                t = tt;
                r = j;
                rr = i;
            }
            tt = 4;
            for(j=f,k=i;j<b->dimension&&k<b->dimension;j++,k++){
                if(b->rows[j].pos[k] == val){
                    tt--;
                }
                else{
                    break;
                }
            }
            if(tt < t){
                t = tt;
                r = j;
                rr = i;
            }
            tt = 4;
            for(j=f,k=i;j<b->dimension&&k>-1;j++,k--){
                if(b->rows[j].pos[k] == val){
                    tt--;
                }
                else{
                    break;
                }
            }
            if(tt < t){
                t = tt;
                r = j;
                rr = i;
            }
        }
        if(i != 0){
            int m = 4;
            for(j=i-1;j>-1;j--){
                if(b->rows[f].pos[j] == val){
                    m--;
                }
                else{
                    break;
                }
            }
            if(m < t){
                t = m;
                r = f;
                rr = i;
            }
            
        }
        if(i != b->dimension - 1){
            int mm = 4;
            for(j=i+1;j<b->dimension;j++){
                if(b->rows[f].pos[j] == val){
                    mm--;
                }
                else{
                    break;
                }
            }
            if(mm < t){
                t = mm;
                r = f;
                rr = i;
            }
        }
    }
    return playmove(b, val, r, rr);
}

//search functions
int lefttoright(Board* b, int x, int y, int row, int col){
    int result = 0, j;
    
    if(y == 0){
        for(j=col;j>-1;j--){
            if(b->rows[row].pos[j] == x){
                result++;
            }
        }
    }
    
    else if(y == 1){
        for(j=col;j<b->dimension;j++){
            if(b->rows[row].pos[j] == x){
                result++;
            }
        }
    }
    return result;
}

int diag(Board* b, int x, int y, int row, int col){
    int result = 0, j, k;
    if(y == 0){
        for(j=row,k=col;j<b->dimension&&k>-1;j++,k--){
            if(b->rows[j].pos[k] == x){
                result++;
            }
        }
    }
    else if(y == 1){
        for(j=row,k=col;j<b->dimension &&k<b->dimension;j++,k++){
            if(b->rows[j].pos[k] == x){
                result++;
            }
        }
    }
    return result;
}

int toptobot(Board* b, int x, int row, int col){
    int j;
    int result = 0;
    for(j=row;j<b->dimension;j++){
        if(b->rows[j].pos[col] == x){
            result++;
        }
    }
    return result;
}


int findpos1(Board* b, int col){
    int i = 0;
    for(i=b->dimension-1;i>-1;i--){
        if(b->rows[i].pos[col] == 0) {
            break;
        }
    }
    return i;
}

int findpos2(Board* b, int col){
    int i;
    for(i=0;i<b->dimension;i++){
        if(b->rows[i].pos[col] != 0) {
            break;
        }
    }
    i = (i == b->dimension) ? i - 1 : i;
    return i;
}

// using toptobot, diag and lefttoright functions to search if there is a winner
int win(Board* b, int val){
    int result = 0, t, i, win = 0;
    for(i=0;i< b->dimension;i++){
        t = findpos2(b, i);
        if (b->rows[t].pos[i] != 0){
            continue;
        }
        else{
            if(i >= 3){
                result = lefttoright(b, val, 0, t, i);
                if(result == 4) {
                    return 1;
                }
                result = 0;
                
                if(t <= (b->dimension - 1) - 3){
                    result = diag(b, val, 0, t, i);
                    if(result == 4){
                        return 1;
                    }
                    result = 0;
                }
                if(t != b->dimension - 1){
                    result = diag(b, val, 1, t, i);
                    if(result == 4){
                        return 1;
                    }
                    result = 0;
                }
            }
            if(i <= (b->dimension - 1) - 3){
                result = lefttoright(b, val, 1, t, i);
                if(result == 4){
                    return 1;
                }
                result = 0;
                if(t != 0){
                }
                if(t != b->dimension - 1){
                }
            }
            if(t <= (b->dimension - 1)){
                result = toptobot(b, val, t, i);
                if(result == 4){
                    return 1;
                }
                result = 0;
            }
        }
    }
    win = result;
    return win;
}

//print board
void printb(Board* b){
    int i, j;
    for(i=0;i<b->dimension;i++){
        printf("%d ", b->dimension - i);
        for(j=0;j<b->dimension;j++){
            switch (b->rows[i].pos[j]){
                default:
                    break;
                case 0:
                    printf(". ");
                    break;
                case 1:
                    printf("B ");
                    break;
                case 2:
                    printf("R ");
                    break;
            }
        }
        printf("\n");
    }
    printf("  ");
    for(i=0;i<b->dimension;i++){
        printf("%d ", i+1);
    }
    printf("\n\n");
}

#endif /* ipc_h */