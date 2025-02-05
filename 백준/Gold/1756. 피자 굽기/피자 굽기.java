import java.util.*;
import java.io.*;

public class Main{
    static int D, N;
    static int[] pizza;
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        input(br);
        pro();
    }
    public static void pro(){
        int idx = D;
 
        for(int i =0 ; i<N ; i++){
            while(idx > 0 && dp[idx-1]< pizza[i]){
                idx--;
            }
            if(idx==0) break;
            if(i!=N-1) idx--;
        }
        System.out.print(idx);
    }
    public static void input(BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        pizza = new int[N];
        dp = new int[D];
        
        st = new StringTokenizer(br.readLine());
        int min = Integer.MAX_VALUE;
        for(int i=0 ; i<D ; i++){
            min = Math.min(Integer.parseInt(st.nextToken()), min);
            dp[i] = min;
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<N ; i++){
            pizza[i] = Integer.parseInt(st.nextToken());
        }
        
    }
}