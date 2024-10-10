import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    PriorityQueue<Info> pq = new PriorityQueue<>();
    for (int i=0 ; i<n ; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int index = Integer.parseInt(st.nextToken());
      int color = Integer.parseInt(st.nextToken());
      pq.add(new Info(index, color));
    }
    Map<Integer, Integer> min = new HashMap<>();
    Map<Integer, Integer> last = new HashMap<>();
    while(!pq.isEmpty()){
      Info cur = pq.poll();
      if(last.get(cur.color) == null) {
        min.put(cur.i, Integer.MAX_VALUE);
        last.put(cur.color, cur.i);
        continue;
      }
      int lastIndex = last.get(cur.color);
      int len = cur.i - lastIndex;
      min.put(lastIndex, Math.min(len, min.get(lastIndex)));
      min.put(cur.i, len);
      last.put(cur.color, cur.i);
    }
    int sum = 0;
    for(int m : min.keySet()){
      sum += min.get(m);
    }

    System.out.println(sum);
  }
  static class Info implements Comparable<Info>{
    int i;
    int color;

    public Info(int i, int color) {
      this.color = color;
      this.i = i;
    }

    public int compareTo(Info o){
      return Integer.compare(this.i, o.i);
    }
  }
}
