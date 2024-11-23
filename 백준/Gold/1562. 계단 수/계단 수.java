import java.io.*;
import java.util.*;

public class Main {

  static int N;
  static int MOD = 1_000_000_000;
  static int[][][][] dp;
  static int result = 0;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
    System.out.println(result);
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    dp = new int[N+1][10][10][10];
  }

  static void pro() {
    for(int i = 1 ; i < 10 ; i++){
      dp[1][i][i][i] = 1;
    }
    for(int n = 1; n < N ; n++){
      for(int i = 0 ; i<10 ; i++){
        for(int a = 0; a<10 ; a++){
          for(int b=0 ; b<10 ; b++){
            if(dp[n][i][a][b]==0) continue;
            for(int k : new int[]{i-1, i+1}){
              if(k <0 || k>9) continue;
              dp[n+1][k][Math.min(k,a)][Math.max(k,b)] += dp[n][i][a][b];
              dp[n+1][k][Math.min(k,a)][Math.max(k,b)] %= MOD;
            }
          }
        }
      }
    }
    for(int i=0 ; i<10 ; i++){
      result+= dp[N][i][0][9];
      result%=MOD;
    }
  }
}
