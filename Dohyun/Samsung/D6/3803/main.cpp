//
//  main.cpp
//  3803
//
//  Created by Dohyun Kim on 2018. 3. 20..
//  Copyright © 2018년 Rurumimic. All rights reserved.
//

#include <iostream>

unsigned long long factorial(unsigned long long n) {
    if(n == 1) { return 1; }
    return n * factorial(n-1) % 1000000007;
}

unsigned long long onerow(int r, int c, int k) {
    unsigned long long result = 0;
    int temp = 0;
    
    if (c == 1) {
        temp = r;
        r = c;
        c = temp;
    }
    
    result = factorial(c-2) / factorial(k-2) / factorial(c-k);
    return result;
}

unsigned long long box(int r, int c, int k) {
    unsigned long long total = r * c;
    unsigned long long a = 0;
    unsigned long long b = 0;
    
    
    unsigned long long x = 0, y = 0, z = 0;
    x = total - 2;
    x = factorial(x);
    y = k - 2;
    y = factorial(y);
    z = total-k;
    z = factorial(z);
    
    a = x / y / z;
    
    if (r == 2) {
        b = 1;
    } else {
        x = factorial(total);
        y = factorial(k-2);
        z = factorial(total-k+2);
        
        b = x / y / z;
    }
    
    return a*2 + b*2;
}

unsigned long long compute(int r, int c, int k) {
    unsigned long long result = 0;
    if(r == 1 || c == 1) {
        result = onerow(r, c, k);
    } else {
        result = box(r, c, k);
    }
    return result;
}

int main(int argc, const char * argv[]) {
    int testcase = 0;
    int r, c, k = 0;
    unsigned long long result = 0;
    std::cin >> testcase;
    for(int i = 0; i < testcase; i++) {
        std::cin >> r >> c >> k;
        result = compute(r, c, k);
        std::cout << "#" << i+1 << " " << result << std::endl;
    }
    
    return 0;
}

