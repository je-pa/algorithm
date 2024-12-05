import java.io.*;
import java.util.*;

public class Main {
  static int[][][] ta = {
  {
      {1,1,1,1}
  }
  ,{
      {1,1,1},
      {1,0,0}
  },{
      {1,1,0},
      {0,1,1}
  },{
      {1,1},
      {1,1}
  },{
      {1,1,1},
      {0,1,0}
  }
  };
  static int N;
  static int M;
  static int[][] arr;

  static int result;

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
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

  }

  static void pro() {
    for(int i=0 ; i<N ; i++){
      for(int j=0 ; j<M ; j++){
        for(int[][] t: ta){
          for(int k=0 ; k<4 ; k++){
            result = Math.max(sum(i,j,t), result);
            t = lr(t);
            result = Math.max(sum(i,j,t), result);
            t = ud(t);
            result = Math.max(sum(i,j,t), result);

            if(k==4) continue;
            t = r90(t);
          }
        }
      }
    }
  }
  static int sum(int i, int j, int[][] t){
    if(i+t.length > N) return 0;
    if(j+t[0].length > M) return 0;
    int sum =0;
    for(int r = i ; r<i+t.length ; r++){
      for(int c = j ; c<j+t[0].length ; c++){
        if(t[r-i][c-j] == 1)sum+=arr[r][c];
      }
    }
    return sum;
  }
  static int[][] r90(int[][] arr){
    int r = arr[0].length;
    int c = arr.length;
    int[][] na = new int[r][c];
    for(int i=0 ; i<arr.length ; i++){
      for(int j=0 ; j<arr[i].length ; j++){
        na[j][c-i-1] = arr[i][j];
      }
    }
    return na;
  }
  static int[][] lr(int[][] arr){
    int r = arr.length;
    int c = arr[0].length;
    int[][] na = new int[r][c];
    for(int i=0 ; i<r ; i++){
      for(int j=0 ; j<c ; j++){
        na[i][c-j-1] = arr[i][j];
      }
    }
    return na;
  }
  static int[][] ud(int[][] arr){
    int r = arr.length;
    int c = arr[0].length;
    int[][] na = new int[r][c];
    for(int i=0 ; i<r ; i++){
      for(int j=0 ; j<c ; j++){
        na[r-i-1][j] = arr[i][j];
      }
    }
    return na;
  }
}
