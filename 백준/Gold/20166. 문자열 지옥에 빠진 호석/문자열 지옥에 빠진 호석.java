import java.util.*;
import java.io.*;

public class Main {
  public static int N;
  public static int M;
  public static int K;
  public static int result = 0;
  public static String[] sts;
  public static char[][] map;
  public static Map<String, Integer> hash = new HashMap<>();
  public static String[] gods;
  public static int[] dx = {0,0,1,-1, -1, -1, 1, 1};
  public static int[] dy = {1,-1,0,0, -1, 1, -1, 1};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    StringBuilder sb = new StringBuilder();
    for(String s : hash.keySet()){
      result = 0;
      for(int i=0 ; i< N ; i++){
        for(int j=0 ; j< M ; j++){
          pro(s, 0, i, j);
        }
      }
      hash.put(s, result);
    }
    for(int n = 0; n < K; n++) {
      sb.append(hash.get(gods[n])).append("\n");
    }
    System.out.println(sb);
  }
  public static void input(BufferedReader br) throws Exception{
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    map = new char[N][M];
    gods = new String[K];
    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < M; j++) {
        char k = str.charAt(j);
        map[i][j] = k;
      }
    }

    for(int i = 0; i < K; i++){
      String s = br.readLine();
      hash.put(s, 0);
      gods[i] = s;
    }
  }

  public static void pro(String god, int dep, int x, int y){
    if(map[x][y] != god.charAt(dep)) return;
    if(dep == god.length()-1){
      result++;
      return;
    }
    for(int i=0 ; i<8 ; i++){
      int nx = x + dx[i];
      int ny = y + dy[i];
      if(nx < 0) nx = N-1;
      if(ny < 0) ny = M-1;
      if(nx >= N) nx = 0;
      if(ny >= M) ny = 0;
      pro(god, dep+1, nx, ny);
    }
  }
}