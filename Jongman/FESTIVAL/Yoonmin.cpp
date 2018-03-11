#include <iostream>
#include <vector>

using namespace std;

int testcase, N, L;
vector<int> input;

void festival();

int main(void) {
	cin >> testcase;

	for (int i = 0; i < testcase; i++) {
		cin >> N >> L;

		input.resize(N);
		for (int j = 0; j < N; j++)
			cin >> input[j];

		festival();
	}

	return 0;
}

void festival() {
	int sum;
	double avg;
	double MIN = 100;

	for (int start = 0; start <= N - L; start++) {
		sum = 0;
		int i, size = L;

		for (i = start; i < start + L; i++)
			sum += input[i];

		avg = (double)sum / size;

		if (avg < MIN) MIN = avg;

		for (; i < N; i++) {
			sum += input[i];
			size++;
			avg = (double)sum / size;
			if (avg < MIN) MIN = avg;
		}
	}
	cout << fixed;
	cout.precision(12);
	cout << MIN << endl;
}