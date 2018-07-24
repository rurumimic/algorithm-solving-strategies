import java.util.Arrays;
import java.util.Scanner;

 public class Main
 {  
	public static void main(String[] args)
 	{ 
 		Scanner s = new Scanner(System.in);
 		int c = s.nextInt();
 		for(int i=0;i<c;i++){
 			int n = s.nextInt();
 			int l = s.nextInt();
 			// int[] numbers = new int[n];
 			int[] psum = new int[n];
 			psum[0] = s.nextInt();
 			for(int j = 1;j<n;j++){
 			  // numbers[j] = s.nextInt();
 			  psum[j] = psum[j-1] + s.nextInt();
 			}
 			System.out.printf("%.12f\n", findMin(psum, l));
 			
 		}
		

 	}
 	
 	private static double findMin(int[] psum, int range){
 	  //�κ����� ���� �� �������δ�, ù ��° �迭��Һ��� �������� ���ϰ�, �̸� �迭�� �����Ѵ�. ���ķδ� ����� �������� ���� �������� ���� �� �ִ�.
 	  //ex) {1, 2, 3, 4} -> {1, 3, 6, 10} -> {2, 3}�� ���Ϸ��� 6 - 1 ���ָ� �ȴ�.
 	  double result = Double.MAX_VALUE;
 	  int startPsum = 0;
 	  for(int i=-1;i<psum.length-range;i++){
 	    if(i == -1){
 	      startPsum = 0;
 	    }
 	    else{
 	      startPsum = psum[i];
 	    }
 	    
 	    for(int j = i + range;j<psum.length;j++){
 	      result = Math.min(result, (double)(psum[j] - startPsum) / (j - i));
 	    }
 	    
 	  }
 	  return result;
 	  
    
 	  
 	}
 		
 }