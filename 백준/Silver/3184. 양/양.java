import java.io.*;
import java.util.*;

public class Main {
  public static final char FILED = '.', BA = '#', SH = 'o', WOOLF = 'v';
  public static final int[] dx = {1,0,-1,0};
  public static final int[] dy = {0,1,0,-1};
  public static int N, M;
  public static char[][] map;
  public static boolean[][] visited;
  public static int countS = 0, countW = 0;
  public static int resultS = 0, resultW = 0;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  static void pro() {
    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {
        if(visited[i][j]) continue;
        if(map[i][j] == BA) continue;
        dfs(i, j);
        if(countS > countW) resultS += countS;
        if(countS <= countW) resultW += countW;
        countS = 0; countW = 0;
      }
    }
    System.out.println(resultS + " " + resultW);
  }

  static void dfs(int x, int y) {
    if(x<0 || y<0 || x>=N || y>=M) return;
    if(visited[x][y]) return;
    if(map[x][y] == BA) return;

    visited[x][y] = true;
    if(map[x][y] == SH) countS++;
    if(map[x][y] == WOOLF) countW++;

    for(int i=0 ; i<4 ; i++){
      dfs(x + dx[i], y + dy[i]);
    }
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new char[N][M];
    visited = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      map[i] = st.nextToken().toCharArray();
    }
  }
}