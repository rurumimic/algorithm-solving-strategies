//
//  main.cpp
//  12100
//
//  Created by Dohyun Kim on 2018. 3. 25..
//  Copyright © 2018년 Rurumimic. All rights reserved.
//

#include <iostream>

int methods[1024][5] = {0, };
int methodCount = 0;

void look(int tile[][22], int size) {
    for(int i = 1; i <= size; i++) {
        for(int j = 1; j <= size; j++) {
            printf("%d ", tile[i][j]);
        }
        printf("\n");
    }
    printf("\n\n");
}

void right(int tile[][22], int size) {
    
    int i, j, k;
    int index;
    
    for(i = 1; i <= size; i++) {
        index = size;
        for(j = 1; j <= size; j++) {
            if(tile[i][index] == 0) {
                for(k = index; k >= 1; k--) {
                    tile[i][k] = tile[i][k-1];
                }
            } else {
                index--;
            }
        }
    }
    
    for(i = size; i >= 1; i--) {
        for(j = size; j >= 1; j--) {
            if(tile[i][j] == tile[i][j-1]) {
                tile[i][j] = tile[i][j] + tile[i][j-1];
                for(k = j-1; k >= 1; k--) {
                    tile[i][k] = tile[i][k-1];
                }
            }
        }
    }
    
    return;
}

void down(int tile[][22], int size) {
    
    int i, j, k;
    int index;
    
    for(i = 1; i <= size; i++) {
        index = size;
        for(j = 1; j <= size; j++) {
            if(tile[index][i] == 0) {
                for(k = index; k >= 1; k--) {
                    tile[k][i] = tile[k-1][i];
                }
            } else {
                index--;
            }
        }
    }
    
    for(i = size; i >= 1; i--) {
        for(j = size; j >= 1; j--) {
            if(tile[j][i] == tile[j-1][i]) {
                tile[j][i] = tile[j][i] + tile[j-1][i];
                for(k = j-1; k >= 1; k--) {
                    tile[k][i] = tile[k-1][i];
                }
            }
        }
    }
    
    return;
}

void left(int tile[][22], int size) {
    
    int i, j, k;
    int index;
    
    for(i = 1; i <= size; i++) {
        index = 1;
        for(j = 1; j <= size; j++) {
            if(tile[i][index] == 0) {
                for(k = index; k <= size; k++) {
                    tile[i][k] = tile[i][k+1];
                }
            } else {
                index++;
            }
        }
    }
    
    for(i = 1; i <= size; i++) {
        for(j = 1; j <= size; j++) {
            if(tile[i][j] == tile[i][j+1]) {
                tile[i][j] = tile[i][j] + tile[i][j+1];
                for(k = j+1; k <= size; k++) {
                    tile[i][k] = tile[i][k+1];
                }
            }
        }
    }
    
    return;
}

void up(int tile[][22], int size) {
    
    int i, j, k;
    int index;
    
    for(i = 1; i <= size; i++) {
        index = 1;
        for(j = 1; j <= size; j++) {
            if(tile[index][i] == 0) {
                for(k = index; k <= size; k++) {
                    tile[k][i] = tile[k+1][i];
                }
            } else {
                index++;
            }
        }
    }
    
    for(i = 1; i <= size; i++) {
        for(j = 1; j <= size; j++) {
            if(tile[j][i] == tile[j+1][i]) {
                tile[j][i] = tile[j][i] + tile[j+1][i];
                for(k = j+1; k <= size; k++) {
                    tile[k][i] = tile[k+1][i];
                }
            }
        }
    }
    
    return;
}

int getMaxBlock(int tile[][22], int size) {
    int result = 0;
    for(int i = 1; i <= size; i++) {
        for(int j = 1; j <= size; j++) {
            if(tile[i][j] > result) {
                result = tile[i][j];
            }
        }
    }
    return result;
}

void addMethod(int picked[], int size) {
    for(int i = 0; i < size; i++) {
        methods[methodCount][i] = picked[i];
    }
    methodCount++;
    return;
}

void loop(int sorted[], int sortedSize) {
    if (sortedSize == 5) { addMethod(sorted, sortedSize); return; }
    int tempNotSorted[5] = {0, };
    for(int i = 0; i < 4; i++) {
        for(int j = 0; j < 5; j++) {
            tempNotSorted[j] = sorted[j];
        }
        tempNotSorted[sortedSize] = i;
        loop(tempNotSorted, sortedSize+1);
    }
}

int move(int tile[][22], int size) {
    int temp[22][22] = {0, };
    int i, j;
    
    int result = 0;
    int max = 0;
    
    for(int m = 0; m < methodCount; m++) {
        for(i = 1; i <= size; i++) {
            for(j = 1; j <= size; j++) {
                temp[i][j] = tile[i][j];
            }
        }
        for(int n = 0; n < 5; n++) {
            int action = methods[m][n];
            if(action == 0) {
                up(temp, size);
            } else if(action == 1) {
                down(temp, size);
            } else if(action == 2) {
                left(temp, size);
            } else if(action == 3) {
                right(temp, size);
            }
        }
        max = getMaxBlock(temp, size);
        if(max > result) {
            result = max;
        }
    }
    return result;
}

int main(int argc, const char * argv[]) {
    int n;
    std::cin >> n;
    
    int tile[22][22] = {0, };
    
    for(int i = 1; i <= n; i++) {
        for(int j = 1; j <= n; j++) {
            scanf("%d", &tile[i][j]);
        }
    }
    
    int sorted[5] = {0, };
    loop(sorted, 0);
    
    printf("%d\n", move(tile, n));
    
    return 0;
}

