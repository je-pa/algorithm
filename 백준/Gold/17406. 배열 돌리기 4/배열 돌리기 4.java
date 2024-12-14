import java.io.*;
import java.util.*;

public class Main {
  static int result = Integer.MAX_VALUE;
  static int N;
  static int M;
  static int K;
  static int[][] arr;
  static int[][] rcs;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
//    System.out.println(2500 * 6 * 6*5*4*3*2);
    System.out.println(result);
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    arr = new int[N][M];
    rcs = new int[K][3];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < M; j++) {
        int a = Integer.parseInt(st.nextToken());
        arr[i][j] = a;
      }
    }
    for(int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      rcs[i][0] = a-1;
      rcs[i][1] = b-1;
      rcs[i][2] = c;
    }
//    print(arr);
//    System.out.println();
//    rotate(arr, new int[]{2,2,2});
//    print(arr);
//    System.out.println();
//    recover(arr, new int[]{2,2,2});
//    print(arr);
//    System.out.println();
  }
//  static void print(int[][] arr){
//    for(int[] i : arr){
//      for(int k : i){
//        System.out.print(k+" ");
//      }
//      System.out.println();
//    }
//  }

  static void pro() {
    dfs(new HashSet<>());
  }
  static void dfs(Set<Integer> set){
    if(set.size() == K){
      result = Math.min(result, count(arr));
      return;
    }
    for(int i = 0; i < K; i++){
      if(set.contains(i)) continue;
      set.add(i);
      rotate(arr, rcs[i]);
      dfs(set);
      recover(arr, rcs[i]);
      set.remove(i);
    }

  }
  static void rotate(int[][] arr, int[] rcs) {
      int r = rcs[0];
      int c = rcs[1];
      int s = rcs[2];
      for(int i=1 ; i<=s ; i++){
        int curX = r - i;
        int before = arr[curX][c-i];
        for(int y = c-i ; y < c+i ; y++){
          int next = arr[curX][y+1];
          arr[curX][y+1] = before;
          before = next;
        }
        int curY = c + i;
        for(int x = r-i ; x < r+i ; x++){
          int next = arr[x+1][curY];
          arr[x+1][curY] = before;
          before = next;
        }
        curX = r + i;
        for(int y = c+i ; y > c-i ; y--){
          int next = arr[curX][y-1];
          arr[curX][y-1] = before;
          before = next;
        }
        curY = c - i;
        for(int x = r+i ; x > r-i ; x--){
          int next = arr[x-1][curY];
          arr[x-1][curY] = before;
          before = next;
        }
      }
  }
  static void recover(int[][] arr, int[] rcs) {
    int r = rcs[0];
    int c = rcs[1];
    int s = rcs[2];
    for(int i=1 ; i<=s ; i++){
      int curX = r - i;
      int before = arr[curX][c+i];
      for(int y = c+i ; y > c-i ; y--){
        int next = arr[curX][y-1];
        arr[curX][y-1] = before;
        before = next;
      }

      int curY = c - i;
      for(int x = r-i ; x < r+i ; x++){
        int next = arr[x+1][curY];
        arr[x+1][curY] = before;
        before = next;
      }

      curX = r + i;
      for(int y = c-i ; y < c+i ; y++){
        int next = arr[curX][y+1];
        arr[curX][y+1] = before;
        before = next;
      }

      curY = c + i;
      for(int x = r+i ; x > r-i ; x--){
        int next = arr[x-1][curY];
        arr[x-1][curY] = before;
        before = next;
      }
    }
  }
  static int count(int[][] arr){
    int min = Integer.MAX_VALUE;
    for(int[] i : arr){
      min = Math.min(min, Arrays.stream(i).sum());
    }
    return min;
  }
}// 2500 * 6 * 6*5*4*3*2
