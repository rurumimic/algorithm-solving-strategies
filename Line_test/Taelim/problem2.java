package kakao1802;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		final class Point{
			int x;
			int y;
			Point(int x, int y){
				this.x = x;
				this.y = y;
			}
			
		}
		
		final class Store{
			int x;
			int y;
			String name;
			int coupon;
			int dist;
			Store(int x, int y, String name, int coupon, int dist){
				this.x = x;
				this.y = y;
				this.name = name;
				this.coupon = coupon;
				this.dist = dist;
			}
			
		}
		
		Point user = new Point(sc.nextInt(), sc.nextInt());
//		System.out.println(user.x+" "+user.y);
		int TC = sc.nextInt();
		sc.nextLine();
		Store[] store_arr = new Store[TC];
		for(int i = 0;i < TC;i++){
			String[] input_arr = sc.nextLine().split(" ");
			int x = Integer.parseInt(input_arr[0]);
			int y = Integer.parseInt(input_arr[1]);
			store_arr[i] = new Store(x, y, input_arr[2], Integer.parseInt(input_arr[3]), (int)(Math.sqrt((Math.pow(user.x - x, 2) + (Math.pow(user.y - y, 2))))) / 100 * 100);
		}
		
		Arrays.sort(store_arr, new Comparator<Store>(){

			@Override
			public int compare(Store s1, Store s2) {
				// TODO Auto-generated method stub
				if(s1.dist > s2.dist){
					return 1;
				}
				else if(s1.dist < s2.dist){
					return -1;
				}
				else{
					if(s1.coupon < s2.coupon){
						return 1;
					}
					else if(s1.coupon > s2.coupon){
						return -1;
					}
					else{
						return s1.name.compareTo(s2.name);
					}
				}
			}
			
			
		});
		for(int i = 0;i < TC;i++){
			System.out.println(store_arr[i].x+" "+store_arr[i].y+" "+store_arr[i].name+" "+store_arr[i].coupon+" "+store_arr[i].dist);
		}
		

	}

}
