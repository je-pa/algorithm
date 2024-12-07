import java.io.*;
import java.util.*;

public class Main {
  static StringBuilder result = new StringBuilder();
  static int[] tree;
  static int[][] ms;
  static int N;
  static int M;
  static int K;
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
    ms = new int[M][2];
    K = 0;
    while(Math.pow(2, K) < N) K++;
    tree = new int[(int)Math.pow(2,K)*2];
    for(int i = 0 ; i< N ; i++){
      tree[tree.length/2+i] = Integer.parseInt(br.readLine());
    }
    for(int i= tree.length/2-1 ; i>0 ; i--){
      if(tree[i*2+1] == 0 && tree[i*2] != 0) {
        tree[i] = tree[i*2];
        continue;
      }
      tree[i] = Math.min(tree[i*2],tree[i*2+1]);
    }

    for(int i=0 ; i<M ; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      ms[i][0] = a;
      ms[i][1] = b;
    }
  }

  static void pro() {

    for(int[] m : ms){
      int s = m[0] + tree.length/2 - 1;
      int e = m[1] + tree.length/2 - 1;
      int min = Integer.MAX_VALUE;
      while(s <= e){
        if(s%2 == 1 && tree[s] != 0) min = Math.min(min, tree[s]);
        if(e%2 == 0 && tree[e] != 0) min = Math.min(min, tree[e]);
        s = (s+1) / 2;
        e = (e-1) / 2;
      }
      result.append(min).append("\n");
    }
  }


}
//                        5
//             20                   5
//      30           20         5       0
//   30    38     50    20    5   0   0   0
// 75 30 100 38 50 51 52 20 81 5 0 0 0 0 0 0