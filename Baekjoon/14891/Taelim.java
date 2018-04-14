package baek14891;

import java.util.Scanner;

public class Main {
	static int A;
	static int B;
	static int C;
	static int D;
	public static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = Integer.parseInt(sc.nextLine(), 2);
		B = Integer.parseInt(sc.nextLine(), 2);
		C = Integer.parseInt(sc.nextLine(), 2);
		D = Integer.parseInt(sc.nextLine(), 2);
		int result = 0;
		
		int K = sc.nextInt();
		
		for(int i = 0;i < K;i++){
			Point point = new Point(sc.nextInt(), sc.nextInt());
			// 3°ú 7¹øÂ°
			switch(point.x){
				case 1:
					if((1 & (A >> 5)) != (1 & (B >> 1))){
						if((1 & (B >> 5)) != (1 & (C >> 1))){
							if((1 & (C >> 5)) != (1 & (D >> 1)))
								D = shift(D, point.y * -1);
							C = shift(C, point.y);
						}
						B = shift(B, point.y * -1);
					}
					A = shift(A, point.y);
					break;
				case 2:
					if((1 & (B >> 5)) != (1 & (C >> 1))){
						if((1 & (C >> 5)) != (1 & (D >> 1))){
							D = shift(D, point.y);
						}
						C = shift(C, point.y * -1);
					}
					if((1 & (A >> 5)) != (1 & (B >> 1)))
						A = shift(A, point.y * -1);
					B = shift(B, point.y);
					break;
				case 3:
					if((1 & (B >> 5)) != (1 & (C >> 1))){
						if((1 & (A >> 5)) != (1 & (B >> 1))){
							A = shift(A, point.y);
						}
						B = shift(B, point.y * -1);
					}
					if((1 & (C >> 5)) != (1 & (D >> 1)))
						D = shift(D, point.y * -1);
					C = shift(C, point.y);
					break;
				case 4:
					if((1 & (C >> 5)) != (1 & (D >> 1))){
						if((1 & (B >> 5)) != (1 & (C >> 1))){
							if((1 & (A >> 5)) != (1 & (B >> 1)))
								A = shift(A, point.y * -1);
							B = shift(B, point.y);
						}
						C = shift(C, point.y * -1);
					}
					D = shift(D, point.y);
					break;
			}
//			System.out.println("");
//			System.out.println(Integer.toBinaryString(A));
//			System.out.println(Integer.toBinaryString(B));
//			System.out.println(Integer.toBinaryString(C));
//			System.out.println(Integer.toBinaryString(D));
//			System.out.println("check");
		}
		if((A & (1 << 7)) == 128)
			result += 1;
		if((B & (1 << 7)) == 128)
			result += 2;
		if((C & (1 << 7)) == 128)
			result += 4;
		if((D & (1 << 7)) == 128)
			result += 8;
		System.out.println(result);
		sc.close();

	}
	public static int shift(int gear, int dir){
		if(dir == -1)
			gear = (gear >> 7) | ((gear & 127) << 1);
		else
			gear = ((gear & 1) << 7) | (gear >> 1);
		return gear;
	}
}
