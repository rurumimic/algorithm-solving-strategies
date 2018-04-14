package baek14888;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] number = new int[N];
		for(int i = 0;i < N;i++)
			number[i] = sc.nextInt();
		List<Integer> operand = new ArrayList<Integer>();
		for(int i = 0;i < 4;i++){
			int countOp = sc.nextInt();
			for(int j = 0;j < countOp;j++){
				operand.add(i);
			}
		}
		Integer[] operandArray = operand.toArray(new Integer[operand.size()]);
		Arrays.sort(operandArray);
		int resultMax = Integer.MIN_VALUE;
		int resultMin = Integer.MAX_VALUE;
		boolean isEnd = false;
		while(!isEnd){
			int result = number[0];
			for(int i = 0;i < operandArray.length;i++){
				if(operandArray[i] == 0)
					result = result + number[i + 1];
				else if(operandArray[i] == 1)
					result = result - number[i + 1];
				else if(operandArray[i] == 2)
					result = result * number[i + 1];
				else if(operandArray[i] == 3)
					result = result / number[i + 1];
			}
			for(int i = operandArray.length - 1;i > 0;i--){
				if(operandArray[i] > operandArray[i - 1]){
					for(int j = operandArray.length - 1;j >= i;j--){
						if(operandArray[j] > operandArray[i - 1]){
							int temp = operandArray[i - 1];
							operandArray[i - 1] = operandArray[j];
							operandArray[j] = temp;
							Arrays.sort(operandArray, i, operandArray.length);
							break;
						}				
					}
					break;
				}
				if(i == 1)
					isEnd = true;
			}
			if(operandArray.length == 1){
				isEnd = true;
			}
			
			resultMax = Math.max(resultMax, result);
			resultMin = Math.min(resultMin, result);
		}
		System.out.println(resultMax);
		System.out.println(resultMin);
		sc.close();
	}
}
