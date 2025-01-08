import java.io.*;
import java.util.*;

public class Main {
  static int K;
  static int M;
  static int N;
  static int[] dx= {1,-1,0,0, -2,-2,2,2, -1,-1,1,1};
  static int[] dy= {0,0,1,-1, -1,1,-1,1, -2,2,-2,2};
  static boolean[][] arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  static void input(BufferedReader br) throws Exception {
    K = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    arr = new boolean[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        arr[i][j] = st.nextToken().equals("1");
      }
    }
  }
  static void pro() {
    PriorityQueue<int[]> q = new PriorityQueue<>((x,y) -> Integer.compare(x[2],y[2]));
    PriorityQueue<Integer> d = new PriorityQueue<>();
    boolean[][][] visited = new boolean[N][M][31];
    q.add(new int[]{0,0,0,0});
    visited[0][0][0] = true;
    if(N==1 && M==1) {
      System.out.println(0);
      return;
    }
    while (!q.isEmpty()) {
      int[] c = q.poll();
      int cx = c[0], cy = c[1], cd = c[2], ck = c[3];
      if(cx == N-1 && cy == M-1){
        d.add(cd);
        continue;
      }
      for(int i=0 ; i<dx.length ; i++){
        int nx = cx + dx[i];
        int ny = cy + dy[i];
        int nd = cd + 1;
        if(ck >= K && i >3) continue;
        int nk = ck;
        if(i>3){
          nk++;
        }
        if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
        if(visited[nx][ny][nk]) continue;
        if(arr[nx][ny]) continue;
        visited[nx][ny][nk] = true;
        q.add(new int[]{nx, ny, nd, nk});
      }
    }
//    for(int i=0 ; i<N ; i++){
//      for(int j=0 ; j<M ; j++){
//        System.out.print(visited[i][j] + " ");
//      }
//      System.out.println();
//    }
    System.out.println(d.isEmpty() ? -1 : d.poll());
  }
}
//2
//8 12
//0 0 0 0 0 0 0 0
//0 1 1 1 1 1 1 0
//0 1 1 1 1 1 1 0
//0 1 1 0 0 0 0 0
//0 1 1 0 1 1 1 1
//0 1 1 0 1 1 1 1
//0 1 1 0 0 0 0 0
//0 1 1 0 1 1 1 0
//0 1 1 1 1 1 1 0
//1 1 0 0 0 0 1 1
//1 1 1 1 1 1 1 1
//1 1 1 0 1 1 0 0

//1
//7 8
//0 0 0 0 0 0 0
//1 1 1 1 1 1 0
//1 1 1 1 1 1 0
//0 0 0 1 1 1 0
//0 1 1 1 0 0 0
//0 1 1 1 1 1 1
//0 1 1 1 1 1 1
//0 0 0 0 0 0 0