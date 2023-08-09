import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = -1_000_000;
        int min = 1_000_000;
        
        for(int i = 0 ; i < n ; i++)
        {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        System.out.println(min + " " + max);
    }
}