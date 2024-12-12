import java.io.*;
import java.util.*;

public class Main {
  static int result;
  static int N;
  static int M;
  static int[] arr;
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
    arr = new int[N];
    for(int i=0 ; i < N ; i++){
      arr[i] = Integer.parseInt(br.readLine());
    }
  }

  static void pro() {
    int[][] dp = new int[N][M+1];
    dp[0][0] = arr[0] == 1 ? 1 : 0;
    dp[0][1] = arr[0] == 2 ? 1 : 0;
    for(int i=1 ; i < N ; i++){
      for(int j=0 ; j < M+1 && j < i+1 ; j++){
        if((j%2 == 0 ? 1 : 2) == arr[i]){
          if(j == 0) {
            dp[i][j] = dp[i-1][j]+1;
            continue;
          }
          dp[i][j] = Math.max(dp[i-1][j]+1, dp[i-1][j-1]+1);
        }else{
          if(j == 0) {
            dp[i][j] = dp[i-1][j];
            continue;
          }
          dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]);
        }
      }
    }
    for(int i=0 ; i < M+1 ; i++){
      result = Math.max(result, dp[N-1][i]);
    }
  }

}
