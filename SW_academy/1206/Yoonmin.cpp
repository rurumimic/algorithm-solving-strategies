#include <iostream>
#include <vector>
#include <array>

using namespace std;

void jomang(int test_num);

int jomang_cal(int * center_building);

int main(void) {
	int testcase = 10;

	for (int i = 0; i < testcase; i++) {
		jomang(i);
	}

	return 0;
}

void jomang(int test_num) {
	int case_line;
	vector<int> building_height;

	cin >> case_line;

	building_height.resize(case_line);

	for (int i = 0; i < case_line; i++) {
		cin >> building_height[i];
	}

	int max_jomang = 0;

	for (int i = 2; i < case_line - 2; i++) {
		max_jomang += jomang_cal(&building_height[i]);
	}

	cout << "#" << test_num+1 << " " << max_jomang << endl;
}

int jomang_cal(int * center_building) {
	int temp, min_jomang = *center_building;

	temp = *center_building - *(center_building - 2);
	if (temp < 0) return 0;
	else if (temp < min_jomang) min_jomang = temp;

	temp = *center_building - *(center_building - 1);
	if (temp < 0) return 0;
	else if (temp < min_jomang) min_jomang = temp;

	temp = *center_building - *(center_building + 1);
	if (temp < 0) return 0;
	else if (temp < min_jomang) min_jomang = temp;

	temp = *center_building - *(center_building + 2);
	if (temp < 0) return 0;
	else if (temp < min_jomang) min_jomang = temp;

	return min_jomang;
}