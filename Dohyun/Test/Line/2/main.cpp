//
//  main.cpp
//  2
//
//  Created by Dohyun Kim on 2018. 4. 1..
//  Copyright © 2018년 Rurumimic. All rights reserved.
//

#include <iostream>
#include <vector>
#include <math.h>

using namespace std;

vector<string> ordername;
vector<int> ordercoupon;
vector<int> orderdist;

int distance(int ux, int uy, int x, int y) {
    int a = x - ux;
    int b = y - uy;
    int a2 = a*a;
    int b2 = b*b;
    int dist = sqrt(a2+b2);
    int result = dist/100;
    return result * 100;
}

void names(vector<string> name, int num) {
    int count = 1;
    ordername[0] = name[0];
    for(int i = 0; i < num; i++) {
        for(int j = 0; j < count; j++) {
            if(ordername[j] > name[i]) {
                for(int k = count; k >= j; k--) {
                    ordername[k+1] = ordername[k];
                }
            }
        }
    }
}

void coupons(vector<int> coupon, int num) {
    int count = 1;
    ordercoupon[0] = coupon[0];
    for(int i = 0; i < num; i++) {
        for(int j = 0; j < count; j++) {
            if(ordercoupon[j] > coupon[i]) {
                for(int k = count; k >= j; k--) {
                    ordercoupon[k+1] = ordercoupon[k];
                }
            }
        }
    }
}

int main(int argc, const char * argv[]) {
    
    int ux, uy;
    int num;
    cin >> ux >> uy >> num;
    
    vector<int> x(num);
    vector<int> y(num);
    vector<string> name(num);
    vector<int> count(num);
    
    ordername.resize(num);
    ordercoupon.resize(num);
    orderdist. resize(num);
    
    for(int i = 0; i < num; i++) {
        cin >> x[i];
        cin >> y[i];
        cin >> name[i];
        cin >> count[i];
    }
    
    vector<int> dist(num);
    for(int j = 0; j < num; j++) {
        dist[j] = distance(ux, uy, x[j], y[j]);
    }
    
    int temp = 0;
    vector<int> tempv;
    vector<int> order;
    
    for(int k = 0; k < num; k++) {
        if(temp == dist[k]) {
            tempv.push_back(temp);
        }
        temp = dist[k];
        order.resize(tempv.size());
        for(int l = 0; l < tempv.size(); l++) {
            if([tempv[l]])
        }
    }
    
    return 0;
}
