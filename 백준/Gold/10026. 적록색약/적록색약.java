import java.io.*;
import java.util.*;

public class Main {

  static int N;
  static StringBuilder result = new StringBuilder();
  static char[][] arr;
  static char R = 'R', G = 'G', B = 'B';
  static int[] dx = {-1,1,0,0};
  static int[] dy = {0,0,-1,1};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro(new boolean[N][N], false);
    pro(new boolean[N][N], true);
    System.out.println(result);
  }

  static void input(BufferedReader br) throws Exception {
    N = Integer.parseInt(br.readLine());
    arr = new char[N][N];
    for(int i=0 ; i<N ; i++){
      String str = br.readLine();
      for(int j =0; j<N ; j++){
        arr[i][j] = str.charAt(j);
      }
    }
  }

  static void pro(boolean[][] visited, boolean person) {
    Map<Character, char[]> map = new HashMap<>();
    if(person){
      map.put(R, new char[]{R, G});
      map.put(G, new char[]{R, G});
      map.put(B, new char[]{B});
    }else{
      map.put(R, new char[]{R});
      map.put(G, new char[]{G});
      map.put(B, new char[]{B});
    }
    int count =0;
    for(int i=0 ; i<N ; i++){
      for(int j=0 ; j<N ; j++){
        if(!visited[i][j]){
          dfs(visited, i, j, map);
          count++;
        }
      }
    }
    result.append(count).append(" ");
  }
  static void dfs(boolean[][] visited, int x, int y, Map<Character, char[]> map){
    visited[x][y] = true;
    char[] next = map.get(arr[x][y]);
    for(int i=0 ; i<4 ; i++){
      int nx = x + dx[i];
      int ny = y + dy[i];
      if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;
      for(char c : next){
        if(arr[nx][ny] == c){
          dfs(visited, nx, ny, map);
        }
      }
    }
  }
}
