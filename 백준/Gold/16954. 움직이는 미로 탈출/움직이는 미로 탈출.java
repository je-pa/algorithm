import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
  static int N=8;
  static boolean[][] map;
  static int[] dx = {-1, 1, 0, 0, 1, 1, -1, -1, 0};
  static int[] dy = {0, 0, -1, 1, 1, -1, 1, -1, 0};
  static boolean[][][] visited = new boolean[50][N][N];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }
  private static void input(BufferedReader br) throws IOException {
    map = new boolean[N][N];
    for(int i = 0; i < N; i++){
      String line = br.readLine();
      for(int j = 0; j < N; j++){
        map[i][j] = line.charAt(j) == '#';
      }
    }
  }

  private static void pro() {
    bfs();
  }

  private static void bfs(){
    LinkedList<int[]> q = new LinkedList<>();
    q.offer(new int[]{N-1, 0,0});
    while(!q.isEmpty()){
      int[] cur = q.poll();
      int cx = cur[0];
      int cy = cur[1];
      int cd = cur[2];
      if(cx == N-1 && cy == N-1) {
        System.out.println(1);
        return;
      }
      if(visited[cd][cx][cy]) continue;
      visited[cd][cx][cy] = true;
      for(int i=0 ; i<dx.length ; i++){
        int nx = cx + dx[i];
        int ny = cy + dy[i];
        int nd = cd + 1;
        if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
        if(nx-cd>=0 && map[nx-cd][ny]) continue;
        if(nx-nd >=0 && map[nx-nd][ny]) continue;
        q.offer(new int[]{nx,ny,nd});
      }
    }
    System.out.println(0);
  }

}

