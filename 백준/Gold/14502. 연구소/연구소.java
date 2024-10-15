import java.util.*;
import java.io.*;

public class Main {
  public static Set<Integer> set = new TreeSet<>();
  public static int n;
  public static int m;
  public static int[][] map;
  public static boolean[][] visit;
  public static int[] dx = {1, -1, 0, 0};
  public static int[] dy = {0, 0, 1, -1};
  public static List<int[]> list = new ArrayList<>();
  public static int maxZero = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    map = new int[n][m];
    visit = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        int num = Integer.parseInt(st.nextToken());
        map[i][j] = num;
        if(num == 2) list.add(new int[]{i, j});
      }
    }
    setWall(0, 0, 0);
    System.out.println(maxZero);
  }
  public static void setWall(int x, int y, int count){
    if(x >= n || y >= m) return;
    if(count == 3) {
      setVisit();
      for(int[] arr : list) {
        virus(arr[0], arr[1]);
      }
      zeroCount();
      return;
    }
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < m; j++) {
        if(map[i][j] == 0){
          map[i][j] = -1;
          setWall(i, j, count+1);
          map[i][j] = 0;
        }
      }
    }
  }

  private static void zeroCount() {
    int zero = 0;
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < m; j++) {
        if(map[i][j] == 0 && !visit[i][j]) zero++;
      }
    }
    maxZero = Math.max(maxZero, zero);
  }

  public static void setVisit(){
    for(int i = 0; i < n; i++){
      for(int j = 0; j < m; j++){
        visit[i][j] = false;
      }
    }
  }
  public static void virus(int x, int y){
    if(x < 0 || y < 0 || x >= n || y >= m) return;
    if(visit[x][y] || map[x][y] == 1 || map[x][y] == -1) return;
    visit[x][y] =true;
    for(int i =0 ; i < dx.length ; i++){
      virus(x+dx[i], y+dy[i]);
    }
  }
}
