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
    
      // case 0 : ���γ� ���ΰ� 1�� ���
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
        
// case 1 : �밢�� 4
        long case_1 = combination(R * C - 4, K - 4, comb);
        // case 2 : �밢�� 3
        long case_2 = 4 * combination(R * C - 4, K - 3, comb);
        // case 3 : �밢�� 2, �ݴ��� ��ġ
        long case_3 = 2 * combination(R * C - 4, K - 2, comb);
        // case 4 : �밢�� 2, �����ʿ� ��ġ
        long case_4 = 2 * (2 * combination(R * C - 4, K - 2, comb) % mod - combination(R * C - 2 - R, K - 2, comb) % mod + mod + mod - combination(R * C - 2 - C, K - 2, comb) % mod) % mod;
        // case 5 : �밢�� 1
        long case_5 = 4 * (combination(R * C - 4, K - 1, comb) % mod - combination(R * C - 2 - R, K - 1, comb) % mod + mod - combination(R * C - 2 - C, K - 1, comb) % mod + mod +  combination(R * C - R - C, K - 1, comb) % mod) % mod;
        // case 6 : �밢�� 0 - �� ���̽����� ����� ��¥ ���� �Ұ��� ����...
        long case_6 = (combination(R * C - 4, K, comb) % mod - 2 * (combination(R * C - R - 2, K, comb) % mod + combination(R * C - C - 2, K, comb) % mod) % mod + mod + 4 * combination(R * C - R - C, K, comb) % mod - 2 *(combination(R * C - 2 * C - R + 2, K, comb) % mod + mod + combination(R * C - 2 * R - C + 2, K, comb) % mod) % mod + combination(R * C - 2 * C, K, comb) % mod + combination(R * C - 2 * R, K, comb) % mod + combination(R * C - 2 * C - 2 * R + 4, K, comb) % mod) % mod;

        // System.out.println(case_1+" "+case_2+" "+case_3+" "+case_4+" "+case_5+" "+case_6);
        result = (case_1 + case_2 + case_3 + case_4 + case_5 + case_6) % mod;

      }

      System.out.println("#"+test_case+" "+result);

    }

  }

  // �Ź� �� �� ���� ���չ迭�� ������ ���� 50 X 50 �� ���� �ĵ��� �̸� ���س��´ٸ�?



  public static long combination(int a, int b, long[][] comb){
    // ������ �ö󰡸� ��ġ�� Dynamic programming �ϸ� �Ǵ� ����...
    
    
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
