import java.io.*;
import java.util.*;

public class Main {
  static int result = Integer.MAX_VALUE;
  static int N;
  static int M;
  static int[][] arr;
  static List<int[]> houses = new ArrayList<>();
  static List<int[]> chs = new ArrayList<>();

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
    arr = new int[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < N; j++) {
        int a = Integer.parseInt(st.nextToken());
        arr[i][j] = a;
        if(a == 1){
          houses.add(new int[]{i,j});
        }
        if(a == 2){
          chs.add(new int[]{i,j});
        }
      }
    }
  }

  static void pro() {
    dfs(0, 0, new HashSet<>());
  }
  static void dfs(int idx, int dep, Set<Integer> set){
    if(dep == M){
      count(set);
    }
    for(int i = idx ; i< chs.size() ; i++){
      set.add(i);
      dfs(i+1, dep+1, set);
      set.remove(i);
    }
  }
  static void count(Set<Integer> set){
    int sum = 0;
    for(int[] house : houses){
      Integer[] array = set.toArray(new Integer[0]);
      int min = Integer.MAX_VALUE;
      for(int i : array){
        int[] ch = chs.get(i);
        min = Math.min(min, Math.abs(house[0]-ch[0]) + Math.abs(house[1]-ch[1]));
      }
      sum += min;
    }
    result = Math.min(sum, result);
  }
}
