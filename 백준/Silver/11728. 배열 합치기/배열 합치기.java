import java.util.*;
import java.io.*;

public class Main {
  public static int N;
  public static int M;
  public static PriorityQueue<Integer> pq = new PriorityQueue<>();
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    for(int i=0 ; i<N ; i++){
      pq.add(Integer.parseInt(st.nextToken()));
    }
    st = new StringTokenizer(br.readLine());
    for(int i=0 ; i<M ; i++){
      pq.add(Integer.parseInt(st.nextToken()));
    }
    StringBuilder sb = new StringBuilder();
    while(!pq.isEmpty()){
      sb.append(pq.remove()).append(" ");
    }
    System.out.println(sb);
  }


}
