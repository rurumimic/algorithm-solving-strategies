package sw1952;

import java.util.Scanner;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		// Test case
		int T = sc.nextInt();
		
		for(int i = 1;i <= T;i++){
			// Cost list
			int[] cost = new int[4];
			cost[0] = sc.nextInt();
			cost[1] = sc.nextInt();
			cost[2] = sc.nextInt();
			cost[3] = sc.nextInt();
//			System.out.println(Arrays.toString(cost));
			// Total cost
			int totalFirst = 0;
			int totalSecond = 0;
			int totalThird = 0;
			// Handle days
			int threeMonthes = 0;

			int[] days = new int[12];
			for(int j = 0;j < 12;j++){
				days[j] = sc.nextInt();
			}

			for(int j = 0;j < 12;j++){
//				System.out.println(days[j]);


				if(days[j] * cost[0] < cost[1]){
					int pay = days[j] * cost[0];
					totalFirst += pay;
					days[j] = pay;

				}
				else{
					int pay = cost[1];
					totalFirst += pay;
					days[j] = pay;

					
				}

			}
			totalSecond = totalFirst;
			totalThird = totalFirst;
			for(int j = 0;j < 10;j++){
				threeMonthes = days[j] + days[j + 1] + days[j + 2];
				if(threeMonthes > cost[2]){
					totalSecond -= threeMonthes;
					totalSecond += cost[2];
					j += 2;
				}
				if(j == 9){
					if(days[j + 1] + days[j + 2] > cost[2]){
						totalSecond -= (days[j + 1] + days[j + 2]);
						totalSecond += cost[2];
					}
				}
				else if(j == 10){
					if(days[j + 1] > cost[2]){
						totalSecond -= days[j + 1];
						totalSecond += cost[2];
					}
				}
			}
			for(int j = 11;j >= 2;j--){
				threeMonthes = days[j] + days[j - 1] + days[j - 2];
				if(threeMonthes > cost[2]){
					totalThird -= threeMonthes;
					totalThird += cost[2];
					j -= 2;
				}
			}
			
			int[] sortNum = new int[4];
			sortNum[0] = cost[3];
			sortNum[1] = totalFirst;
			sortNum[2] = totalSecond;
			sortNum[3] = totalThird;
			Arrays.sort(sortNum);
			System.out.println("#"+i+" "+sortNum[0]);
			
		}
		sc.close();

	}

}
