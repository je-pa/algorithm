import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
  static int N, S, M;
  static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  static void pro() {
    boolean[][] dp = new boolean[N + 1][M + 1];
    dp[0][S] = true;
    for (int i = 1; i <= N; i++) {
      boolean check = false;

      for (int j = 0; j <= M; j++) {
        if (!dp[i - 1][j]) continue;
        for(int k : new int[] {j - arr[i], j + arr[i]}) {
          if(k < 0 || k > M) continue;
          dp[i][k] = true;
          check = true;
        }
      }
      if(!check) {
        System.out.println(-1);
        break;
      }
    }
    for(int i=M ; i>=0 ; i--){
      if(!dp[N][i]) continue;
      System.out.println(i);
      break;
    }
  }

  static void input(BufferedReader br) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new int[N+1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
  }
}
