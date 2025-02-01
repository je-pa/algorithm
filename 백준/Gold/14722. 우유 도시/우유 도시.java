import java.io.*;
import java.util.*;

public class Main {
  public static int N;
  public static int[] dx = {1, 0};
  public static int[] dy = {0, 1};
  public static int[][] arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  static void input(BufferedReader br) throws Exception {
    N = Integer.parseInt(br.readLine());
    arr = new int[N+1][N+1];
    for (int i = 1; i <= N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
  }

  static void pro() {
    int[][][] dp = new int[N+1][N+1][3];

    for (int i = 1; i <= N; i++) {
      for(int j = i ; j <= N; j++) {
        dp(dp, i, j);
      }
      for(int j = i ; j <= N; j++) {
        dp(dp, j, i);
      }
    }
    System.out.println(Math.max(dp[N][N][0],Math.max(dp[N][N][1],dp[N][N][2])));
  }

  public static void dp(int[][][] dp, int i, int j){
    for(int k =0 ; k< 3 ; k++){
      dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j-1][k]);
      dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j][k]);
      if(k==0 && arr[i][j] == 0){
        dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j-1][2]+1);
        dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j][2]+1);
      }
      if(k==1 && arr[i][j] == 1){
        if(dp[i][j-1][0] != 0) dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j-1][0]+1);
        if(dp[i-1][j][0] != 0) dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j][0]+1);
      }
      if(k==2 && arr[i][j] == 2){
        if(dp[i][j-1][1] != 0) dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j-1][1]+1);
        if(dp[i-1][j][1] != 0) dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j][1]+1);
      }
    }
  }
}