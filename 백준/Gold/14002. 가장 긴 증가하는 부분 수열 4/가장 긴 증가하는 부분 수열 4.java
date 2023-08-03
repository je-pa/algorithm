import java.util.*;
import java.io.*;

public class Main{
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
        int maxLen = d[0];
        int maxIndex = 0;
        for(int i=1 ; i<d.length ; i++){
            if(maxLen < d[i]){
                maxLen = d[i];
                maxIndex = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        int num = arr[maxIndex];
        Stack<Integer> s = new Stack<>();
        s.push(arr[maxIndex]);
        int count = d[maxIndex] - 1;
        for(int i = maxIndex ; i>=0 ; i--){
            if(num > arr[i] && d[i] == count){
                num = arr[i];
                count--;
                s.push(arr[i]);
            }
        }
        while(!s.empty()){
            sb.append(s.pop()).append(" ");
        }
        System.out.println(maxLen);
        System.out.println(sb);
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