import java.io.*;
import java.util.*;

public class Main {

  public static int N; // 최대 수
  public static long result; // 최대 수
  public static Map<String, PriorityQueue<Integer>> map = new HashMap<>(); // 층수

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    System.out.println(result);
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    for(int i=0 ; i<N ; i++){
      st = new StringTokenizer(br.readLine());
      int k = Integer.parseInt(st.nextToken());
      if(k == 1){
        input1(st);
        continue;
      }
      if(k == 2){
        input2(st);
      }
    }
  }
  static void input1(StringTokenizer st) {
    String s = st.nextToken();
    PriorityQueue<Integer> pq = map.getOrDefault(s, new PriorityQueue<>((x, y) -> y - x));
    int k = Integer.parseInt(st.nextToken());
    for(int i=0 ; i<k ; i++){
      int n = Integer.parseInt(st.nextToken());
      pq.add(n);
//      System.out.println("1: "+s + " " + n);
    }
    map.put(s, pq);
  }
  static void input2(StringTokenizer st) {
    String s = st.nextToken();
    int b = Integer.parseInt(st.nextToken());
    pro(s, b);
//    System.out.println(s + " " + count.get(s));
  }
  static void pro(String name, int b){
    PriorityQueue<Integer> pq = map.get(name);
      // if(pq != null) System.out.println("pro:" + name + " " + pq.size() + " " + b);
    while((pq != null && !pq.isEmpty()) && b >0){
      int n = pq.poll();
//        System.out.println(n);
      result += n;
      b--;
    }
  }
}
// 18 18 8