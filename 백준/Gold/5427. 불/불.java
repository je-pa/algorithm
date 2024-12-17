import java.io.*;
import java.util.*;

public class Main {
  static int result = -50_000;
  static int N;
  static int M;
  static int[][] arr;
  static int W = -1, BIN = 0, S = 1, F=-2;
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, -1, 0, 1};
  static int sx = 0;
  static int sy = 0;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for(int i=0 ; i<T ; i++){
      result = Integer.MAX_VALUE;
      input(br);
      pro();
      System.out.println(result == Integer.MAX_VALUE ? "IMPOSSIBLE" : result);
    }
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    arr = new int[N][M];
    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < M; j++) {
        char c = line.charAt(j);
        int input = 0;
        if(c == '#'){
          input = W;
        }else if(c == '@'){
          input = S;
          sx = i;
          sy = j;
        }else if(c == '*'){
          input = F;
        }

        arr[i][j] = input;
      }
    }

  }

  static void pro() {
    LinkedList<int[]> q = new LinkedList<>();

    q.add(new int[]{sx, sy, 0});
    for(int i=0 ; i<N ; i++){
      for(int j=0 ; j<M ; j++){
        if(arr[i][j] == F){
          q.add(new int[]{i, j, 0});
        }
      }
    }
    while(!q.isEmpty()){
      int[] cur = q.poll();
      int cx = cur[0];
      int cy = cur[1];
      int cd = cur[2];
      if(arr[cx][cy] == S && (cx== 0 || cy == 0 || cx == N-1 || cy == M-1)){
        result = cd+1;
        return;
      }
      for(int i=0 ; i<4 ; i++){
        int nx = cx + dx[i];
        int ny = cy + dy[i];
        int nd = cd + 1;
        if(isNotAva(cx,cy,nx,ny)) continue;
        arr[nx][ny] = arr[cx][cy];

        q.add(new int[]{nx, ny, nd});
      }
    }
  }
  static boolean isNotAva(int cx, int cy, int nx, int ny){
    if(isSizeOut(nx,ny,N,M)) return true;
    if(arr[cx][cy] == S) return arr[nx][ny] == W || arr[nx][ny] == F || arr[nx][ny] == S;
    if(arr[cx][cy] == F) return arr[nx][ny] == W || arr[nx][ny] == F;
    return arr[nx][ny] == W || arr[nx][ny] == F;
  }
  static boolean isSizeOut(int nx, int ny, int N, int M){
    return nx<0 || ny<0 || nx>=N || ny>=M;
  }
}