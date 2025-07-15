import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
  static int N, M;
  static int[] parent;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
  }
  private static void input(BufferedReader br) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    parent = new int[N];
    for(int i=0; i<N; i++) {
      parent[i] = i;
    }
    for(int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      if (union(x, y)) {
        System.out.println(i + 1);
        return;
      }
    }

    System.out.println(0);
  }

  private static boolean union(int x, int y) {
    int px = find(x);
    int py = find(y);
    if(px == py) {
      return true;
    }
    if(px < py) {
      parent[py] = px;
    }else {
      parent[px] = py;
    }
    return false;
  }

  static int find(int x){
    if(parent[x] == x) return x;
    return parent[x] = find(parent[x]);
  }

}

