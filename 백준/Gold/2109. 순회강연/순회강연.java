import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    if(n==0){
      System.out.println("0");
      return;
    }
    PriorityQueue<Info> pq = new PriorityQueue<>();
    StringTokenizer st;
    int maxD = 0;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int p = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());
      maxD = Math.max(maxD, d);
      pq.add(new Info(p, d));
    }

    Info first = pq.poll();
    int d = first.d;
    long sum = first.p;
    int[] ds = new int[maxD+1];
    ds[d] = first.p;
    while(!pq.isEmpty()) {
      Info info = pq.poll();
      int curD = info.d;
      while(curD > 0 && ds[curD] != 0){
        curD--;
      }
      if(curD!=0){
        ds[curD] = info.p;
        sum += info.p;
      }
    }
    System.out.println(sum);
  }
  static class Info implements Comparable<Info>{
    int p;
    int d;

    public Info(int p, int d) {
      this.p = p;
      this.d = d;
    }

    @Override
    public int compareTo(Info o) {
      return Integer.compare(o.p, this.p);
    }
  }
}