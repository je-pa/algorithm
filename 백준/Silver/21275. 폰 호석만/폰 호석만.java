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
        long X1 = 0;
        int len1 = str1.length();
        boolean check = false;
        for(int k = 1 ; k <= len1 ; k++){
          char c = str1.charAt(len1 - k);
          long pow = (long)Math.pow(i, k-1);
          if(c >= 'a'){
            if(((c - 'a') + 10) >= i){
              check = true;
              break;
            }
            X1 += ((c - 'a') + 10) * pow;
          }else{
            if(((c - '0')) >= i){
              check = true;
              break;
            }
            X1 += ((c - '0')) * pow;
          }
        }
        if(check) break;
        long X2 = 0;
        int len2 = str2.length();
        for(int k = 1 ; k <= len2 ; k++){
          char c = str2.charAt(len2 - k);
          long pow = (long)Math.pow(j, k-1);
          if(c >= 'a'){
            if(((c - 'a') + 10) >= j){
              check = true;
              break;
            }
            X2 += ((c - 'a') + 10) * pow;
          }else{
            if(((c - '0')) >= j){
              check = true;
              break;
            }
            X2 += ((c - '0')) * pow;
          }
        }
        if(check) break;
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
}