//
//  main.cpp
//  Dohyun
//
//  Created by Dohyun Kim on 2018. 3. 11..
//  Copyright © 2018년 Rurumimic. All rights reserved.
//

#include <iostream>
#include <vector>

using namespace std;

double inputData();
double compute(int days, int teams, vector<int> rentfee);

double inputData() {
    int days = 0;
    int teams = 0;
    int cost = 0;
    
    cin >> days >> teams;
    
    vector<int> rentfee(days);
    
    for(int i=0; i<days; i++) {
        cin >> cost;
        rentfee[i] = cost;
    }
    
    return compute(days, teams, rentfee);
}

double compute(int days, int teams, vector<int> rentfee) {
    
    int i, j, k, t = 0;
    double count = 0.0;
    double sum = 0.0;
    double m = 987654321.0;
    double temp = 0.0;
    double result = 987654321.0;
    
    for(i = 0; i < days-teams+1; i++) {
        sum = 0;
        for(j = 0; j < teams; j++) {
            t = j + i;
            sum = sum + rentfee[t];
        }
        
        m = sum / teams;
        if (m < result) {
            result = m;
        }
        count = teams;
        
        for(k = t+1; k < days; k++) {
            count++;
            sum = sum + rentfee[k];
            temp = sum / count;
            if (temp < result) {
                result = temp;
            }
        }
    }
    
    return result;
}

int main(int argc, const char * argv[]) {
    int testcase;
    
    cin >> testcase;
    vector<double> result(testcase);
    
    for(int i = 0; i < testcase; i++) {
        result[i] = inputData();
    }
    
    cout << fixed;
    cout.precision(12);
    
    for(int j = 0; j < testcase; j++) {
        cout << result[j] << endl;
    }
    
    return 0;
}
