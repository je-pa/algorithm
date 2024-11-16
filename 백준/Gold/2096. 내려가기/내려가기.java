import java.io.*;
import java.util.*;

public class Main {

  public static int N;
  public static int[][] arr;
  public static int[] dy = {-1, 0, 1};

  public static StringBuilder result = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
    System.out.println(result);
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    arr = new int[N][3];
    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < 3; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
  }

  static void pro(){
    int[][][] dp = new int[N][3][2];
    dp[0][0][0] = arr[0][0];
    dp[0][0][1] = arr[0][0];
    dp[0][1][0] = arr[0][1];
    dp[0][1][1] = arr[0][1];
    dp[0][2][0] = arr[0][2];
    dp[0][2][1] = arr[0][2];
    for(int i = 1; i < dp.length; i++) {
      for(int j = 0; j < 3; j++) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int z = 0 ; z < dy.length ; z++){
          int y = dy[z] + j;
          if(y < 0 || y >= 3) continue;
          min = Math.min(min, dp[i-1][y][0]);
          max = Math.max(max, dp[i-1][y][1]);
        }
        dp[i][j][0] = min + arr[i][j];
        dp[i][j][1] = max + arr[i][j];
      }
    }
    int min = Integer.MAX_VALUE;
    int max = 0;
    for(int[] ar : dp[N-1]){
      min = Math.min(min, ar[0]);
      max = Math.max(max, ar[1]);
    }
    result.append(max).append(" ").append(min);
  }
}
