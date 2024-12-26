import java.io.*;
import java.util.*;

public class Main {
  static int result;
  static int N;
  static int M;
  static int X;
  static List<List<int[]>> lists = new ArrayList<>();
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
    System.out.println(result);
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());
    for(int i = 0; i <= N; i++) {
      lists.add(new ArrayList<>());
    }
    for(int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      lists.get(a).add(new int[]{b, c});
    }
  }

  static void pro() {
    for(int i = 1; i <= N; i++) {
      result = Math.max(result,
          d(i, X, new boolean[N+1]) + d(X, i, new boolean[N+1])
      );
    }
  }
  static int d(int start, int goal, boolean[] visited){
    if(start == goal) return 0;
    PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(x[1], y[1]));
    pq.add(new int[]{start, 0});
    while(!pq.isEmpty()){
      int[] cur = pq.poll();
      int cn = cur[0];
      int cd = cur[1];
      visited[cn] = true;
      if(cn == goal){
        return cd;
      }
      for(int[] arr : lists.get(cn)) {
        if(visited[arr[0]]) continue;
        pq.add(new int[]{arr[0], cd + arr[1]});
      }
    }
    return 0;
  }
}
