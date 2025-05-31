import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
  static int N, M;
  static int[][] map;
  static int[][] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  static void pro() {
    for(int k = 1 ; k <= N ; k++) {
      for(int i = 1 ; i < N ; i++){
        for(int j = i+1 ; j <= N ; j++){
          if(map[i][k] == Integer.MAX_VALUE) continue;
          if(map[j][k] == Integer.MAX_VALUE) continue;
          map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
          map[j][i] = map[i][j];
        }
      }
    }
    StringBuilder sb= new StringBuilder();
    for(int[] a : arr){
      sb.append(map[a[0]][a[1]]).append("\n");
    }
    System.out.println(sb);
  }

  static void input(BufferedReader br) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N+1][N+1];
    arr = new int[M][2];
    for(int i=1 ; i<=N ; i++){
      for(int j=1 ; j<=N ; j++){
        if(i==j) continue;
        map[i][j] = Integer.MAX_VALUE;
      }
    }
    for(int i = 1; i < N; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      map[a][b] = c;
      map[b][a] = c;
    }
    for(int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      arr[i][0] = a;
      arr[i][1] = b;
    }
  }
}
