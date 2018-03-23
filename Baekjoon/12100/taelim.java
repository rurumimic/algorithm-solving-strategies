import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;
public class Main{
    public static void main(String[] args) throws Exception{

    Scanner sc = new Scanner(System.in);
    
    int T = sc.nextInt();
    int[][] arr = new int[T][T];
    int[][] temp = new int[T][T];
    // int[][] ans = new int[T][T];
    Stack<Integer> visit = new Stack<Integer>();
    
    for(int i = 0;i < T;i++){
      for(int j = 0;j < T;j++){
        arr[i][j] = sc.nextInt();
      }
    }
    
    // 북서남동 = 0, 1, 2, 3
    
    Stack<int[][]> stack = new Stack<int[][]>();
    stack.push(arr);
    
    // System.arraycopy(stack.pop(), 0, ans, 0, ans.length);
    // ans[0][0] = 0;
    // System.out.println(Arrays.deepToString(ans));
    // System.out.println(Arrays.deepToString(arr));
    
    visit.push(0);
    
    int result = 0;
    while(!stack.empty()){
      
      // System.out.println(Arrays.deepToString(ans));
      temp = stack.pop();
      // System.out.println(Arrays.deepToString(temp));
      // for(int i = 0;i < T;i++){
      //   for(int j = 0;j < T;j++){
      //     ans[i][j] = temp[i][j];
      //   }
      // }
      
      // ans = stack.pop();
      int x = 0; // 현재 위치 나타냄
      int level = visit.pop(); // 레벨 초기화
      if(level <= 4){
        for(int i = 0;i < 4;i++){
          // System.arraycopy(temp, 0, ans, 0, ans.length);
          int[][] ans = new int[T][T];
          for(int j = 0;j < T;j++){
            for(int k = 0;k < T;k++){
              ans[j][k] = temp[j][k];
            }
          }
          // 서
if(i == 0){
            x = 0;
            for(int j = 0;j < T;j++){
              for(int k = 1;k < T;k++){
                if(ans[j][k] != 0){
                  if(ans[j][x] == 0){
                    ans[j][x] = ans[j][k];
                    ans[j][k] = 0;
                    
                  }
                  else if(ans[j][x] == ans[j][k]){
                    ans[j][x] += ans[j][k];
                    ans[j][k] = 0;
                  
                    x++;

                  }
                  else if(ans[j][x] != ans[j][k]){
                    ans[j][x + 1] = ans[j][k];
                    if(x + 1 != k){
                      ans[j][k] = 0;
                   
                    }
                    x++;
                  }

                  
                    
                }
              }
              x = 0;
            }
          }
          //
          if(i == 1){
            x = 0;
            for(int j = 0;j < T;j++){
              for(int k = 1;k < T;k++){
                if(ans[k][j] != 0 && ans[x][j] == 0){
                  ans[x][j] = ans[k][j];
                  ans[k][j] = 0;
                  
                }
                else if(ans[k][j] != 0 && ans[x][j] == ans[k][j]){
                  ans[x][j] += ans[k][j];
                  ans[k][j] = 0;
                  x++;
                }
                else if(ans[k][j] != 0 && ans[x][j] != ans[k][j]){
                  ans[x + 1][j] = ans[k][j];
                  if(x + 1 != k){
                    ans[k][j] = 0;
                 
                  }
                  x++;
                }


              }
              x = 0;
            }
          }
          if(i == 2){
            x = T - 1;
            for(int j = T - 1;j >= 0;j--){
              for(int k = T - 2;k >= 0;k--){
                if(ans[j][k] != 0 && ans[j][x] == 0){
                  ans[j][x] = ans[j][k];
                  ans[j][k] = 0;
                  
                }
                
                else if(ans[j][k] != 0 && ans[j][x] != ans[j][k]){
                  ans[j][x - 1] = ans[j][k];
                  if(x - 1 != k){
                    ans[j][k] = 0;
                 
                  }
                  
                  x--;
                }
                else if(ans[j][k] != 0 && ans[j][x] == ans[j][k]){
                  ans[j][x] += ans[j][k];
                  ans[j][k] = 0;
                  x--;
                }

              }
              x = T - 1;
            }
          }
          if(i == 3){
            x = T - 1;
            for(int j = T - 1;j >= 0;j--){
              for(int k = T - 2;k >= 0;k--){
                if(ans[k][j] != 0 && ans[x][j] == 0){
                  ans[x][j] = ans[k][j];
                  ans[k][j] = 0;
                  
                }
                
                else if(ans[k][j] != 0 && ans[x][j] != ans[k][j]){
                  ans[x - 1][j] = ans[k][j];
                  if(x - 1 != k){
                    ans[k][j] = 0;
                 
                  }
                  
                  x--;
                }
                else if(ans[k][j] != 0 && ans[x][j] == ans[k][j]){
                  ans[x][j] += ans[k][j];
                  ans[k][j] = 0;
                  x--;

                }

              }
              x = T - 1;
            }
          }
          stack.push(ans);

          // System.out.println(Arrays.deepToString(ans));
          visit.push(level + 1);
          // System.out.println(level);
          
        }
        // System.out.println("=======================================");
        

      }
      
      else{

        
        
        for(int i = 0;i < T;i++){
          for(int j = 0;j < T;j++){
            // System.out.println(temp[i][j]);
            if(result < temp[i][j]){
              result = temp[i][j];
            }
          }
        }
        // System.out.println("=================");
        
        // other way
        
        // Arrays.sort(ans);
        // result = ans[0][0];

        // visit.pop();
      }
    }
    System.out.println(result);
    
  
    }
}