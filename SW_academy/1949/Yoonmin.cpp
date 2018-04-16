#include <stdio.h>
#include <iostream>

using namespace std;

int map[8][8], N, K, longest;
bool visit[8][8];

void find_way(int x, int y, int length, bool dig, int height);

int main(void) {
	int tc;

	scanf("%d", &tc);

	for (int i = 0; i < tc; i++) {
		int highest = 0;

		scanf("%d %d", &N, &K);

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++)
			{
				scanf("%d", &map[r][c]);
				if (map[r][c] > highest) highest = map[r][c];
			}
		}

		longest = 0;

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++)
				if(map[r][c] == highest) find_way(r, c, 1, false, highest);
		}

		printf("#%d %d\n", i + 1, longest);
	}

	return 0;
}

void find_way(int x, int y, int length, bool dig, int height) {
	if (longest < length) longest = length;
	visit[x][y] = true;
	for (int i = 0; i < 4; i++) {
		int next_x = x, next_y = y;

		if (i == 0)  next_y -= 1;
		else if (i == 1)next_x += 1;
		else if (i == 2)next_y += 1;
		else next_x -= 1;

		if (next_x < 0 || next_y < 0 || next_x >= N || next_y >= N || visit[next_x][next_y]) continue;

		if (height > map[next_x][next_y])
			find_way(next_x, next_y, length + 1, dig, map[next_x][next_y]);
		else if (!dig && height > map[next_x][next_y] - K) {
			find_way(next_x, next_y, length + 1, true, height - 1);
		}
	}
	visit[x][y] = false;
}