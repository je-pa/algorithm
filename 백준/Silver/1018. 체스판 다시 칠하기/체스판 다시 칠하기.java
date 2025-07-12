import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
  static int N, M;
  static char[][] map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }
  private static void input(BufferedReader br) throws IOException {
    StringTokenizer sb = new StringTokenizer(br.readLine());
    N = Integer.parseInt(sb.nextToken());
    M = Integer.parseInt(sb.nextToken());
    map = new char[N][M];
    for(int i = 0; i < N; i++){
      String line = br.readLine();
      for(int j = 0; j < M; j++){
        map[i][j] = line.charAt(j);
      }
    }
  }

  private static void pro() {
    int min = Integer.MAX_VALUE;
    for(int i=0 ; i<=N-8 ; i++){
      for(int j=0 ; j<=M-8 ; j++){
        min = Math.min(min, count(i,j));
      }
    }
    System.out.println(min);
  }

  private static int count(int x, int y){
    int sum = 0;
    boolean w = true;
    for(int i = x; i < x+8 ; i++){
      for(int j = y ; j < y+8 ; j++){
        if(w && map[i][j] == 'W') sum++;
        if(!w && map[i][j] == 'B') sum++;
        w = !w;
      }
      w = !w;
    }
    return Math.min(sum, 64 - sum);
  }
}

