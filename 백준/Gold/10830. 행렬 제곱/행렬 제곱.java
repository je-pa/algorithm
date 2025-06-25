import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
  static int N;
  static long B;
  static long[][] arr;
  static long MOD = 1000;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }
  static void pro() {
    long[][] result = pow(arr, B);

    StringBuilder sb = new StringBuilder();

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < N; j++) {
        result[i][j] = result[i][j] % MOD;
        sb.append(result[i][j]).append(' ');
      }
      sb.append('\n');
    }
    System.out.println(sb);
  }
  public static long[][] pow(long[][] A, long exp) {

    if(exp == 1L) {
      return A;
    }

    long[][] ret = pow(A, exp / 2);

    ret = multiply(ret, ret);

    if(exp % 2 == 1L) {
      ret = multiply(ret, arr);
    }

    return ret;
  }


  public static long[][] multiply(long[][] o1, long[][] o2) {

    long[][] ret = new long[N][N];

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < N; j++) {
        for(int k = 0; k < N; k++) {

          ret[i][j] += o1[i][k] * o2[k][j];
          ret[i][j] %= MOD;
        }
      }
    }
    return ret;
  }

  private static void input(BufferedReader br) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    B = Long.parseLong(st.nextToken());
    arr = new long[N][N];
    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < N; j++) {
        arr[i][j] = Long.parseLong(st.nextToken());
      }
    }
  }
}

