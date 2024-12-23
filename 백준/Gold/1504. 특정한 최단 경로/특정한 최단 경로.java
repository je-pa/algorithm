import java.io.*;
import java.util.*;

public class Main {
  static int result;
  static int N;
  static int M;
  static List<List<int[]>> lists;
  static int V1, V2;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
    System.out.println(result);
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    result = -1;
    lists = new ArrayList<>();
    for(int i = 0; i <= N; i++) {
      lists.add(new ArrayList<>());
    }
    for(int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      lists.get(a).add(new int[]{b, c});
      lists.get(b).add(new int[]{a, c});
    }

    st = new StringTokenizer(br.readLine());
    V1 = Integer.parseInt(st.nextToken());
    V2 = Integer.parseInt(st.nextToken());

  }

  static void pro() {
    PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(x[1], y[1]));
    boolean[][][][] visited = new boolean[N+1][N+1][2][2];
    pq.add(new int[]{1, 0, check(false, 1, V1), check(false, 1, V2)});
    while(!pq.isEmpty()){
      int[] cur = pq.poll();
      int cn = cur[0];
      int cd = cur[1];
      boolean cv1 = cur[2] == 1;
      boolean cv2 = cur[3] == 1;
      if(cn == N && cv1 && cv2){
        result = cd;
        return;
      }
      for(int[] arr : lists.get(cn)) {
        int nn = arr[0];
        int nd = cd + arr[1];
        int nv1 = check(cv1, nn, V1);
        int nv2 = check(cv2, nn, V2);
        if(visited[cn][nn][nv1][nv2]) continue;
        visited[cn][nn][nv1][nv2] = true;
        pq.add(new int[]{nn, nd, nv1, nv2});
      }
    }
  }
  static int check(boolean cur, int n, int v){
    return checkB(cur, n, v) ? 1 : 0;
  }
  static boolean checkB(boolean cur, int n, int v){
    if(cur) return true;
    return n == v;
  }

}