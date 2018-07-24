import java.util.Arrays;
import java.util.Scanner;

class Solution{
  public static void main(String[] args){

    Scanner sc = new Scanner(System.in);
    for(int i = 0;i<10;i++){
      int width = sc.nextInt();
      int[] buildings = new int[width];
      for(int j = 0;j<width;j++){
        buildings[j] = sc.nextInt();
      }
      System.out.println("#"+(i+1)+" "+findSight(buildings));
      
      
    }
    sc.close();
  }
  
  public static int findSight(int[] buildings){
    int sumSights = 0;
    for(int i = 2;i<buildings.length-2;i++){
      int highestBuilding = Math.max(Math.max(Math.max(buildings[i-2], buildings[i-1]), buildings[i+1]), buildings[i+2]);
      if(highestBuilding < buildings[i]){
        sumSights += (buildings[i] - highestBuilding);
      }
    }
    return sumSights;
  }
}
