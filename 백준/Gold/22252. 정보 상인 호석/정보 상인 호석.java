import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
  static Map<String, PriorityQueue<Integer>> map = new HashMap<>();
  static long result = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int Q = Integer.parseInt(br.readLine());
    for(int i=0 ; i<Q ; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      boolean buy = st.nextToken().equals("2");
      String name = st.nextToken();
      PriorityQueue<Integer> pq = map.getOrDefault(name, new PriorityQueue<>((x,y) -> Integer.compare(y,x)));
      int k = Integer.parseInt(st.nextToken());
      if(buy){
        buyInfo(k, pq);
      }else{
        getInfo(name, k, pq, st);
      }
    }
    System.out.println(result);
  }

  static void buyInfo(int k, PriorityQueue<Integer> pq) throws IOException{
    for(int i=0 ; i<k ; i++){
      if(pq.isEmpty()) break;
      result += (long)pq.poll();
    }
  }

  static void getInfo(String name, int k, PriorityQueue<Integer> pq, StringTokenizer st) throws IOException{
    for(int i=0 ; i<k ; i++){
      pq.add(Integer.parseInt(st.nextToken()));
    }
    map.put(name, pq);
  }
}
