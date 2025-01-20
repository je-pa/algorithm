import java.io.*;
import java.util.*;

public class Main {

  public static int V, E;
  public static int[] map;
  public static List<List<Integer>> lists;
  public static String result;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      input(br);
      pro();
    }
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());
    map = new int[V + 1];
    lists = new ArrayList<>();
    for (int i = 0; i <= V; i++) {
      lists.add(new ArrayList<>());
    }
    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      lists.get(a).add(b);
      lists.get(b).add(a);
    }
    result = "YES";
  }

  static void pro() {
    for(int i=1 ; i<=V ; i++){
      if(map[i] == 0) dfs(i, 1);
    }
    System.out.println(result);
  }
  static void dfs(int n, int cur) {
    if(map[n] != 0){
      if(map[n] != cur) result = "NO";
      return;
    }
    map[n] = cur;
    for(int i : lists.get(n)){
      dfs(i, cur*(-1));
    }
  }

}