import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    if(n == 1){
      System.out.println(Integer.parseInt(br.readLine()));
      return;
    }
    int[][] dp = new int[n][2];
    dp[0][0] = Integer.parseInt(br.readLine());
    dp[0][1] = dp[0][0];
    dp[1][0] = Integer.parseInt(br.readLine());
    dp[1][1] = dp[0][0] + dp[1][0];
    for (int i = 2; i < n; i++) {
      int x = Integer.parseInt(br.readLine());
      dp[i][0] = Math.max(dp[i-2][0], dp[i-2][1]) + x;
      dp[i][1] = dp[i-1][0] + x;
    }

    System.out.println(Math.max(dp[n-1][0], dp[n-1][1]));
  }
}