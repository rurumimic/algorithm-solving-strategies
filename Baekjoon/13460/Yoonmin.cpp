#include <iostream>
#include <stdio.h>
#include <list>

using namespace std;

typedef struct _node {
	int16_t rx, ry;
	int16_t bx, by;
	int16_t height;
}node;

list<node> queue;

enum direction {UP, DOWN, RIGHT, LEFT};
char map[10][10];
int16_t r, c;

node move(node prev_node, direction dir) {
	node next_node;
	next_node.height = prev_node.height + 1;
	switch (dir)
	{
	case UP:
		if (prev_node.rx == prev_node.bx) {
			if (prev_node.ry < prev_node.by) {
				for (int16_t y = prev_node.ry - 1; y >= 0; y--) {
					if (map[y][prev_node.rx] == 'O') {
						next_node.ry = y; next_node.rx = prev_node.rx;
						next_node.by = y; next_node.bx = prev_node.bx;
					}
					else if (map[y][prev_node.rx] == '#') {
						next_node.ry = y + 1; next_node.rx = prev_node.rx;
					}
				}
				if (next_node.ry != next_node.by) {
					for (int16_t y = prev_node.by - 1; y >= 0; y--) {
						if (y == next_node.ry) {
							next_node.by = y + 1; next_node.bx = prev_node.bx;
						}
					}
				}
			}
			else {
				for (int16_t y = prev_node.by - 1; y >= 0; y--) {
					if (map[y][prev_node.bx] == 'O') {
						next_node.by = y; next_node.bx = prev_node.bx;
						next_node.ry = y; next_node.rx = prev_node.rx;
					}
					else if (map[y][prev_node.bx] == '#') {
						next_node.by = y + 1; next_node.bx = prev_node.bx;
					}
				}
				if (next_node.ry != next_node.by) {
					for (int16_t y = prev_node.ry - 1; y >= 0; y--) {
						if (y == next_node.by) {
							next_node.ry = y + 1; next_node.rx = prev_node.rx;
						}
					}
				}
			}
		}
		else {
			for (int16_t y = prev_node.ry - 1; y >= 0; y--) {
				if (map[y][prev_node.rx] == 'O') {
					next_node.ry = y; next_node.rx = prev_node.rx;
				}
				else if (map[y][prev_node.rx] == '#') {
					next_node.ry = y + 1; next_node.rx = prev_node.rx;
				}
			}
			for (int16_t y = prev_node.by - 1; y >= 0; y--) {
				if (map[y][prev_node.bx] == 'O') {
					next_node.by = y; next_node.bx = prev_node.bx;
				}
				else if (map[y][prev_node.bx] == '#') {
					next_node.by = y + 1; next_node.bx = prev_node.bx;
				}
			}
		}
		break;
	case DOWN:
		if (prev_node.rx == prev_node.bx) {
			if (prev_node.ry > prev_node.by) {
				for (int16_t y = prev_node.ry + 1; y < r; y++) {
					if (map[y][prev_node.rx] == 'O') {
						next_node.ry = y; next_node.rx = prev_node.rx;
						next_node.by = y; next_node.bx = prev_node.bx;
					}
					else if (map[y][prev_node.rx] == '#') {
						next_node.ry = y - 1; next_node.rx = prev_node.rx;
					}
				}
				if (next_node.ry != next_node.by) {
					for (int16_t y = prev_node.by + 1; y < r; y++) {
						if (y == next_node.ry) {
							next_node.by = y - 1; next_node.bx = prev_node.bx;
						}
					}
				}
			}
			else {
				for (int16_t y = prev_node.by + 1; y < r; y++) {
					if (map[y][prev_node.bx] == 'O') {
						next_node.by = y; next_node.bx = prev_node.bx;
						next_node.ry = y; next_node.rx = prev_node.rx;
					}
					else if (map[y][prev_node.bx] == '#') {
						next_node.by = y - 1; next_node.bx = prev_node.bx;
					}
				}
				if (next_node.ry != next_node.by) {
					for (int16_t y = prev_node.ry + 1; y < r; y++) {
						if (y == next_node.by) {
							next_node.ry = y - 1; next_node.rx = prev_node.rx;
						}
					}
				}
			}
		}
		else {
			for (int16_t y = prev_node.ry + 1; y < r; y++) {
				if (map[y][prev_node.rx] == 'O') {
					next_node.ry = y; next_node.rx = prev_node.rx;
				}
				else if (map[y][prev_node.rx] == '#') {
					next_node.ry = y - 1; next_node.rx = prev_node.rx;
				}
			}
			for (int16_t y = prev_node.by + 1; y < r; y++) {
				if (map[y][prev_node.bx] == 'O') {
					next_node.by = y; next_node.bx = prev_node.bx;
				}
				else if (map[y][prev_node.bx] == '#') {
					next_node.by = y - 1; next_node.bx = prev_node.bx;
				}
			}
		}
		break;
	case RIGHT:
		if (prev_node.ry == prev_node.by) {
			if (prev_node.rx > prev_node.bx) {
				for (int16_t x = prev_node.rx + 1; x < c; x++) {
					if (map[prev_node.ry][x] == 'O') {
						next_node.ry = prev_node.ry; next_node.rx = x;
						next_node.by = prev_node.by; next_node.bx = x;
					}
					else if (map[prev_node.ry][x] == '#') {
						next_node.ry = prev_node.ry; next_node.rx = x - 1;
					}
				}
				if (next_node.rx != next_node.bx) {
					for (int16_t x = prev_node.bx + 1; x < c; x++) {
						if (x == next_node.rx) {
							next_node.by = prev_node.by; next_node.bx = x - 1;
						}
					}
				}
			}
			else {
				for (int16_t x = prev_node.bx + 1; x < c; x++) {
					if (map[prev_node.by][x] == 'O') {
						next_node.by = prev_node.by; next_node.bx = x;
						next_node.ry = prev_node.by; next_node.rx = x;
					}
					else if (map[prev_node.by][x] == '#') {
						next_node.by = prev_node.by; next_node.bx = x - 1;
					}
				}
				if (next_node.rx != next_node.bx) {
					for (int16_t x = prev_node.rx + 1; x < c; x++) {
						if (x == next_node.bx) {
							next_node.ry = prev_node.ry; next_node.rx = x - 1;
						}
					}
				}
			}
		}
		else {
			for (int16_t x = prev_node.rx + 1; x < c; x++) {
				if (map[prev_node.ry][x] == 'O') {
					next_node.ry = prev_node.ry; next_node.rx = x;
				}
				else if (map[prev_node.ry][x] == '#') {
					next_node.ry = prev_node.ry; next_node.rx = x - 1;
				}
			}
			for (int16_t x = prev_node.bx + 1; x < c; x++) {
				if (map[prev_node.by][x] == 'O') {
					next_node.by = prev_node.by; next_node.bx = x;
				}
				else if (map[prev_node.by][x] == '#') {
					next_node.by = prev_node.by; next_node.bx = x - 1;
				}
			}
		}
		break;
	case LEFT:
		if (prev_node.ry == prev_node.by) {
			if (prev_node.rx < prev_node.bx) {
				for (int16_t x = prev_node.rx - 1; x >= 0; x--) {
					if (map[prev_node.ry][x] == 'O') {
						next_node.ry = prev_node.ry; next_node.rx = x;
						next_node.by = prev_node.by; next_node.bx = x;
					}
					else if (map[prev_node.ry][x] == '#') {
						next_node.ry = prev_node.ry; next_node.rx = x + 1;
					}
				}
				if (next_node.rx != next_node.bx) {
					for (int16_t x = prev_node.bx - 1; x >= 0; x--) {
						if (x == next_node.rx) {
							next_node.by = prev_node.by; next_node.bx = x + 1;
						}
					}
				}
			}
			else {
				for (int16_t x = prev_node.bx - 1; x >= 0; x--) {
					if (map[prev_node.by][x] == 'O') {
						next_node.by = prev_node.by; next_node.bx = x;
						next_node.ry = prev_node.by; next_node.rx = x;
					}
					else if (map[prev_node.by][x] == '#') {
						next_node.by = prev_node.by; next_node.bx = x + 1;
					}
				}
				if (next_node.rx != next_node.bx) {
					for (int16_t x = prev_node.rx - 1; x >= 0; x--) {
						if (x == next_node.bx) {
							next_node.ry = prev_node.ry; next_node.rx = x + 1;
						}
					}
				}
			}
		}
		else {
			for (int16_t x = prev_node.rx - 1; x >= 0; x--) {
				if (map[prev_node.ry][x] == 'O') {
					next_node.ry = prev_node.ry; next_node.rx = x;
				}
				else if (map[prev_node.ry][x] == '#') {
					next_node.ry = prev_node.ry; next_node.rx = x + 1;
				}
			}
			for (int16_t x = prev_node.bx - 1; x >= 0; x--) {
				if (map[prev_node.by][x] == 'O') {
					next_node.by = prev_node.by; next_node.bx = x;
				}
				else if (map[prev_node.by][x] == '#') {
					next_node.by = prev_node.by; next_node.bx = x + 1;
				}
			}
		}
		break;
	}
	
	return next_node;
}

