#include <iostream>
#include <vector>
#include <array>
#include <time.h>

#define MAX(x,y)	( (x) > (y) ? (x) : (y) )

using namespace std;

//array<array<unsigned long long int, 2501>, 2501> combi_array;
vector<vector<unsigned long long int>> combi_array;

void make_combiarray() {
	for (int n = 0; n < 2501; n++) {
		for (int k = 0; k <= n; k++) {
			if (k == 0 || n == k) { combi_array[k][n] = 1; continue; }
			else if (k == 1 || k + 1 == n) { combi_array[k][n] = n; continue; }
			else { combi_array[k][n] = combi_array[k - 1][n - 1] + combi_array[k][n - 1]; }
		}
	}
}

unsigned long long int return_combination(int n, int k) {
	if (n < k)
		return 0;
	return combi_array[k][n];
}

unsigned long long int calculate_probleam(int R, int C, int K) {
	if (K == 1) {
		if (R * C == 1)
			return 1;
		return 0;
	}
	else if (R == 1 || C == 1) {
		return return_combination(MAX(R, C) - 2, K - 2);
	}
	else {
		unsigned long long int total_case = return_combination(R * C, K);
		unsigned long long int not_one_line_case = 2 * return_combination((R - 1) * C, K) + 2 * return_combination(R*(C - 1), K);
		unsigned long long int not_two_line_case = 4 * return_combination((R - 1)*(C - 1), K) + return_combination((R - 2)*C, K) + return_combination(R*(C - 2), K);
		unsigned long long int not_three_line_case = 2 * (return_combination((R - 2) * (C - 1), K) + return_combination((R - 1)*(C - 2), K));
		unsigned long long int not_four_line_case = return_combination((R - 2) * (C - 2), K);

		return total_case - not_one_line_case + not_two_line_case - not_three_line_case + not_four_line_case;
	}
}

int main(void) {
	clock_t begin, end;
	int testcase, row, col, K;

	begin = clock();
	combi_array.resize(2501);
	for (int i = 0; i < 2501; i++)
		combi_array[i].resize(2501);
	make_combiarray();

	end = clock();
	cout << (end - begin) << endl;

	/*for (int n = 2500; n < 2501; n++) {
		for (int k = 0; k <= n; k++) {
			cout << combi_array[n][k] << " ";
		}
		cout << endl;
	}*/
/*
	begin = clock();*/

	cin >> testcase;

	for (int i = 0; i < testcase; i++) {
		cin >> row >> col >> K;

		cout << "#" << i + 1 << " " << calculate_probleam(row, col, K) << endl;
	}/*
	end = clock();
	cout << (end - begin) << endl;*/
	//print_combination();

	return 0;
}