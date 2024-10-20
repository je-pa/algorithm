import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[12];
        arr[1]=1;
        arr[2]=2;
        arr[3]=4;
        for(int i = 4 ; i<12 ; i++){
            arr[i]=arr[i-3]+arr[i-2]+arr[i-1];
        }
        for(int i=0 ; i<N ; i++){
            int num = Integer.parseInt(br.readLine());
            sb.append(arr[num]).append('\n');
        }
        System.out.println(sb);
    }
}
