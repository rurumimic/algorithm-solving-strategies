#include <stdio.h>
#include <iostream>
#include <algorithm>

using namespace std;

uint64_t mod = 1e9 + 7;

uint64_t inverse(uint64_t K) {
	uint64_t inverse = 1;
	uint64_t modminus = mod - 2;
	while (modminus > 0) {
		if (modminus % 2 != 0) {
			inverse *= K;
			inverse %= mod;
		}
		K *= K;
		K %= mod;
		modminus /= 2;
	}
 	return inverse;
}

int main(void) {
	uint64_t N, K, _up, _down;
	uint64_t down_inverse, ans;

	scanf("%llu %llu", &N, &K);

	_up = _down = 1;

	for (uint64_t i = 1; i <= N; i++) {
		_up *= i;
		_up %= mod;
	}

	for (uint64_t i = 1; i <= K; i++) {
		_down *= i;
		_down %= mod;
	}

	for (uint64_t i = 1; i <= (N - K); i++) {
		_down *= i;
		_down %= mod;
	}
	down_inverse = inverse(_down);
	ans = (_up * down_inverse) % mod;

	printf("%llu\n", ans);

	return 0;
}