import java.io.*;
import java.util.*;

public class Main {
  static int result;
  static int N;
  static int M;
  static int[][] arr;
  static boolean[][] check;

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
    check = new boolean[N][M];
    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for(int j = 0; j < M; j++) {
        int a = line.charAt(j)-'0';
        arr[i][j] = a;
      }
    }
  }

  static void pro() {
    dfs(0,0);
  }
  static void dfs(int x, int y){
    if(y==M){
      dfs(x+1, 0);
      return;
    }
    if(x==N){
      sum();
      return;
    }
    check[x][y] = true;
    dfs(x, y+1);

    check[x][y] = false;
    dfs(x, y+1);
  }

  static void sum(){
    int sum = 0;
    for(int i=0; i<N; i++){
      int cur = 0;
      for(int j=0; j<M; j++){
        if(check[i][j]){
          cur = cur * 10 + arr[i][j];
        }else{
          sum += cur;
          cur = 0;
        }
      }
      sum+=cur;
    }
    for(int i=0; i<M; i++){
      int cur = 0;
      for(int j=0; j<N; j++){
        if(!check[j][i]){
          cur = cur*10 + arr[j][i];
        }else{
          sum += cur;
          cur = 0;
        }
      }
      sum += cur;
    }
    result = Math.max(sum, result);
  }
}
