import java.util.*;
import java.io.*;
public class Main {
  public static int n;
  public static int root;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    List<List<Integer>> list = new ArrayList<>();
    for(int i = 0; i < n; i++) {
      list.add(new ArrayList<>());
    }
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++) {
      int parent = Integer.parseInt(st.nextToken());
      if(parent == -1) {
        root = i;
        continue;
      }
      list.get(parent).add(i);
    }
    int remove = Integer.parseInt(br.readLine());
    if(remove == root) {
      System.out.println(0);
      return;
    }
    int count = 0;
    LinkedList<Integer> q = new LinkedList<>();
    q.add(root);
    while(!q.isEmpty()) {
      int cur = q.poll();
      List<Integer> childs = list.get(cur);
      if(childs.size() == 0) {
        count++;
        continue;
      }else if(childs.size() == 1 && childs.get(0) == remove) {
        count++;
        continue;
      }
      for(Integer child : childs) {
        if(child == remove) continue;
        q.add(child);
      }
    }
    System.out.println(count);
  }


}