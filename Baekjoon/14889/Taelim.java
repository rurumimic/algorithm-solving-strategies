package baek14889;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.OutputStreamWriter;
public class Main {

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = sc.nextInt();
		int[][] ability = new int [N][N];
		int result = Integer.MAX_VALUE;
		
		for(int i = 0;i < N;i++){
			for(int j = 0;j < N;j++) 
				ability[i][j] = sc.nextInt();
		}
//		int people = (1 << N) - 1;
//		int little = (1 << (N / 2)) - 1;
//		int big = people ^ little;
		for(int i = 0;i < (1 << N);i++){
			List<Integer> first = new ArrayList<Integer>();
			List<Integer> second = new ArrayList<Integer>();
			for(int j = 0;j < N;j++){
				if((i & (1 << j)) == 0)
					first.add(j);
				else
					second.add(j);
			}
			if(first.size() != N / 2)
				continue;
			
			int firstResult = 0;
			int secondResult = 0;
			for(int j = 0;j < N / 2;j++){
				for(int k = 0;k < N / 2;k++){
					if(j == k)
						continue;
					firstResult += ability[first.get(j)][first.get(k)];
					secondResult += ability[second.get(j)][second.get(k)];
				}
			}
			result = Math.min(result, Math.abs(firstResult - secondResult));
			
		}
		System.out.println(result);

		
		
		
		
		
//		String littleBit = Integer.toBinaryString(little);
//		String bigBit = Integer.toBinardddwwwwwwsrwdyString(big);
		
//		bf.write(littleBit+"\n");
//		bf.write(bigBit+"\n");
//		bf.flush();
//		br.close();
		sc.close();
	}

}
