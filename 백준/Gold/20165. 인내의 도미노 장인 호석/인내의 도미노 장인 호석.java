import java.util.*;
import java.io.*;

public class Main {
  public static int N;
  public static int M;
  public static int H;
  public static int result = 0;
  public static int[][] map;
  public static boolean[][] fs;
  public static char[] d= {'E', 'W', 'S', 'N'};
  public static int[] dx = {0,0,1,-1};
  public static int[] dy = {1,-1,0,0};
  public static LinkedList<Integer> q = new LinkedList<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    StringTokenizer st;
    for(int i=0 ; i<H ; i++){
      st = new StringTokenizer(br.readLine());
      int fx = Integer.parseInt(st.nextToken())-1;
      int fy = Integer.parseInt(st.nextToken())-1;
      char dir = st.nextToken().charAt(0);
      st = new StringTokenizer(br.readLine());
      int sx = Integer.parseInt(st.nextToken())-1;
      int sy = Integer.parseInt(st.nextToken())-1;

      pro(fx, fy, dir, sx, sy);
    }

    StringBuilder sb = new StringBuilder();
    sb.append(result).append("\n");
    for(int n = 0; n < N; n++) {
      for(int m = 0; m < M; m++) {
        if(fs[n][m]){
          sb.append('F');
        }else{
          sb.append('S');
        }
        sb.append(' ');
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }
  public static void input(BufferedReader br) throws Exception{
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    fs = new boolean[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        int k = Integer.parseInt(st.nextToken());
        map[i][j] = k;
      }
    }
  }

  public static void pro(int fx, int fy, char dir, int sx, int sy){
    int remain = map[fx][fy];
    int count = 0;
    int cx = fx;
    int cy = fy;
    int cdx =0;
    int cdy =0;
    for(int i=0 ; i<4 ; i++){
      if(dir != d[i]) continue;
      cdx = dx[i];
      cdy = dy[i];
    }

    while(remain >0){
      if(cx < 0 || cx >= N || cy < 0 || cy >=M) break;
      if(!fs[cx][cy]){
        count++;
        remain = Math.max(map[cx][cy], remain);
      }
      fs[cx][cy] = true;
      remain--;
      cx += cdx;
      cy += cdy;
    }
    result += count;

    fs[sx][sy] = false;
  }

}