import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import org.w3c.dom.Node;


public class Main {
  static int N;
  static Node root = new Node("", 0, new PriorityQueue<>(Comparator.comparing(x -> x.name)));
  static Map<String, Node> map = new HashMap<>();


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }
  static void pro() {
    StringBuilder sb = new StringBuilder();
    dfs(root, sb,0);
    System.out.println(sb);
  }
  static void dfs(Node node, StringBuilder sb, int dep) {
    while(!node.child.isEmpty()){
      Node c = node.child.poll();
      for(int i=0 ; i<dep ; i++){
        sb.append("--");
      }
      sb.append(c.name).append("\n");
      dfs(c,sb, dep+1);
    }
  }

  private static void input(BufferedReader br) throws IOException {
    N = Integer.parseInt(br.readLine());
    for(int i = 0; i < N; i++) {
      String line = br.readLine();
      StringTokenizer st = new StringTokenizer(line);
      int k = Integer.parseInt(st.nextToken());
      Node parent = root;
      StringBuilder sb = new StringBuilder();
      for(int j = 1; j <= k; j++) {
        String name = st.nextToken();
        String curFullName = sb.append(name).toString();
        Node cur = map.getOrDefault(curFullName, new Node(name, j, new PriorityQueue<>(Comparator.comparing(x -> x.name))));
        if(map.get(curFullName) == null){
          parent.child.add(cur);
          map.put(curFullName, cur);
        }
        parent = cur;
      }
    }


  }
  static class Node {
    String name;
    int layer;
    PriorityQueue<Node> child;
    public Node(String name, int layer, PriorityQueue<Node> child) {
      this.name = name;
      this.layer = layer;
      this.child = child;
    }
  }
}

