import java.util.*;
import java.io.*;

public class Main {
  public static int N;
  public static int K;
  public static ArrayList<Character> ml = new ArrayList<>();
  public static ArrayList<Character> jl = new ArrayList<>();
  public static TreeSet<String> result = new TreeSet<>();
  public static char[] mo = {'a','e','i','o','u'};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    dfs(0,0,0,0,0,"");
    StringBuilder sb = new StringBuilder();
    for(String s : result){
      sb.append(s).append("\n");
    }
    System.out.println(sb);
  }
  public static void input(BufferedReader br) throws Exception{
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < K; i++){
      char num = st.nextToken().charAt(0);
      boolean isM = false;
      for(char c : mo){
        if(num == c){
          ml.add(num);
          isM = true;
          break;
        }
      }
      if(!isM){
        jl.add(num);
      }
    }
  }

  public static void dfs(int mi, int ji, int dep, int mc, int jc, String s){
    if(dep > N) return;
    if(dep == N && mc > 0 && jc > 1){
      PriorityQueue<Character> pq = new PriorityQueue<>();
      for(int i = 0 ; i < s.length() ; i++){
        pq.add(s.charAt(i));
      }
      StringBuilder sb = new StringBuilder();
      while(!pq.isEmpty()){
        sb.append(pq.poll());
      }
      result.add(sb.toString());
      return;
    }
    if(mi < ml.size()){
      for(int i = mi ; i < ml.size() ; i++){
        dfs(i+1, ji, dep+1, mc+1, jc, s+ml.get(i));
      }
    }
    if(ji < jl.size()){
      for(int i = ji ; i < jl.size() ; i++){
        dfs(mi, i+1, dep+1, mc, jc+1, s+jl.get(i));
      }
    }

  }
}