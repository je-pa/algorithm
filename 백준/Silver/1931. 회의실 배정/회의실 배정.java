import java.io.*;
import java.util.*;

public class Main {

  static int N;
  static int[][] arr;
  static int result = 0;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
    System.out.println(result);
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    arr = new int[N][2];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      arr[i][0] = a;
      arr[i][1] = b;
    }
  }

  static void pro() {
    Arrays.sort(arr, (x, y) -> {
      if(x[1] != y[1]){
        return Integer.compare(x[1], y[1]);
      }
      return Integer.compare(x[0], y[0]);
    });
    int k = -1;
    for(int i = 0; i < N; i++){
      if(k <= arr[i][0]) {
        result ++;
        k = arr[i][1];
      }
    }
  }
}
