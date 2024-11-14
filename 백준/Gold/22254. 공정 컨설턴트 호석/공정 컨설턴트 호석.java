import java.io.*;
import java.util.*;

public class Main {

  public static int N;
  public static int X;
  public static int result;
  public static int[] arr;
  public static PriorityQueue<Integer> pq;
//  public static int[] check = new int[2_000_001];
  public static Map<Integer,Integer> map = new HashMap<>();
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
    System.out.println(result);
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());
    arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) {
      int a = Integer.parseInt(st.nextToken());
      arr[i] = a;
    }
  }

  static void pro(){
    int l = 1;
    int r = Integer.MAX_VALUE;
    while(l <= r){
      pq = new PriorityQueue<>();
      int mid = (l/2 + r/2) ;
      boolean flag = false;
      for(int i = 0 ; i<N ; i++){
        int k = arr[i];
        if(pq.size() < mid){
//          System.out.println(mid);
          pq.add(k);
        }else{
//          System.out.println(mid);
          int cur = pq.poll();
          int next = cur + k;
          if(next > X){
            flag = true;
            break;
          }
          pq.add(next);
        }

      }

      if(flag){
        l = mid + 1;
      }else{
        r = mid - 1;
      }
    }
    result = l;
  }
}
