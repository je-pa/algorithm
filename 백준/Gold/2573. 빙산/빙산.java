import java.io.*;
import java.util.*;

public class Main {
  static int result;
  static int N;
  static int M;
  static int[][] arr;
  static boolean[][] visited;
  static int[] dx = {-1, 1,0,0};
  static int[] dy = {0, 0,1,-1};
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
    System.out.println(result);
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new int[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < M; j++) {
        int a = Integer.parseInt(st.nextToken());
        arr[i][j] = a;
      }
    }

  }

  static void pro() {
    int meltCount = 0;
    while(true){
      int[][] meltArr = melt(arr);
      arr = meltArr;
      meltCount++;
      int count = countPart(meltArr);
      if(count >1){
        result = meltCount;
        break;
      }
      if(count == 0){
        result = 0;
        break;
      }
    }
  }
  static int[][] melt(int[][] arr){
    int[][] newArr = new int[N][M];
    for(int i=0 ; i<N ; i++){
      for(int j=0 ; j<M ; j++){
        if(arr[i][j] == 0) continue;
        int meltCount = 0;
        for(int k = 0 ; k<4 ; k++){
          int nx = i+dx[k];
          int ny = j+dy[k];
          if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
          if(arr[nx][ny] == 0) meltCount++;
        }
        newArr[i][j] = Math.max(arr[i][j] - meltCount, 0);
      }
    }
    return newArr;
  }
  static void dfs(int x, int y, int[][] arr){
    visited[x][y] = true;
    for(int i=0 ; i<4 ; i++){
      int nx = x + dx[i];
      int ny = y + dy[i];
      if(nx<0 || ny<0 || nx>=N || ny >= M) continue;
      if(arr[nx][ny]==0) continue;
      if(visited[nx][ny]) continue;
      dfs(nx, ny, arr);
    }
  }
  static int countPart(int[][] arr){
    visited = new boolean[N][M];
    int count = 0;
    for(int i=0 ; i<N ; i++){
      for(int j=0 ; j<M ; j++){
        if(arr[i][j] != 0 && !visited[i][j]){
          dfs(i, j, arr);
          count++;
        }
      }
    }
    return count;
  }
}