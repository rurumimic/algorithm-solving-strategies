#include <iostream>
#include <vector>
#include <algorithm>
#include <tuple>

using namespace std;

int main()
{
	int N;
	cin >> N;
	for (int idx = 1; idx <= N; idx++) {
		int result = 0;
		int A, B;
		int C, D;
		cin >> A >> B;
		vector< tuple <int, int> > arr;
		vector< vector<int> > map;
		map.assign(A+1, vector<int>(B+1, 0));
		for (int j = 0; j<A; j++) {
			cin >> C >> D;
			
			arr.push_back(make_tuple(C, D));
		}
		for (int i = 1; i <= A; i++) {
			for (int j = 0; j <= B; j++) {
				if (get<1>(arr[i-1]) > j)
					map[i][j] = map[i - 1][j];
				else
					map[i][j] = max(map[i - 1][j], map[i - 1][j - get<1>(arr[i - 1])] + get<0>(arr[i-1]));

			}
		}
		result = map[A][B];

		cout << "#" << idx << " " << result << endl;
	}

}