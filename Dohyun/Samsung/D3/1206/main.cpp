//
//  main.cpp
//  1206
//
//  Created by Dohyun Kim on 2018. 3. 19..
//  Copyright © 2018년 Rurumimic. All rights reserved.
//

#include <iostream>
#include <algorithm>
#include <vector>

int compute(int scale) {
    int i = 0;
    std::vector<int> building(scale);
    std::vector<int> temp(4);
    int diff = 0;
    int sum = 0;
    
    for(i = 0; i < scale; i++) {
        std::cin >> building[i];
    }
    
    for(i = 2; i < scale - 2; i++) {
        temp[0] = building[i-2];
        temp[1] = building[i-1];
        temp[2] = building[i+1];
        temp[3] = building[i+2];
        
        std::sort(temp.begin(), temp.end());
        
        diff = building[i] - temp[3];
        
        if(diff > 0) {
            sum += diff;
        }
    }
    
    return sum;
}

int main(int argc, const char * argv[]) {
    
    int testcase = 10;
    int scale = 0;
    std::vector<int> result(testcase);
    
    int i = 0;
    
    for(i = 0; i < testcase; i++) {
        std::cin >> scale;
        result[i] = compute(scale);
    }
    
    for(i = 0; i < testcase; i++) {
        std::cout << "#" << i+1 << " " << result[i] << std::endl;
    }
    
    return 0;
}

