import java.util.*;
import java.io.*;
public class Main {
  public static int n;
  public static int m;
  public static List<List<Integer>> list;
  public static int[] count;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    count = new int[n+1];
    list = new ArrayList<>();
    for(int i = 0; i <= n; i++) {
      list.add(new ArrayList<>());
    }

    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++) {
      int parent = Integer.parseInt(st.nextToken());
      if(parent == -1 )continue;
      list.get(parent).add(i+1);
    }
    for(int i =0 ; i<m ; i++){
      st = new StringTokenizer(br.readLine());
      int parent = Integer.parseInt(st.nextToken());
      int score = Integer.parseInt(st.nextToken());
      count[parent] += score;
    }
    bfs(1);

    StringBuilder sb = new StringBuilder();
    for(int i = 1; i <= n; i++) {
      sb.append(count[i]).append(" ");
    }
    System.out.println(sb);
  }
  public static void bfs(int root){
    LinkedList<Integer> q = new LinkedList<>();
    q.add(root);
    while(!q.isEmpty()) {
      int cur = q.poll();
      List<Integer> childs = list.get(cur);

      for(Integer child : childs) {
        q.add(child);
        count[child] = count[child] + count[cur];
      }
    }
  }
}

