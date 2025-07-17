import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
  static int N, D, C;
  static List<List<int[]>> lists;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= T; t++) {
      input(br);
      pro();
    }
    System.out.println(sb);
  }
  static void pro() {
    PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
    q.add(new int[] { C, 0 });
    int count = 0;
    int max = 0;
    boolean[] visited = new boolean[N+1];
    while(!q.isEmpty()) {
      int[] poll = q.poll();
      int cn = poll[0];
      int cd = poll[1];
      if(visited[cn]) continue;
      visited[cn] = true;
      count ++;
      max = Math.max(max, cd);
      for(int[] arr: lists.get(cn)) {
        int n = arr[0];
        int d = cd + arr[1];
        q.add(new int[]{n, d});
      }
    }
    sb.append(count).append(" ");
    sb.append(max).append(" \n");
  }
  private static void input(BufferedReader br) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    D = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    lists = new ArrayList<>();

    for(int i=0; i<=N; i++) {
      lists.add(new ArrayList<>());
    }

    for(int i=0; i<D; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      lists.get(b).add(new int[]{a,c});
    }
  }

}

