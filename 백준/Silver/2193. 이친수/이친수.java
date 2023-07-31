import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if(n<=2){
            System.out.println(1);
            return;
        }
        long[][] d = new long[n+1][2];
        d[1][1] = 1;
        d[2][0] = 1;
        d[3][0] = 1;
        d[3][1] = 1;
        
        for(int i = 4 ; i <= n ; i++){
            d[i][0] = d[i-1][0] + d[i-1][1];
            d[i][1] = d[i-1][0];
        }
        System.out.println(d[n][0]+d[n][1]);
    }
}