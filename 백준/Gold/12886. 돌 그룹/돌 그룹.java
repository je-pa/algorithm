import java.io.*;
import java.util.*;

public class Main {
  static int A;
  static int B;
  static int C;
  static int[][] d= {{0,1,2}, {0,2,1}, {1,2,0}};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    A = Integer.parseInt(st.nextToken());
    B = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

  }
  static String toStr(int[] arr){
    StringBuilder sb = new StringBuilder();
    for(int i =0 ; i<3 ; i++){
      sb.append(arr[i]).append(" ");
    }
//    System.out.println(sb);
    return sb.toString();
  }

  static void pro() {
    LinkedList<int[]> q = new LinkedList<>();
    Set<String> visited = new HashSet<>();
    q.add(new int[]{A,B,C,0});
    visited.add(toStr(new int[]{A,B,C}));
    if(A==B && B ==C) {
      System.out.println(1);
      return;
    }

    while(!q.isEmpty()){
      int[] cur = q.poll();
//      System.out.println(visited.size());
//      for(int i=0 ; i<cur.length ; i++){
//        System.out.print(cur[i]);
//        System.out.print(" ");
//      }
//      System.out.println();
      for(int i=0 ; i<3 ; i++){
        int[] curD = d[i];
        if(cur[curD[0]] == cur[curD[1]]) continue;
        int[] next = make(cur,curD);
        int na = next[0];
        int nb = next[1];
        int nc = next[2];
        int nd = next[3];
        if(visited.contains(toStr(next))) continue;
        if(na==nb && nb==nc) {
          System.out.println(1);
          return;
        }
        visited.add(toStr(next));
        q.add(next);
      }
    }
    System.out.println(0);
  }
  static int[] make(int[] cur, int[] curD){
    int[] newArr = new int[4];
    for(int i=0 ; i < 4 ; i++){
      newArr[i] = cur[i];
    }
    newArr[3]+=1;
    if(newArr[curD[0]] < newArr[curD[1]]){
      newArr[curD[1]] -= newArr[curD[0]];
      newArr[curD[0]] += newArr[curD[0]];
    }else{
      newArr[curD[0]] -= newArr[curD[1]];
      newArr[curD[1]] += newArr[curD[1]];
    }
    return newArr;
  }
}
