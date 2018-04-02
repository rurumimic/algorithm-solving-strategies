#include <stdio.h>
#include <iostream>
#include <algorithm>

using namespace std;

uint32_t mod = 1003001;

uint64_t inverse(uint64_t K) {
	uint64_t inverse = 1;
	uint32_t modminus = mod - 2;
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
	uint64_t N, K, M;
	uint64_t down_inverse1, down_inverse2, ans, _up, _down1, _down2;

	scanf("%llu %llu %llu", &N, &K, &M);

	_up = _down1 = _down2 = 1;

	for (uint32_t i = 1; i <= N; i++) {
		_up *= i;
		_up %= mod;
	}

	for (uint32_t i = 1; i <= M; i++) {
		_down1 *= i;
		_down1 %= mod;
	}

	for (uint32_t i = 1; i <= (N - M); i++) {
		_down1 *= i;
		_down1 %= mod;
	}

	for (uint32_t i = 1; i <= K - M; i++) {
		_down2 *= i;
		_down2 %= mod;
	}

	for (uint32_t i = 1; i <= (N - K + M); i++) {
		_down2 *= i;
		_down2 %= mod;
	}

	down_inverse1 = inverse(_down1);
	down_inverse2 = inverse(_down2);

	down_inverse1 = (down_inverse1 * _up) % mod;
	down_inverse2 = (down_inverse2 * _up) % mod;

	ans = (down_inverse1 * down_inverse2) % mod;

	printf("%llu\n", ans);

	return 0;
}