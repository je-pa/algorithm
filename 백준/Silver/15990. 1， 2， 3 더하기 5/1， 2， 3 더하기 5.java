import java.io.*;
import java.util.*;

public class Main {

  static int N;
  static int MOD = 1_000_000_009;
  static int[] arr;

  static StringBuilder result = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
    System.out.println(result);
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    arr = new int[N];
    for(int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
  }

  static void pro() {
    int[][] dp = new int[100_001][4];
    dp[1][1] = 1;
    dp[2][2] = 1;
    dp[3][1] = 1;
    dp[3][2] = 1;
    dp[3][3] = 1;
    for(int i = 4; i < 100_001; i++) {
      dp[i][1] = dp[i-1][2] + dp[i-1][3];
      dp[i][1] %= MOD;
      dp[i][2] = dp[i-2][1] + dp[i-2][3];
      dp[i][2] %= MOD;
      dp[i][3] = dp[i-3][1] + dp[i-3][2];
      dp[i][3] %= MOD;
    }
    for(int i : arr){
      int sum = 0;
      for(int j : dp[i]){
        sum += j;
        sum %= MOD;
      }
      result.append(sum).append("\n");
    }
  }
}
