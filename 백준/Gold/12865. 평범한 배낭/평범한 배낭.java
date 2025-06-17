import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
  static int N, K;
  static int[][] arr;
  static int[][] dp;

  public static void pro() {
    for(int i=1 ; i<=N ; i++){
      for(int j=1 ; j<=K ; j++){
        if(arr[i-1][0] > j){
          dp[i][j] = dp[i-1][j];
          continue;
        }
        dp[i][j] = Math.max(dp[i-1][j-arr[i-1][0]]+arr[i-1][1], dp[i-1][j]);
      }
    }
    System.out.println(dp[N][K]);
  }

  public static void input(BufferedReader br) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    arr = new int[N][2];
    dp = new int[N+1][K+1];
    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      st = new StringTokenizer(str);
      for (int j = 0; j < 2; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }
}

