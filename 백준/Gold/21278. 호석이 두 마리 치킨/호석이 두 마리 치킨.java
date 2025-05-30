import java.io.*;
import java.util.*;

public class Main {

  public static int N;
  public static int M;
  public static int result = Integer.MAX_VALUE;
  public static int min, max;
  public static int[][] arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
    StringBuilder sb = new StringBuilder();
    sb.append(min);
    sb.append(" ");
    sb.append(max);
    sb.append(" ");
    sb.append(result*2);

    System.out.println(sb);
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new int[N+1][N+1];
    for(int i = 1; i <= N; i++) {
      for(int j = 1; j <= N; j++) {
        if(i == j) continue;
        arr[i][j] = 101;
      }
    }
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      arr[a][b] = 1;
      arr[b][a] = 1;
    }
  }
  static void pro(){
    for(int i = 1; i <= N; i++) {
      for(int j = 1; j <= N; j++) {
        for(int k = 1; k <= N; k++) {
          if(arr[j][i] == 101 || arr[i][k] == 101) continue;
          arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
        }
      }
    }
    for(int i = 1; i <= N; i++) {
      for(int j = i+1; j <= N; j++) {
        int sum = 0;
        if(i == j) continue;
        for(int k = 1; k <= N; k++) {
          if(i == k || j == k) continue;
          sum+=Math.min(arr[i][k], arr[j][k]);
        }
        if(sum < result){
          result = sum;
          min = i;
          max = j;
        }
      }
    }
  }
}
