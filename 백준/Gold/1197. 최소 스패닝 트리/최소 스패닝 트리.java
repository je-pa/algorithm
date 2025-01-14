import java.io.*;
import java.util.*;

public class Main {
  public static int N, M;
  public static int[][] infos;
  public static int[] uni;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    infos = new int[M][3];
    for(int i =0 ; i < M ; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      infos[i][0] = a;
      infos[i][1] = b;
      infos[i][2] = c;
    }
    uni = new int[N+1];
    for(int i = 0 ; i <= N ; i++){
      uni[i] = i;
    }
  }

  static void pro() {
    Arrays.sort(infos, Comparator.comparingInt(x -> x[2]));
    int count = 0;
    int result = 0;
    for(int i = 0 ; i < M ; i++){
      int[] info = infos[i];
      if(dfs(info[0], info[1])){
        count++;
        result+=info[2];
        if(count == N-1) break;
      }
    }
    System.out.println(result);
  }
  static boolean dfs(int a, int b){
    int ap = find(a);
    int bp = find(b);
    if(ap == bp) return false;
    uni[ap] = bp;
    return true;
  }
  static int find(int a){
    if(uni[a] == a) return a;
    return uni[a] = find(uni[a]);
  }
}
