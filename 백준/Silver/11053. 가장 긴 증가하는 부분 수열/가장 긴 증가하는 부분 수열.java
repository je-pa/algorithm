import java.util.*;
import java.io.*;

class Main{
    static int[] arr;
    static int[] d;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        d = new int[arr.length];
        
        for(int i = 0 ; i<arr.length ; i++){
            L(i);
        }
        int max = d[0];
        for(int i=1 ; i<d.length ; i++){
            max = Math.max(max, d[i]);
        }
        System.out.println(max);
    }
    
    public static int L(int n){
        if(d[n]==0){
            d[n]=1;
            for(int i = n-1 ; i>=0 ; i--){
                if(arr[i]<arr[n]) d[n] = Math.max(d[n], L(i)+1);
            }
        }
        return d[n];
    }
}