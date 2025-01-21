import java.io.*;
import java.util.*;

public class Main {

  public static int N, M;
  public static int WALL = 1, IS_AVA_B = 2;
  public static int[][] map;
  public static int[] dx = {-1, 0, 1, 0};
  public static int[] dy = {0, -1, 0, 1};
  public static List<int[]> bi = new ArrayList();
  public static int min = Integer.MAX_VALUE;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if(map[i][j] == IS_AVA_B){
          bi.add(new int[]{i, j, 0});
        }
      }
    }
  }

  static void pro() {
    dfs(0, new HashSet<>());
    System.out.println(min == Integer.MAX_VALUE ? -1 : min);
  }
  static void dfs(int cur, HashSet<Integer> set) {
    if(set.size() == M){
      bfs(set);
    }
    for(int i=cur; i<bi.size() ; i++){
      set.add(i);
      dfs(i+1, set);
      set.remove(i);
    }
  }
  static void bfs(HashSet<Integer> set) {
    LinkedList<int[]> q = new LinkedList<>();
    Integer[] arr = set.toArray(new Integer[]{});
    boolean[][] visited = new boolean[N][N];
    for(int i : arr){
      int[] cur = bi.get(i);
      q.add(cur);
      visited[cur[0]][cur[1]] = true;
    }
    int max = 0;
    while(!q.isEmpty()){
      int[] cur = q.poll();
      int cx = cur[0], cy = cur[1], cd = cur[2];
      for(int i=0 ; i<4 ; i++){
        int nx = cx + dx[i];
        int ny = cy + dy[i];
        int nd = cd + 1;
        if(nx <0 || ny <0 || nx >= N || ny >= N) continue;
        if(visited[nx][ny] || map[nx][ny] == WALL) continue;
        visited[nx][ny] = true;
        max = Math.max(max, nd);
        q.add(new int[]{nx, ny, nd});
      }
    }
    for(int i=0 ; i<N ; i++){
      for(int j=0 ; j<N ; j++){
        if(visited[i][j]) continue;
        if(map[i][j] == WALL) continue;
        return;
      }
    }
    min = Math.min(min, max);
  }
}