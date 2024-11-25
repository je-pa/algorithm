import java.io.*;
import java.util.*;

public class Main {

  static int N;
  static int M;
  static int[] arr;
  static int result = Integer.MAX_VALUE;
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
    arr = new int[N];
    for (int i = 0; i < N; i++) {
      int a = Integer.parseInt(br.readLine());
      arr[i] = a;
    }
  }

  static void pro() {
    int l = 0;
    int r = 0;
    Arrays.sort(arr);
    while(r != N && l != N){
      if(arr[r] - arr[l] >= M){
        result = Math.min(result, arr[r] - arr[l]);
        l++;
        continue;
      }
      if(arr[r] - arr[l] < M){
        r++;
      }
    }
  }
}
