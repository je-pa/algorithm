import java.util.*;
import java.io.*;

public class Main {
  public static int n;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    List<List<Integer>> list = new ArrayList<>();
    for(int i = 0; i < n+1; i++) {
      list.add(new ArrayList<>());
    }
    for(int i = 0; i < n-1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      list.get(a).add(b);
      list.get(b).add(a);
    }

    boolean[] visit = new boolean[n+1];
    int[] parents = new int[n+1];
    LinkedList<Integer> q = new LinkedList<>();
    q.add(1);
    while(!q.isEmpty()) {
      int cur = q.poll();
      visit[cur] = true;
      for(int i : list.get(cur)) {
        if(visit[i]) continue;
        q.add(i);
        parents[i] = cur;
      }
    }
    StringBuilder sb = new StringBuilder();
    for(int i = 2; i < n+1; i++) {
      sb.append(parents[i]).append("\n");
    }
    System.out.println(sb);
  }
}