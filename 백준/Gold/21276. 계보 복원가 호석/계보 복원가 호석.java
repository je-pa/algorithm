import java.util.*;
    import java.io.*;

public class Main {

  public static int N;
  public static int M;
  public static String[] arr;
  public static int count = 0;
  public static PriorityQueue<String> sijo = new PriorityQueue<>();
  public static PriorityQueue<String> sijoChilds = new PriorityQueue<>();
  public static HashMap<String, Integer> parentCount = new HashMap<>();
  public static HashMap<String, PriorityQueue<String>> childs = new HashMap<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
    StringBuilder sb = new StringBuilder();
    sb.append(sijo.size()).append("\n");
    while (!sijo.isEmpty()) {
      sb.append(sijo.poll()).append(" ");
    }
    sb.append("\n");
    while (!sijoChilds.isEmpty()) {
      sb.append(sijoChilds.poll()).append("\n");
    }
    System.out.println(sb);
  }
  public static void input(BufferedReader br) throws IOException{
    N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    arr = new String[N];
    for(int i = 0; i < N; i++){
      arr[i] = st.nextToken();
    }

    M = Integer.parseInt(br.readLine());

    for(int i=0; i<M; i++){
      st = new StringTokenizer(br.readLine());
      String c = st.nextToken();
      String p = st.nextToken();

      parentCount.put(c,parentCount.getOrDefault(c, 0)+1);
      PriorityQueue<String> orDefault = childs.getOrDefault(p, new PriorityQueue<>());
      orDefault.add(c);
      childs.put(p, orDefault);
    }
  }

  public static void pro() {
    for(String s : arr){
      if(!parentCount.containsKey(s)) {
        parentCount.put(s, 0);
        dfs(s, 0);
        sijo.add(s);
      }
    }
  }
  public static void dfs(String p, int dep){
    if(parentCount.get(p) == dep){
      StringBuilder sb = new StringBuilder();
      sb.append(p).append(" ");
      PriorityQueue<String> child = childs.get(p);
      if(child == null || child.size() == 0){
        sb.append(0);
        sijoChilds.add(sb.toString());
        return;
      }
      int count = 0;
      StringBuilder cs = new StringBuilder();
      for(String c : child){
        if(parentCount.get(c) != dep + 1) continue;
        count++;
        cs.append(c).append(" ");
      }
      sb.append(count).append(" ").append(cs);
      sijoChilds.add(sb.toString());

      for(String c : child){
        dfs(c, dep+1);
      }
    }
  }
}