import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int K;
  static int[] arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
  }

  static void pro() {
    int[] dp = new int[K+1];
    dp[0] = 1;
    for(int i = 0; i < N; i++) {
      for(int j =arr[i] ; j <= K ; j++){
        dp[j] += dp[j - arr[i]];
      }
    }
    System.out.println(dp[K]);
  }

}
