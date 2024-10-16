import java.util.*;
import java.io.*;

public class Main {
  public static int n;
  public static int m;
  public static int[][] map;
  public static boolean[][] visit;
  public static int[] dx = {1, -1, 0, 0};
  public static int[] dy = {0, 0, 1, -1};
  public static int min = 10001;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    map = new int[n][m];
    visit = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      for (int j = 0; j < m; j++) {
        int num = s.charAt(j) - '0';
        map[i][j] = num;
      }
    }
    bfs();

    System.out.println(min);
  }

  public static void bfs(){
    LinkedList<Integer> q = new LinkedList<>();
    q.add(0);
    q.add(0);
    q.add(1);
    while(!q.isEmpty()){
      int curX = q.poll();
      int curY = q.poll();
      int count = q.poll();
      for(int i = 0; i < 4; i++){
        int nx = curX + dx[i];
        int ny = curY + dy[i];
        int nc = count + 1;
        if(nx <0 || ny <0 || nx >= n || ny >= m) continue;
        if(visit[nx][ny] || map[nx][ny] == 0) continue;
        if(nx == n -1 && ny == m - 1){
          min = Math.min(min, nc);
        }
        visit[nx][ny] = true;
        q.add(nx);
        q.add(ny);
        q.add(nc);
      }
    }
  }
}
