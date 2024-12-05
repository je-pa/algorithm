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
    for(int[][] t: ta){
      for(int k=0 ; k<4 ; k++){
        if(k!=0) t = r90(t);
        result = Math.max(maxSum(t), result);
      }
      t = lr(t);
      for(int k=0 ; k<4 ; k++){
        if(k!=0) t = r90(t);
        result = Math.max(maxSum(t), result);
      }
    }
  }


  static int maxSum(int[][] t){
    int max = 0;
    for(int i=0 ; i<N ; i++) {
      for (int j = 0; j < M; j++) {
        int sum =0;
        if(i+t.length > N) continue;
        if(j+t[0].length > M) continue;
        for(int r = i ; r<i+t.length ; r++){
          for(int c = j ; c<j+t[0].length ; c++){
            if(t[r-i][c-j] == 1)sum+=arr[r][c];
          }
        }
        max = Math.max(max, sum);
      }
    }

    return max;
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

}
