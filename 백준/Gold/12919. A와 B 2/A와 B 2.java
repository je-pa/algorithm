import java.io.*;

public class Main {
  public static String S, T;
  public static int result = 0;


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  static void input(BufferedReader br) throws Exception {
    S = br.readLine();
    T = br.readLine();
  }

  static void pro() {
    dfs(T);
    System.out.println(result);
  }

  public static void dfs(String t) {
    int lenT = t.length();
    if (lenT == S.length()) {
      if (t.equals(S)) {
        result = 1;
      }
      return;
    }
    if (t.endsWith("A")) {
      dfs(t.substring(0, lenT - 1));
    }
    if (t.startsWith("B")) {
      dfs(new StringBuilder(t.substring(1)).reverse().toString());
    }
  }

}
