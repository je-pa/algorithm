import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
  static int N, K, P, X;
  static int[][] dg = {{1,1,1,1, 1,1,0}, {0,1,1,0, 0,0,0}, {1,1,0,1, 1,0,1}, {1,1,1,1, 0,0,1}, //  0 1 2 3
      {0,1,1,0, 0,1,1}, {1,0,1,1, 0,1,1}, {1,0,1,1, 1,1,1}, // 4 5 6
      {1,1,1,0, 0,0,0}, {1,1,1,1, 1,1,1}, {1,1,1,1, 0,1,1}};  // 7 8 9
  static int[][] counts = new int[10][10];
  static int[] num;
  static int result = 0;
  static int p = 1;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  static void pro() {
    dfs(0, P, 0);
//    print(counts);
//    print(num);
    System.out.println(result);
  }

  static void print(int[][] arr){
    for(int[] a : arr){
      print(a);
    }
    System.out.println();
  }

  static void print(int[] arr){
    for(int i : arr){
      System.out.print(i+" ");
    }
    System.out.println();
  }

  static void dfs(int idx, int remain, int cur){
    if(cur > N) return;
    if(remain < 0) return;
    if(idx == num.length){
      if(remain == P) return;
      if(cur <= 0 || cur == X) return;
      result ++;
      return;
    }
    for(int i=0 ; i<10 ; i++){
      dfs(idx+1, remain - change(num[idx], i), cur*10 + i);
    }
  }

  static int change(int to, int from){
//    System.out.println("change:: "+to + " " + from + " " + counts[to][from]);
    return counts[to][from];
  }

  static void input(BufferedReader br) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    P = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());
    num = new int[K];
    int idx = num.length - 1;
    int x = X;
    while(x > 0){
      num[idx--] = x%10;
      x/=10;
    }
    for(int i=1 ; i<10 ; i++){
      for(int j=0 ; j<i ; j++){
        int count = 0;
        for(int k = 0 ; k<dg[0].length ; k++){
          if(dg[i][k] != dg[j][k]) count++;
        }
        counts[i][j] = count;
        counts[j][i] = count;
      }
    }
  }
}
