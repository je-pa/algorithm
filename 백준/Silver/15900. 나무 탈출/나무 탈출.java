import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static List<List<Integer>> tree;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    tree = new ArrayList<>();

    for (int i = 0; i <= n; i++) {
      tree.add(new ArrayList<>());
    }

    for (int i = 0; i < n - 1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      tree.get(x).add(y);
      tree.get(y).add(x);
    }

    visited = new boolean[n+1];

    System.out.println(dfs(1, visited, 0) % 2 == 1 ? "Yes" : "No");
  }

  public static int dfs(int node, boolean[] visited, int cnt) {
    visited[node] = true;
    int sum = 0;
    boolean isLeaf = true;

    for (int next : tree.get(node)) {
      if (!visited[next]) {
        isLeaf = false;
        sum += dfs(next, visited, cnt + 1);
      }
    }

    if (isLeaf) {
      return cnt;
    }

    return sum;
  }
}
