#include <stdio.h>
#include <iostream>
#include <vector>
#include <list>
#include <array>

using namespace std;

array<vector<int>, 100001> people;
array<bool, 100001> visit;

int main(void) {
	int p_num, p_1, p_2, p_max = 0, ans = 0;
	list<int> queue;

	scanf("%d", &p_num);

	for (int i = 0; i < p_num; i++) {
		scanf("%d %d", &p_1, &p_2);

		people[p_1].push_back(p_2);
		people[p_2].push_back(p_1);

		visit[i] = false;

		if (p_max < p_1) p_max = p_1;
		if (p_max < p_2) p_max = p_2;
	}

	for (int i = 1; i <= p_max; i++) {
		if (people[i].empty() || visit[i])continue;
		visit[i] = true;
		ans++;
		for (int j = 0; j < people[i].size(); j++) {
			queue.push_back(people[i][j]);
		}

		while (!queue.empty()) {
			int next = queue.front();
			queue.pop_front();
			if (people[next].empty() || visit[next]) continue;

			visit[next] = true;
			for (int j = 0; j < people[next].size(); j++)
				queue.push_back(people[next][j]);
		}
	}

	printf("%d\n", ans);
	return 0;
}
