#include <stdio.h>
#include <vector>
#include <array>
#include <time.h>

#define MAX(x,y)	( (x) > (y) ? (x) : (y) )

using namespace std;

array<array<uint32_t, 2501>, 2501> combi_array;
//vector<vector<uint32_t>> combi_array;

uint32_t mod = 1e9 + 7;

void make_combiarray() {
	for (int n = 0; n < 2501; n++) {
		combi_array[0][n] = combi_array[n][n] = 1;
		for (int k = 1; k < n; k++) {
			if (k == 1 || k + 1 == n) combi_array[k][n] = n;
			else combi_array[k][n] = (combi_array[k - 1][n - 1] + combi_array[k][n - 1]) % mod;
		}
	}
}

uint32_t return_combination(int n, int k) {
	if (n < k)
		return 0;
	return combi_array[k][n];
}

uint32_t calculate_probleam(int R, int C, int K) {
	if (K == 1) {
		if (R * C == 1)
			return 1;
		return 0;
	}
	else if (R == 1 || C == 1) {
		return return_combination(MAX(R, C) - 2, K - 2);
	}
	else {
		uint32_t total_case = return_combination(R * C, K);

		// case 1:
		total_case = (total_case + mod - return_combination((R - 1) * C, K)) % mod;
		total_case = (total_case + mod - return_combination((R - 1) * C, K)) % mod;
		total_case = (total_case + mod - return_combination(R * (C - 1), K)) % mod;
		total_case = (total_case + mod - return_combination(R * (C - 1), K)) % mod;

		// case 2:
		total_case = (total_case + return_combination((R - 1) * (C - 1), K)) % mod;
		total_case = (total_case + return_combination((R - 1) * (C - 1), K)) % mod;
		total_case = (total_case + return_combination((R - 1) * (C - 1), K)) % mod;
		total_case = (total_case + return_combination((R - 1) * (C - 1), K)) % mod;
		total_case = (total_case + return_combination((R - 2) * C, K)) % mod;
		total_case = (total_case + return_combination(R * (C - 2), K)) % mod;

		// case 3:
		total_case = (total_case + mod - return_combination((R - 2) * (C - 1), K)) % mod;
		total_case = (total_case + mod - return_combination((R - 2) * (C - 1), K)) % mod;
		total_case = (total_case + mod - return_combination((R - 1) * (C - 2), K)) % mod;
		total_case = (total_case + mod - return_combination((R - 1) * (C - 2), K)) % mod;

		// case 4:
		total_case = (total_case + return_combination((R - 2) * (C - 2), K)) % mod;

		return total_case;
		//uint32_t not_one_line_case = ((2 * return_combination((R - 1) * C, K)) % mod + (2 * return_combination(R*(C - 1), K)) % mod) % mod;
		//uint32_t not_two_line_case = 4 * return_combination((R - 1)*(C - 1), K) + return_combination((R - 2)*C, K) + return_combination(R*(C - 2), K);
		//uint32_t not_three_line_case = 2 * (return_combination((R - 2) * (C - 1), K) + return_combination((R - 1)*(C - 2), K));
		//uint32_t not_four_line_case = return_combination((R - 2) * (C - 2), K);

		//return total_case - not_one_line_case + not_two_line_case - not_three_line_case + not_four_line_case;
	}
}

int main(void) {
	clock_t begin, end;
	int testcase, row, col, K;

	begin = clock();

	make_combiarray();

	end = clock();

	//cout << (end - begin) << endl;
	scanf("%d", &testcase);

	for (int i = 0; i < testcase; i++) {
		scanf("%d %d %d", &row, &col, &K);

		//cout << "#" << i + 1 << " " << calculate_probleam(row, col, K) << endl;
		printf("#%d %d\n", i + 1, calculate_probleam(row, col, K));
	}

	return 0;
}