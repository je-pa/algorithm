import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[][] dp = new int[n+1][10];
    for(int i = 1; i < n+1; i++){
      dp[i][0] = 1;
    }
    for(int i=1 ;i<10; i++){
      dp[1][i] = 1;
    }

    for (int i = 2; i < n+1; i++) {
      for (int j = 1; j < 10; j++) {
        dp[i][j] = dp[i-1][j] + dp[i][j-1];
        dp[i][j] %= 10_007;
      }
    }
    int sum =0;
    for(int i=0 ;i<10 ;i++){
      sum+=dp[n][i];
      sum%=10_007;
    }

    System.out.println(sum);
  }
}
