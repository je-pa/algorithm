import java.io.*;
import java.util.*;

public class Main {
  static int result;
  static int N;
  static int[][] arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    arr = new int[N+1][2];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 2; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
  }

  static void pro() {
    int[] dp = new int[N+1];
    int max = 0;
    for(int i=0 ; i<N+1 ; i++){
      max = Math.max(max, dp[i]);
      int nxt = i + arr[i][0];
      if(nxt >= N+1) continue;
      dp[nxt] = Math.max(dp[nxt], max+arr[i][1]);
    }
    System.out.println(dp[N]);
  }
}
