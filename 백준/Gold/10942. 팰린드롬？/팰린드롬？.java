import java.io.*;
import java.util.*;

public class Main {
  public static int N, M;
  public static int[] arr;
  public static int[][] infos;
  public static int[][] dp;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  static void input(BufferedReader br) throws Exception {
    N = Integer.parseInt(br.readLine());
    arr = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    M = Integer.parseInt(br.readLine());
    infos = new int[M][2];
    dp = new int[N][N];
    for(int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      infos[i][0] = Integer.parseInt(st.nextToken())-1;
      infos[i][1] = Integer.parseInt(st.nextToken())-1;
    }
  }

  static void pro() {
    StringBuilder sb = new StringBuilder();
    for(int[] info : infos) {
      sb.append(dfs(info[0], info[1]) == 1 ? 1 : 0).append("\n");
    }
    System.out.println(sb);
  }

  public static int dfs(int l, int r) {
    if(l >= r) return 1;
    if (dp[l][r] != 0) return dp[l][r];
    if(arr[l] == arr[r]){
      return dp[l][r] = dfs(l+1, r-1);
    }
    return dp[l][r]  = -1;
  }

}
