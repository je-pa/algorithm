import java.io.*;
import java.util.*;

public class Main {
  public static String str1, str2;
  public static int max;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  static void input(BufferedReader br) throws Exception {
    str1 = br.readLine();
    str2 = br.readLine();
  }

  static void pro() {
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < str1.length(); i++) {
      sb.append(str1.charAt(i));

      while(sb.length() != 0 && !str2.contains(sb)){
        sb.deleteCharAt(0);
      }

      max = Math.max(max, sb.length());
    }
    System.out.println(max);
  }

}