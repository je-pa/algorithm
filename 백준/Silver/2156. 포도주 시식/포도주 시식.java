import java.io.*;
import java.util.*;

public class Main {

  static int N;
  static StringBuilder result = new StringBuilder();
  static int[] arr;
  static int[][] dp;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
    System.out.println(result);
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    arr = new int[N+1];
    dp = new int[N+1][4];
    for (int i = 1; i <= N; i++) {
      int a = Integer.parseInt(br.readLine());
      arr[i] = a;
    }
  }

  static void pro() {
    if(N==1) {
      result.append(arr[1]);
      return;
    }
    dp[1][0] =0;
    dp[1][1] = arr[1];
    dp[2][0] = arr[1];
    dp[2][1] = arr[2];
    dp[2][2] = arr[2] + arr[1];
    for(int i = 3 ; i <N+1 ; i++){
      dp[i][0] = Math.max(dp[i-1][0],Math.max(dp[i-1][1],dp[i-1][2]));
      dp[i][1] = dp[i-1][0] + arr[i];
      dp[i][2] = Math.max(dp[i-1][1],dp[i-1][3]) + arr[i];
      dp[i][3] = dp[i-2][0] + arr[i];
    }

    int max = Math.max(Math.max(dp[N][0],dp[N][3]), Math.max(dp[N][1], dp[N][2]));
    result.append(max);
  }
}
