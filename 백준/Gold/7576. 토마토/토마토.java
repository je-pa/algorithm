import java.io.*;
import java.util.*;

public class Main {

  static int N;
  static int M;
  static int result = 0;
  static int[][] arr;
  static int[] dx = {-1,1,0,0};
  static int[] dy = {0,0,-1,1};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
    System.out.println(result);
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    arr = new int[N][M];
    for(int i=0 ; i<N ; i++){
      st = new StringTokenizer(br.readLine());
      for(int j =0; j<M ; j++){
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
  }

  static void pro() {
    LinkedList<int[]> q = new LinkedList<>();
    for(int i=0 ; i<N ; i++){
      for(int j=0 ; j<M ; j++){
        if(arr[i][j] == 1){
          q.add(new int[]{i, j, 0});
        }
      }
    }
    while(!q.isEmpty()){
      int[] cur = q.poll();
      int cx = cur[0], cy = cur[1], cl = cur[2];
      result = Math.max(cl, result);
      for(int i=0 ; i<4 ; i++){
        int nx = cx + dx[i];
        int ny = cy + dy[i];
        int nl = cl + 1;
        if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
        if(arr[nx][ny] != 0) continue;
        arr[nx][ny] = 1;
        q.add(new int[]{nx, ny, nl});
      }
    }
    for(int i=0; i<N ; i++){
      for(int j=0 ; j<M ; j++){
        if(arr[i][j] == 0){
          result = -1;
          return;
        }
      }
    }
  }
}
