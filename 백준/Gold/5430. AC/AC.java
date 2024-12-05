import java.io.*;
import java.util.*;

public class Main {
  static String AC;
  static int N;
  static int[] arr;
  static char R = 'R';
  static char D = 'D';

  static StringBuilder result = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for(int i=0 ; i<T ; i++){
      input(br);
      pro();
    }
    System.out.println(result);
  }

  static void input(BufferedReader br) throws Exception {
    AC = br.readLine();
    N = Integer.parseInt(br.readLine());

    String s = br.readLine();
    if(N == 0) {
      arr = new int[N];
      return;
    }
    arr = Arrays.stream(s.substring(1, s.length()-1).split(",")).mapToInt(Integer::parseInt).toArray();
  }

  static void pro() {
    boolean first = true;
    LinkedList<Integer> q = new LinkedList<>();
    for(int i : arr){
      q.add(i);
    }
    for(int i=0 ; i<AC.length() ; i++){
      char c = AC.charAt(i);
      if(c == R){
        first = !first;
        continue;
      }
      if(c == D){
        if(q.isEmpty()){
          result.append("error").append('\n');
          return;
        }
        if(first){
          q.poll();
        }else{
          q.removeLast();
        }
      }
    }
    result.append("[");
    if(!q.isEmpty()) result.append(first ? q.removeFirst() : q.removeLast());
    if(first){
      while(!q.isEmpty()){
        result.append(',').append(q.removeFirst());
      }
    }else{
      while(!q.isEmpty()){
        result.append(',').append(q.removeLast());
      }
    }
    result.append(']').append('\n');
  }
}
