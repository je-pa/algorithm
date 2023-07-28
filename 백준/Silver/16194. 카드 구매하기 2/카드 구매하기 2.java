import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] d = new int[n+1];
        int[] arr = new int[n+1];
        for(int i=1 ; i<=n ; i++){
            arr[i] = scan.nextInt();
            d[i] = n*10000;
        }
        for(int i = 1 ; i<= n ; i++){
            for(int j = 1 ; j<=i ; j++){
                d[i] = Math.min(d[i], d[i-j]+ arr[j]);
            }
        }
        System.out.println(d[n]);
        
    }
}