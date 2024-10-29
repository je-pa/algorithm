import java.io.*;

public class Main {
  public static int N;
  public static int MOD = 1_000_000_009;
  public static int[] dp;
  public static int max = 0;
  public static int[] arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    arr = new int[N];

    for (int i = 0; i < N; i++) {
      int k = Integer.parseInt(br.readLine());
      max = Math.max(max, k);
      arr[i] = k;
    }

    dp = new int[max+1];
    pro();
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < N; i++) {
      sb.append(dp[arr[i]]).append("\n");
    }
    System.out.println(sb);
  }

  public static void pro(){
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4; // 7 13 24 44 81 149 274
    for(int i = 4; i <= max; i++) {
      dp[i] = ((dp[i-1] + dp[i-2]) % MOD + dp[i-3]) % MOD;
    }
  }
}