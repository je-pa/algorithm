import java.io.*;
import java.util.*;

public class Main {

  static int N = -1;
  static int M = -1;
  static boolean go = true;
  static ArrayList<ArrayList<Integer>> lists;
  static boolean[] visited;
  static String C1 = "Case %d: A forest of %d trees.";
  static String C2 = "Case %d: There is one tree.";
  static String C3 = "Case %d: No trees.";
  static int caseCount = 0;
  static StringBuilder sb = new StringBuilder();
  static int nodeCount;
  static int branchCount;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while(true){
      input(br);
      if(!go) break;
      caseCount++;
      pro();
    }
    System.out.println(sb);
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    visited = new boolean[N+1];
    M = Integer.parseInt(st.nextToken());
    if(N==0 && M==0) {
      go = false;
      return;
    }
    lists = new ArrayList<>();
    for(int i = 0; i <= N; i++) {
      lists.add(new ArrayList<>());
    }
    for(int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      lists.get(a).add(b);
      lists.get(b).add(a);
    }
  }

  static void pro() {
    int treeCount = 0;
    for(int i = 1; i <= N; i++) {
      if(visited[i]) continue;
      nodeCount = 0;
      branchCount = 0;
      dfs(i);
      if(nodeCount == branchCount/2 + 1) treeCount++;
    }
    String temp = "";
    if(treeCount > 1) temp = String.format(C1, caseCount, treeCount);
    if(treeCount == 1) temp = String.format(C2, caseCount);
    if(treeCount == 0) temp = String.format(C3, caseCount);
    sb.append(temp).append("\n");
  }
  static void dfs(int i) {
    visited[i] = true;
    nodeCount++;
    branchCount+=lists.get(i).size();
    for(int j : lists.get(i)) {
      if(!visited[j]) dfs(j);
    }
  }
}
