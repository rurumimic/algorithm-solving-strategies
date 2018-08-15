import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int SIZE = 100;
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        for(int index=1;index <=10;index++){
            sc.nextLine();
            
            // Answer
            int result = 0;

            // Map : map[Y][X]
            String[][] map = new String[SIZE][SIZE];

            for(int i = 0;i<SIZE;i++){
                map[i] = sc.nextLine().split(" ");
            }
            // Tool
            Tool tool = new Tool(map, SIZE);

            result = tool.findStart();

            System.out.println("#"+index+" "+result);
            // System.out.println(Arrays.deepToString(map));
        }

    }
}

class Tool{
    int startX;

    int SIZE;
    String[][] map;
    Tool(String[][] map, int SIZE){
        this.map = map;
        this.SIZE = SIZE;
        for(int i = 0;i<SIZE;i++){
            if(map[SIZE-1][i].equals("2")){
                this.startX=i;
            }
        }
    }

    int findStart(){
        int x=this.startX;
        int y=this.SIZE-1;
        while(y>0){
            if(x > 0 && x < this.SIZE-1){
                if(this.map[y][x-1].equals("1")){
                    while(this.map[y][x-1].equals("1")) {
                        x--;
                        if(x==0)break;

                    }

                }
                else if(this.map[y][x+1].equals("1")){
                    while(this.map[y][x+1].equals("1")) {
                        
                        x++;
                        if(x==this.SIZE-1)break;
                    }
                }
            }
            else if(x == 0){
                if(this.map[y][x+1].equals("1")){
                    while(this.map[y][x+1].equals("1")) {
                        
                        x++;
                        if(x==this.SIZE-1)break;
                    }
                }
            }
            else if(x == this.SIZE-1) {
                if(this.map[y][x-1].equals("1")){
                    while(this.map[y][x-1].equals("1")) {
                        
                        x--;
                        if(x==0)break;

                    }
                }
            }
            y--;


        }
        return x;
    }
}