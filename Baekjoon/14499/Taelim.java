package baek14499;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[][] dice = new int [4][3];
	static int[][] map;
	static int N, M, X, Y;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arr = sc.nextLine().split(" ");
		N = Integer.parseInt(arr[0]);
		M = Integer.parseInt(arr[1]);
		X = Integer.parseInt(arr[2]);
		Y = Integer.parseInt(arr[3]);
		int K = Integer.parseInt(arr[4]);
		map = new int[N][M];
		for(int i = 0;i < N;i++){
			arr = sc.nextLine().split(" ");
			for(int j = 0;j < M;j++)
				map[i][j] = Integer.parseInt(arr[j]);
		}
		for(int t = 0;t < K;t++){
			move(sc.nextInt());
		}
		// µ¿ 1 ¼­ 2 ºÏ 3 ³² 4
		sc.close();
	}
	public static void move(int dir){
		int temp;
		if(dir == 1){
			if(Y + 1 == M)
				return;
			else
				Y++;
			temp = dice[1][1];
			dice[1][1] = dice[1][0];
			dice[1][0] = dice[3][1];
			dice[3][1] = dice[1][2];
			dice[1][2] = temp;
		}
		else if(dir == 2){
			if(Y - 1 == -1)
				return;
			else
				Y--;
			temp = dice[1][1];
			dice[1][1] = dice[1][2];
			dice[1][2] = dice[3][1];
			dice[3][1] = dice[1][0];
			dice[1][0] = temp;
		}
		else if(dir == 3){
			if(X - 1 == -1)
				return;
			else
				X--;
			temp = dice[1][1];
			dice[1][1] = dice[2][1];
			dice[2][1] = dice[3][1];
			dice[3][1] = dice[0][1];
			dice[0][1] = temp;
		}
		else if(dir == 4){
			if(X + 1 == N)
				return;
			else
				X++;
			temp = dice[1][1];
			dice[1][1] = dice[0][1];
			dice[0][1] = dice[3][1];
			dice[3][1] = dice[2][1];
			dice[2][1] = temp;
		}
		if(map[X][Y] == 0)
			map[X][Y] = dice[3][1];
		else{
			dice[3][1] = map[X][Y];
			map[X][Y] = 0;
		}
		System.out.println(dice[1][1]);
	}
}
