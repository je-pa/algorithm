import java.io.*;
import java.util.*;

public class Main {

  static int N;
  static int M;
  static int[] in;
  static List<List<int[]>> lists = new ArrayList<>();
  static int[][] counts;
  static StringBuilder result = new StringBuilder();
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
    System.out.println(result);
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());
    counts = new int[N+1][N+1];
    in = new int[N+1];
    for(int i=0 ; i<=N ; i++){
      lists.add(new ArrayList<>());
    }
    for(int i=0 ; i<M ; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      lists.get(b).add(new int[]{a,c});
      in[a] += 1;
    }
  }

  static void pro() {
    LinkedList<Integer> q = new LinkedList<>();
    for(int i=1 ; i<=N ; i++){
      if(in[i] != 0) continue;
      q.add(i);
      counts[i][i] = 1;
    }
    while(!q.isEmpty()){
      int cur = q.poll();
      for(int[] arr : lists.get(cur)){
        int n = arr[0];
        int nc = arr[1];
        for(int i=1 ; i<N ; i++){
          counts[n][i] += counts[cur][i]*nc;
        }
        in[n] -=1;
        if(in[n] == 0)q.add(n);
      }
    }
    for(int i=1; i<N ; i++){
      if(counts[N][i] == 0) continue;
      result.append(i).append(" ").append(counts[N][i]).append("\n");
    }
  }
}
