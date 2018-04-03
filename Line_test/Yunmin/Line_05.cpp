#include <stdio.h>
#include <iostream>
#include <vector>
#include <array>
#include <algorithm>

using namespace std;

typedef struct _alba_node {
	uint16_t start_day;
	uint16_t work_period;
	uint16_t pay;
}alba_node;

typedef struct _hourly_wage_node {
	uint16_t node_index;
	float hourly_wage;
}hourly_wage_node;

vector<hourly_wage_node> hourly_wage_stack;
array<hourly_wage_node, 500> hourly_wage_list;
array<alba_node, 500> alba_list;

bool cmp(const hourly_wage_node &a, const hourly_wage_node &b) {
	return a.hourly_wage > b.hourly_wage;
}

bool cmp2(const hourly_wage_node &a, const hourly_wage_node &b) {
	return a.node_index < b.node_index;
}

bool valid_term(uint16_t index) {
	for (uint16_t i = 0; i < hourly_wage_stack.size(); i++) {
		uint16_t stack_index = hourly_wage_stack[i].node_index;
		if (index < stack_index) {
			if (alba_list[index].start_day + alba_list[index].work_period > alba_list[stack_index].start_day) return false;
		}
		else {
			if (alba_list[stack_index].start_day + alba_list[stack_index].work_period > alba_list[index].start_day) return false;
		}
	}
	return true;
}

int main(void) {
	uint16_t alba_num;
	uint32_t sum = 0;
	
	scanf("%hd", &alba_num);

	for (uint16_t n = 0; n < alba_num; n++) {
		scanf("%hd %hd %hd", &alba_list[n].start_day, &alba_list[n].work_period, &alba_list[n].pay);
		hourly_wage_list[n].node_index = n;
		hourly_wage_list[n].hourly_wage = ((float)alba_list[n].pay) / alba_list[n].work_period;
	}

	sort(hourly_wage_list.begin(), hourly_wage_list.begin() + alba_num, cmp);

	hourly_wage_stack.push_back(hourly_wage_list[0]);
	sum += alba_list[hourly_wage_stack[0].node_index].pay;
	

	for (uint16_t i = 1; i < alba_num; i++) {
		if (valid_term(hourly_wage_list[i].node_index)) {
			hourly_wage_stack.push_back(hourly_wage_list[i]);
			sum += alba_list[hourly_wage_list[i].node_index].pay;
		}
	}

	sort(hourly_wage_stack.begin(), hourly_wage_stack.end(), cmp2);

	printf("%u\n", sum);

	for (vector<hourly_wage_node>::iterator itr = hourly_wage_stack.begin(); itr != hourly_wage_stack.end(); ++itr)
		printf("%hd %hd %hd\n", alba_list[itr->node_index].start_day, alba_list[itr->node_index].work_period, alba_list[itr->node_index].pay);


	return 0;
}
