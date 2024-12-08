import java.io.*;
import java.util.*;

public class Main {
  static int result = Integer.MAX_VALUE;
  static int[] ps;
  static List<List<Integer>> lists;
  static int N;
  static int total;
  static int zeroCount;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
    System.out.println(result);
  }

  static void input(BufferedReader br) throws Exception {
    N = Integer.parseInt(br.readLine());
    ps = new int[N+1];
    lists = new ArrayList<>();
    total = 0;
    zeroCount = 0;
    for(int i=0 ; i<=N ; i++){
      lists.add(new ArrayList<>());
    }
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=1 ; i<=N ; i++) {
      ps[i] = Integer.parseInt(st.nextToken());
      total += ps[i];
    }
    for(int i=1 ; i<=N ; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      if(a == 0){
        zeroCount++;
        continue;
      }
      List<Integer> list = lists.get(i);
      for(int j=0 ; j<a ; j++){
        int b = Integer.parseInt(st.nextToken());
        list.add(b);
      }
    }
  }

  static void pro() {
//    if(zeroCount == 0){
//      Set<Integer> set = new HashSet<>();
//      set.add(1);
//      dfs(1, ps[1], set);
//    }else if(zeroCount == 1){
//      for(int i=1 ; i<=N ; i++){
//        List<Integer> list = lists.get(i);
//        if(list.size() == 0){
//          result = Math.abs(total - 2 * ps[i]);
//        }
//      }
//    }else if(zeroCount == 2){
//      if(N == 2){
//        result = Math.abs(total - 2 * ps[0]);
//      }else{
//        result = -1;
//      }
//    }else{
//      result = -1;
//    }

    for(int i = 1 ; i<=N ; i++){
      Set<Integer> set = new HashSet<>();
      set.add(1);
      dfs(1, ps[1], set);
    }
    if(result == Integer.MAX_VALUE) result = -1;
  }
  static void dfs(int curI, int curCount, Set<Integer> set){
    if(check(set)){
      result = Math.min(result, Math.abs(total - 2 * curCount));
    }
//    if(curCount > total - curCount) return;

    for(int i=curI+1 ; i<=N ; i++){
      set.add(i);
      dfs( i, curCount+ps[i], set);
      set.remove(i);
    }
  }
  static boolean check(Set<Integer> set){
    if(set.size() == N) return false;
    Set<Integer> set2 = new HashSet<>();
    int s1 = 0;
    int s2 = 0;
    for(int i=1 ; i<=N ; i++){
      if(set.contains(i)) {
        s1 = i;
        continue;
      }
      s2 = i;
      set2.add(i);
    }
    if(connect(set, s1) && connect(set2, s2)){
      return true;
    }
    return false;
  }
  static boolean connect(Set<Integer> set, int s){
    LinkedList<Integer> q = new LinkedList<>();
    boolean[] visited = new boolean[N+1];
    int count = 0;
    q.add(s);
    count++;
    visited[s] = true;
    while(!q.isEmpty()){
      int cur = q.poll();
      for(int n : lists.get(cur)){
        if(visited[n]) continue;
        if(!set.contains(n)) continue;
        q.add(n);
        visited[n] = true;
        count++;
      }
    }
    if(count == set.size()) return true;
    return false;
  }
}
