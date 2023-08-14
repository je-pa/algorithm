import java.util.*;
import java.io.*;

public class Main {
    private static final int DIGIT = 20;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr= new int[n];
        int max = 0;

        for(int i = 0 ; i<n ; i++){
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(arr[i], max);
        }
        long answer = 0;
        int k=0;
        while(max != 0){
            int count1 = 0;
            for(int i=0; i <arr.length ;i++){
                if(arr[i] == 0)continue;
                if((arr[i] & (1 << k)) == 0) count1++;
            }
            answer += (1L << k) * count1 * (n - count1);
            max/=2;
            k++;
        }

        System.out.print(arr.length==1 ? arr[0] : answer);
    }
}