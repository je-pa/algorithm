import java.io.*;
import java.util.*;

public class Main {

  static int T;
  static int N;
  static StringBuilder result = new StringBuilder();
//  static int[] deps;
//  static List<List<Integer>> lists = new ArrayList<>();
  static int[] parents;
  static int n1;
  static int n2;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    T = Integer.parseInt(br.readLine());
    for(int i=0; i<T ; i++){
      input(br);
      pro();
    }
    System.out.println(result);
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    parents = new int[N+1];
//    deps = new int[N+1];
//    for(int i=0 ; i<N+1 ; i++){
//      lists.add(new ArrayList<>());
//    }
    for (int i = 1; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      parents[b] = a;
//      lists.get(a).add(b);
    }
    int top = 0;
    for(int i = 1 ; i<parents.length ; i++){
      if(parents[i]==0){
        top = i;
        break;
      }
    }
//    dfs(top, 0);
    st = new StringTokenizer(br.readLine());
    n1 = Integer.parseInt(st.nextToken());
    n2 = Integer.parseInt(st.nextToken());
  }
//  static void dfs(int cur, int d){
//    deps[cur] = d;
//    for(int i : lists.get(cur)){
//      dfs(i, d+1);
//    }
//  }

  static void pro() {
    Set<Integer> set = new HashSet<>();
    int idx = n1;
    set.add(idx);
    while(true){
      set.add(parents[idx]);
      if(parents[idx] == 0) break;
      idx = parents[idx];
    }
    if(set.contains(n2)){
      result.append(n2).append("\n");
      return;
    }
    idx = n2;
    while(!set.contains(parents[idx])){
      idx = parents[idx];
    }
    result.append(parents[idx]).append("\n");
  }
}
