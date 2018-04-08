package sw1949;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

public class Main{
	public static int result;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int i = 0;i < T;i++){
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			// 최고 높이 따지기
			int highest = 0;
			// Make map!
			int[][] map = new int[N][N];
			for(int j = 0;j < N;j++){
				for(int k = 0;k < N;k++){
					
					map[j][k] = sc.nextInt();
					if(highest< map[j][k]){
						highest = map[j][k];
					}
				}
			}
			
			
			
			// value of return
			Main.result = 0;
			
			for(int j = 0;j < N;j++){
				for(int k = 0;k < N;k++){
					
					if(highest == map[j][k]){
						
						dfs(j, k, 0, 0, map[j][k], N, K, 1, map);
					}
				}
			}
			System.out.println("#"+(i + 1)+" "+Main.result);
			
		}
		
		
		sc.close();
	}
	
	public static void dfs(int x, int y, int visited, int dig, int previous, int N, int K, int count, int[][] map){
		boolean finish = false;
		if(x > 0 && 3 != visited){
			if(map[x - 1][y] < previous){
				
				dfs(x - 1, y, 1, dig, map[x - 1][y], N, K, count + 1, map);
				finish = true;
			}
			else{
				if(dig == 0 && map[x - 1][y] - K < previous){
					dfs(x - 1, y, 1, dig + 1, previous - 1, N, K, count + 1, map);
					finish = true;
				}
			}
		}
		if(y > 0 && 4 != visited){
			if(map[x][y - 1] < previous){
				
				dfs(x, y - 1, 2, dig, map[x][y - 1], N, K, count + 1, map);
				finish = true;
			}
			else{
				if(dig == 0 && map[x][y - 1] - K < previous){
					dfs(x, y - 1, 2, dig + 1, previous - 1, N, K, count + 1, map);
					finish = true;
				}
			}
		}
		if(x < N - 1 && 1 != visited){
			if(map[x + 1][y] < previous){
				
				dfs(x + 1, y, 3, dig, map[x + 1][y], N, K, count + 1, map);
				finish = true;
			}
			else{
				if(dig == 0 && map[x + 1][y] - K < previous){
					dfs(x + 1, y, 3, dig + 1, previous - 1, N, K, count + 1, map);
					finish = true;
				}
			}
		}
		if(y < N - 1 && 2 != visited){
			if(map[x][y + 1] < previous){
				
				dfs(x, y + 1, 4, dig, map[x][y + 1], N, K, count + 1, map);
				finish = true;
			}
			else{
				if(dig == 0 && map[x][y + 1] - K < previous){
					dfs(x, y + 1, 4, dig + 1, previous - 1, N, K, count + 1, map);
					finish = true;
				}
			}
		}
		if(!finish){
			if(Main.result < count){
				Main.result = count;
			}
		}
	}
}

