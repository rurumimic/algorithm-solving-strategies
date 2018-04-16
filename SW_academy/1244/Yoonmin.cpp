#include <stdio.h>
#include <cstdlib>
#include <list>
#include <string.h>

using namespace std;

class node {
public:
	char number[7];
	int len;
	int swap_num;
	node() {}
	node(const char *_number, int num) {
		strcpy(number, _number);
		len = strlen(_number);
		swap_num = num;
	}
	~node() {}

	node& operator=(node& B) {
		strcpy(number, B.number);
		swap_num = B.swap_num;
		len = B.len;

		return *this;
	}

	void swap(int i, int j) {
		char tmp = number[i];
		number[i] = number[j];
		number[j] = tmp;

		swap_num--;
	}

	bool operator>(node& B) {
		if (strcmp(number,B.number) > 0) return true;
		return false;
	}
};

bool check[1000000][10];

int toint(char* number) {
	int k = 0;
	for (int i = 0; i < strlen(number); i++) {
		k += number[i] - '0';
		k *= 10;
	}
	return k / 10;
}

int main(void) {
	int tc;
	char numbers[7];
	int swap_num;

	list<node> queue;

	scanf("%d", &tc); getchar();

	memset(check, 0, sizeof(bool) * 10000000);

	for (int t = 1; t <= tc; t++) {
		scanf("%s %d", numbers, &swap_num); getchar();

		node first(numbers, swap_num);

		queue.push_back(first);

		while (!queue.empty()) {
			node dequeue = queue.front();
			queue.pop_front();

			if (dequeue.swap_num == 0) {
				first = dequeue; break;
			}

			for (int i = 0; i < dequeue.len; i++) {
				for (int j = i + 1; j < dequeue.len; j++) {
					node enqueue(dequeue.number, dequeue.swap_num);

					enqueue.swap(i, j);
					int num = toint(enqueue.number);
					if (check[num][enqueue.swap_num]) continue;
					check[num][enqueue.swap_num] = true;
					queue.push_back(enqueue);
				}
			}
		}

		while (!queue.empty()) {
			node dequeue = queue.front();
			queue.pop_front();
			if (dequeue > first) first = dequeue;
		}

		printf("#%d %s\n", t, first.number);

		memset(check, 0, sizeof(bool) * 10000000);
	}

	return 0;
}