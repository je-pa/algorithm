import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
  static int N;
  static int[] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }
  static void pro() {
    int[] dp = new int[N];
    int max = 0;
    for(int i=0;i<N;i++) {
      dp[i] = 1;
      for(int j=0;j<i;j++) {
        if(arr[j]<arr[i] && dp[j]+1>dp[i]) {
          dp[i] = dp[j]+1;
          max = Math.max(max, dp[i]);
        }
      }
    }
    System.out.println(N-max);
  }

  private static void input(BufferedReader br) throws IOException {
    N = Integer.parseInt(br.readLine());
    arr = new int[N];
    for(int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
  }
}

