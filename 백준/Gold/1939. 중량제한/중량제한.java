import java.io.*;
import java.util.*;

public class Main {
  public static int N, M;
  public static List<List<int[]>> lists = new ArrayList<>();
  public static int start, end;
  public static int MAX_W;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    for(int i=0 ; i<=N ; i++){
      lists.add(new ArrayList<>());
    }
    for(int i =0 ; i < M ; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      MAX_W = Math.max(MAX_W, c);
      lists.get(a).add(new int[]{b, c});
      lists.get(b).add(new int[]{a, c});
    }
    st = new StringTokenizer(br.readLine());
    start = Integer.parseInt(st.nextToken());
    end = Integer.parseInt(st.nextToken());
  }

  static void pro() {
    int l = 0;
    int r = MAX_W;
    int result = 0;
    while(l <= r){
      int m = (l+r)/2;
      if(check(m)){
        l = m+1;
        result = m;
      }else{
        r = m-1;
      }
    }
    System.out.println(result);
  }
  static boolean check(int n){
    LinkedList<Integer> q = new LinkedList<>();
    boolean[] visited = new boolean[N+1];
    q.add(start);
    visited[start] = true;
    while(!q.isEmpty()){
      int c = q.poll();
      for(int[] cur : lists.get(c)){
        int nn = cur[0];
        int max = cur[1];
        if(visited[nn]) continue;
        if(n > max) continue;
        if(nn == end){
          return true;
        }
        visited[nn] = true;
        q.add(nn);
      }
    }
    return false;
  }

}
