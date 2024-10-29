import java.util.*;
import java.io.*;

public class Main {
  public static int N;
  public static int M;
  public static int H;
  public static int result = 0;
  public static int[][][] map;
  public static int[] dx = {0,0,1,-1, 0, 0};
  public static int[] dy = {1,-1,0,0, 0, 0};
  public static int[] dh = {0,0,0,0, -1, 1};
  public static LinkedList<Integer> q = new LinkedList<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
    for(int h = 0; h < H; h++) {
      for(int m = 0; m < M; m++) {
        for(int n = 0; n < N; n++) {
          if(map[m][n][h] == 0){
            System.out.println(-1);
            return;
          }
        }
      }
    }
    System.out.println(result);
  }
  public static void input(BufferedReader br) throws Exception{
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());
    map = new int[M][N][H];
    for(int h = 0 ; h<H ; h++){
      for (int i = 0; i < M; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
          int k = Integer.parseInt(st.nextToken());
          map[i][j][h] = k;
          if(k == 1){
            q.add(i);
            q.add(j);
            q.add(h);
            q.add(0);
          }
        }
      }
    }

  }

  public static void pro(){
    while(!q.isEmpty()){
      int cx = q.poll();
      int cy = q.poll();
      int ch = q.poll();
      int cd = q.poll();
      result = Math.max(result, cd);
      for(int i=0 ; i<6 ; i++){
        int nx = cx + dx[i];
        int ny = cy + dy[i];
        int nh = ch + dh[i];
        int nd = cd + 1;
        if(nx < 0 || ny < 0 || nh < 0 || nx >= M || ny >= N || nh >=H || map[nx][ny][nh] != 0) continue;
        q.add(nx);
        q.add(ny);
        q.add(nh);
        q.add(nd);
        map[nx][ny][nh] = 1;
      }
    }
  }

}