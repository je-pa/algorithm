import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
  static int N, M;
  static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }
  static void pro() {
    int INF = 1_000_000;
    int[] P = new int[N+1],
        pos = new int[INF+1];
    for(int i = 0; i < N; i++) pos[arr[i]] = i+1;

    for(int mod : arr) {
      for (int i = mod * 2; i <= INF; i += mod) {
        if (pos[i] != 0) {
          P[pos[i]]--;
          P[pos[mod]]++;
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for(int i = 1; i <= N; i++) sb.append(P[i]).append(" ");
    System.out.print(sb);
  }
  private static void input(BufferedReader br) throws IOException {
    N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    arr = new int[N];
    for(int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
  }

}

