#include <iostream>
#include <stdio.h>
#include <list>

using namespace std;

class point {
public:
	int16_t x, y;

	point() {}
	point(int16_t ix, int16_t iy) {
		x = ix; y = iy;
	}
	~point() {}

	void operator+=(point &B) {
		x += B.x; y += B.y;
	}

	void operator-=(point &B) {
		x -= B.x; y -= B.y;
	}

	bool operator!=(point &B) {
		if (x != B.x || y != B.y)
			return true;
		return false;
	}

	bool operator==(point &B) {
		if (x == B.x && y == B.y)
			return true;
		return false;
	}

	point& operator=(const point &B) {
		x = B.x; y = B.y;
		return *this;
	}
};

point d[4];

enum _direction { UP, DOWN, RIGHT, LEFT, NONE };
typedef _direction direction;
char map[10][10];
int16_t r, c;

typedef struct _node {
	point r, b;
	int16_t height;
	direction dir;
}node;

list<node> queue;

node move(node prev_node, direction dir) {
	node next_node;
	next_node.height = prev_node.height + 1;
	next_node.dir = dir;
	point o(0, 0), tr = prev_node.r, tb = prev_node.b;
	next_node.r = o; next_node.b = o;

	while (next_node.r == o && next_node.b == o) {
		if (next_node.r == o) {
			tr += d[dir];
		}
		if (next_node.b == o) {
			tb += d[dir];
		}
		if (map[tr.y][tr.x] == 'O') {
			next_node.r = tr;
		}
		else if (map[tr.y][tr.x] == '#') {
			tr -= d[dir];
			next_node.r = tr;
		}
		if (map[tb.y][tb.x] == 'O') {
			next_node.b = tb;
		}
		else if (map[tb.y][tb.x] == '#') {
			tb -= d[dir];
			next_node.b = tb;
		}
	}
	while (next_node.r == o) {
		if (map[tr.y][tr.x] == 'O') {
			next_node.r = tr; break;
		}
		else if (map[tr.y][tr.x] == '#') {
			tr -= d[dir];
			next_node.r = tr;
			break;
		}
		else if (tr == tb) {
			tr -= d[dir];
			next_node.r = tr;
			break;
		}
		tr += d[dir];
	}
	while (next_node.b == o) {
		if (map[tb.y][tb.x] == 'O') {
			next_node.b = tb; break;
		}
		else if (map[tb.y][tb.x] == '#') {
			tb -= d[dir];
			next_node.b = tb; break;
		}
		else if (tb == tr) {
			tb -= d[dir];
			next_node.b = tb; break;
		}
		tb += d[dir];
	}


	return next_node;
}

int main(void) {
	point o;
	node first;
	int16_t height = -1;

	scanf("%hd %hd", &r, &c);

	getchar();

	d[0].x = 0; d[0].y = -1;
	d[1].x = 0; d[1].y = 1;
	d[2].x = 1; d[2].y = 0;
	d[3].x = -1; d[3].y = 0;

	for (int16_t y = 0; y < r; y++) {
		for (int16_t x = 0; x < c; x++) {
			map[y][x] = getchar();
			if (map[y][x] == 'R') {
				first.r.x = x; first.r.y = y;
			}
			else if (map[y][x] == 'B') {
				first.b.x = x; first.b.y = y;
			}
			else if (map[y][x] == 'O') {
				o.x = x; o.y = y;
			}
		}
		getchar();
	}
	first.height = 0;
	first.dir = NONE;

	queue.push_back(first);

	while (!queue.empty()) {
		node dequeue = queue.front();
		queue.pop_front();
		if (dequeue.height > 9) break;
		node _up, _down, _right, _left, next;

		for (int i = UP; i != NONE; i++) {
			if ((direction)i == dequeue.dir) continue;
			next = move(dequeue, (direction)i);
			if (next.b != o) {
				if (next.r == o) {
					height = next.height;
					break;
				}
				queue.push_back(next);
			}
		}
		if (height != -1) break;
	}

	printf("%hd\n", height);

	return 0;
}