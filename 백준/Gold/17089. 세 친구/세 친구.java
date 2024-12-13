import java.io.*;
import java.util.*;

public class Main {
  static int result = Integer.MAX_VALUE;
  static int N;
  static int M;
  static List<Set<Integer>> sets;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
    System.out.println(result);
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    sets = new ArrayList<>();
    for(int i=0 ; i<= N ; i++){
      sets.add(new HashSet<>());
    }

    for(int i=0 ; i < M ; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      sets.get(a).add(b);
      sets.get(b).add(a);
    }
  }

  static void pro() {
    dfs(0, new HashSet<>());
    result = result == Integer.MAX_VALUE ? -1 : result;
  }

  static void dfs(int idx, Set<Integer> set){
    if(set.size() > 3) return;
    if(set.size() == 3){
      int count = -6;
      for(int i : set){
        count+= sets.get(i).size();
      }
      result = Math.min(result, count);
      return;
    }
    for(int i = idx ; i <= N ; i++){
      if(!check(set, i)) continue;
      set.add(i);
      dfs(i+1, set);
      set.remove(i);
    }
  }
  static boolean check(Set<Integer> set, int idx){
    for(int i : set){
      Set<Integer> fr = sets.get(i);
      if(!fr.contains(idx)) return false;
    }
    return true;
  }
}
