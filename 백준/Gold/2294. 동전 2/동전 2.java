import java.io.*;
import java.util.*;

public class Main {
  static int result;
  static int N;
  static int K;
  static int MAX;
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
    K = Integer.parseInt(st.nextToken());
    arr = new int[N];
    for(int i=0 ; i<N ; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      MAX = Math.max(a, MAX);
      arr[i] = a;
    }
  }

  static void pro() {
    int[] dp = new int[K+1];
    for(int i=0 ; i<N ; i++){
      if(arr[i] > K) continue;
      dp[arr[i]] = 1;
    }

    for(int i=1 ; i<=K ; i++){
      if(dp[i] == 0) dp[i] = 10001;
      for(int j=0 ; j<N ; j++){
        int idx = i - arr[j];
        if(idx < 0) continue;
        if(dp[idx] == 0) continue;
        dp[i] = Math.min(dp[i], dp[idx] + 1);
      }
    }
    result = dp[K];
    if(result == 10001) result = -1;
  }
}