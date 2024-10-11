import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] arrs = new int[n][3];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      arrs[i][0] = Integer.parseInt(st.nextToken());
      arrs[i][1] = Integer.parseInt(st.nextToken());
      arrs[i][2] = Integer.parseInt(st.nextToken());
    }
    long k = two(arrs);
    if(k==0){
      System.out.println("NOTHING");
    }else{
      System.out.println(k + " " + count(k, arrs));
    }
  }
  public static long two(int[][] arrs) {
    long left = 0;
    long right = (long)(Integer.MAX_VALUE+(long)1);

    while(left <= right){
      long mid = (left + right) / 2;
      long sum = 0;
      long count =0;
      for(int[] arr : arrs){
        int a = arr[0];
        int c = arr[1];
        int b = arr[2];
        if(a > mid) continue;
        if(c < a) continue;
        if(c < mid) count++;
        sum += Math.max(0, Math.min((mid - a)/b , (c-a)/b) + 1);
      }
      if(sum%2 == 0 && count == arrs.length) return 0;
      if(sum %2 == 1){
        right = mid -1;
      }else{
        left = mid +1;
      }
    }
    return left;
  }
  public static long count(long k, int[][] arrs){
    long count =0 ;
    for(int[] arr : arrs){
      int a = arr[0];
      int c = arr[1];
      int b = arr[2];
      if(a > k || k > c) continue;
      if((k - a)%b == 0) count++;
    }
    return count;
  }
}
