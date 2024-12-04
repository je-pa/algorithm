import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int R;
  static int C;
  static StringBuilder result = new StringBuilder();
  static int[][] arr;
  static int[][] bell;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    System.out.println(pro((int)Math.pow(2,N), R, C));
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
  }

  static int pro(int n, int x, int y) {
    if(n==2){
      return 2*x + y;
    }
    int d = n/2;
    if(x < d){
      if(y < d){
        return pro(d, x, y);
      }else{
        return d*d + pro(d, x, y-d);
      }
    }else{
      if(y < d){
        return d*d*2 + pro(d, x-d, y);
      }else{
        return d*d*3 + pro(d, x-d, y-d);
      }
    }

  }
}
