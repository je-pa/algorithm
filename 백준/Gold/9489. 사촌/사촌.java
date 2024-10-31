import java.util.*;
import java.io.*;

public class Main {
  public static int N;
  public static int K;
  public static long result = 0;
  public static int[] arr ;
  public static int[] parents;
  public static int[] childCount;

  public static LinkedList<Integer> q = new LinkedList<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while(true){
      input(br);
      if(N==0) {
        break;
      }
      pro();
      System.out.println(result);
    }
  }
  public static void input(BufferedReader br) throws Exception{
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    if(N==0) return;
    arr  = new int[N];
    parents = new int[N];
    childCount = new int[N];
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++){
      int num = Integer.parseInt(st.nextToken());
      arr[i] = num;
    }

    while(!q.isEmpty()) q.poll();
    q.add(0);
    parents[0] = -1;
    for (int i = 1; i < N; i++) {
      int parent = q.poll();
//      System.out.println("parent: "+parent+"curDep"+curDep);
      q.add(i);
      childCount[parent]+=1;
      parents[i] = parent;
      while(i+1 < N && arr[i+1] == arr[i]+1){
//        System.out.println("!:"+arr[i]);
//        System.out.println("2:"+arr[i+1]);
//        System.out.println("dep:"+curDep);
        i++;
        q.add(i);
        childCount[parent]+=1;
        parents[i] = parent;
      }
    }
  }

  public static void pro(){
    int idx = 0;
    while(arr[idx] != K) idx++;

    int parent = parents[idx];
    if(parent == -1) {
      result = 0;
      return;
    }

    int pp = parents[parent];
    result = 0;
    for(int i=0 ; i<parents.length ; i++){
      if(parents[i] == pp && parent != i) result += childCount[i];
    }
  }
}