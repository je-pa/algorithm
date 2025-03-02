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
    int count =0;
    for(int i = 1; i <= N; i++) {
      if(!visited[i]) {
        deps = new int[N+1];
        LinkedList<Integer> q = new LinkedList<>();
        int cur = dfs(i, 1, q);
        if(cur != 0){
          count += cur;
          pq.addAll(q);
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    sb.append(count);
    while(!pq.isEmpty()) {
      sb.append("\n").append(pq.poll());
    }
    System.out.println(sb);
  }

  static int dfs(int idx, int dep, LinkedList<Integer> q){
    if(deps[idx] != 0){
      for(int i=0 ; i<deps[idx]-1 ; i++){
        q.poll();
      }
      return dep - deps[idx];
    }
    if(visited[idx]) return 0;
    visited[idx] = true;
    deps[idx] = dep;
    q.add(idx);
    return dfs(arr[idx], dep+1, q);
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

