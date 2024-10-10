import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    Map<Long, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      Long key = Long.parseLong(st.nextToken());
      map.put(key, map.getOrDefault(key, 0) + 1);
    }
    PriorityQueue<Info> pq = new PriorityQueue<>();
    for(Long key : map.keySet()){
      pq.add(new Info(key, map.get(key)));
    }
    System.out.println(pq.poll().num);
  }

  static class Info implements Comparable<Info>{
    long num;
    int count;

    public Info(long num, int count) {
      this.count = count;
      this.num = num;
    }

    @Override
    public int compareTo(Info o) {
      if(this.count != o.count) return Integer.compare(o.count, this.count);
      return Long.compare(this.num, o.num);
    }
  }
}
