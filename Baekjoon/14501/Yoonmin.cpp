#include <stdio.h>
#include <iostream>
#include <algorithm>

#define MAX(x,y) ((x) > (y) ? (x) : (y))

using namespace std;

int main(void) {
	uint16_t N;
	uint16_t work_list[15][2], best_pay[15], max = 0;

	scanf("%hd", &N);

	for (uint16_t i = 0; i < N; i++) {
		scanf("%hd %hd", &work_list[i][0], &work_list[i][1]);
		best_pay[i] = work_list[i][1];
	}

	for (uint16_t i = 1; i < N; i++) {
		for (uint16_t j = 0; j < i; j++) {
			if (i - j >= work_list[j][0])
				best_pay[i] = MAX(best_pay[j] + work_list[i][1], best_pay[i]);
		}
	}

	for (uint16_t i = 0; i < N; i++) {
		if ((i + work_list[i][0] <= N) && (max < best_pay[i]))
			max = best_pay[i];
	}

	printf("%hd\n", max);

	return 0;
}