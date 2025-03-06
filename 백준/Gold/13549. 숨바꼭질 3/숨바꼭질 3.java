import java.io.*;
import java.util.*;

public class Main {
  public static int N, K;
  public static boolean[] visited = new boolean[100_001];

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  static void pro() {
    PriorityQueue<int[]> q = new PriorityQueue<>((x,y)-> Integer.compare(x[1], y[1]));
    q.add(new int[]{N, 0});
    while (!q.isEmpty()) {
      int[] cur = q.poll();
      int cn = cur[0];
      int cd = cur[1];
      if(cn == K) {
        System.out.println(cd);
        return;
      }
      if (cn <0 || cn >= 100_001 || visited[cn]) continue;
      visited[cn] = true;
      q.add(new int[]{cn + 1, cd + 1});
      q.add(new int[]{cn - 1, cd + 1});
      q.add(new int[]{cn * 2, cd});
    }
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
  }
}

