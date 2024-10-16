import java.util.*;
import java.io.*;

public class Main {
  public static int n;
  public static int m;
  public static char[][] map;
  public static boolean[][] visit;
  public static int[] dx = {1, -1, 0, 0};
  public static int[] dy = {0, 0, 1, -1};
  public static ArrayList<int[]> waters = new ArrayList<>();
  public static int[] S = new int[2];
  public static int w = '*'+0;
  public static int dochi = 'S'+0;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    map = new char[n][m];
    visit = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      for (int j = 0; j < m; j++) {
        char c = s.charAt(j);
        map[i][j] = c;
        if(c == 'S') {
          S[0] = i;
          S[1] = j;
          continue;
        }
        if(c == '*'){
          waters.add(new int[]{i, j});
        }
      }
    }
    int result = bfs();
    System.out.println(result == 0 ? "KAKTUS" : result);
  }

  public static int bfs(){
    LinkedList<Integer> q = new LinkedList<>();
    for(int[] water: waters) {
      q.add(water[0]);
      q.add(water[1]);
      q.add(w);
      q.add(0);
    }
    q.add(S[0]);
    q.add(S[1]);
    q.add(dochi);
    q.add(0);
    while(!q.isEmpty()){
      int cx = q.poll();
      int cy = q.poll();
      int type = q.poll();
      int count = q.poll();
      visit[cx][cy] = true;
      if(type == dochi && map[cx][cy] == 'D') return count;
      for(int i = 0; i < 4; i++){
        int nx = cx + dx[i];
        int ny = cy + dy[i];
        int nc = count+1;
        if(nx <0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny] || map[nx][ny] == 'X') continue;
        if(type == dochi){
          if(map[nx][ny] == '*') continue;
        }else if(type == w){
          if(map[nx][ny] == 'D') continue;
        }
        visit[nx][ny] = true;
        q.add(nx);
        q.add(ny);
        q.add(type);
        q.add(nc);

      }
    }
    return 0;
  }
}
