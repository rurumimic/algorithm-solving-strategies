#include <iostream>
#include <stdio.h>
#include <array>

#define MIN(x, y) ((x) < (y) ? (x) : (y))

using namespace std;

typedef struct _price {
	uint16_t day;
	uint16_t month;
	uint16_t tmonth;
	uint16_t year;
}price;

int main(void) {
	uint16_t use_day[12], tc, pay[12];
	price price;

	scanf("%hd", &tc);

	for (uint16_t i = 1; i <= tc; i++) {
		scanf("%hd %hd %hd %hd", &price.day, &price.month, &price.tmonth, &price.year);

		for (uint16_t m = 0; m < 12; m++)
			scanf("%hd", &use_day[m]);

		pay[0] = MIN(price.month, price.day * use_day[0]);
		pay[1] = MIN(price.month, price.day * use_day[1]) + pay[0];
		pay[2] = MIN(price.month, price.day * use_day[2]) + pay[1];
		pay[2] = MIN(pay[2], price.tmonth);

		for (uint16_t j = 3; j < 12; j++) {
			pay[j] = MIN(price.month, price.day * use_day[j]) + pay[j - 1];
			pay[j] = MIN(price.tmonth + pay[j - 3], pay[j]);
		}

		pay[11] = MIN(price.year, pay[11]);

		printf("#%hd %hd\n", i, pay[11]);
	}

	return 0;
}