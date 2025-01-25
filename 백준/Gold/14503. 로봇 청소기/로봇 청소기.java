import java.io.*;
    import java.util.*;

public class Main {
  public static int[] dx = {-1,0,1,0}; //북 동 남 서
  public static int[] dy = {0,1,0,-1};

  public static int N, M, R, C, D;
  public static int[][] arr;
  public static int result =0;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    D = Integer.parseInt(st.nextToken());
    arr = new int[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
  }

  static void pro() {
    while(true){
      if(arr[R][C] == 0){
        arr[R][C] = -1;
        result ++;
      }
      boolean isClean = true;
      for (int i = 0; i < 4; i++) {
        int nr = R + dx[i];
        int nc = C + dy[i];
        if(arr[nr][nc] == 0) {
          isClean = false;
          break;
        }
      }
      if(isClean){
        int backD = (D + 2)% 4;
        int nr = R + dx[backD];
        int nc = C + dy[backD];
        if(nr < 0 || nc < 0 || nr >= N || nc >= M || arr[nr][nc] == 1) break;
        R = nr;
        C = nc;
      }else{
        D = (D+4-1)%4;
        int nr = R + dx[D];
        int nc = C + dy[D];
        if(arr[nr][nc] == 0) {
          R = nr;
          C = nc;
        }
      }
    }
    System.out.println(result);
  }
}