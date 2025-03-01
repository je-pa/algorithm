import java.io.*;
import java.util.*;

public class Main {
  public static int N, M;
  public static int S, E;

  static List<List<int[]>> lists;
  static List<List<int[]>> reverse;
  static int[] in;
  static int[] maxLen;
  static int[] counts;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  static void pro() {
    LinkedList<Integer> q = new LinkedList<>();
    q.add(S);
    while (!q.isEmpty()) {
      int cur = q.poll();
      for(int[] arr : lists.get(cur)){
        int next = arr[0];
        int len = arr[1];
        if(maxLen[next] < len + maxLen[cur]){
          maxLen[next] = len + maxLen[cur];
        }
        in[next]--;
        if(in[next] == 0){
          q.add(next);
        }
      }
    }
    q.add(E);
    int count = 0;
    boolean[] visited = new boolean[N+1];
    while(!q.isEmpty()){
      int cur = q.poll();
      for(int[] arr : reverse.get(cur)){
        int next = arr[0];
        int len = arr[1];
        if(maxLen[cur] == len + maxLen[next]){
          count ++;
          if(!visited[next]){
            visited[next] = true;
            q.add(next);
          }
        }
      }
    }
    System.out.println(maxLen[E]);
    System.out.println(count);
  }

  static void input(BufferedReader br) throws Exception {
    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());
    counts = new int[N+1];
    maxLen = new int[N+1];
    in = new int[N+1];

    StringTokenizer st;
    lists = new ArrayList<>();
    reverse = new ArrayList<>();
    for(int i=0 ; i<=N; i++){
      lists.add(new ArrayList<>());
      reverse.add(new ArrayList<>());
    }
    for(int i =0 ; i< M ; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      lists.get(a).add(new int[]{b,c});
      reverse.get(b).add(new int[]{a,c});
      in[b]++;
    }
    st = new StringTokenizer(br.readLine());
    S = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());
  }
}

