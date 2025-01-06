import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int M;
  static boolean[][] arr;
  static int[] dx = {-1,1,0,0};
  static int[] dy = {0,0,-1,1};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    arr = new boolean[N][M];
    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < line.length(); j++) {
        arr[i][j] = line.charAt(j) == '1';
      }
    }
  }

  static void pro() {
    System.out.println(check());
  }
  static int check() {
    PriorityQueue<int[]> q = new PriorityQueue<>((x,y) -> Integer.compare(x[2], y[2]));
    boolean[][] visited =  new boolean[N][M];

    q.add(new int[]{0,0,0});
    while(!q.isEmpty()){
      int[] cur = q.poll();
      int x = cur[0],
          y = cur[1]
      ;
      for(int i=0 ; i<4 ; i++){
        int cnt = cur[2];
        int nx = x + dx[i],
            ny = y + dy[i]
        ;
        if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
        if(arr[nx][ny]) cnt += 1;
        if(visited[nx][ny]) continue;
        if(nx == N-1 && ny == M-1){
          return cnt;
        }
        visited[nx][ny] = true;
        q.add(new int[]{nx,ny,cnt});
      }

    }
    return 0;
  }
}
