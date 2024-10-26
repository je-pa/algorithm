import java.util.*;
import java.io.*;

public class Main {
  public static int N;
  public static int[] ps;
  public static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
  public static int[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    ps = new int[N+1];
    dp = new int[N+1][2];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      ps[i] = Integer.parseInt(st.nextToken());
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
    pro(1, true, -1);
    pro(1, false, -1);

    System.out.println(Math.max(dp[1][0], dp[1][1]));
  }

  public static int pro(int curN, boolean curB, int parent){
    int curCheck = curB ? 1 : 0;
    if(dp[curN][curCheck] != 0){
      return dp[curN][curCheck];
    }
    dp[curN][curCheck] += curB ? ps[curN] : 0;

    for(int i : list.get(curN)){
      if(i == parent) continue;
      if(curB){
        dp[curN][curCheck] += pro(i, false, curN);
      }else{
        dp[curN][curCheck] += Math.max(pro(i, false, curN), pro(i, true, curN));
      }
    }

    return dp[curN][curCheck];
  }
}
