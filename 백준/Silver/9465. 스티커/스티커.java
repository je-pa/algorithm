import java.util.*;
import java.io.*;

public class Main {
  public static int N;
  public static int result = Integer.MAX_VALUE;
  public static int[][] arr;
  public static int[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for(int i=0 ; i<n ; i++) {
      input(br);
      pro();
      sb.append(result).append("\n");
    }
    System.out.println(sb);
  }
  public static void input(BufferedReader br) throws IOException{
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    arr = new int[2][N];
    dp = new int[N][3];
    for(int i = 0; i < 2; i++){
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < N; j++){
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
  }

  public static void pro(){
    dp[0][0] = 0;
    dp[0][1] = arr[0][0];
    dp[0][2] = arr[1][0];
    for(int i=1 ; i<N ; i++){
      dp[i][0] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][2]);
      dp[i][1] = Math.max(dp[i-1][2] + arr[0][i], dp[i-1][0] + arr[0][i]);
      dp[i][2] = Math.max(dp[i-1][1] + arr[1][i], dp[i-1][0] + arr[1][i]);
    }
    result = Math.max(Math.max(dp[N-1][0], dp[N-1][1]), dp[N-1][2]);
  }
}