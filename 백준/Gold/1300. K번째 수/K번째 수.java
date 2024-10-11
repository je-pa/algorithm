import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());

    System.out.println(two(n, m));
  }
  public static long two(int n, int m) {
    int left = 0;
    int right = Integer.MAX_VALUE;

    while(left <= right){
      int mid = (left + right) / 2;
      long sum = 0;
      for(int i = 1; i <= n; i++){
        sum += Math.min(mid / i, n);
      }

      if(sum >= m){
        right = mid -1;
      }else{
        left = mid +1;
      }
    }
    return left;
  }

}
