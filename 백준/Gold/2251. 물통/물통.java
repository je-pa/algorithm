import java.util.*;
import java.io.*;

public class Main {
  public static Set<Integer> set = new TreeSet<>();
  public static int[][] d = {{1, 2}, {1, 3}
      ,{2, 1}, {2, 3}
      ,{3, 1}, {3, 2}};
  public static boolean[][][] visit = new boolean[201][201][201];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    int n = Integer.parseInt(br.readLine());
    int[] bottle = new int[3];
    int[] water = new int[3];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 3; i++) {
      bottle[i] = Integer.parseInt(st.nextToken());
    }
    water[2] = bottle[2];
    dfs(bottle, water);
    StringBuilder sb = new StringBuilder();
    for(int i: set){
      sb.append(i).append(" ");
    }
    System.out.println(sb);
  }

  public static void dfs(int[] bottle, int[] water){
    if(water[0] == 0){
      set.add(water[2]);
    }


    for(int[] arr : d){
      int l = arr[0] -1;
      int r = arr[1] -1;
      if(water[l] == 0 || water[r] == bottle[r]) continue;
      int cl = water[l];
      int cr = water[r];

      int amount = Math.min(cl, bottle[r] - cr);
      water[r] += amount;
      water[l] -= amount;

      if(visit[water[0]][water[1]][water[2]]){
        water[l] = cl;
        water[r] = cr;
      }else{
        visit[water[0]][water[1]][water[2]] = true;
        dfs(bottle, water);
        water[l] = cl;
        water[r] = cr;
      }
    }
  }

}
