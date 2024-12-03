import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int M;
  static int MAX = Integer.MAX_VALUE;
  static StringBuilder result = new StringBuilder();
  static int[][] arr;
  static int[][] bell;

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
    arr = new int[M][3];
    bell = new int[N+1][N+1];
    for(int i=0 ; i<M ; i++){
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      int C = Integer.parseInt(st.nextToken());
      arr[i][0] = A;
      arr[i][1] = B;
      arr[i][2] = C;
    }
    for(int r = 0 ; r<=N ;r++){
      for(int i=2 ; i<=N ; i++){
        bell[r][i] = MAX;
      }
    }
  }

  static void pro() {
    for(int i=1 ; i<N ; i++){
      for(int[] ar : arr){
        int A = ar[0];
        int B = ar[1];
        int C = ar[2];
        if(bell[i-1][A] == MAX) continue;
        if(bell[i-1][A] + C < bell[i-1][B]) bell[i][B] = bell[i-1][A] + C;
      }
      for(int j =1 ; j<=N ; j++){
        bell[i+1][j] = bell[i][j];
      }
    }

    int i = N;
    for(int[] ar : arr){
      int A = ar[0];
      int B = ar[1];
      int C = ar[2];
      if(bell[i-1][A] == MAX) continue;
      if(bell[i-1][A] + C < bell[i-1][B]) {
        result.append("-1");
        return;
      }
    }

    for(int k = 2 ; k<=N ; k++){
      result.append(bell[N][k] ==MAX? -1 : bell[N][k]).append("\n");
    }
  }
}
