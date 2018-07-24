#include <iostream>
#include <vector>

using namespace std;

vector<bool> visited;
vector<uint16_t> _permutation;

uint16_t N;

void Permutation(uint16_t depth);

int main(void) {
	cin >> N;

	visited.resize(N + 1);
	//_permutation.resize(N + 1);

	for (uint16_t i = 1; i <= N; i++)
		visited[i] = false;

	for (uint16_t i = 1; i <= N; i++) {
		visited[i] = true;
		_permutation.push_back(i);
		Permutation(0);
		_permutation.pop_back();
		visited[i] = false;
	}

	return 0;
}

void Permutation(uint16_t depth) {
	if (depth == N - 1) {
		for (uint16_t i = 0; i < N; i++) {
			printf("%d ", _permutation[i]);
		}
		printf("\n");
	}
	else {
		for (uint16_t i = 1; i <= N; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			_permutation.push_back(i);
			Permutation(depth + 1);
			_permutation.pop_back();
			visited[i] = false;
		}
	}
}