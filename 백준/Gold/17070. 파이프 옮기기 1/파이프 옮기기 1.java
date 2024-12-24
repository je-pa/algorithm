import java.io.*;
import java.util.*;

public class Main {
  static int result;
  static int N;
  static boolean[][] isWall;
//  static int[][] count;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
    System.out.println(result);
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    isWall = new boolean[N][N];
    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < N; j++) {
        boolean b = st.nextToken().equals("1");
        isWall[i][j] = b;
      }
    }
  }

  static void pro() {
    int[][][] dp = new int[3][N][N];
    dp[0][0][1] = 1;
    for(int i=0 ; i<N ; i++){
      for(int j=0 ; j<N ; j++){
        if(isWall[i][j]) continue;
        if(j-1 >= 0) dp[0][i][j] += dp[0][i][j-1] + dp[2][i][j-1];
        if(i-1 >= 0) dp[1][i][j] += dp[1][i-1][j] + dp[2][i-1][j];
        if(i-1 >= 0 && j-1 >= 0 && !(isWall[i-1][j] || isWall[i][j-1])) dp[2][i][j] += dp[0][i-1][j-1] + dp[1][i-1][j-1] + dp[2][i-1][j-1];
      }
    }
    result = dp[0][N-1][N-1] + dp[1][N-1][N-1] + dp[2][N-1][N-1];
  }

}