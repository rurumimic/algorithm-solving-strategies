import java.util.Scanner;
public class Solution {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int index = 1;index <= T;index++){
			int[] cost = new int[4];
			cost[0] = sc.nextInt();
			cost[1] = sc.nextInt();
			cost[2] = sc.nextInt();
			cost[3] = sc.nextInt();
			int[] month = new int[14];
			int total = 0;
			for(int i = 0;i < 12;i++){
				month[i] = Math.min(sc.nextInt() * cost[0], cost[1]);
			}
			for(int i = 11;i > 0;i--){
				month[i - 1] = Math.min(month[i] + month[i - 1], month[i + 2] + cost[2]);
			}
			System.out.println("#"+index+" "+Math.min(month[0], cost[3]));
		}
		sc.close();
	}
}