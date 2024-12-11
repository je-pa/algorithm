import java.io.*;
import java.util.*;

public class Main {
  static int result = Integer.MAX_VALUE;
  static int N;
  static boolean[][] arr;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
    System.out.println(result);
  }

  static void input(BufferedReader br) throws Exception {
    N = Integer.parseInt(br.readLine());
    arr = new boolean[N][N];
    for(int i=0 ; i < N ; i++){
      String s = br.readLine();
      for(int j=0 ; j < N ; j++){
        arr[i][j] = s.charAt(j) == 'T';
      }
    }
  }

  static void pro() {
    dfs(0);
  }

  static void dfs(int idx){
    count();
    for(int i=idx ; i<N ; i++){
      for(int j =0 ; j < N ; j++){
        arr[i][j] = ! arr[i][j];
      }
      dfs(i+1);
      for(int j =0 ; j < N ; j++){
        arr[i][j] = ! arr[i][j];
      }
    }
  }
  static void count(){
    int count = 0;
    for(int i=0 ; i<N ; i++){
      int countT = 0;
      for(int j=0 ; j < N ; j++){
        if(arr[j][i]) countT++;
      }
      count += Math.min(countT, N-countT);
    }
    result = Math.min(result, count);
  }

}
