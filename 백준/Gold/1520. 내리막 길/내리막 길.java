import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int M;
  static int[][] arr;
  static int[][] dp;
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, 1, 0, -1};


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    dp = new int[N+1][M+1];
    arr = new int[N+1][M+1];

    for(int i=1 ; i<=N ; i++){
      st = new StringTokenizer(br.readLine());
      for(int j=1 ; j<=M ; j++){
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
  }

  static void pro() {
    for(int i=1 ; i<=N ; i++){
      for(int j=1 ; j<=M ; j++){
        if(i == 1 && j == 1){
          dp[i][j] = 1;
          continue;
        }
        dp[i][j] = -1;
      }
    }
    System.out.println(dfs(N, M));
  }

  static int dfs(int x, int y){
    if(dp[x][y] != -1) return dp[x][y];
    dp[x][y] = 0;
    for(int i=0 ; i<4 ; i++){
      int nx = x + dx[i];
      int ny = y + dy[i];
      if(nx < 1 || nx > N || ny < 1 || ny > M) continue;
      if(arr[x][y] >= arr[nx][ny]) continue;
      dp[x][y] += dfs(nx,ny);
    }
    return dp[x][y];
  }

}
