import java.util.*;
import java.io.*;

public class Main {
  public static int T;
  public static int N;
  public static int K;
  public static int W;

  public static List<Integer>[] list;
  public static int[] times;
  public static int[] count;
  public static int[] result;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    T = Integer.parseInt(st.nextToken());
    result = new int[T];
    for(int i = 0; i < T; i++){
      set(br);
      result[i] = bfs();
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < T; i++){
      sb.append(result[i]).append("\n");
    }
    System.out.println(sb);
  }

  private static void set(BufferedReader br) throws IOException {
    StringTokenizer st;
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    times = new int[N+1];
    count = new int[N+1];
    list = new List[N+1];
    for(int i = 0; i <= N; i++) {
      list[i] = new ArrayList<>();
    }

    st = new StringTokenizer(br.readLine());
    for(int i = 1; i <= N; i++) {
      times[i] = Integer.parseInt(st.nextToken());
    }

    for(int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      list[a].add(b);
      count[b]++;
    }
    W = Integer.parseInt(br.readLine());
  }

  public static int bfs(){
    LinkedList<Integer> q = new LinkedList<>();
    int[] max = new int[N+1];
    for(int i = 1; i <= N; i++) {
      if(count[i] == 0) q.add(i);
      max[i]=times[i];
    }
    while(!q.isEmpty()) {
      int cur = q.poll();
      List<Integer> childs = list[cur];
      for(Integer c : childs) {
        count[c]-=1;
        max[c]=Math.max(max[c], times[c] + max[cur]);
        if(count[c] == 0) {
          q.add(c);
          if(c == W) break;
        }
      }
    }
    return max[W];
  }
}

