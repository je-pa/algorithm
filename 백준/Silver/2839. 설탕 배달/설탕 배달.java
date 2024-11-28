import java.io.*;
import java.util.*;

public class Main {

  static int N;
  static int[] dp;
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

    dp = new int[Math.max(N+1,6)];
  }

  static void pro() {
    dp[3] = 1;
    dp[5] = 1;
    for(int i=6; i<=N ; i++){
      int a = 5000;
      int b = 5000;
      if(dp[i-3] != 0){
        a = dp[i-3];
      }
      if(dp[i-5] != 0){
        b = dp[i-5];
      }
      if(a==5000 && b==5000){
        continue;
      }
      dp[i] = Math.min(a,b) + 1;

    }
    result.append(dp[N] == 0 ? -1 : dp[N]);
  }
}
