import java.io.*;
import java.util.*;

public class Main {

  public static String A, B;
  public static List<List<int[]>> lists = new ArrayList<>();
  public static int start, end;
  public static int MAX_W;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  static void input(BufferedReader br) throws Exception {
    A = br.readLine();
    B = br.readLine();
  }

  static void pro() {
    Stack<Character> st = new Stack<>();
    for(int i = 0; i < A.length(); i++) {
      char c = A.charAt(i);
      st.push(c);
      if(st.size() >= B.length()){
        boolean check = true;
        for(int j = 0; j < B.length(); j++) {
          if(st.get(st.size()-B.length()+j) == B.charAt(j)) continue;
          check = false;
          break;
        }
        if(check) {
          for(int j = 0; j < B.length(); j++) {
            st.pop();
          }
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for(char c : st){
      sb.append(c);
    }
    System.out.println(sb.length() == 0? "FRULA": sb);
  }
}