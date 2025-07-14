import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
  static int N, S;
  static int[] map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }
  private static void input(BufferedReader br) throws IOException {
    StringTokenizer sb = new StringTokenizer(br.readLine());
    N = Integer.parseInt(sb.nextToken());
    S = Integer.parseInt(sb.nextToken());
    map = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++){
      map[i] = Integer.parseInt(st.nextToken());
    }
  }

  private static void pro() {
    int min = Integer.MAX_VALUE;
    int right = 0;
    int left = 0;
    int sum = 0;
    while(right < N){
      sum += map[right];
      right++;
      while(sum >= S){
        sum -= map[left];
        min = Math.min(min, right - left);
        left++;
      }
    }
    System.out.println(min == Integer.MAX_VALUE ? 0 : min);
  }

}

