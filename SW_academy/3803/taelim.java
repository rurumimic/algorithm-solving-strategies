import java.util.Arrays;
import java.util.Scanner;

public class Solution{
  //static long[][] comb = new long[2501][2501];
  public static void main(String[] args) throws Exception{
    Scanner sc = new Scanner(System.in);
    int T;
    T = sc.nextInt();
    long[][] comb = new long[2501][2501];
    long mod = 1000000007;
    comb[1][1] = comb[1][0] = 1;
    for(int i = 2;i <= 2500;i++){
        comb[i][0] = comb[i][i] = 1;
        comb[i][1] = comb[i][i - 1] = i;
      for(int j = 1;j <=i;j++){
        comb[i][j] = (comb[i - 1][j] + comb[i - 1][j - 1]) % mod;
      }
    }
    for(int test_case = 1; test_case <= T; test_case++){  
      int R = sc.nextInt();
      int C = sc.nextInt();
      int K = sc.nextInt();
      
      long result = 0;
    
      // case 0 : 가로나 세로가 1일 경우
      if(R == 1 || C == 1){
        if(K == 1 && R == C){
          result = 1;
        }
        else if(K == 1){
          result = 0;
        }
        else{
          result = combination(R * C - 2, K - 2, comb) % mod;
        }
      }
      else{
        
// case 1 : 대각선 4
        long case_1 = combination(R * C - 4, K - 4, comb);
        // case 2 : 대각선 3
        long case_2 = 4 * combination(R * C - 4, K - 3, comb);
        // case 3 : 대각선 2, 반대편에 위치
        long case_3 = 2 * combination(R * C - 4, K - 2, comb);
        // case 4 : 대각선 2, 같은쪽에 위치
        long case_4 = 2 * (2 * combination(R * C - 4, K - 2, comb) % mod - combination(R * C - 2 - R, K - 2, comb) % mod + mod + mod - combination(R * C - 2 - C, K - 2, comb) % mod) % mod;
        // case 5 : 대각선 1
        long case_5 = 4 * (combination(R * C - 4, K - 1, comb) % mod - combination(R * C - 2 - R, K - 1, comb) % mod + mod - combination(R * C - 2 - C, K - 1, comb) % mod + mod +  combination(R * C - R - C, K - 1, comb) % mod) % mod;
        // case 6 : 대각선 0 - 이 케이스에서 계산이 진짜 거의 불가능 수준...
        long case_6 = (combination(R * C - 4, K, comb) % mod - 2 * (combination(R * C - R - 2, K, comb) % mod + combination(R * C - C - 2, K, comb) % mod) % mod + mod + 4 * combination(R * C - R - C, K, comb) % mod - 2 *(combination(R * C - 2 * C - R + 2, K, comb) % mod + mod + combination(R * C - 2 * R - C + 2, K, comb) % mod) % mod + combination(R * C - 2 * C, K, comb) % mod + combination(R * C - 2 * R, K, comb) % mod + combination(R * C - 2 * C - 2 * R + 4, K, comb) % mod) % mod;

        // System.out.println(case_1+" "+case_2+" "+case_3+" "+case_4+" "+case_5+" "+case_6);
        result = (case_1 + case_2 + case_3 + case_4 + case_5 + case_6) % mod;

      }

      System.out.println("#"+test_case+" "+result);

    }

  }

  // 매번 할 때 마다 조합배열을 구하지 말고 50 X 50 의 조합 식들을 미리 구해놓는다면?



  public static long combination(int a, int b, long[][] comb){
    // 역으로 올라가며 합치는 Dynamic programming 하면 되는 것을...
    
    
    if(a < b || a < 0 || b < 0){
      return 0;
    }
    else if(a == 0){
      return 1;
    }
   // long result = 0;
    //int mod = 1000000007;

    
    
    //for(int i = 2;i <= a;i++){
        //comb[i][0] = comb[i][i] = 1;
       // comb[i][1] = comb[i][i - 1] = i;
     // for(int j = 0;j <= i;j++){
    //    if(comb[i][j] == 0){
          //if(i == j || j == 0){
            //comb[i][j] = 1;
          //}
          //else if(j == 1 || i - j == 1){
            //comb[i][j] = i;
          //}
          //else{
      //      comb[i][j] = (comb[i - 1][j] + comb[i - 1][j - 1]) % mod;
          //}
     //   }
  //    }
 //   }
    
    return comb[a][b];

    
  }
}
