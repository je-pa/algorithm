import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {
  static int N;
  static int[][] map;
  static boolean[][] visited;
  static int min = Integer.MAX_VALUE;
  static int[] dx = {1,-1,0,0};
  static int[] dy = {0,0,1,-1};

  public static void pro() {
    numbering();
    for(int i=0 ; i<N ; i++){
      for(int j=0 ; j<N ; j++){
        if(map[i][j] == 0) continue;
        boolean go = false;
        for(int k=0 ; k<4 ; k++){
          int nx = i + dx[k];
          int ny = j + dy[k];
          if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
          if(map[i][j] == map[nx][ny]) continue;
          go = true;
          break;
        }
        if(!go) continue;
        bfs(i,j);
      }
    }
    System.out.println(min);
  }

  public static void bfs(int x, int y){
    visited = new boolean[N][N];
    LinkedList<int[]> list = new LinkedList<>();
    list.add(new int[]{x, y, 0});
    int startNum = map[x][y];
    while(!list.isEmpty()) {
      int[] cur = list.remove();
      int cx = cur[0];
      int cy = cur[1];
      int cd = cur[2];
      if(cx < 0 || cy < 0 || cx >= N || cy >= N) continue;
      if(visited[cx][cy]) continue;
      visited[cx][cy] = true;
      if(map[cx][cy] != startNum && map[cx][cy] != 0) {
        min = Math.min(min, cd-1);
        return;
      }

      for(int i = 0; i < dx.length; i++) {
        int nx = cx + dx[i];
        int ny = cy + dy[i];
        int nd = cd + 1;
        list.add(new int[]{nx, ny, nd});
      }
    }
  }

  public static void numbering(){
    visited = new boolean[N][N];
    int num = 1;
    for(int i=0 ; i<N ; i++){
      for(int j=0 ; j<N ; j++){
        if(map[i][j] != -1) continue;
        numberingBfs(num, i, j);
        num++;
      }
    }
  }
  public static void numberingBfs(int num, int x, int y){
    LinkedList<int[]> list = new LinkedList<>();
    list.add(new int[]{x, y});
    while(!list.isEmpty()) {
      int[] cur = list.remove();
      int cx = cur[0];
      int cy = cur[1];
      if(cx < 0 || cy < 0 || cx >= N || cy >= N) continue;
      if(map[cx][cy] != -1) continue;
      if(visited[cx][cy]) continue;
      visited[cx][cy] = true;
      map[cx][cy] = num;

      for(int i = 0; i < dx.length; i++) {
        int nx = cx + dx[i];
        int ny = cy + dy[i];
        list.add(new int[]{nx, ny});
      }
    }
  }

  public static void input(BufferedReader br) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    map = new int[N][N];
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken()) * -1;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }
}

