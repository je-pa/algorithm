import java.io.*;
import java.util.*;

public class Main {

  public static int N;
  public static int M;
  public static int result = Integer.MAX_VALUE;
  public static int min, max;
  public static int[][] arr;
  public static int[][] twos;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
    StringBuilder sb = new StringBuilder();
    for(int[] two : twos){
      sb.append(arr[two[0]][two[1]]).append('\n');
    }
    System.out.println(sb);
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new int[N+1][N+1];
    twos = new int[M][2];
    for(int i = 1; i <= N; i++) {
      for(int j = 1; j <= N; j++) {
        if(i == j) continue;
        arr[i][j] = Integer.MAX_VALUE;
      }
    }
    for (int i = 0; i < N-1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      arr[a][b] = c;
      arr[b][a] = c;
    }
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      twos[i][0] = a;
      twos[i][1] = b;
    }

  }
  static void pro(){
    for(int i = 1; i <= N; i++) {
      for(int j = 1; j <= N; j++) {
        for(int k = 1; k <= N; k++) {
          if(arr[j][i] == Integer.MAX_VALUE || arr[i][k] == Integer.MAX_VALUE) continue;
          arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
        }
      }
    }

  }
}
