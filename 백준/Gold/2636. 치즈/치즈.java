import java.io.*;
import java.util.*;

public class Main {
  public static int N, M;
  public static boolean[][] map;
  public static int[] dx = {-1, 0, 1 ,0};
  public static int[] dy = {0, -1, 0 ,1};


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
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken()) == 1;
      }
    }
  }

  static void pro() {
    int countBefore = 0, countAfter = -1;
    int t = 0;
    while(countAfter != 0){
      countBefore = countAfter;
      countAfter = bfs(t);
      t++;
    }
    System.out.println(t-1);
    System.out.println(countBefore);
  }

  public static int bfs(int t) {
    List<int[]> list = new ArrayList<>();
    LinkedList<int[]> q = new LinkedList<>();
    q.add(new int[]{t,t});
    boolean[][] visited = new boolean[N][M];
    visited[t][t] = true;
    while(!q.isEmpty()){
      int[] c = q.poll();
      int cx = c[0], cy = c[1];
      for(int i = 0; i < dx.length; i++){
        int nx = cx + dx[i];
        int ny = cy + dy[i];
        if(nx < t || ny < t || nx >= N -t || ny >= M -t) continue;
        if(visited[nx][ny]) continue;
        if(map[nx][ny]) {
          list.add(new int[]{nx,ny});
          continue;
        }
        q.add(new int[]{nx,ny});
        visited[nx][ny] = true;
      }
    }
    int count = 0;
    for(int[] arr : list){
      if(map[arr[0]][arr[1]]) {
        map[arr[0]][arr[1]] = false;
        count++;
      }
    }
    return count;
  }

}
