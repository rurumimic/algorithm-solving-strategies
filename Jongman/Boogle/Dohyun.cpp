//
//  main.cpp
//  boggle
//
//  Created by Dohyun Kim on 2018. 3. 20..
//  Copyright © 2018년 Rurumimic. All rights reserved.
//

#include <iostream>
#include <vector>

void printPicked(std::vector<int>& picked) {
    for(int i = 0; i < picked.size(); i++) {
        std::cout << picked[i] << " ";
    }
    std::cout << std::endl;
    return;
}

void pick(int n, std::vector<int>& picked, int toPick) {
    if(toPick == 0) { printPicked(picked); return; }
    
    int smallest = picked.empty() ? 0 : picked.back() + 1;
    
    for(int next = smallest; next < n; ++next) {
        picked.push_back(next);
        pick(n, picked, toPick - 1);
        picked.pop_back();
    }
}

int main(int argc, const char * argv[]) {
    
    std::vector<int> picked;
    
    pick(7, picked, 4);
    
    return 0;
}

