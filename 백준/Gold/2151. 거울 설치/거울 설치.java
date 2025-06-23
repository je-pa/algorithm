import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;


public class Main {
  static int N;
  static char[][] map;
  static int[] start = new int[2], end = new int[2];
  static char D = '#', E = '.', M = '!', W = '*'; // 문, 빈, 거울가능, 벽
  // 상 하 좌 우
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  static Map<Integer, int[]> dir = new HashMap<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }
  static void pro() {
    PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(x -> x[3]));
    boolean[][][] visited = new boolean[N][N][4];
    for(int i=0 ; i<4 ; i++){
      q.add(new int[] {start[0], start[1], i, 0});
    }
    while(!q.isEmpty()){
      int[] cur = q.poll();
      int cx = cur[0], cy = cur[1];
      int cd = cur[2];
      int count = cur[3];
      if(end[0] == cx && end[1] == cy){
        System.out.println(count);
        return;
      }
      if(visited[cx][cy][cd]) continue;
      visited[cx][cy][cd] = true;
      int[] nDir = dir.get(cd + (map[cx][cy] == M ? 0 : 4)); // 거울 설치방 0~3, 아닌방 5~7
      for(int nd : nDir){
        int nx = cx + dx[nd];
        int ny = cy + dy[nd];
        if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
        if(map[nx][ny] == W) continue;
        int nc = count + (cd == nd ? 0 : 1);
        q.add(new int[] {nx, ny, nd, nc});
      }
    }
  }

  private static void input(BufferedReader br) throws IOException {
    N = Integer.parseInt(br.readLine());
    map = new char[N][N];
    boolean isStart = true;
    dir.put(0, new int[]{0, 2, 3});
    dir.put(1, new int[]{1, 2, 3});
    dir.put(2, new int[]{2, 0, 1});
    dir.put(3, new int[]{3, 0, 1});
    // E
    dir.put(4, new int[]{0});
    dir.put(5, new int[]{1});
    dir.put(6, new int[]{2});
    dir.put(7, new int[]{3});
    for(int i = 0; i < N; i++){
      String line = br.readLine();
      for(int j = 0; j < N; j++){
        map[i][j] = line.charAt(j);
        if(map[i][j] != D) continue;
        if(isStart){
          start[0] = i;
          start[1] = j;
          isStart = false;
          continue;
        }
        end[0] = i;
        end[1] = j;
      }
    }

  }

}

