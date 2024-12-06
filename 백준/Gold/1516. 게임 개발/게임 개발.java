import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int[] time;
  static int[] in;
  static List<List<Integer>> list;
  static StringBuilder result= new StringBuilder();
  static int[] total;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
    System.out.println(result);
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    list = new ArrayList<>();
    time = new int[N+1];
    in = new int[N+1];
    total = new int[N+1];

    for(int i=0 ; i<=N ; i++){
      list.add(new ArrayList<>());
    }
    for(int i=1 ; i<=N ; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      time[i] = a;
      while(b!=-1){
        list.get(b).add(i);
        in[i] +=1;
        b = Integer.parseInt(st.nextToken());
      }
    }
  }

  static void pro() {
    PriorityQueue<int[]> q = new PriorityQueue<>((x,y) -> Integer.compare(x[1],y[1]));
    for(int i=1 ; i<=N ; i++){
      if(in[i]==0){
        q.add(new int[]{i, time[i]});
      }
    }
    while(!q.isEmpty()){
      int[] cur = q.poll();
      int cn = cur[0];
      int ct = cur[1];
      total[cn] = ct;

      for(int nn : list.get(cn)){
        in[nn]-=1;
        if(in[nn]!=0) continue;
        q.add(new int[]{nn, ct+time[nn]});
      }
    }
    for(int i=1 ; i<=N ; i++){
      result.append(total[i]).append('\n');
    }
  }

}
