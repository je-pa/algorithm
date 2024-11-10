import java.io.*;
import java.util.*;

public class Main {

  public static int N; // 최대 수
  public static int M; // 자리수
  public static Map<Integer, Integer> map = new HashMap<>(); // 층수
  public static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    for(int i=0 ; i<N ; i++){
      int k = Integer.parseInt(st.nextToken());
      map.put(k, map.getOrDefault(k, 0)+1);
    }
    st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    for(int i=0 ; i<M ; i++){
      int k = Integer.parseInt(st.nextToken());
      sb.append(map.getOrDefault(k,0)).append(" ");
    }
  }
  static void pro(){
    System.out.println(sb);
  }
}
