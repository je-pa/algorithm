import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
  static int N, M, R;
  static int[] items;
  static List<List<int[]>> lists = new ArrayList<>();
  static int res;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
    System.out.println(res);
  }
  private static void input(BufferedReader br) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());
    items = new int[N+1];
    st = new StringTokenizer(br.readLine());
    for(int i = 1 ; i <= N; i ++) {
      int a = Integer.parseInt(st.nextToken());
      items[i] = a;
      lists.add(new ArrayList<>());
    }
    lists.add(new ArrayList<>());

    for(int i = 0 ; i < R; i ++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken()) * 1;
      lists.get(a).add(new int[]{b, c});
      lists.get(b).add(new int[]{a, c});
    }
  }

  private static void pro() {
    for(int i = 1 ; i <= N ; i ++) {
      bfs(i);
    }
  }

  private static void bfs(int start){
    PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->x[1]-y[1]);
    pq.offer(new int[]{start,0});
    int count = 0;
    boolean[] visited = new boolean[N+1];
    while(!pq.isEmpty()){
      int[] cur = pq.poll();
      int cn = cur[0];
      int cd = cur[1];
      if(cd > M || visited[cn]) continue;
      visited[cn] = true;
      count += items[cn];
      for(int[] arr : lists.get(cn)){
        int nn = arr[0];
        int nd = cd + arr[1];
        pq.add(new int[]{nn,nd});
      }
    }
    res = Math.max(res, count);
  }

}

