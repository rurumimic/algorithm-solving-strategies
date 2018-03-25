//
//  main.cpp
//  10974
//
//  Created by Dohyun Kim on 2018. 3. 21..
//  Copyright © 2018년 Rurumimic. All rights reserved.
//

#include <iostream>
#include <vector>

// 그냥 정리된 배열 출력
void printLoop(int sorted[], int size) {
    for(int i = 0; i < size; i++) {
        std::cout << sorted[i] << " ";
    }
    std::cout << std::endl;
    return;
}

// 그냥 정리된 배열 출력
void printLoop(std::vector<int> sorted) {
    for(int i = 0; i < sorted.size(); i++) {
        std::cout << sorted[i] << " ";
    }
    std::cout << std::endl;
    return;
}


// 재귀 함수
void loop(std::vector<int> sorted, std::vector<int> notsorted) {
    // 정렬할 것이 없으면 출력
    if (notsorted.size() == 0) { printLoop(sorted); return; }

    // 임시로 사용할 배열 공간 만들어주고
    std::vector<int> tempNotSorted;

    // 정렬할 것들이 남은만큼 루프를 돌린다
    for(int i = 0; i < notsorted.size(); i++) {
//        순차적으로 하나씩 옮겨주고
        sorted.push_back(notsorted[i]);
//        임시 배열을 만들어서 (백터니까 복사해야함)
        tempNotSorted.resize((int)(notsorted.size())); // 크기 설정
        std::copy(notsorted.begin(), notsorted.end(), tempNotSorted.begin()); // 복사
        tempNotSorted.erase(tempNotSorted.begin()+i); // 원소 삭제
//        루프에 돌려버린다
        loop(sorted, tempNotSorted);
//        루프에서 돌고 나오면 정리된 것에서 맨 뒤에 것을 하나 빼준다
        sorted.pop_back();
    }
}

// 재귀 함수
void loop(int sorted[], int sortedSize, int notsorted[], int notSortedSize) {
    // 정렬할 것이 없으면 출력
    if (notSortedSize == 0) { printLoop(sorted, sortedSize); return; }
    
    // 임시로 사용할 배열 공간 만들어주고
    int tempNotSorted[9] = {0, };
    
    // 정렬할 것들이 남은만큼 루프를 돌린다
    for(int i = 0; i < notSortedSize; i++) {
        // 순차적으로 하나씩 옮겨주고
        sorted[sortedSize] = notsorted[i];
        // 임시 배열을 복사하고
        for(int k = 0; k < notSortedSize; k++) {
            tempNotSorted[k] = notsorted[k];
        }
        // 자리를 옮겨준다
        for(int j = i; j < notSortedSize; j++) {
            tempNotSorted[j] = tempNotSorted[j+1];
        }
        // 루프에 돌려버린다
        loop(sorted, sortedSize+1, tempNotSorted, notSortedSize-1);
        // 루프에서 돌고 나오면 정리된 것에서 맨 뒤에 것을 하나 빼준다
        sorted[sortedSize] = 0;
    }
}

int main(int argc, const char * argv[]) {
    
    int n = 0;
    std::cin >> n;
    
    // 배열
    int sorted[9] = {0, };
    int notsorted[9] = {0, };
    
    // 벡터
//    std::vector<int> sorted, notsorted;
    
    // 정렬되지 않은 배열 만들기
    for(int i = 0; i < n; i++) {
        // 배열
        notsorted[i] = i+1;
        // 벡터
//        notsorted.push_back(i);
    }
    
    // 배열 루프
    loop(sorted, 0, notsorted, n);
    
    // 벡터 루프
//    loop(sorted, notsorted);
    
    return 0;
}