int main(void) {
	int16_t ox, oy;
	node first;
	int16_t height = -1;

	scanf("%hd %hd", &r, &c);

	getchar();

	for (int16_t y = 0; y < r; y++) {
		for (int16_t x = 0; x < c; x++) {
			map[y][x] = getchar();
			if (map[y][x] == 'R') {
				first.rx = x; first.ry = y;
			}
			else if (map[y][x] == 'B') {
				first.bx = x; first.by = y;
			}
			else if (map[y][x] == 'O') {
				ox = x; oy = y;
			}
		}
		getchar();
	}
	first.height = 0;

	queue.push_back(first);

	while (!queue.empty()) {
		node dequeue = queue.front();
		queue.pop_front();
		if (dequeue.height > 10) break;
		node _up, _down, _right, _left;

		_up = move(dequeue, UP);
		if (_up.bx != ox || _up.by != oy) {
			if (_up.rx == ox && _up.ry == oy) {
				height = _up.height;
				break;
			}
			queue.push_back(_up);
		}

		_down = move(dequeue, DOWN);
		if (_down.bx != ox || _down.by != oy) {
			if (_down.rx == ox && _down.ry == oy) {
				height = _down.height;
				break;
			}
			queue.push_back(_down);
		}

		_right = move(dequeue, RIGHT);
		if (_right.bx != ox || _right.by != oy) {
			if (_right.rx == ox && _right.ry == oy) {
				height = _right.height;
				break;
			}
			queue.push_back(_right);
		}

		_left = move(dequeue, LEFT);
		if (_left.bx != ox || _left.by != oy) {
			if (_left.rx == ox && _left.ry == oy) {
				height = _left.height;
				break;
			}
			queue.push_back(_left);
		}
	}

	printf("%hd\n", height);

	return 0;
}