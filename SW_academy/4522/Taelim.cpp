#include <iostream>
#include <string>

using namespace std;

int main(int argc, char* argv[]) {
	size_t N;
	cin >> N;
	for (size_t idx = 1; idx <= N; idx++) {
		string str;
		string result = "Exist";
		cin >> str;

		size_t begin = 0;
		size_t end = str.size() - 1;
		while (begin < end) {
			if (str[begin] == str[end]) {
				// Nothing happen
			}
			else if (str[begin] == '?' || str[end] == '?') {
				// Nothing happen
			}
			else {
				result = "Not exist";
				break;
			}
			begin++;
			end--;
		}
		cout << "#" << idx << " " << result << endl;
	}
	return 0;
}