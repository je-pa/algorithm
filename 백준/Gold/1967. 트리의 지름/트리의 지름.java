import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
  static int N, max, num;
  static boolean[] visited;
  static List<List<int[]>> lists = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }
  private static void pro() {
    visited = new boolean[N+1];
    dfs(1, 0);
    visited = new boolean[N+1];
    dfs(num, 0);
    System.out.println(max);
  }

  private static void dfs(int cur, int d){
    if(visited[cur]) return;
    visited[cur] = true;
    if(d > max){
      max = d;
      num = cur;
    }
    for(int[] arr : lists.get(cur)){
      dfs(arr[0], d + arr[1]);
    }
  }

  private static void input(BufferedReader br) throws IOException {
    N = Integer.parseInt(br.readLine());
    for (int i = 0; i <= N; i++) {
      lists.add(new ArrayList<>());
    }

    for (int i = 1; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      lists.get(a).add(new int[]{b, c});
      lists.get(b).add(new int[]{a, c});
    }
  }
}

