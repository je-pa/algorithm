import java.io.*;
import java.util.*;

public class Main {

  static int N;
  static StringBuilder result = new StringBuilder();
  static int[] in;
  static int[] times;
  static List<List<Integer>> lists = new ArrayList<>();
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
    System.out.println(result);
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    in = new int[N+1];
    times = new int[N+1];
    for(int i=0 ; i<N+1 ; i++){
      lists.add(new ArrayList<>());
    }
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      int time = Integer.parseInt(st.nextToken());
      times[i] = time;
      int n = Integer.parseInt(st.nextToken());
      in[i] = n;
      for (int j = 0; j < n; j++) {
        int a = Integer.parseInt(st.nextToken());
        lists.get(a).add(i);
      }
    }
  }

  static void pro() {
    PriorityQueue<int[]> q = new PriorityQueue<>((x, y) -> Integer.compare(x[1], y[1]));
    int count = 0;
    for(int i=1 ; i<=N ; i++){
      if(in[i] == 0){
        q.add(new int[]{i, times[i]});
      }
    }
    while(!q.isEmpty()){
      int[] cur = q.poll();
      int curN = cur[0];
      int curTime = cur[1];
      count = Math.max(count, curTime);
      for(int i : lists.get(curN)){
        in[i] -= 1;
        if(in[i] == 0){
          q.add(new int[]{i, curTime + times[i]});
        }
      }
    }
    result.append(count);
  }
}
