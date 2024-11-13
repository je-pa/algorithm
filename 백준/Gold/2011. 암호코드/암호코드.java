import java.io.*;
import java.util.*;

public class Main {

  public static String N; // 최대 수
  public static int result; // 최대 수
  public static int[] dp; // 최대 수

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
    System.out.println(dp[dp.length - 1]);
  }
  public static boolean check(char a, char b){
    if(a == '1') return true;
    if(a == '2' && b < '7') return true;
    return false;
  }
  public static boolean check(String s){
    int a = Integer.parseInt(s);
    return a >= 10 && a <= 26;
  }

  static void input(BufferedReader br) throws Exception {
    N = br.readLine();
    dp = new int[N.length()];
  }

  static void pro(){
    if(N.length() < 1) return;
    if(N.charAt(0) != '0') dp[0] = 1;
    if(N.length() < 2) return;
    if(N.charAt(1) != '0') dp[1] = dp[0];
    dp[1] += check(N.charAt(0), N.charAt(1)) ? 1 : 0;

    for(int i = 2; i < dp.length; i++){
      if(N.charAt(i) != '0') dp[i] = dp[i-1];
//      dp[i] += check(N.substring(i-1, i+1)) ? dp[i-2] : 0;
      dp[i] += check(N.charAt(i-1), N.charAt(i)) ? dp[i-2] : 0;
      dp[i] %= 1000000;
    }
  }
}
// 18 18 8