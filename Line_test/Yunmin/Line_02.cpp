#include <iostream>
#include <stdio.h>
#include <vector>
#include <string.h>
#include <math.h>

using namespace std;

typedef struct _store {
	int distance;
	int sx;
	int sy;
	int coup;
	char name[7];
}store;

int usr_x, usr_y, store_num;

void store_swap(store *x, store *y) {
	int tmp_dist = x->distance, tmp_coup = x->coup;
	int tmp_x = x->sx, tmp_y = x->sy;

	x->distance = y->distance; x->coup = y->coup;
	y->distance = tmp_dist; y->coup = tmp_coup;

	x->sx = y->sx; x->sy = y->sy;
	y->sx = tmp_x; y->sy = tmp_y;

	for (int i = 0; i < 6; i++) {
		char tmp = x->name[i];
		x->name[i] = y->name[i];
		y->name[i] = tmp;
	}
}

int distance(int sx, int sy) {
	int dx = sx - usr_x, dy = sy - usr_y;
	dx = dx * dx; dy = dy * dy;
	int dist = dx + dy;
	dist = sqrt(dist);
	
	dist -= dist % 100;
	return dist;
}

int main(void) {
	int tc;
	store *stores;

	scanf("%d", &tc);

	for (int t = 0; t < tc; t++) {
		scanf("%d %d %d", &usr_x, &usr_y, &store_num);

		stores = (store *)malloc(store_num * (sizeof store));

		for (int i = 0; i < store_num; i++) {
			scanf("%d %d %s %d", &stores[i].sx, &stores[i].sy, stores[i].name, &stores[i].coup);
			stores[i].distance = distance(stores[i].sx, stores[i].sy);
		}

		for (int i = 1; i < store_num; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (stores[j + 1].distance < stores[j].distance) {
					swap(stores[j + 1], stores[j]);
				}
				else if (stores[j + 1].distance == stores[j].distance) {
					if (stores[j + 1].coup > stores[j].coup)
						swap(stores[j + 1], stores[j]);
					else {
						if (strcmp(stores[j + 1].name, stores[j].name) < 0)
							swap(stores[j + 1], stores[j]);
					}
				}
			}
		}

		for (int i = 0; i < store_num; i++) {
			printf("%d %d %s %d\n", stores[i].sx, stores[i].sy, stores[i].name, stores[i].coup);
		}
		free(stores);
	}

	return 0;
}