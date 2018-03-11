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
 			System.out.printf("%.10f\n", findMin(psum, l));
 			
 		}
		

 	}
 	
 	private float findMin(int[] psum, int range){
 	  //부분합을 구할 때 꿀팁으로는, 첫 번째 배열요소부터 누적합을 구하고, 이를 배열에 저장한다. 이후로는 저장된 누적합을 통해 범위합을 구할 수 있다.
 	  //ex) {1, 2, 3, 4} -> {1, 3, 6, 10} -> {2, 3}합 구하려면 6 - 1 해주면 된다.
 	  float result = Float.MAX_VALUE;
 	  int startPsum = 0;
 	  for(int i=-1;i<psum.length-range;i++){
 	    if(i == -1){
 	      startPsum = 0;
 	    }
 	    else{
 	      startPsum = psum[i];
 	    }
 	    
 	    for(int j = i + range;j<psum.length;j++){
 	      result = Math.min(result, (float)(psum[j] - startPsum) / (j - i));
 	    }
 	    
 	  }
 	  return result;
 	  
    
 	  
 	}
 		
 }