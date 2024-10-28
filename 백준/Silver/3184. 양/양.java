import java.util.*;
import java.io.*;

public class Main {
  public static int N;
  public static int M;
  public static char[][] map;
  public static boolean[][] visit;
  public static char[] d = new char[]{'.','o','v'};
  public static int[] dx = new int[]{0,0, 1, -1};
  public static int[] dy = new int[]{1,-1, 0, 0};
  public static int shT;
  public static int woT;
  public static int shC;
  public static int woC;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  public static void pro(){
    for(int i = 0 ; i < N ; i++){
      for(int j = 0 ; j < M ; j++){
        if(map[i][j] == '#') continue;
        shC = 0;
        woC = 0;
        dfs(i, j);
        if(shC > woC){
          woT -= woC;
        }else{
          shT -= shC;
        }
      }
    }
    System.out.println(shT + " " + woT);
  }

  public static void dfs(int cx, int cy){
    if(visit[cx][cy]) return;
    if(map[cx][cy] == '#') return;
    visit[cx][cy] = true;
    if(map[cx][cy] == 'o'){
      shC++;
    }else if(map[cx][cy] == 'v'){
      woC++;
    }
    for(int i=0 ; i<4; i++){
      int nx = cx + dx[i];
      int ny = cy + dy[i];
      if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
      dfs(nx, ny);
    }
  }

  public static void input(BufferedReader br) throws IOException{
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new char[N][M];
    visit = new boolean[N][M];
    String s;
    for(int i=0 ; i<N ; i++){
       s = br.readLine();
      for(int j=0 ; j<M ; j++){
        char c = s.charAt(j);
        map[i][j] = c;
        if(c == 'v') {
          woT++;
        }else if(c == 'o'){
          shT++;
        }
      }
    }
  }
}