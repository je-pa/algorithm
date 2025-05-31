import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
  static int N, M;
  static List<List<int[]>> lists;
  static int[][] arr;
  static boolean[] visited;
  static StringBuilder sb= new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  static void pro() {
    for(int[] a : arr){
      visited = new boolean[N+1];
      dfs(a[0],a[1], 0);
    }
    System.out.println(sb);
  }

  static void dfs(int cur, int des, int dep){
    if(des == cur) {
      sb.append(dep).append("\n");
      return;
    }
    if(visited[cur]) return;
    visited[cur] = true;

    for(int[] arr : lists.get(cur)){
      int next = arr[0];
      int len = arr[1];
      dfs(next, des, dep+len);
    }
  }

  static void input(BufferedReader br) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    lists = new ArrayList<>();
    arr = new int[M][2];
    for(int i=0 ; i<=N ; i++){
      lists.add(new ArrayList<>());
    }
    for(int i = 1; i < N; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      lists.get(a).add(new int[]{b,c});
      lists.get(b).add(new int[]{a,c});
    }
    for(int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      arr[i][0] = a;
      arr[i][1] = b;
    }
  }
}
