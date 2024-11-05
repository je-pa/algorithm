import java.util.*;
    import java.io.*;

public class Main {
// abc 1 / ab 1
  public static int N;
  public static int M;
  public static String[] arr;
  public static HashMap<String, Integer> map = new HashMap<>();
  public static ArrayList<PriorityQueue<Integer>> parents = new ArrayList<>();
  public static ArrayList<PriorityQueue<Integer>> childs = new ArrayList<>();
  public static PriorityQueue<String> all = new PriorityQueue<>();
  public static int count = 0;
  public static int[] indeg;
  public static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    StringBuilder sb = new StringBuilder();
    StringBuilder sijo = new StringBuilder();
    int sijoCount = 0;
    for(int i=0 ; i<N ; i++){
      if(parents.get(i).size() == 0){
        sijoCount++;
        sijo.append(arr[i]).append(" ");
      }
    }
    sb.append(sijoCount).append("\n").append(sijo).append("\n");

    pro();
    while (!all.isEmpty()) {
      sb.append(all.poll()).append("\n");
    }

    System.out.println(sb);
  }
  public static void input(BufferedReader br) throws IOException{
    N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    arr = new String[N];
    indeg = new int[N];
    visited = new boolean[N];
    for(int i = 0; i < N; i++){
      arr[i] = st.nextToken();
      parents.add(new PriorityQueue<>());
      childs.add(new PriorityQueue<>());
    }
    Arrays.sort(arr);
    for(int i=0 ; i< N ; i++){
      map.put(arr[i], i);
    }

    M = Integer.parseInt(br.readLine());

    for(int i=0; i<M; i++){
      st = new StringTokenizer(br.readLine());
      String c = st.nextToken();
      String p = st.nextToken();
      parents.get(map.get(c)).add(map.get(p));
      childs.get(map.get(p)).add(map.get(c));
      indeg[map.get(p)]+=1;
    }
  }

  public static void pro() {
    LinkedList<Integer> q = new LinkedList<>();
    for(int i=0 ; i<N ; i++){
      if(indeg[i] == 0){
        q.add(i);
      }
    }
    while(!q.isEmpty()){
      int cur = q.poll();
      for(int i : parents.get(cur)){
        indeg[i]-=1;
        if(indeg[i] ==0) q.add(i);
      }
      StringBuilder sb = new StringBuilder();
      StringBuilder cs = new StringBuilder();
      int count = 0;
      PriorityQueue<Integer> pq = childs.get(cur);
      while(!pq.isEmpty()){
        int i = pq.poll();
        if(visited[i]) continue;
        count++;
        visited[i] = true;
        cs.append(arr[i]).append(" ");
      }
      sb.append(arr[cur]).append(" ").append(count).append(" ").append(cs);
      all.add(sb.toString());
    }
  }

}