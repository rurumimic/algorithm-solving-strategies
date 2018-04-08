//
//  main.cpp
//  3
//
//  Created by Dohyun Kim on 2018. 4. 1..
//  Copyright © 2018년 Rurumimic. All rights reserved.
//

#include <iostream>
#include <vector>
using namespace std;

void visit() {
    
}

int main(int argc, const char * argv[]) {
    
    int N;
    cin >> N;
    
    vector<int> person(N);
    vector<vector<int> > friends(N, vector<int>());
    
    int p = 0;
    
    for(int i = 0; i < N; i++) {
        cin >> person[i];
        cin >> p;
        friends[i].push_back(p);
    }
    
    for(int j = 0; j < N; j++) {
        for(int k = 0; k < friends[j].size(); k++) {
            cout << friends[j][k] << " ";
        }
        cout << endl;
    }
    
    return 0;
}
