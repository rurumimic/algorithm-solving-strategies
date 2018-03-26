#include <iostream>
#include <vector>
#include <array>

using namespace std;

array<array<array<uint16_t, 20>, 20>, 6> board_stack;

typedef enum _direction{UP, RIGHT, DOWN, LEFT} direction;

vector<direction> dir_stack;

uint16_t N, MAX = 0;

void _2048(int level,_direction react);

void key_up(int level);
void key_right(int level);
void key_down(int level);
void key_left(int level);

int main(void) {
	cin >> N;

	for (int r = 0; r < N; r++) {
		for (int c = 0; c < N; c++)
			scanf("%d", &board_stack[0][r][c]);
	}
	
	_2048(1, UP);
	_2048(1, RIGHT);
	_2048(1, DOWN);
	_2048(1, LEFT);

	cout << MAX;

	return 0;
}

void _2048(int level, _direction react) {
	switch (react)
	{
	case UP:
		key_up(level);
		break;
	case RIGHT:
		key_right(level);
		break;
	case DOWN:
		key_down(level);
		break;
	default:
		key_left(level);
		break;
	}
	if (level == 5) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++)
				if (board_stack[5][r][c] > MAX) {
					MAX = board_stack[5][r][c];
				}
		}
	}
	else {
		_2048(level + 1, UP);
		_2048(level + 1, RIGHT);
		_2048(level + 1, DOWN);
		_2048(level + 1, LEFT);
	}
}

void key_up(int level) {
	for (int c = 0; c < N; c++) {
		int m = 0;
		board_stack[level][m][c] = 0;
		for (int r = 0; r < N; r++) {
			if (board_stack[level - 1][r][c] == 0) continue;
			if (board_stack[level][m][c] == 0) { board_stack[level][m][c] = board_stack[level - 1][r][c]; }
			else {
				if (board_stack[level - 1][r][c] == board_stack[level][m][c]) { board_stack[level][m][c] <<= 1; m++; board_stack[level][m][c] = 0; }
				else { m++; board_stack[level][m][c] = board_stack[level - 1][r][c]; }
			}
		}
		m++;
		for (; m < N; m++)
			board_stack[level][m][c] = 0;
	}
}
void key_right(int level) {
	for (int r = 0; r < N; r++) {
		int m = N - 1;
		board_stack[level][r][m] = 0;
		for (int c = N - 1; c >= 0; c--) {
			if (board_stack[level - 1][r][c] == 0) continue;
			if (board_stack[level][r][m] == 0) { board_stack[level][r][m] = board_stack[level - 1][r][c]; }
			else {
				if (board_stack[level - 1][r][c] == board_stack[level][r][m]) { 
					board_stack[level][r][m] <<= 1; 
					m--; 
					board_stack[level][r][m] = 0;
				}
				else { 
					m--;
					board_stack[level][r][m] = board_stack[level - 1][r][c]; 
				}
			}
		}
		m--;
		for (; m >= 0; m--)
			board_stack[level][r][m] = 0;
	}
}
void key_down(int level) {
	for (int c = 0; c < N; c++) {
		int m = N - 1;
		board_stack[level][m][c] = 0;
		for (int r = N - 1; r >= 0; r--) {
			if (board_stack[level - 1][r][c] == 0) continue;
			if (board_stack[level][m][c] == 0) { board_stack[level][m][c] = board_stack[level - 1][r][c]; }
			else {
				if (board_stack[level - 1][r][c] == board_stack[level][m][c]) { board_stack[level][m][c] <<= 1; m--; board_stack[level][m][c] = 0; }
				else { m--; board_stack[level][m][c] = board_stack[level - 1][r][c]; }
			}
		}
		m--;
		for (; m >= 0; m--)
			board_stack[level][m][c] = 0;
	}
}
void key_left(int level) {
	for (int r = 0; r < N; r++) {
		int m = 0;
		board_stack[level][r][m] = 0;
		for (int c = 0; c < N; c++) {
			if (board_stack[level - 1][r][c] == 0) continue;
			if (board_stack[level][r][m] == 0) { board_stack[level][r][m] = board_stack[level - 1][r][c]; }
			else {
				if (board_stack[level - 1][r][c] == board_stack[level][r][m]) { board_stack[level][r][m] <<= 1; m++; board_stack[level][r][m] = 0; }
				else { m++; board_stack[level][r][m] = board_stack[level - 1][r][c]; }
			}
		}

		m++;
		for (; m < N; m++)
			board_stack[level][r][m] = 0;
	}
}