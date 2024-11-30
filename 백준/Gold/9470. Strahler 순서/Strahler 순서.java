import java.io.*;
import java.util.*;

public class Main {

  static int N;
  static int M;
  static int P;
  static int[] in;
  static List<List<Integer>> lists;
  static ArrayList<PriorityQueue<Integer>> pqs;
  static StringBuilder result = new StringBuilder();
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= T; t++) {
      input(br);
      pro();
    }
    System.out.println(result);
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    pqs = new ArrayList<>();
    lists = new ArrayList<>();
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    P = Integer.parseInt(st.nextToken());
    in = new int[M+1];
    for(int i=0 ; i<=M ; i++){
      lists.add(new ArrayList<>());
      pqs.add(new PriorityQueue<>((x, y) -> Integer.compare(y,x)));
    }
    for(int i=0 ; i<P ; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      lists.get(a).add(b);
      in[b] += 1;
    }
  }

  static void pro() {
    LinkedList<int[]> q = new LinkedList<>();
    int max = 0;
    for(int i=1 ; i<=M ; i++){
      if(in[i] != 0) continue;
      q.add(new int[]{i, 1});
    }
    while(!q.isEmpty()){
      int[] cur = q.poll();
      int cn = cur[0];
      int cs = cur[1];
      for(int nn : lists.get(cn)){
        PriorityQueue<Integer> pq = pqs.get(nn);
        pq.add(cs);
        in[nn] -=1;
        if(in[nn] != 0) continue;
        int ns;
        if(pq.isEmpty()){
          ns = 0;
        }else if(pq.size()==1){
          ns = pq.poll();
        }else{
          int a = pq.poll();
          int b = pq.poll();
          if(a == b){
            ns = a +1;
          }else{
            ns = a;
          }
        }
        max = Math.max(max, ns);
        q.add(new int[]{nn, ns});
      }
    }
    result.append(N).append(" ").append(max).append("\n");
  }
}
