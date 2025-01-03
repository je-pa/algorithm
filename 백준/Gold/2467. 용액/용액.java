import java.io.*;
import java.util.*;

public class Main {
  static int result;
  static int N;
  static PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(Math::abs));

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      pq.add(Integer.parseInt(st.nextToken()));
    }
  }

  static void pro() {
    int before = pq.poll();
    int min = Integer.MAX_VALUE;
    int[] arr = new int[2];
    while(!pq.isEmpty()) {
      int cur = pq.poll();
      int g = Math.abs(before + cur);
      if(min > g){
        arr[0] = cur;
        arr[1] = before;
        min = g;
      }
      before = cur;
    }
    Arrays.sort(arr);
    System.out.println(arr[0] +" "+ arr[1]);
  }

}
