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
  static int countLand = 0;
  static int[] dx = {1,-1,0,0};
  static int[] dy = {0,0,1,-1};

  public static void print(){
    for(int i=0;i<N;i++){
      for(int j=0;j<N;j++){
        System.out.print(map[i][j]+" ");
      }
      System.out.println();
    }
  }
  public static void pro() {
    numbering();
    for(int i=1 ; i<countLand ; i++){
      bfs(i);
    }

    System.out.println(min);
  }

  public static void bfs(int num){
    visited = new boolean[N][N];
    LinkedList<int[]> list = new LinkedList<>();

    for(int i=0 ; i<N ; i++){
      for(int j=0 ; j<N ; j++){
        if(map[i][j] != num) continue;
        list.add(new int[]{i,j,0});
      }
    }

    while(!list.isEmpty()) {
      int[] cur = list.remove();
      int cx = cur[0];
      int cy = cur[1];
      int cd = cur[2];
      if(cx < 0 || cy < 0 || cx >= N || cy >= N) continue;
      if(visited[cx][cy] || map[cx][cy] == -1) continue;
      visited[cx][cy] = true;
      if(map[cx][cy] != num && map[cx][cy] != 0 && map[cx][cy] != -1) {
        min = Math.min(min, cd-1);
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
    countLand = 1;
    for(int i=0 ; i<N ; i++){
      for(int j=0 ; j<N ; j++){
        if(map[i][j] > -1 || visited[i][j]) continue;
        numberingBfs(countLand, i, j);
        countLand++;
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
      if(map[cx][cy] > -1) continue;
      if(visited[cx][cy]) continue;
      visited[cx][cy] = true;

      for(int i = 0; i < dx.length; i++) {
        int nx = cx + dx[i];
        int ny = cy + dy[i];
        if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
        list.add(new int[]{nx, ny});
        if(map[nx][ny] == 0) map[cx][cy] = num;
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

