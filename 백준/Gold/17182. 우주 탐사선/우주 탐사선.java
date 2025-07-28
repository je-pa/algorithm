import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
  static int N, K;
  static int[][] arr;
  static boolean[] visited;
  static int result = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }
  static void pro() {
    for(int k = 0; k <N ; k++){
      for(int i =0 ; i< N ; i++){
        for(int j =0 ; j< N ; j++){
          arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
        }
      }
    }
      visited[K] = true;
    dfs(K, 1, 0);
    System.out.println(result);
  }

  static void dfs(int now, int dep, int cost) {
    if(cost > result) return;
    if(dep == N) {
      result = Math.min(result, cost);
      return;
    }
    for(int i =0 ; i< N ; i++){
      if(visited[i]) continue;
      visited[i] = true;
      dfs(i, dep+1, cost+arr[now][i]);
      visited[i] = false;
    }
  }

  private static void input(BufferedReader br) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    arr = new int[N][N];
    visited = new boolean[N];

    for(int i=0 ; i<N ; i++){
      st = new StringTokenizer(br.readLine());
      for(int j=0 ; j<N ; j++){
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
  }

}

