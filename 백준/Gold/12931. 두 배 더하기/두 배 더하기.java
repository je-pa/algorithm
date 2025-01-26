import java.io.*;
    import java.util.*;

public class Main {
  public static int N;
  public static int sum;
  public static int[] arr;
  public static int result =0;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    arr = new int[N];
    for (int i = 0; i < N; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
        sum += arr[i];
    }
  }

  static void pro() {
    while(sum != 0) {
      int count = 0;
      for(int i = 0; i < N; i++) {
        if(arr[i] % 2 == 1) {
          arr[i]--;
          count++;
        }
      }

      if(count > 0) {
        sum -= count;
        result += count;
      }
      else {
        for(int i = 0; i < N; i++) {
          arr[i] /= 2;
        }
        sum /= 2;
        result++;
      }
    }
    System.out.print(result);
  }
}