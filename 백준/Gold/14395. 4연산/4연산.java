import java.io.*;
import java.util.*;

public class Main {
  static String result = "-1";
  static long N;
  static long M;
  static char[] cs = {'*', '+', '-', '/'};
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
    System.out.println(result);
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Long.parseLong(st.nextToken());
    M = Long.parseLong(st.nextToken());
  }

  static void pro() {
    if(N == M) {
      result = "0";
      return;
    }
    if(M == 0){
      result = "-";
      return;
    }
    Set<Long> set = new HashSet<>();
    LinkedList<StringBuilder> q = new LinkedList<>();
    q.add(new StringBuilder().append(N));
    set.add(N);
    q.add(new StringBuilder());
    PriorityQueue<String> pq = new PriorityQueue<>();
    while(!q.isEmpty()) {
      long cn = Long.parseLong(q.poll().toString());
      StringBuilder cc = q.poll();
      for(int i=0 ; i<4 ; i++){
        long nn = calc(cn, cn, cs[i]);
        StringBuilder nc = new StringBuilder(cc).append(cs[i]);
        if(nn == M){
          result = nc.toString();
          return;
        }
        if(set.contains(nn)) continue;
        if(nn < 0 || nn > 1_000_000_000) continue;
        q.add(new StringBuilder().append(nn));
        q.add(nc);
        set.add(nn);
      }
    }
    if(!pq.isEmpty()) {
      result = pq.poll();
    }
  }

  static long calc(long x, long y, char c){
    if(c=='+'){
      return x + y;
    }
    if(c=='-'){
      return x - y;
    }
    if(c=='*'){
      return x * y;
    }
    if(c=='/'){
      if(y == 0) return 0;
      return x / y;
    }
    return 0;
  }

}