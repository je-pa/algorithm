import java.io.*;
import java.util.*;

public class Main {

  public static int N;
  public static int M;
  public static int result = -1;
  public static int[][] dx = {{1,-1,0,0},{1,-1},{0,0}};
  public static int[][] dy = {{0,0,1,-1},{0,0},{1,-1}};
  public static int[][] map;
  public static boolean[][][] visit;
  public static int SX;
  public static int SY;
  public static int EX;
  public static int EY; // 6 7 9 10 12 13 15

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
    map = new int[N][M];
    visit = new boolean[N][M][3];

    st = new StringTokenizer(br.readLine());
    SX = Integer.parseInt(st.nextToken()) -1;
    SY = Integer.parseInt(st.nextToken()) -1;
    EX = Integer.parseInt(st.nextToken()) -1;
    EY = Integer.parseInt(st.nextToken()) -1;

    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < M; j++) {
        int a = Integer.parseInt(st.nextToken());
        map[i][j] = a;
      }
    }
  }

  static void pro(){
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[2]));
//    PriorityQueue<int[]> pq = new PriorityQueue<>((x, y )-> Integer.compare(x[2], y[2]));
    pq.add(new int[]{SX, SY, 0, 1});
    int count =0;
    while(!pq.isEmpty()) {
      int[] cur = pq.poll();
      int cx = cur[0];
      int cy = cur[1];
      int cd = cur[2];
      int cCount = cur[3];
      if(cx == EX && cy == EY){
        result = cd;
        return;
      }
      for(int i = 0 ; i<dx[cCount%3].length; i++) {
        int nx = cx + dx[cCount%3][i];
        int ny = cy + dy[cCount%3][i];
        if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
        if(map[nx][ny] == -1) continue;
        if(visit[nx][ny][(cCount+1)%3]) continue;
        visit[nx][ny][(cCount+1)%3] = true;
        pq.add(new int[]{nx, ny, cd + map[nx][ny], cCount+1});
      }
    }
  }
}
