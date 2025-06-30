import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
  static int N, M, W;
  static int[][] branches;
  static int[][] bellman;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int TC = Integer.parseInt(br.readLine());
    for (int t = 1; t <= TC; t++) {
      input(br);
      pro();
    }
    System.out.println(sb);
  }
  private static void input(BufferedReader br) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    W = Integer.parseInt(st.nextToken());
    branches = new int[M*2+W][3];
    bellman = new int[N+1][N+1];

    int idx = 0;
    for(int i = 0 ; i < M; i ++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      branches[idx][0] = a;
      branches[idx][1] = b;
      branches[idx][2] = c;
      idx ++;
      branches[idx][0] = b;
      branches[idx][1] = a;
      branches[idx][2] = c;
      idx ++;
    }

    for(int i = 0 ; i < W; i ++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken()) * -1;
      branches[idx][0] = a;
      branches[idx][1] = b;
      branches[idx][2] = c;
      idx ++;
    }
  }

  private static void pro() {
    for(int i=1 ; i<N; i++){
      for(int[] branch:branches){
        int a = branch[0];
        int b = branch[1];
        int c = branch[2];
        bellman[i][b] = Math.min(bellman[i-1][a]+c, bellman[i][b]);
      }

      for(int j=1 ; j<=N ; j++){
        bellman[i+1][j] = bellman[i][j];
      }
    }

    for(int[] branch:branches){
      int a = branch[0];
      int b = branch[1];
      int c = branch[2];
      if(bellman[N-1][a]+c < bellman[N-1][b]){
        sb.append("YES\n");
        return;
      }
    }
    sb.append("NO\n");
  }

}

