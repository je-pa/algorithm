import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
  static int N, M;
  static int[] parent;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    parent = new int[N+1];
    StringBuilder sb = new StringBuilder();
    for(int i=1;i<=N;i++){
      parent[i] = i;
    }
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      if(a == 0){
        union(b,c);
        continue;
      }
      sb.append(check(b,c) ? "YES" : "NO").append("\n");
    }
    System.out.println(sb);
  }


  static boolean check(int b, int c){
    int bp = find(b);
    int cp = find(c);

    return bp == cp;
  }

  static void union(int b, int c){
    int bp = find(b);
    int cp = find(c);

    if(bp < cp){
      parent[cp] = bp;
      return;
    }
    parent[bp] = cp;
  }
  static int find(int x){
    if(parent[x] == x) return x;
    return parent[x] = find(parent[x]);
  }
}

