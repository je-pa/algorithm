import java.io.*;
import java.util.*;

public class Main {
  public static int N;
  public static int[] ss;
  public static int A = 0, B = 0, C = 0;
  public static int[][] ks = {{9,3,1},{9,1,3},{3,1,9},{3,9,1},{1,3,9},{1,9,3}};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    ss = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      ss[i] = Integer.parseInt(st.nextToken());
    }
    if(N > 0) A = ss[0];
    if(N > 1) B = ss[1];
    if(N > 2) C = ss[2];

  }

  static void pro() {
    LinkedList<int[]> q = new LinkedList<>();
    boolean[][][] visited = new boolean[61][61][61];
    q.add(new int[]{A,B,C,0});
    visited[A][B][C] = true;
    while (!q.isEmpty()) {
      int[] p = q.poll();
      int ca = p[0];
      int cb = p[1];
      int cc = p[2];
      int cd = p[3];
      for(int[] k : ks) {
        int na = Math.max(ca - k[0], 0);
        int nb = Math.max(cb - k[1], 0);
        int nc = Math.max(cc - k[2], 0);
        int nd = cd + 1;
        if(na == 0 && nb == 0 && nc == 0){
          System.out.println(nd);
          return;
        }
        if(visited[na][nb][nc]) continue;
        visited[na][nb][nc] = true;
        q.add(new int[]{na,nb,nc,nd});
      }
    }
  }

}