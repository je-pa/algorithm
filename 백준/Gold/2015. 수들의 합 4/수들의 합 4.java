import java.io.*;
import java.util.*;

public class Main {
  static long result;
  static int N;
  static int K;
  static int[] arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
  }

  static void pro() {
    long[] su = new long[N];
    su[0] = arr[0];
    for (int i = 1; i < N; i++) {
      su[i] = su[i -1] + arr[i];
    }
    Map<Long, Long> map = new HashMap<>();
    map.put(0l, 1l);
    for (int i = 0; i < N; i++) {
      result += map.getOrDefault(su[i]-K, 0l);
      map.put(su[i], map.getOrDefault(su[i], 0l) + 1);
    }
    System.out.println(result);
  }
}
