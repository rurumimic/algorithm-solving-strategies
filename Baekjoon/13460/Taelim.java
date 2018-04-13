import java.util.Arrays;
import java.util.Scanner;
public class Main {
	public static int[] visit = new int[10];
	public static String[][] map;
	public static int result = Integer.MAX_VALUE;
	public static int N;
	public static int M;	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int xR = 0, yR = 0, xB = 0, yB = 0;
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		map = new String[N][M];
		for(int i = 0;i < N;i++)
			map[i] = sc.nextLine().split("");	
		for(int i = 0;i < N;i++){
			for(int j = 0;j < M;j++){
				if(map[i][j].equals("R")){
					xR = i;
					yR = j;
				}else if(map[i][j].equals("B")){
					xB = i;
					yB = j;
				}
			}
		}
		explore(xR, yR, xB, yB, 1, "up");
		explore(xR, yR, xB, yB, 1, "down");
		explore(xR, yR, xB, yB, 1, "left");
		explore(xR, yR, xB, yB, 1, "right");
		if(result == Integer.MAX_VALUE){
			result = -1;
		}
		System.out.println(result);
//		System.out.println(Arrays.deepToString(map));
		sc.close();
	}
	public static void explore(int xR, int yR, int xB, int yB, int count, String dir){
		int newR, newB;
		int isMoveR, isMoveB;
		if(dir.equals("up")){
			newR = xR;
			newB = xB;
			isMoveR = isMoveB = 1;
			for(int i = 0;i < N;i++){
				isMoveR = move(newR, newR - 1, yR, dir);
				isMoveB = move(newB, newB - 1, yB, dir);
				if(isMoveR == 1)newR--;
				if(isMoveB == 1)newB--;
				if(isMoveR != 1 && isMoveB != 1)break;
			}
			if(count < 10 && (isMoveR == 0 && isMoveB == 0)){
				explore(newR, yR, newB, yB, count + 1, "left");
				explore(newR, yR, newB, yB, count + 1, "right");	
			}
			else if(isMoveR == 2 && isMoveB == 0) result = Math.min(result, count);
//			System.out.println(result);

			map[newR][yR] = ".";
			map[newB][yB] = ".";
			
		}else if(dir.equals("down")){
			newR = xR;
			newB = xB;
			isMoveR = isMoveB = 1;
			for(int i = 0;i < N;i++){
				isMoveR = move(newR, newR + 1, yR, dir);
				isMoveB = move(newB, newB + 1, yB, dir);
				if(isMoveR == 1)newR++;
				if(isMoveB == 1)newB++;
				if(isMoveR != 1 && isMoveB != 1)break;
			}
			if(count < 10 && (isMoveR == 0 && isMoveB == 0)){
				explore(newR, yR, newB, yB, count + 1, "left");
				explore(newR, yR, newB, yB, count + 1, "right");	
			}else if(isMoveR == 2 && isMoveB == 0) result = Math.min(result, count);
//			System.out.println(result);

			map[newR][yR] = ".";
			map[newB][yB] = ".";
			
		}else if(dir.equals("left")){
			newR = yR;
			newB = yB;
			isMoveR = isMoveB = 1;
			for(int i = 0;i < M;i++){
				isMoveR = move(newR, newR - 1, xR, dir);
				isMoveB = move(newB, newB - 1, xB, dir);
				if(isMoveR == 1)newR--;
				if(isMoveB == 1)newB--;
				if(isMoveR != 1 && isMoveB != 1)break;
			}
			if(count < 10 && (isMoveR == 0 && isMoveB == 0)){
				explore(xR, newR, xB, newB, count + 1, "up");
				explore(xR, newR, xB, newB, count + 1, "down");	
			}else if(isMoveR == 2 && isMoveB == 0) result = Math.min(result, count);
//			System.out.println(result);

			map[xR][newR] = ".";
			map[xB][newB] = ".";
			
		}else if(dir.equals("right")){
			newR = yR;
			newB = yB;
			isMoveR = isMoveB = 1;
			for(int i = 0;i < M;i++){
				isMoveR = move(newR, newR + 1, xR, dir);
				isMoveB = move(newB, newB + 1, xB, dir);
				if(isMoveR == 1)newR++;
				if(isMoveB == 1)newB++;
				if(isMoveR != 1 && isMoveB != 1)break;
			}
			if(count < 10 && (isMoveR == 0 && isMoveB == 0)){
				explore(xR, newR, xB, newB, count + 1, "up");
				explore(xR, newR, xB, newB, count + 1, "down");	
			}else if(isMoveR == 2 && isMoveB == 0) result = Math.min(result, count);
//			System.out.println(result);

			map[xR][newR] = ".";
			map[xB][newB] = ".";
			
		}
		map[xR][yR] = "R";
		map[xB][yB] = "B";
	}
	public static int move(int oldP, int newP, int fixed, String dir){
		if((dir.equals("up") && newP >= 0) || (dir.equals("down") && newP < N)){
			if(map[newP][fixed].equals(".")){
				String temp = map[newP][fixed];
				map[newP][fixed] = map[oldP][fixed];
				map[oldP][fixed] = temp;
				return 1;
			}else if(map[newP][fixed].equals("O")){
				map[oldP][fixed] = ".";
				return 2;
			}else return 0;
				
		}else if((dir.equals("left") && newP >= 0) || (dir.equals("right") && newP < M)){
			if(map[fixed][newP].equals(".")){
				String temp = map[fixed][newP];
				map[fixed][newP] = map[fixed][oldP];
				map[fixed][oldP] = temp;
				return 1;
			}else if(map[fixed][newP].equals("O")){
				map[fixed][oldP] = ".";
				return 2;
			}else return 0;
		}else return 0;	
	}
}
