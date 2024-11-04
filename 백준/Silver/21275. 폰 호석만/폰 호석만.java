import java.util.*;
import java.io.*;

public class Main {
//  public static int N;
  public static String str1;
  public static String str2;

  public static long X = 0;
  public static int A = 0;
  public static int B = 0;
  public static int count = 0;
  public static int[][] arr;
  public static int[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
    StringBuilder sb = new StringBuilder();
    if(count == 1){
      sb.append(X).append(" ").append(A).append(" ").append(B);
    }else if(count == 0){
      sb.append("Impossible");
    }else{
      sb.append("Multiple");
    }
    System.out.println(sb);
  }
  public static void input(BufferedReader br) throws IOException{
    StringTokenizer st = new StringTokenizer(br.readLine());
    str1 = st.nextToken();
    str2 = st.nextToken();
  }

  public static void pro(){
    for(int i = 2 ; i < 37 ; i++){
      for(int j = 2 ; j < 37 ; j++){
        if(i==j) continue;
        long X1 = getX1(str1, i);
        long X2 = getX1(str2, j);
        if(X1 == -1 || X2 == -1) continue;
        if(X1 == X2){
          count++;
          if(count == 1){
            X = X1;
            A = i;
            B = j;
          }else{
            return;
          }
        }
      }
    }
  }

  private static long getX1(String str1, int i) {
    long X = 0;
    int len1 = str1.length();
    for (int k = 1; k <= len1; k++) {
      char c = str1.charAt(len1 - k);
      long pow = (long) Math.pow(i, k - 1);
      if (c >= 'a') {
        if (((c - 'a') + 10) >= i) {
          return  -1;
        }
        X += ((long)(c - 'a') + (long)10) * pow;
      } else {
        if (((c - '0')) >= i) {
          return  -1;
        }
        X += ((long)(c - '0')) * pow;
      }
    }
    return X;
  }
}