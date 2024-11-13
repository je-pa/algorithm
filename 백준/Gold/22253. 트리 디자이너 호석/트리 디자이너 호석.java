import java.io.*;
import java.util.*;

public class Main {

  public static int N;
  public static int MOD = 1_000_000_007;
  public static int result;
  public static int[][] dp;
  public static int[] arr;
  public static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro(1,-1);
    for(int i=0;i<10;i++){
      result+=dp[1][i];
      result%=MOD;
    }
    System.out.println(result);
  }

  static void input(BufferedReader br) throws Exception {
    N = Integer.parseInt(br.readLine());
    dp = new int[N+1][10];
    arr = new int[N+1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    for(int i = 0; i <= N; i++) {
      list.add(new ArrayList<>());
    }
    for(int i = 1; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      list.get(a).add(b);
      list.get(b).add(a);
    }
  }

  static void pro(int cur, int par){
    dp[cur][arr[cur]] = 1;
    for(int i : list.get(cur)) {
      if(i == par) continue;
      pro(i, cur);
      for(int k = 0 ; k< 10 ; k++){
        dp[cur][k] += dp[i][k];
        dp[cur][k] %= MOD;
      }
      for(int k=arr[cur] ; k<10 ; k++){
        dp[cur][arr[cur]] += dp[i][k];
        dp[cur][arr[cur]] %= MOD;
      }
    }
  }
}
