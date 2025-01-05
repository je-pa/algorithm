import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int M;
  static boolean[][] map;
  static boolean[][] visited;
  static int[][] arr;
  static int[] dx = {-1,1,0,0};
  static int[] dy = {0,0,-1,1};
  static int count = 0;
  static int max=0;
  static Map<Integer, Integer> numCount = new HashMap<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new boolean[N][M];
    visited = new boolean[N][M];
    arr = new int[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = 1 == Integer.parseInt(st.nextToken());
      }
    }
  }

  static void pro() {
    int num = 1;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if(visited[i][j]) continue;
        if(!map[i][j]) continue;
        count = 0;
        dfs(i, j, num);
        numCount.put(num, count);
        num++;
      }
    }
    numCount.put(0, 0);
    for(int i=0;i<N;i++) {
      for(int j=0;j<M;j++) {
        if(visited[i][j]) continue;
        max = Math.max(max,count(i, j));
      }
    }
    System.out.println(max);
  }
  static int count(int x, int y){
    int result = 0;
    Set<Integer> set = new HashSet<>();
    for(int i=0 ; i<4 ; i++){
      int nx = x + dx[i];
      int ny = y + dy[i];
      if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
      int nn = arr[nx][ny];
      if(set.contains(nn)) continue;
      set.add(nn);
      result += numCount.get(nn);
    }
    return result + 1;
  }

  static void dfs(int x, int y, int n){
    if(x < 0 || x >= N || y < 0 || y >= M) return;
    if(visited[x][y]) return;
    if(!map[x][y]) return;
    count++;
    visited[x][y] = true;
    arr[x][y] = n;
    for(int i=0 ; i<4 ; i++){
      int nx = x + dx[i];
      int ny = y + dy[i];
      dfs(nx, ny, n);
    }
  }
}
