import java.io.*;
import java.util.*;

public class Main {
  public static int N, K;
  public static int[] dx = {0, 0, 1};
  public static int[] dy;
  public static int[][] arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    dy = new int[]{1, -1, K};
    arr = new int[2][N];
    for(int i =0 ; i < 2 ; i++){
      String line = br.readLine();
      for(int j =0 ; j < N ; j++){
        arr[i][j] = line.charAt(j) - '0';
      }
    }
  }

  static void pro() {
    LinkedList<int[]> q = new LinkedList<>();
    boolean[][] visited=new boolean[2][N];
    q.add(new int[]{0, 0, 0});
    visited[0][0] = true;
    while(!q.isEmpty()){
      int[] c = q.poll();
      int cx = c[0], cy = c[1], cd = c[2];
      for(int i=0 ; i<3 ; i++){
        int nx = (cx + dx[i])%2;
        int ny = cy + dy[i];
        int nd = cd + 1;
        if(ny < nd || ny < 0) continue;
        if(ny > N-1){
          System.out.println(1);
          return;
        }
        if(visited[nx][ny]) continue;
        if(arr[nx][ny]==0) continue;

        visited[nx][ny] = true;
        q.add(new int[]{nx, ny, nd});
      }
    }
    System.out.println(0);
  }

}
