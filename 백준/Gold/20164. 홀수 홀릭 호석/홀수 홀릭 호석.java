import java.util.*;
import java.io.*;

public class Main {
  public static String N;
  public static int len;
  public static int min = Integer.MAX_VALUE;
  public static int max = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = br.readLine();
    len = N.length();
    pro(N, 0);
    System.out.println(min + " " + max);
  }

  public static void pro(String n, int count){
    int len = n.length();
    int sum = count(n);
    if(len == 1) {
      int a = count + ((n.charAt(0) - '0')%2 == 1 ? 1 : 0);
      min = Math.min(min, a);
      max = Math.max(max, a);
    }
    if(len == 2){
      int a = n.charAt(0) - '0';
      int b = n.charAt(1) - '0';
      pro(String.valueOf(a + b), count + sum);
    }
    if(len > 2){
      for (int i = 1; i < len - 1; i++) {
        for (int j = i + 1; j < len ; j++) {
          sum = count(n);
          int a = Integer.parseInt(n.substring(0, i));
          int b = Integer.parseInt(n.substring(i, j));
          int c = Integer.parseInt(n.substring(j, len));
          pro(String.valueOf(a+b+c), count + sum);
        }
      }
    }
  }
  public static int count(String n){
    int sum = 0;
    for(int i=0 ; i< n.length() ; i++){
      if((n.charAt(i)-'0')%2 == 1) sum++;
    }
    return sum;
  }
}