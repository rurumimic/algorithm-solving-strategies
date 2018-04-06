package sw1953;
import java.awt.Point;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
public class Solution {
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visit;
	static int result;
	
	static final class Points extends Point{
		int L;
		Points(int x, int y, int L){
			super(x, y);
			this.L = L;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int index = 1;index <= T;index++){
			N = sc.nextInt();
			M = sc.nextInt();
			int R = sc.nextInt();
			int C = sc.nextInt();
			int L = sc.nextInt();
			result = 0;
			map = new int[N][M];
			visit = new boolean[N][M];
			
			for(int i = 0;i < N;i++){
				
				for(int j = 0;j < M;j++){
					map[i][j] = sc.nextInt();
					visit[i][j] = false;
				}
			}
//			System.out.println(Arrays.deepToString(map));
			bfs(R, C, L - 1);
			for(int i = 0;i < N;i++){
//				System.out.println(Arrays.toString(visit[i]));
				for(int j = 0;j < M;j++){
					if(visit[i][j] == true){
						result++;
					}
				}
			}
			System.out.println("#"+index+" "+result);
			
			
			
		}
		
		sc.close();

	}
	
	public static boolean direction(int x, int y, int arrow){

		if(arrow == 1){
			if(map[x - 1][y] != 3 && map[x - 1][y] != 4 && map[x - 1][y] != 7){
				return true;
			}
			else{
				return false;
			}
		}
		else if(arrow == 3){
			if(map[x + 1][y] != 3 && map[x + 1][y] != 5 && map[x + 1][y] != 6){
				return true;
			}
			else{
				return false;
			}
		}
		else if(arrow == 2){
			if(map[x][y - 1] != 2 && map[x][y - 1] != 6 && map[x][y - 1] != 7){
				return true;
			}
			else{
				return false;
			}
		}
		else if(arrow == 4){
			if(map[x][y + 1] != 2 && map[x][y + 1] != 4 && map[x][y + 1] != 5){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
	
	public static void dfs(int x, int y, int L){
		if(map[x][y] == 0 || L == -1){
			return;
		}
		visit[x][y] = true; 
		result++;
		switch(map[x][y]){
			case 1:
				if(x != 0){
					if(visit[x - 1][y] != true && direction(x, y, 1)){
						dfs(x - 1, y, L - 1);
					}
				}
				if(x != N - 1){
					if(visit[x + 1][y] != true && direction(x, y, 3)){
						dfs(x + 1, y, L - 1);
					}
				}
				if(y != 0){
					if(visit[x][y - 1] != true && direction(x, y, 2)){
						dfs(x, y - 1, L - 1);
					}
				}
				if(y != M - 1){
					if(visit[x][y + 1] != true && direction(x, y, 4)){
						dfs(x, y + 1, L - 1);
					}
				}
				
				break;
			case 2:
				if(x != 0){
					if(visit[x - 1][y] != true && direction(x, y, 1)){
						dfs(x - 1, y, L - 1);
					}
				}
				if(x != N - 1){
					if(visit[x + 1][y] != true && direction(x, y, 3)){
						dfs(x + 1, y, L - 1);
					}
				}
				break;
			case 3:
				if(y != 0){
					if(visit[x][y - 1] != true && direction(x, y, 2)){
						dfs(x, y - 1, L - 1);
					}
				}
				if(y != M - 1){
					if(visit[x][y + 1] != true && direction(x, y, 4)){
						dfs(x, y + 1, L - 1);
					}
				}
				break;
			case 4:
				if(x != 0){
					if(visit[x - 1][y] != true && direction(x, y, 1)){
						dfs(x - 1, y, L - 1);
					}
				}
				if(y != M - 1){
					if(visit[x][y + 1] != true && direction(x, y, 4)){
						dfs(x, y + 1, L - 1);
					}
				}
				break;
			case 5:
				if(x != N - 1){
					if(visit[x + 1][y] != true && direction(x, y, 3)){
						dfs(x + 1, y, L - 1);
					}
				}
				if(y != M - 1){
					if(visit[x][y + 1] != true && direction(x, y, 4)){
						dfs(x, y + 1, L - 1);
					}
				}
				break;
			case 6:
				if(x != N - 1){
					if(visit[x + 1][y] != true && direction(x, y, 3)){
						dfs(x + 1, y, L - 1);
					}
				}
				if(y != 0){
					if(visit[x][y - 1] != true && direction(x, y, 2)){
						dfs(x, y - 1, L - 1);
					}
				}
				break;
			case 7:
				if(x != 0){
					if(visit[x - 1][y] != true && direction(x, y, 1)){
						dfs(x - 1, y, L - 1);
					}
				}
				if(y != 0){
					if(visit[x][y - 1] != true && direction(x, y, 2)){
						dfs(x, y - 1, L - 1);
					}
				}
				break;
			case 0:
			
				break;
		}
	}
	
	public static void bfs(int x, int y, int L){
		Queue<Points> q = new LinkedList<Points>();
		Points point = new Points(x, y, L);
		q.add(point);
		
		while(!q.isEmpty()){

			
//			System.out.println(q.toString());
			point = q.poll();
			x = point.x;
			y = point.y;
			L = point.L;
			if(L == -1){
				break;
			}
//			System.out.println(q.toString());
			visit[x][y] = true; 
			
//			System.out.println(result);
			switch(map[x][y]){
				case 1:
					if(x != 0){
						if(visit[x - 1][y] != true && direction(x, y, 1)){
							q.add(new Points(x - 1, y, L - 1));
						}
					}
					if(x != N - 1){
						if(visit[x + 1][y] != true && direction(x, y, 3)){
							q.add(new Points(x + 1, y, L - 1));
						}
					}
					if(y != 0){
						if(visit[x][y - 1] != true && direction(x, y, 2)){
							q.add(new Points(x, y - 1, L - 1));
						}
					}
					if(y != M - 1){
						if(visit[x][y + 1] != true && direction(x, y, 4)){
							q.add(new Points(x, y + 1, L - 1));
						}
					}
					
					break;
				case 2:
					if(x != 0){
						if(visit[x - 1][y] != true && direction(x, y, 1)){
							q.add(new Points(x - 1, y, L - 1));
						}
					}
					if(x != N - 1){
						if(visit[x + 1][y] != true && direction(x, y, 3)){
							q.add(new Points(x + 1, y, L - 1));
						}
					}
					break;
				case 3:
					if(y != 0){
						if(visit[x][y - 1] != true && direction(x, y, 2)){
							q.add(new Points(x, y - 1, L - 1));
						}
					}
					if(y != M - 1){
						if(visit[x][y + 1] != true && direction(x, y, 4)){
							q.add(new Points(x, y + 1, L - 1));
						}
					}
					break;
				case 4:
					if(x != 0){
						if(visit[x - 1][y] != true && direction(x, y, 1)){
							q.add(new Points(x - 1, y, L - 1));
						}
					}
					if(y != M - 1){
						if(visit[x][y + 1] != true && direction(x, y, 4)){
							q.add(new Points(x, y + 1, L - 1));
						}
					}
					break;
				case 5:
					if(x != N - 1){
						if(visit[x + 1][y] != true && direction(x, y, 3)){
							q.add(new Points(x + 1, y, L - 1));
						}
					}
					if(y != M - 1){
						if(visit[x][y + 1] != true && direction(x, y, 4)){
							q.add(new Points(x, y + 1, L - 1));
						}
					}
					break;
				case 6:
					if(x != N - 1){
						if(visit[x + 1][y] != true && direction(x, y, 3)){
							q.add(new Points(x + 1, y, L - 1));
						}
					}
					if(y != 0){
						if(visit[x][y - 1] != true && direction(x, y, 2)){
							q.add(new Points(x, y - 1, L - 1));
						}
					}
					break;
				case 7:
					if(x != 0){
						if(visit[x - 1][y] != true && direction(x, y, 1)){
							q.add(new Points(x - 1, y, L - 1));
						}
					}
					if(y != 0){
						if(visit[x][y - 1] != true && direction(x, y, 2)){
							q.add(new Points(x, y - 1, L - 1));
						}
					}
					break;
				case 0:
					visit[x][y] = false; 
					break;
			}

			
		}
		
		
	}

}
