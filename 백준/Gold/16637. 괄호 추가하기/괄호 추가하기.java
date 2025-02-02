import java.io.*;
import java.util.*;

public class Main {
  public static int N, max = Integer.MAX_VALUE*-1;
  public static String[] arr;
  public static boolean[] check;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  static void input(BufferedReader br) throws Exception {
    N = Integer.parseInt(br.readLine());
    arr = br.readLine().split("");
    check = new boolean[N/2];
  }

  static void pro() {
    dfs(-1, false);
    System.out.println(max);
  }

  static void dfs(int idx, boolean beforeMode){
    if(idx > 0) check[idx - 1] = beforeMode;
    if(idx*2 >= N-1){
      cal();
      return;
    }
    if(!beforeMode) {
      dfs(idx+1, true);
    }

    dfs(idx+1, false);
  }
  static void cal(){
    LinkedList<String> list = new LinkedList<>();
    list.add(arr[0]);
    for(int i=0 ; i<check.length ;i++){
      if(check[i]){
        list.add((cal(list.removeLast(), arr[i*2+2], arr[i*2+1])));
      }
      if(!check[i]){
        list.add(arr[i*2+1]);
        list.add(arr[i*2+2]);
      }
    }
    int result = Integer.parseInt(list.poll());
//    System.out.print(result);
    while(!list.isEmpty()){
      String before = String.valueOf(result);
      String cc = list.poll();
      String num = list.poll();
//      System.out.print(cc+" "+num);
      result = Integer.parseInt(cal(before, num, cc));
//      System.out.println(" = " + result);
    }
//    System.out.println(result);
    max = Math.max(result, max);
  }
  static String cal(String cx, String cy, String cc){
    long x = Long.parseLong(cx);
    long y = Long.parseLong(cy);
    char c = cc.charAt(0);
    long result = 0;
    if(c=='+'){
      result = x+y;
    }
    if(c=='-'){
      result = x-y;
    }
    if(c=='*'){
      result = x*y;
    }
    return String.valueOf(result);
  }
}

