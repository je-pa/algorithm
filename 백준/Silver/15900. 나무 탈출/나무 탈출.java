import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
  static int N;
  static List<List<Integer>> lists = new ArrayList<>();
  static boolean[] visited;
  static int res = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  static void pro() {
    dfs(0, 1);
    System.out.println(res % 2 == 0 ? "No" : "Yes");
  }

  static void dfs(int dep, int cur){
    visited[cur] = true;
    int count = 0;
    for(int i : lists.get(cur)){
      if(visited[i]) continue;
      count++;
      dfs(dep+1, i);
    }
    if(count == 0) res+= dep;
  }

  static void input(BufferedReader br) throws IOException {
    N = Integer.parseInt(br.readLine());
    StringTokenizer st;
    visited = new boolean[N+1];
    for (int i = 0; i <= N; i++) {
      lists.add(new ArrayList<>());
    }
    for (int i = 0; i < N-1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      lists.get(a).add(b);
      lists.get(b).add(a);
    }


  }
}
