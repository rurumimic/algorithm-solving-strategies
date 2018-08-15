import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        // Input 10 cases
        for(int index = 1;index <= 10;index++){
            // Set maximum dump
            int dump = Integer.parseInt(sc.nextLine());

            // Set min, max value
            int min_val = Integer.MIN_VALUE;
            int max_val = Integer.MAX_VALUE;

            // Result
            int result=0;

            // Set building array
            String[] temp = sc.nextLine().split(" ");
            int arr_len = temp.length;
            int[] building = new int[temp.length];
            for(int i = 0;i<arr_len;i++)
                building[i] = Integer.parseInt(temp[i]);

            // Sort building
            Arrays.sort(building);
            min_val = building[0];
            max_val = building[arr_len-1];

            int min_iter=0;
            int max_iter=arr_len-1;
            while(dump > 0 && (max_val-min_val) > 1 && building[max_iter]!=building[min_iter]){
                if(building[min_iter]==min_val) {
                    building[min_iter]++;
                    min_iter++;
                }
                else if(building[min_iter]>min_val) {

                    min_val++;
                    building[0]++;
                    min_iter=1;
                }

                if(building[max_iter]==max_val){
                    building[max_iter]--;
                    max_iter--;
                }
                else if(building[max_iter]<max_val){
                    max_val--;
                    building[arr_len-1]--;
                    max_iter=arr_len-2;
                }
                dump--;
            }
            Arrays.sort(building);
            result = building[arr_len-1]-building[0];

            System.out.println("#"+index+" "+result);
        }
    }
}
