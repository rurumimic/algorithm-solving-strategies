package kakao1805;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		final class Job{
			int M;
			int D;
			int I;
			Job(int M, int D, int I){
				this.M = M;
				this.D = D;
				this.I = I;
			}
		}
		int[] day = new int[301];
		int pay = 0;
		List<Job> jobList = new ArrayList<Job>();
		for(int i = 0;i < N;i++){
			jobList.add(new Job(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		
		jobList.sort(new Comparator<Job>(){

			@Override
			public int compare(Job j1, Job j2) {
				// TODO Auto-generated method stub
				if(j1.I < j2.I){
					return 1;
				}
				else if(j1.I > j2.I){
					return -1;
				}
				else{
					return 0;
				}
				
			}
			
		});
		List<Job> selectedList = new ArrayList<Job>();
		
		for(int i = 0;i < N;i++){
			if(day[jobList.get(0).M] == 0 && day[jobList.get(0).D + jobList.get(0).M - 1] == 0){
				Arrays.fill(day, jobList.get(0).M, jobList.get(0).D + jobList.get(0).M - 1,  1);
				pay += jobList.get(0).I;
				selectedList.add(jobList.get(0));
				
				
			}
			jobList.remove(0);

		}
		
		System.out.println(pay);
		for(int i = selectedList.size() - 1;i >= 0;i--){
			System.out.println(selectedList.get(i).M+" "+selectedList.get(i).D);
		}
		sc.close();
		
//		
//		int[][] job = new int[201][101];
//		
//		int pay = 0;
		
//		for(int i = 0;i < N;i++){
//			int eachPay;
//			job[sc.nextInt()][sc.nextInt()] = eachPay = sc.nextInt();
//					
//		}
////		System.out.println(Arrays.deepToString(job));
//		for(int i = 0;i < N;i++){
//			
//		}

	}

}
