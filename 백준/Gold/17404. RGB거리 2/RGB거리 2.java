import java.io.*;
import java.util.*;

public class Main {
  static int result = 1_000*1_000;
  static int N;
  static int[][] arr;
  static int INF = 1_000*1_000;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    arr = new int[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
  }

  static void pro() {
    for(int k=0 ; k<3 ; k++){
      int[][] dp = new int[N][3];
      for(int t=0 ; t<3 ; t++){
        if(k==t){
          dp[0][t] = arr[0][t];
        }
        if(k!=t){
          dp[0][t] = INF;
        }
      }
      for (int i = 1; i < N; i++) {
        dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
        dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
        dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
      }
      for(int i=0 ; i<3 ; i++){
        if(i != k) result = Math.min(result, dp[N-1][i]);
      }
    }


    System.out.println(result);
  }
}
