package baek14500;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arr = sc.nextLine().split(" ");
		int N = Integer.parseInt(arr[0]);
		int M = Integer.parseInt(arr[1]);
		int[][] map = new int[N][M];
		for(int i = 0;i < N;i++){
			arr = sc.nextLine().split(" ");
			for(int j = 0;j < M;j++)
				map[i][j] = Integer.parseInt(arr[j]);
		}
		int result = Integer.MIN_VALUE;
		for(int i = 0;i < N;i++)
			for(int j = 0;j < M - 3;j++)
				result = Math.max(result, map[i][j] + map[i][j+1] + map[i][j+2] + map[i][j+3]);	
		for(int i = 0;i < N - 3;i++)
			for(int j = 0;j < M;j++)
				result = Math.max(result, map[i][j] + map[i+1][j] + map[i+2][j] + map[i+3][j]);
		for(int i = 0;i < N - 1;i++)
			for(int j = 0;j < M - 1;j++)
				result = Math.max(result, map[i][j] + map[i+1][j] + map[i][j+1] + map[i+1][j+1]);
		for(int i = 0;i < N - 1;i++)
			for(int j = 0;j < M - 2;j++)
				result = Math.max(result, map[i][j] + map[i+1][j] + map[i][j+1] + map[i][j+2]);	
		for(int i = 0;i < N - 1;i++)
			for(int j = 0;j < M - 2;j++)
				result = Math.max(result, map[i][j] + map[i+1][j+2] + map[i][j+1] + map[i][j+2]);
		for(int i = 0;i < N - 1;i++)
			for(int j = 0;j < M - 2;j++)
				result = Math.max(result, map[i+1][j] + map[i][j] + map[i+1][j+1] + map[i+1][j+2]);	
		for(int i = 0;i < N - 1;i++)
			for(int j = 0;j < M - 2;j++)
				result = Math.max(result, map[i+1][j] + map[i][j+2] + map[i+1][j+1] + map[i+1][j+2]);	
		for(int i = 0;i < N - 2;i++)
			for(int j = 0;j < M - 1;j++)
				result = Math.max(result, map[i][j] + map[i+2][j+1] + map[i+1][j] + map[i+2][j]);	
		for(int i = 0;i < N - 2;i++)
			for(int j = 0;j < M - 1;j++)
				result = Math.max(result, map[i][j] + map[i][j+1] + map[i+1][j] + map[i+2][j]);	
		for(int i = 0;i < N - 2;i++)
			for(int j = 0;j < M - 1;j++)
				result = Math.max(result, map[i][j+1] + map[i][j] + map[i+1][j+1] + map[i+2][j+1]);	
		for(int i = 0;i < N - 2;i++)
			for(int j = 0;j < M - 1;j++)
				result = Math.max(result, map[i][j+1] + map[i+2][j] + map[i+1][j+1] + map[i+2][j+1]);	
		for(int i = 0;i < N - 2;i++)
			for(int j = 0;j < M - 1;j++)
				result = Math.max(result, map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+2][j+1]);	
		for(int i = 0;i < N - 2;i++)
			for(int j = 0;j < M - 1;j++)
				result = Math.max(result, map[i][j+1] + map[i+1][j] + map[i+1][j+1] + map[i+2][j]);	
		for(int i = 0;i < N - 1;i++)
			for(int j = 0;j < M - 2;j++)
				result = Math.max(result, map[i+1][j] + map[i+1][j+1] + map[i][j+1] + map[i][j+2]);	
		for(int i = 0;i < N - 1;i++)
			for(int j = 0;j < M - 2;j++)
				result = Math.max(result, map[i][j] + map[i+1][j+1] + map[i][j+1] + map[i+1][j+2]);	
		for(int i = 0;i < N - 1;i++)
			for(int j = 0;j < M - 2;j++)
				result = Math.max(result, map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j+1]);	
		for(int i = 0;i < N - 1;i++)
			for(int j = 0;j < M - 2;j++)
				result = Math.max(result, map[i+1][j] + map[i+1][j+1] + map[i+1][j+2] + map[i][j+1]);	
		for(int i = 0;i < N - 2;i++)
			for(int j = 0;j < M - 1;j++)
				result = Math.max(result, map[i][j] + map[i+1][j] + map[i+2][j] + map[i+1][j+1]);	
		for(int i = 0;i < N - 2;i++)
			for(int j = 0;j < M - 1;j++)
				result = Math.max(result, map[i][j+1] + map[i+1][j+1] + map[i+2][j+1] + map[i+1][j]);	
		System.out.println(result);
		sc.close();
	}
}