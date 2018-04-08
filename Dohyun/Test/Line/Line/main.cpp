//
//  main.cpp
//  Line
//
//  Created by Dohyun Kim on 2018. 4. 1..
//  Copyright © 2018년 Rurumimic. All rights reserved.
//

#include <iostream>
#include <vector>

using namespace std;

// 41분

void countwords(string word) {
    vector<char> alphabet(200);
    vector<int> count(200);
    char temp = word[0];
    int num = 0;
    int index = 0;
    for(int i = 0; i < word.length(); i++) {
        if(word[i] == temp) {
            count[index] = ++num;
            alphabet[index] = word[i];
        } else {
            temp = word[i];
            index++;
            num = 1;
            count[index] = num;
            alphabet[index] = word[i];
        }
    }
    
    for(int j = 0; j < 26; j++) {
        if(count[j] == 0) {
            break;
        }
        cout << count[j] << alphabet[j];
    }

    cout << endl;
}

int main(int argc, const char * argv[]) {
    
    int T; // count of lines
    int i = 0;
    cin >> T;
    vector<string> words(T);
    
    for(i = 0; i < T; i++) {
        cin >> words[i];
    }
    
    for(i = 0; i < T; i++) {
        countwords(words[i]);
    }
    
    cout << endl;
    
    return 0;
}
