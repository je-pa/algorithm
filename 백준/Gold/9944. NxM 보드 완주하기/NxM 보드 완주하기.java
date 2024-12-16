import java.io.*;
import java.util.*;

public class Main {
  static int result;
  static int N;
  static int M;
  static char[][] arr;
  static int[] dx = {-1, 1,0,0};
  static int[] dy = {0, 0,1,-1};
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int count = 1;
    String str;
    while((str = br.readLine()) != null){
      result = Integer.MAX_VALUE;
      input(br, str);
      pro();
      System.out.print("Case "+ count +": ");
      System.out.println(result == Integer.MAX_VALUE ? -1 : result);
      count++;
    }
  }

  static void input(BufferedReader br, String str) throws Exception {
    StringTokenizer st = new StringTokenizer(str);
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new char[N][M];
    String line;
    for (int i = 0; i < N; i++) {
      line = br.readLine();
      for(int j = 0; j < M; j++) {
        char a = line.charAt(j);
        arr[i][j] = a;
      }
    }

  }

  static void pro() {
    for(int i=0 ; i<N ; i++){
      for(int j=0 ; j<M ; j++){
        boolean[][] visited = new boolean[N][M];
        visited[i][j] = true;
        dfs(visited, i, j,0);
      }
    }
  }
  static void dfs(boolean[][] visited, int x, int y, int count){
    int deg = 0 ;
    for(int i=0 ; i<4 ; i++){
      int nx = x + dx[i];
      int ny = y + dy[i];
      if(sizeCheck(nx,ny,N,M)) continue;
      if(arr[nx][ny] == '*' || visited[nx][ny]) continue;
      while(!sizeCheck(nx, ny, N, M) && arr[nx][ny] != '*' && !visited[nx][ny]){
        visited[nx][ny] =true;
        nx += dx[i];
        ny += dy[i];
      }
      nx -= dx[i];
      ny -= dy[i];
      deg++;
      dfs(visited, nx, ny, count+1);
      while(true){
        if(nx == x && ny == y) break;
        visited[nx][ny] =false;
        nx -= dx[i];
        ny -= dy[i];
      }
    }
    if(deg == 0 && allVisited(arr, visited)){
      result = Math.min(count, result);
    }
  }
  static boolean sizeCheck(int x, int y, int n, int m){
    return x < 0 || y <0 || x>=n || y>=m;
  }
  static boolean allVisited(char[][] arr, boolean[][] visited){
    for(int i=0 ; i<N ; i++){
      for(int j=0 ; j<M ; j++){
        if(arr[i][j] == '*' || visited[i][j]) continue;
        return false;
      }
    }
    return true;
  }
}