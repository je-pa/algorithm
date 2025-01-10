import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int[] arr;
  static int[][] dp;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  static void input(BufferedReader br) throws Exception {
    N = Integer.parseInt(br.readLine());
    dp = new int[N][N];
    arr = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0 ; i<N ; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
  }

  static void pro() {
    for (int[] ints : dp) {
      // dp의 초기값을 -1로 저장
      Arrays.fill(ints, -1);
    }

    int L = 0;
    int R = N - 1;
    System.out.println(recur(L, R));
  }
  static int recur(int L, int R) {
    // 기저 사례 : L이 R보다 크면 종료
    if (L > R) {
      return 0;
    }

    // dp[L][R]에 값이 저장되어 있다면, 바로 반환하고 종료
    if (dp[L][R] != -1) {
      return dp[L][R];
    }

    if (arr[L] == arr[R]) {
      dp[L][R] = recur(L + 1, R - 1);
    } else {
      dp[L][R] = Math.min(recur(L + 1, R) + 1, recur(L, R - 1) + 1);
    }

    return dp[L][R];
  }
}
