import java.io.*;
import java.util.*;

public class Main {
  static int result;
  static int R;
  static int C;
  static char[][] arr;
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, 1, 0, -1};
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
    System.out.println(result);
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    arr = new char[R][C];
    for(int i=0 ; i<R ; i++){
      String line = br.readLine();
      for(int j=0 ; j<C ; j++){
        arr[i][j] = line.charAt(j);
      }
    }
  }

  static void pro() {
    Set<Character> set = new HashSet<>();
    set.add(arr[0][0]);
    dfs(0,0, set);

  }
  static void dfs(int x, int y, Set<Character> visited){

    for(int i=0 ; i< 4 ; i++){
      int nx = x + dx[i];
      int ny = y + dy[i];
      if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
      if(visited.contains(arr[nx][ny])) continue;
      visited.add(arr[nx][ny]);
      dfs(nx, ny, visited);
      visited.remove(arr[nx][ny]);
    }
    result = Math.max(result, visited.size());
  }

}

// 16 21
// 15 10.5
// 14 5.25
// 13 2.125
// 12 1.0 -> 8 ^ 4
//