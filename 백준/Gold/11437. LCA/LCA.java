import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int M;
  static List<List<Integer>> lists = new ArrayList<>();
  static int[][] arr;

  static int[] parents;
  static int[] deps;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  static void input(BufferedReader br) throws Exception {
    N = Integer.parseInt(br.readLine());
    deps = new int[N+1];
    parents = new int[N+1];
    for(int i = 0; i <= N; i++) {
      lists.add(new ArrayList<>());
    }
    StringTokenizer st;
    for(int i = 1; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      lists.get(a).add(b);
      lists.get(b).add(a);
    }
    M = Integer.parseInt(br.readLine());
    arr = new int[M][2];
    for(int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      arr[i][0] = a;
      arr[i][1] = b;
    }
  }

  static void pro() {
    dfs(1, 1, new boolean[N+1]);
    for(int i=0 ; i<M ; i++){
      int n = find(arr[i][0], arr[i][1]);
      System.out.println(n);
    }
  }

  static void dfs(int d, int cur, boolean[] visited){
    if(visited[cur]) return;
    visited[cur] = true;
    deps[cur] = d;
    for(int n : lists.get(cur)) {
      if(visited[n]) continue;
      parents[n] = cur;
      dfs(d+1, n, visited);
    }
  }
  static int find(int a, int b){
    while(deps[a] != deps[b]){
      if(deps[a] < deps[b]){
        b = parents[b];
      }else{
        a = parents[a];
      }
    }
    if(a==b)  return a;
    while(parents[a] != parents[b]){
      a = parents[a];
      b = parents[b];
    }
    return parents[a];
  }
}
