import java.io.*;
import java.util.*;

public class Main {

  public static int N;
  public static int[] arr;
  public static StringBuilder result = new StringBuilder();

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

  static void pro(){
    int[][] dp = new int[41][2];
    dp[0][0] = 1;
    dp[1][1] = 1;
    for(int i = 2; i < dp.length; i++) {
      dp[i][0] = dp[i-1][0] + dp[i-2][0];
      dp[i][1] = dp[i-1][1] + dp[i-2][1];
    }
    for(int i : arr){
      result.append(dp[i][0]).append(" ").append(dp[i][1]).append("\n");
    }
  }
}
