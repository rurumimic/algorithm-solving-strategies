#include <iostream>
#include <stdio.h>
#include <cstdlib>
#include <vector>
#include <algorithm>

using namespace std;

vector<uint32_t> camera;
vector<uint32_t> gap;

bool visit[1048576];

uint32_t dps(int g_idx, int level) {
	visit[g_idx] = true;


	visit[g_idx] = false;
	return 0;
}

int main(void) {
	int tc;

	scanf("%d", &tc); getchar();

	for (int t = 1; t <= tc; t++) {
		int N, K;
		scanf("%d", &N); getchar();
		scanf("%d", &K); getchar();

		memset(visit, 0, sizeof(bool) * 1048576);

		for (int i = 0; i < N; i++) {
			int tmp;

			scanf("%d", &tmp);

			if (visit[tmp]) continue;

			visit[tmp] = true;
			camera.push_back(tmp);
		}

		sort(camera.begin(), camera.end());

		for (int i = 0; i < camera.size() - 1; i++)
			gap.push_back(camera[i + 1] - camera[i]);

		memset(visit, 0, sizeof(bool) * 1048576);

		getchar();

		camera.erase(camera.begin(), camera.end());
		gap.erase(gap.begin(), gap.end());

		memset(visit, 0, sizeof(bool) * 1048576);

	}

	return 0;
}