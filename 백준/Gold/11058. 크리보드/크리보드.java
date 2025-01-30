import java.io.*;
import java.util.*;

public class Main {
  public static int N;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  static void input(BufferedReader br) throws Exception {
    N = Integer.parseInt(br.readLine());
  }

  static void pro() {
    long[] dp = new long[101];

    dp[1] = 1;
    dp[2] = 2;
    long c = 1;
    for(int i = 3; i <= N; i++) {
      dp[i] = dp[i-1] + c;
      for(int j = 3; i-j > 0 ; j++){
        if(dp[i] < (j-1)*dp[i-j]){
          c = dp[i-j];
          dp[i] = dp[i-j]*(j-1);
        }
      }
    }
    System.out.println(dp[N]);
  }
}