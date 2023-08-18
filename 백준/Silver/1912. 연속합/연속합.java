import java.util.*;
import java.io.*;
class Main{
    static Integer[] d;
    static int[] arr;
    static int N;
    static int max;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        d = new Integer[N];
        d[0] = arr[0];
        max = arr[0];
        
        re(N-1);
        System.out.print(max);
    }
    public static int re(int i){
        if(d[i] == null){
            d[i] = Math.max(re(i-1)+arr[i], arr[i]);
            max = Math.max(max, d[i]);
        }
        return d[i];
    }
}