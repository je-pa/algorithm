import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;


public class Main {
  static long T;
  static int N, M;
  static long[] narr;
  static long[] marr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }
  static void pro() {
    Map<Long, Long> map1 = new HashMap<>();
    Map<Long, Long> map2 = new HashMap<>();
    long[] nsum = new long[N];
    long[] msum = new long[M];
    sum(nsum, narr, map1, N);
    sum(msum, marr, map2, M);
    long count = 0;
    for(Entry<Long, Long> e : map1.entrySet()){
      Long key = e.getKey();
      Long v = e.getValue();

      if(map2.containsKey(T-key)){
        count += v * map2.get(T-key);
      }
    }
    System.out.println(count);
  }

  private static void sum(long[] sum, long[] arr, Map<Long, Long> map, int n) {
    sum[0] = arr[0];
    map.put(sum[0], map.getOrDefault(sum[0], 0l)+1l);
    for (int i = 1; i < n; i++) {
      sum[i] = arr[i] + sum[i - 1];
      map.put(sum[i], map.getOrDefault(sum[i], 0l)+1l);
    }

    for(int i = 0; i < n-1; i++) {
      for(int j = i+1; j < n; j++) {
        long k = sum[j] - sum[i];
        map.put(k, map.getOrDefault(k, 0l)+1);
      }
    }
  }

  private static void input(BufferedReader br) throws IOException {
    T = Long.parseLong(br.readLine());
    N = Integer.parseInt(br.readLine());
    narr = new long[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      narr[i] = Integer.parseInt(st.nextToken());
    }

    M = Integer.parseInt(br.readLine());
    marr = new long[M];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      marr[i] = Integer.parseInt(st.nextToken());
    }

  }

}

