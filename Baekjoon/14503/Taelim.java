package baek14503;

import java.util.Scanner;
public class Main {
	static int N, M, R, C, D;
	static int count = 0;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arr = sc.nextLine().split(" ");
		N= Integer.parseInt(arr[0]);
		M = Integer.parseInt(arr[1]);
		map = new int[N][M];
		arr = sc.nextLine().split(" ");
		R = Integer.parseInt(arr[0]);
		C = Integer.parseInt(arr[1]);
		// 방향 : 0 북, 1 동, 2 남, 3 서
		// 회전 : 3 서, 0 북, 1 동, 2 남
		D = Integer.parseInt(arr[2]);
		for(int i = 0;i < N;i++){
			arr = sc.nextLine().split(" ");
			for(int j = 0;j < M;j++)
				map[i][j] = Integer.parseInt(arr[j]);
		}
		boolean isClean = true;
		while(isClean)
			isClean = sweep();
		System.out.println(count);
		sc.close();
	}
	public static boolean sweep(){
		if(map[R][C] == 0){
			map[R][C] = 2;
			count++;
		}
		for(int turn = 0;turn < 4;turn++){
			D = (D + 3) % 4;
			if(D == 0 && R - 1 >= 0){
				if(map[R - 1][C] == 0){
					R--;
					return true;
				}else{
					if(turn == 3){
						if(R + 1 < N){
							if(map[R + 1][C] == 2){
								R++;
								return true;
							}else return false;
						}else return false;	
					}
				}
			}else if(D == 1 && C + 1 < M){
				if(map[R][C + 1] == 0){
					C++;
					return true;
				}else{
					if(turn == 3){
						if(C - 1 >= 0){
							if(map[R][C - 1] == 2){
								C--;
								return true;
							}else return false;
						}else return false;		
					}
				}
			}else if(D == 2 && R + 1 < N){
				if(map[R + 1][C] == 0){
					R++;
					return true;
				}else{
					if(turn == 3){
						if(R - 1 >= 0){
							if(map[R - 1][C] == 2){
								R--;
								return true;
							}else return false;
						}else return false;
					}
				}
			}else if(D == 3 && C - 1 >= 0){
				if(map[R][C - 1] == 0){
					C--;
					return true;
				}else{
					if(turn == 3){
						if(C + 1 < M){
							if(map[R][C + 1] == 2){
								C++;
								return true;
							}else return false;
						}else return false;
					}
				}
			}
		}
		return false;
	}
}