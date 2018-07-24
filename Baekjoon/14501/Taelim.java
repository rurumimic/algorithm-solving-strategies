import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result = 0;
		int[][] job = new int[N][3];
		for(int i = 0;i < N;i++){
			job[i][0] = sc.nextInt();
			job[i][1] = sc.nextInt();
			if(job[i][0] + i > N)
				continue;
			int temp = 0;
			for(int j = 0;j < i;j++)
				if(job[j][0] + j <= i)temp = temp < job[j][2] ? job[j][2] : temp;
			job[i][2] = temp + job[i][1];
			result = Math.max(result, job[i][2]);
		}
		System.out.println(result);
		sc.close();
	}
}