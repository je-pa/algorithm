import java.util.*;
import java.io.*;

public class Main{
    static int D, N;
    static int[] arr;
    static int[] pizza;
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        input(br);
        pro();
    }
    public static void pro(){
        int idx = D-1;
        if(idx == 0 && N == 1 && arr[0] >= pizza[0]) {
            System.out.print(1);
            return;
        }
 
        for(int i =0 ; i<N ; i++){
            if(idx < 0){
                System.out.print(0);
                return;
            }
            while(idx >= 0 && dp[idx]< pizza[i]){
                idx--;
            }
            if(i!=N-1) idx--;
        }
        System.out.print(idx+1);
    }
    public static void input(BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        arr = new int[D];
        pizza = new int[N];
        dp = new int[D];
        
        st = new StringTokenizer(br.readLine());
        int min = Integer.MAX_VALUE;
        for(int i=0 ; i<D ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            min = Math.min(arr[i], min);
            dp[i] = min;
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<N ; i++){
            pizza[i] = Integer.parseInt(st.nextToken());
        }
        
    }
}