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
    int result = pro(N);
    if(N.length() < 3){
      System.out.println(result + " " + result);
      return;
    }
    System.out.println(min + " " + max);
  }

  public static int pro(String n){
    int len = n.length();
    int sum = count(n);
    if(len == 1) return (n.charAt(0) - '0')%2 == 1 ? 1 : 0;
    if(len == 2){
      int a = n.charAt(0) - '0';
      int b = n.charAt(1) - '0';
      return sum + pro(String.valueOf(a + b));
    }
    if(len > 2){
      for (int i = 1; i < len - 1; i++) {
        for (int j = i + 1; j < len ; j++) {
          sum = count(n);
          int a = Integer.parseInt(n.substring(0, i));
          int b = Integer.parseInt(n.substring(i, j));
          int c = Integer.parseInt(n.substring(j, len));
          sum += pro(String.valueOf(a+b+c));
          if(!N.equals(n)) continue;
          min = Math.min(sum, min);
          max = Math.max(sum, max);
        }
      }
    }

    return sum;
  }
  public static int count(String n){
    int sum = 0;
    for(int i=0 ; i< n.length() ; i++){
      if((n.charAt(i)-'0')%2 == 1) sum++;
    }
    return sum;
  }
}