import java.io.*;
import java.util.*;

public class Main {

  public static int N;
  public static ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
  public static int[][] map;
  public static boolean[] visited;
  public static int result = Integer.MAX_VALUE;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
    StringBuilder sb = new StringBuilder();
    for(int i =0 ; i<N ; i++){
      for(int j =0 ; j<N ; j++){
        sb.append(map[i][j]).append(" ");
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    map = new int[N][N];
    for (int i = 0; i < N; i++) {
      lists.add(new ArrayList<>());
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        int k = Integer.parseInt(st.nextToken());
        if(k == 0) continue;
        lists.get(i).add(j);
      }
    }
  }
  static void pro(){
    for(int i = 0; i < N; i++){
      visited = new boolean[N];
      dfs(i, i, 0);
    }
  }
  static void dfs(int root, int cur, int count){
    if(visited[cur]) return;
    if(count != 0) {
      visited[cur] = true;
      map[root][cur] = 1;
    }
    List<Integer> list = lists.get(cur);
    for(int i = 0; i < list.size(); i++){
      dfs(root, list.get(i), count + 1);
    }
  }
}