import java.io.*;
import java.util.*;

public class Main {

  public static int N;
  public static int M;
  public static StringBuilder result = new StringBuilder();
  public static Set<Integer> set = new HashSet<>();
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
    System.out.println(result);
  }

  static void input(BufferedReader br) throws Exception {
    N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) {
      int a = Integer.parseInt(st.nextToken());
      set.add(a);
    }
    M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < M; i++) {
      int a = Integer.parseInt(st.nextToken());
      result.append(set.contains(a) ? 1 : 0).append("\n");
    }
  }

  static void pro(){
    
  }
}
