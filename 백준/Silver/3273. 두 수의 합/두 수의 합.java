import java.io.*;
import java.util.*;

public class Main {

  public static int N;
  public static int X;
  public static int result;
  public static int[] arr;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
    System.out.println(result);
  }

  static void input(BufferedReader br) throws Exception {
    N = Integer.parseInt(br.readLine());
    arr = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) {
      int a = Integer.parseInt(st.nextToken());
      arr[i] = a;
    }
    Arrays.sort(arr);
    X = Integer.parseInt(br.readLine());
  }

  static void pro(){
    int l = 0;
    int r = N-1;
    while(l < r){
      int k = arr[l] + arr[r];
      if(k == X){
        result++;
        l++;
      }
      if(k < X){
        l++;
        continue;
      }
      if(k > X){
        r--;
      }
    }
  }
}
