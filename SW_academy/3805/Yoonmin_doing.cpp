#include <iostream>
#include <stdio.h>
#include <cstdlib>

using namespace std;

class vertex {
public:
	uint8_t v_num;
	uint16_t x, y, adj_num, *adj;

	vertex() {}
	/*vertex(int _num, int _x, int _y, int _adj_num) {
		v_num = _num; x = _x; y = _y; adj_num = _adj_num;
		adj = new uint16_t[adj_num];
	}*/
	~vertex() {
		delete[] adj;
	}

	vertex& operator=(vertex& B) {
		v_num = B.v_num; x = B.x; y = B.y; adj_num = B.adj_num;
		adj = new uint16_t[adj_num];
	}

	void getadj() {
		adj = new uint16_t[adj_num];
		for (int i = 0; i < adj_num; i++) {
			scanf("%u ", &adj[i]);
		}
	}
};

int main(void) {
	int tc, N, k;
	vertex *v;

	scanf("%d", &tc); getchar();

	for (int t = 1; t <= tc; t++) {
		scanf("%d", &N); getchar();
		v = new vertex[N];

		for (int i = 0; i < N; i++) {
			scanf("%u %u %u %u", &v[i].v_num, &v[i].x, &v[i].y, &v[i].adj_num);
			v[i].getadj();
		}

		scanf("%d", &k);


	}

	return 0;
}