// Loop failed!
//public class Main{
//  public static void main(String[] args){
//    // Create scanner
//    Scanner sc = new Scanner(System.in);
//    
//    // Test case
//    int T = sc.nextInt();
//    
//    // Run test case
//    for(int i = 1;i <= T;i++){
//      // Map size
//      int N = sc.nextInt();
//      
//      // Insert k
//      int K = sc.nextInt();
//      
//      // Create map
//      // int[][][] map = new int[N][N][2]; --> 방문했음을 남길 이유가 없다!
//      int[][][] map = new int[N][N][2];
//      // Create highest map
//      // List<String> highestMap = new ArrayList<String>();
//      List<Point<Integer, Integer, Integer, Integer, Boolean>> highestMap = new ArrayList<Point<Integer, Integer, Integer, Integer, Boolean>>();
//      
//      // Insert input into map
//      sc.nextLine();
//      
//      int highest = 0;
//      for(int j = 0; j < N;j++){
//
//        String[] rowInts = sc.nextLine().split(" ");
//        
//        for(int k = 0;k < N;k++){
//          int num = Integer.parseInt(rowInts[k]);
//          map[j][k][0] = num;  
//          
//          // Find highest place height
//          if(num > highest){
//            highest = num;
//          }
//        }
//      }
////      System.out.println(Arrays.deepToString(map));
//      // Set information where points are the highest in this map (Set 2 = highest)
//      for(int j = 0; j < N;j++){
//        for(int k = 0;k < N;k++){
//          if(map[j][k][0] == highest){
//            // String hp = j + " " + k;
//            Point<Integer, Integer, Integer, Integer, Boolean> hp = new Point<Integer, Integer, Integer, Integer, Boolean>(j, k, 1, map[j][k][0], true);
////            System.out.println(hp.x+" "+hp.y+" "+hp.way+" "+hp.dig);
//
//            highestMap.add(hp);
//          }
//        }
//      }
//      // Search the longest way
//      int longest = 0;
//      for(Point<Integer, Integer, Integer, Integer, Boolean> hp : highestMap){
//        // Start point
//        // int j = Integer.parseInt(hp.split(" ")[0]);
//        // int k = Integer.parseInt(hp.split(" ")[1]);
//        
//        // int j = hp.x;
//        // int k = hp.y;
//        // System.out.println(hp);
//        int result = pathfinder(hp, map, K, N);
//        if(longest < result){
//          longest = result;
//        }
//  
//      }
//      // Answer
//      System.out.println("#" + i + " " + longest);
//      // System.out.println(highest);
//      // System.out.println(Arrays.deepToString(map));
//      
//
//
//    }
//    sc.close();
//    
//  }
//  // Function : pathfinding for map
//  public static int pathfinder(Point<Integer, Integer, Integer, Integer, Boolean> highest, int[][][] map, int K, int N){
//    // Init stack
//    Stack<Point<Integer, Integer, Integer, Integer, Boolean>> stk = new Stack<Point<Integer, Integer, Integer, Integer, Boolean>>();
//    stk.push(highest);
//
//    // Length of a way
//    int way = 0;
//    while(!stk.empty()){
//      Point<Integer, Integer, Integer, Integer, Boolean> now = stk.pop();
//      
//      System.out.println("popped: "+now.x + " " + now.y + " " + now.point);
//      // Push points where can go
//      int isGo = 0;
//
//      if(now.x != 0){
//    	  if(map[now.x - 1][now.y][1] == 0){
//          if(map[now.x - 1][now.y][0] < now.point){
//            stk.push(new Point<Integer, Integer, Integer, Integer, Boolean>(now.x - 1, now.y, now.way + 1, map[now.x - 1][now.y][0], now.dig));
////            System.out.println("pushed: "+(now.x - 1) + " " + now.y + " " + map[now.x - 1][now.y][0]);
//            isGo++;
//          }
//          else if(now.dig == true && map[now.x - 1][now.y][0] - now.point < K && map[now.x - 1][now.y][0] - now.point >= 0){
//            stk.push(new Point<Integer, Integer, Integer, Integer, Boolean>(now.x - 1, now.y, now.way + 1, now.point - 1, false));
////            System.out.println("pushed: "+(now.x - 1) + " " + now.y + " " + (now.point - 1));
//            isGo++;
//          }
//          map[now.x - 1][now.y][1]++;
//    	  }
//        }
//        if(now.x != N - 1){
//        	if(map[now.x + 1][now.y][1] == 0){
//          if(map[now.x + 1][now.y][0] < now.point){
//            stk.push(new Point<Integer, Integer, Integer, Integer, Boolean>(now.x + 1, now.y, now.way + 1, map[now.x + 1][now.y][0], now.dig));
////            System.out.println("pushed: "+(now.x + 1) + " " + now.y + " " + map[now.x + 1][now.y][0]);
//            isGo++;
//          }
//          else if(now.dig == true && map[now.x + 1][now.y][0] - now.point < K && map[now.x + 1][now.y][0] - now.point >= 0){
//            stk.push(new Point<Integer, Integer, Integer, Integer, Boolean>(now.x + 1, now.y, now.way + 1, now.point - 1, false));
////            System.out.println("pushed: "+(now.x + 1) + " " + now.y + " " + (now.point - 1));
//            isGo++;
//          }
//          map[now.x + 1][now.y][1]++;
//
//        	}
//          
//        }
//        if(now.y != 0){
//        	if(map[now.x][now.y - 1][1] == 0){
//          if(map[now.x][now.y - 1][0] < now.point){
//            stk.push(new Point<Integer, Integer, Integer, Integer, Boolean>(now.x, now.y - 1, now.way + 1, map[now.x][now.y - 1][0], now.dig));
////            System.out.println("pushed: "+now.x + " " + (now.y - 1) + " " + map[now.x][now.y - 1][0]);
//            isGo++;
//          }
//          
//          else if(now.dig == true && map[now.x][now.y - 1][0] - now.point < K && map[now.x][now.y - 1][0] - now.point >= 0){
//            stk.push(new Point<Integer, Integer, Integer, Integer, Boolean>(now.x, now.y - 1, now.way + 1, now.point - 1, false));
////            System.out.println("pushed: "+now.x + " " + (now.y - 1) + " " + (now.point - 1));
//            isGo++;
//          } 
//          map[now.x][now.y - 1][1]++;
//        }
//        }
//        if(now.y != N - 1){
//          if(map[now.x][now.y + 1][1] == 0){
//        	if(map[now.x][now.y + 1][0] < now.point){
//	            stk.push(new Point<Integer, Integer, Integer, Integer, Boolean>(now.x, now.y + 1, now.way + 1, map[now.x][now.y + 1][0], now.dig));
////	            System.out.println("pushed: "+now.x + " " + (now.y + 1) + " " + map[now.x][now.y + 1][0]);
//	            isGo++;
//	          }
//          
//	          else if(now.dig == true && map[now.x][now.y + 1][0] - now.point < K && map[now.x][now.y + 1][0] - now.point >= 0){
//	            stk.push(new Point<Integer, Integer, Integer, Integer, Boolean>(now.x, now.y + 1, now.way + 1, now.point - 1, false));
////	            System.out.println("pushed: "+now.x + " " + (now.y + 1) + " " + (now.point - 1));
//	            isGo++;
//	          }
//        	map[now.x][now.y + 1][1]++;
//          }
//        }
//        if(isGo == 0 && way < now.way){
//          way = now.way;
//          
//        }
//        map[now.x][now.y][1]--;
//    }
//    for(int i = 0; i < N;i++){
//    	for(int j = 0;j < N;j++){
//    		map[i][j][1] = 0;
//    	}
//    }
//    return way;
//        
//  
//    
//  }
//  
//  
//}
//
//// Set point
//class Point<X, Y, WAY, POINT, DIG>{
//  // tuple 개념으로 상수 선언
//  final X x;
//  final Y y;
//  final WAY way;
//  final POINT point;
//  final DIG dig;
//
//  Point(X x, Y y, WAY way, POINT point, DIG dig){
//    this.x = x;
//    this.y = y;
//    this.way = way;
//    this.point = point;
//    this.dig = dig;
//  }
//}