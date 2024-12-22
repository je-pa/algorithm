import java.io.*;
import java.util.*;

public class Main {
  static int result;
  static int N;
  static int M;
  static char[][] map ;
  static boolean[][] visited;
  static Set<Character> keys;
  static Map<Character, LinkedList<int[]>> points;
  static int[] dx = {0,0,1,-1};
  static int[] dy = {1,-1,0,0};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= T; t++) {
      input(br);
      pro();
      System.out.println(result);
    }
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    result = 0;
    map = new char[N][M];
    visited = new boolean[N][M];
    keys = new HashSet<>();
    points = new HashMap<>();
    for(int i = 'A'; i <= 'Z'; i++) {
      points.put((char)i, new LinkedList<>());
    }
    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for(int j = 0; j < M; j++) {
        map[i][j] = line.charAt(j);
      }
    }
    String line = br.readLine();
    if(line.equals("0")) return;
    for(int i = 0 ; i < line.length() ; i++) {
      keys.add(line.charAt(i));
    }
  }

  static void pro() {
    for(int i = 0 ; i < N ; i++) {
      dfs(i, 0);
      dfs(i, M-1);
    }

    for(int i = 0 ; i < M ; i++) {
      dfs(0, i);
      dfs(N-1, i);
    }
    while(true){
      boolean check = false;
      Object[] keyList = keys.toArray();
      
      for(Object key : keyList) {
        LinkedList<int[]> doors = points.get(toD((char)key));
        if(!doors.isEmpty()) check = true;
        while(!doors.isEmpty()) {
          int[] door = doors.removeFirst();
          map[door[0]][door[1]] = '.';
          dfs(door[0], door[1]);
        }
      }
      if(!check) break;
    }

  }
  static char toD(char c){
    return (char)(c - ('a'-'A'));
  }
  static void dfs(int x, int y){
    if(isOut(x, y)) return;
    if(visited[x][y]) return;
    if(map[x][y] == '*') return;
    if(isKey(map[x][y])) {
      keys.add(map[x][y]);
    }
    if(isDoor(map[x][y])){
      points.get(map[x][y]).add(new int[]{x, y});
      return;
    }
    if(map[x][y] == '$'){
      result++;
    }
    visited[x][y] = true;
    for(int k = 0; k < 4; k++) {
      int nx = x + dx[k], ny = y + dy[k];
      dfs(nx, ny);
    }
  }
  static boolean isOut(int x, int y){
    return x < 0 || x >= N || y < 0 || y >= M;
  }
  static boolean isKey(char c){
    return 'a' <= c && c <= 'z';
  }

  static boolean isDoor(char c){
    return 'A' <= c && c <= 'Z';
  }
}