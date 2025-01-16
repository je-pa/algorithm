import java.io.*;
import java.util.*;

public class Main {

  public static int N, K, S;
  public static int[][] arr;
  public static int[][] qs;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    arr = new int[N+1][N+1];
    for(int i = 0; i < K; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      arr[a][b] = -1;
      arr[b][a] = 1;
    }
    S = Integer.parseInt(br.readLine());
    qs = new int[S][2];
    for(int i = 0; i < S; i++){
      st = new StringTokenizer(br.readLine());
      qs[i][0] = Integer.parseInt(st.nextToken());
      qs[i][1] = Integer.parseInt(st.nextToken());
    }
  }

  static void pro() {
    for(int k=1 ; k<N+1 ; k++){
      for(int i=1 ; i<N+1 ; i++){
        for(int j=1 ; j<N+1 ; j++){
          if(arr[i][k] == -1 && arr[k][j] == -1){
            arr[i][j] = -1;
            arr[j][i] = 1;
          }
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for(int[] q : qs){
      sb.append(arr[q[0]][q[1]]);
      sb.append("\n");
    }
    System.out.println(sb);
  }
}