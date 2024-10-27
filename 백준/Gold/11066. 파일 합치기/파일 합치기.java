import java.util.*;
import java.io.*;

public class Main {
  public static int N;
  public static int[] arr;
  public static int[][] dp;
  public static int[][] sum;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for(int i = 0 ; i< T ; i++){
      input(br);
      pro();
    }
  }

  public static void pro(){
    for(int i = 0 ; i< N ; i++){
      sum[i][i] = arr[i];
    }
    for(int i = 0 ; i< N ; i++){
      for(int j = i+1 ; j < N ; j++){
        sum[i][j] = sum[i][j-1] + arr[j];
      }
    }
//    for(int i = 0 ; i < N-1 ; i++){
//      for(int j = i+1 ; j < N ; j++){
//        dp[i][j] = Integer.MAX_VALUE;
//        for(int k = i ; k< j ; k++){
//          dp[i][j] = Math.min(dp[i][j], dp[i][k]+ dp[k+1][j] + sum[i][j]);
//        }
//      }
//    }
    for (int len = 2; len <= N; len ++){
      for (int i = 0; i < N - len + 1; i++){
        int j = i + len - 1;
        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i; k < j; k++){
          dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + sum[i][j]);
        }
      }
    }
    System.out.println(dp[0][N-1]);
  }

  public static void input(BufferedReader br) throws IOException{
    N = Integer.parseInt(br.readLine());
    arr = new int[N];
    dp = new int[N][N];
    sum = new int[N][N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0 ; i<N ; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
  }
}
