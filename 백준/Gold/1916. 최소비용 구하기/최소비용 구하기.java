import java.util.*;
import java.io.*;

public class Main {
  public static int N;
  public static int M;

  public static int[][] times;
  public static int[] goal = new int[2];


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    set(br);
    go();
    System.out.println(times[goal[0]][goal[1]]);
  }

  private static void set(BufferedReader br) throws IOException {
    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());
    times = new int[N+1][N+1];
    for(int i = 1; i < N+1; i++) {
      for(int j = 1; j < N+1; j++) {
        if(i == j){
          times[i][j]=0;
          continue;
        }
        times[i][j] = 100_000_001;
      }
    }
    for(int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      times[a][b]=Math.min(times[a][b], c);
//      times[b][a]=Math.min(times[b][a], c);
    }


    st = new StringTokenizer(br.readLine());
    goal[0] = Integer.parseInt(st.nextToken());
    goal[1] = Integer.parseInt(st.nextToken());
  }

  public static void go(){
    for(int k = 1; k < N+1; k++) {
      for(int i = 1; i < N+1; i++) {
        for(int j = 1; j < N+1; j++) {
          times[i][j] = Math.min(times[i][k] + times[k][j], times[i][j]);
        }
      }
    }
  }
}
