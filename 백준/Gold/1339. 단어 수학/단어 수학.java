import java.io.*;
import java.util.*;

public class Main {
  public static class Node{
    char c;
    int w;
    public Node(char c, int w){
      this.c = c;
      this.w = w;
    }
  }
  public static int N;
  public static String[] info;
  // 가중치
  public static Map<Character, Integer> map = new HashMap<>();
  public static PriorityQueue<Node> pq = new PriorityQueue<>((x,y) -> Integer.compare(y.w, x.w));
  // 매칭
  public static Map<Character, Integer> mac = new HashMap<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  static void input(BufferedReader br) throws Exception {
    N = Integer.parseInt(br.readLine());
    info = new String[N];
    for(int i = 0; i < N; i++){
      String str = br.readLine();
      info[i] = str;
      for(int j=0; j < str.length(); j++){
        char ch = str.charAt(j);
        map.put(ch, map.getOrDefault(ch, 0) + (int)Math.pow(10,(str.length() - j - 1)));
      }
    }
  }

  static void pro() {
    for(char c: map.keySet()){
      pq.add(new Node(c, map.get(c)));
    }
    int start = 9;
    while(!pq.isEmpty()){
      Node node = pq.poll();
      mac.put(node.c, start);
      start--;
    }
    int sum = 0;
    for(String str : info){
      int num =0;
      for(char c: str.toCharArray()){
        num*=10;
        num += mac.get(c);
      }
      sum += num;
    }
    System.out.println(sum);
  }
}