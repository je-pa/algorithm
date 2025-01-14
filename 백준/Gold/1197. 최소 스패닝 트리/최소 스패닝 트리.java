import java.io.*;
import java.util.*;

public class Main {
  public static int N, M;
  public static PriorityQueue<int[]> infos = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
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
    for(int i =0 ; i < M ; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      infos.add(new int[]{a,b,c});
    }
    uni = new int[N+1];
    for(int i = 0 ; i <= N ; i++){
      uni[i] = i;
    }
  }

  static void pro() {
    int count = 0;
    int result = 0;
    while(!infos.isEmpty()){
      int[] info = infos.poll(); 
      if(union(info[0], info[1])){
        count++;
        result+=info[2];
        if(count == N-1) break;
      }
    }
    System.out.println(result);
  }
  static boolean union(int a, int b){
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
