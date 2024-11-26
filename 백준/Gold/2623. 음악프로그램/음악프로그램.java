import java.io.*;
import java.util.*;

public class Main {

  static int N;
  static int M;
  static int[][] arr;
  static StringBuilder result = new StringBuilder();
  static int[] in;
  static boolean[] visited;
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
    M = Integer.parseInt(st.nextToken());
    arr = new int[M][];
    in = new int[N+1];
    visited = new boolean[N+1];
    for(int i=0 ; i<N+1 ; i++){
      lists.add(new ArrayList<>());
    }
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      arr[i] = new int[n];
      int before = Integer.parseInt(st.nextToken());
      for (int j = 1; j < n; j++) {
        int a = Integer.parseInt(st.nextToken());
        arr[i][j] = a;
        in[a] +=1;
        lists.get(before).add(a);
        before = a;
      }
    }
  }

  static void pro() {
    LinkedList<Integer> q = new LinkedList<>();
    int count = 0;
    for(int i=1 ; i<=N ; i++){
      if(in[i] == 0){
        q.add(i);
      }
    }
    while(!q.isEmpty()){
      count++;
      int cur = q.poll();
      result.append(cur).append("\n");
      for(int i : lists.get(cur)){
        in[i] -= 1;
        if(in[i] <= 0){
          q.add(i);
        }
      }
    }
    if(count != N){
      result = new StringBuilder();
      result.append(0);
    }
  }
}
