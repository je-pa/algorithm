import java.io.*;
import java.util.*;

public class Main {

  static int N;
  static int[] arr;
  static long[][] dp;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
    System.out.println(dp[N-2][(int)arr[N-1]]);
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    arr = new int[N];
    dp = new long[N][21];
    st = new StringTokenizer(br.readLine());
    for (int j = 0; j < N; j++) {
      arr[j] = Integer.parseInt(st.nextToken());
    }
  }

  static void pro() {
    dp[0][arr[0]] = 1;
    for (int i = 1; i < N-1; i++) {
      for(int j=0 ; j<21 ; j++){
        if(dp[i-1][j]==0) continue;
        for(int k : new int[]{j+arr[i], j-arr[i]}){
          if(k<0 || k>20) continue;
          dp[i][k]+=dp[i-1][j];
        }
      }
    }
  }
}
