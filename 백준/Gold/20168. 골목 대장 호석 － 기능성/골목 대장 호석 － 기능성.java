import java.util.*;
import java.io.*;

public class Main {
  public static int N;
  public static int M;
  public static int A;
  public static int B;
  public static int C;
  public static ArrayList<ArrayList<int[]>> list = new ArrayList<>();
  public static int result = Integer.MAX_VALUE;
  public static boolean[] visited;
  public static boolean check = false;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    dfs(A, 0, 0);
    if(check){
      System.out.println(result);
    }else{
      System.out.println(-1);
    }
  }
  public static void input(BufferedReader br) throws Exception{
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    A = Integer.parseInt(st.nextToken());
    B = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    visited = new boolean[N+1];
    for(int i=0 ; i<=N ; i++){
      list.add(new ArrayList<>());
    }
    for(int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      list.get(a).add(new int[]{b, c});
      list.get(b).add(new int[]{a, c});
    }
  }

  public static void dfs(int cur, int max, int money){
    if(money > C) return;
    if(result < max) return;
    if(cur == B){
      result = Math.min(max, result);
      check = true;
      return;
    }
    for(int[] i : list.get(cur)){
      int ni = i[0];
      int nm = i[1];
      if(visited[ni]) continue;
      visited[ni] = true;
      dfs(ni, Math.max(nm, max), money + nm);
      visited[ni] = false;
    }
  }
}