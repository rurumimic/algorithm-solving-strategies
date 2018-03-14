#include <iostream>
#include <vector>

using namespace std;

int days;
int teams;
int cost;
vector<int> rentfee;

void makeData();
double compute();

void makeData() {
    days = 0;
    teams = 0;
    cost = 0;

    cin >> days >> teams;

    rentfee.resize(days);

    for(int i = 0; i < days; i++) {
        cin >> cost;
        rentfee[i] = cost;
    }

    return;
}

double compute() {
    int i = 0;
    int begin = 0;
    double count = 0.0;
    double sum = 0.0;
    double baseMean = 987654321.0;
    double tempMean = 0.0;
    double resultMean = 987654321.0;

    for(i = 0; i <= days-teams; i++) {
        sum = 0;
        count = teams;

        for(begin = i; begin < teams; begin++) {
          sum = sum + rentfee[begin];
        }

        baseMean = sum / teams;

        if (baseMean < resultMean) {
            resultMean = baseMean;
        }

        for(; begin < days; begin++) {
            count++;
            sum = sum + rentfee[begin];
            tempMean = sum / count;
            if (tempMean < resultMean) {
                resultMean = tempMean;
            }
        }
    }

    return resultMean;
}

int main(int argc, const char * argv[]) {
    int testcase;

    cin >> testcase;
    vector<double> result(testcase);

    for(int i = 0; i < testcase; i++) {
        makeData();
        result[i] = compute();
    }

    cout << fixed;
    cout.precision(12);

    for(int j = 0; j < testcase; j++) {
        cout << result[j] << endl;
    }

    return 0;
}
