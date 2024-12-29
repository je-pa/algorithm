import java.io.*;
import java.util.*;

public class Main {
  static int result;
  static int N;
  static int M;
  static boolean[][] arr;
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
    M = Integer.parseInt(st.nextToken());
    arr = new boolean[N][M];
    dp = new int[N][M];
    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for(int j = 0; j < M; j++) {
        int a = line.charAt(j)-'0';
        arr[i][j] = a == 1;
      }
    }
  }

  static void pro() {
    for(int i = 0; i < M; i++) {
      dp[0][i] = arr[0][i] ? 1 : 0;
      result = Math.max(result, dp[0][i]);
    }
    for(int i = 0; i < N; i++) {
      dp[i][0] = arr[i][0] ? 1 : 0;
      result = Math.max(result, dp[i][0]);
    }
    for(int i = 1; i < N; i++) {
      for(int j = 1; j < M; j++) {
        if(!arr[i][j]) continue;
        int count = 0;
        for(int k = 0; k<=dp[i-1][j-1] ; k++){
          if(!arr[i][j-k]) {
            break;
          }
          if(!arr[i-k][j]) {
            break;
          }
          count++;
        }
        dp[i][j] = count;
        result = Math.max(result, dp[i][j]);
      }
    }
    result = result * result;
  }

}
