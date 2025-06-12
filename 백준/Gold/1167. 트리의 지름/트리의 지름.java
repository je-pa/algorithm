import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
  static int N;
  static List<List<int[]>> lists = new ArrayList<List<int[]>>();
  static int maxLen = 0;
  static int farNode = 0;
  static boolean[] visited;

  public static void pro() {
    visited = new boolean[N+1];
    dfs(1, 0);
    visited = new boolean[N+1];
    dfs(farNode, 0);
    System.out.println(maxLen);
  }

  static void dfs(int cur, int len){
    if(visited[cur]) return;
    visited[cur] = true;
    if(len > maxLen){
      maxLen = len;
      farNode = cur;
    }
    for(int[] arr : lists.get(cur)){
      dfs(arr[0], len + arr[1]);
    }
  }

  public static void input(BufferedReader br) throws IOException {
    N = Integer.parseInt(br.readLine());
    for (int i = 0; i <= N; i++) {
      lists.add(new ArrayList<>());
    }
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int node = Integer.parseInt(st.nextToken());
      while(true){
        int a = Integer.parseInt(st.nextToken());
        if(a == -1) break;
        int len = Integer.parseInt(st.nextToken());
        lists.get(node).add(new int[]{a,len});
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }
}

