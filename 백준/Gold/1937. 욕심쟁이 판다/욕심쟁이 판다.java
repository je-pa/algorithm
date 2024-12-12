import java.io.*;
import java.util.*;

public class Main {
  static int result;
  static int N;
  static int[][] arr;
  static int[][] dep;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
    System.out.println(result);
  }

  static void input(BufferedReader br) throws Exception {
    N = Integer.parseInt(br.readLine());
    arr = new int[N][N];
    dep = new int[N][N];
    for(int i=0 ; i < N ; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j=0 ; j < N ; j++){
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
  }

  static void pro() {
    for(int i=0 ; i < N ; i++){
      for(int j=0 ; j < N ; j++){
        if(dep[i][j]>0) continue;
        dfs(i, j, 1);
        result = Math.max(result, dep[i][j]);
//        print();
      }
    }
  }

  static void print(){
    for(int i=0 ; i < N ; i++){
      for(int j=0 ; j < N ; j++){
        System.out.print(dep[i][j]+" ");
      }
      System.out.println();
    }
    System.out.println();
  }

  static void dfs(int x, int y, int d){
    int count = 0;
    if(dep[x][y] > 0) return;
    for(int i=0 ; i<4 ; i++){
      int nx = x + dx[i];
      int ny = y + dy[i];
      if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
      if(arr[x][y] >= arr[nx][ny]) continue;
      count++;
      dfs(nx, ny, d+1);
      if(dep[nx][ny]>0){
        dep[x][y] = Math.max(dep[nx][ny]+1,dep[x][y]);
      }
    }
    if(count==0) dep[x][y] = 1;
  }
}
