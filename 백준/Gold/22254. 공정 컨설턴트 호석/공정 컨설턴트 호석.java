import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
  static int N, X;
  static int[] xs;

  public static void pro() {
    int l = 1;
    int r = N;
    while(l<=r){
      int mid = (l + r)/2;

      if(isPossible(mid)){
        r = mid - 1;
      }else{
        l = mid + 1;
      }
    }
    System.out.println(l);
  }

  public static boolean isPossible(int n) {
    Queue<Integer> pq = new PriorityQueue<>((x1, x2) -> x1 - x2);
    for (int i = 0; i < n; i++) {
      pq.offer(xs[i]);
    }

    for (int i = n; i < N; i++) {
      int startTime = pq.poll();
      int endTime = startTime + xs[i];
      if (endTime > X) {
        return false;
      }
      pq.offer(endTime);
    }
    return true;
  }

  public static void input(BufferedReader br) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());
    xs = new int[N];
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++){
      xs[i] = Integer.parseInt(st.nextToken());
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }
}

