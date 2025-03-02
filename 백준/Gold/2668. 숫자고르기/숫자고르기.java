import java.io.*;
import java.util.*;

public class Main {
  public static int N;
  public static int[] arr;
  public static boolean[] visited;
  public static int[] deps;
  public static PriorityQueue<Integer> pq = new PriorityQueue<>();


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  static void pro() {
    for(int i = 1; i <= N; i++) {
      if(!visited[i]) {
        deps = new int[N+1];
        dfs(i, i);
      }
    }
    StringBuilder sb = new StringBuilder();
    sb.append(pq.size());
    while(!pq.isEmpty()) {
      sb.append("\n").append(pq.poll());
    }
    System.out.println(sb);
  }

  static void dfs(int idx, int target){
    if(arr[idx] == target){
      pq.add(target);
      return;
    }
    visited[idx] = true;
    if(!visited[arr[idx]]) dfs(arr[idx], target);
    visited[idx] = false;
  }

  static void input(BufferedReader br) throws Exception {
    N = Integer.parseInt(br.readLine());
    arr = new int[N+1];
    visited = new boolean[N+1];
    for(int i=1 ; i<=N ; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
  }
}

