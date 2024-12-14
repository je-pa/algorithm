import java.io.*;
import java.util.*;

public class Main {
  static int result;
  static int N;
  static int M;
  static int TRUE_N;
  static Set<Integer> truePs;
  static List<Set<Integer>> parties;
  static boolean[] checks;
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
    checks = new boolean[M];
    st = new StringTokenizer(br.readLine());
    TRUE_N = Integer.parseInt(st.nextToken());
    truePs = new HashSet<>();
    for(int i=0 ; i<TRUE_N ; i++){
      int a = Integer.parseInt(st.nextToken());
      truePs.add(a);
    }
    parties = new ArrayList<>();
    for(int i=0 ; i< M ; i++){
      parties.add(new HashSet<>());
    }

    for(int i=0 ; i < M ; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      for(int j=0 ; j<a ; j++){
        int b = Integer.parseInt(st.nextToken());
        parties.get(i).add(b);
      }
    }
  }

  static void pro() {
    int beforeCount = 0;
    while(beforeCount != truePs.size()){
      beforeCount = truePs.size();
      for(int i=0 ; i<M ; i++){
        if(checks[i]) continue;
        for(int k : parties.get(i)){
          if(!truePs.contains(k)) continue;
          truePs.addAll(parties.get(i));
          checks[i] = true;
          break;
        }
      }
    }
    for(boolean b : checks){
      if(b) continue;
      result++;
    }
  }

}
