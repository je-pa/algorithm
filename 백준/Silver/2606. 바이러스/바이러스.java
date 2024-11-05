import java.util.*;
import java.io.*;

public class Main {
  public static int N;
  public static int M;
  public static ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
  public static boolean[] visited;
  public static int result= 0;
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());
    visited = new boolean[N+1];
    for(int i=0 ; i<=N ; i++){
      lists.add(new ArrayList<Integer>());
    }
    StringTokenizer st;
    for(int i=0 ; i<M ; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      lists.get(a).add(b);
      lists.get(b).add(a);
    }
    dfs(1);
    System.out.println(result-1);
  }

  public static void dfs(int idx){
    ArrayList<Integer> list = lists.get(idx);
    visited[idx] = true;
    result++;

    for(int i : list){
      if(visited[i]) continue;
      dfs(i);
    }
  }
}
