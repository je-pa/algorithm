import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class Main {
  static int N;
  static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }
  private static void pro() {
    if(N == 1) {
      System.out.println(0);
      return;
    }
    Integer sum = 0;
    while(true) {
      int a = pq.isEmpty() ? 0 : pq.poll();
      int b = pq.isEmpty() ? 0 : pq.poll();
      int sumab = a + b;
      sum += sumab;
      if(pq.isEmpty()) break;
      pq.add(sumab);
    }
    System.out.println(sum);
  }

  private static void input(BufferedReader br) throws IOException {
    N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      pq.add(Integer.parseInt(br.readLine()));
    }
  }
}

