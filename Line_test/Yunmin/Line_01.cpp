#include <iostream>
#include <stdio.h>
#include <vector>

using namespace std;

int main(void) {
	int tc;

	scanf("%d", &tc);
	getchar();

	for (int i = 0; i < tc; i++) {
		char prev_char, present_char;
		vector<char> char_stack;
		vector<int> num_stack;

		present_char = getchar();
		prev_char = present_char;

		char_stack.push_back(present_char);
		num_stack.push_back(0);

		while (present_char != '\n') {
			if (prev_char == present_char) {
				num_stack.back()++;
			}
			else {
				char_stack.push_back(present_char);
				num_stack.push_back(1);
				prev_char = present_char;
			}
			present_char = getchar();
		}

		for (int size = 0; size < char_stack.size(); size++) {
			printf("%d%c", num_stack[size], char_stack[size]);
		}
		printf("\n");
	}

	return 0;
}