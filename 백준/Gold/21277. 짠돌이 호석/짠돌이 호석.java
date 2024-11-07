import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  public static int N1;
  public static int M1;
  public static int N2;
  public static int M2;
  public static int[][] map1;
  public static int[][] map2;
  public static int result = Integer.MAX_VALUE;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
    System.out.println(result);
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N1 = Integer.parseInt(st.nextToken());
    M1 = Integer.parseInt(st.nextToken());
    map1 = new int[N1][M1];
    String s = "";
    for (int i = 0; i < N1; i++) {
      s = br.readLine();
      for (int j = 0; j < M1; j++) {
        map1[i][j] = s.charAt(j) - '0';
      }
    }
    st = new StringTokenizer(br.readLine());
    N2 = Integer.parseInt(st.nextToken());
    M2 = Integer.parseInt(st.nextToken());
    map2 = new int[N2][M2];
    for (int i = 0; i < N2; i++) {
      s = br.readLine();
      for (int j = 0; j < M2; j++) {
        map2[i][j] = s.charAt(j) - '0';
      }
    }
  }
  static void pro(){
    for(int k = 0 ; k< 4 ; k ++){
      turn();
      for(int i = -50 ; i<=50 ; i++){
        for(int j = -50 ; j<=50 ; j++){
          if(check(i, j)){
            int sx = Math.min(0, i);
            int ex = Math.max(N1, map2.length + i);
            int x = ex - sx;
            int sy = Math.min(0, j);
            int ey = Math.max(M1, map2[0].length + j);;
            int y = ey - sy;
            result = Math.min(x*y, result);
          }
        }
      }
    }
  }
  static boolean check(int x, int y){
    for(int i=0 ; i< N1 ; i++){
      for(int j=0 ; j< M1 ; j++){
        if(map1[i][j] == 0) continue;
        int nx = i - x;
        int ny = j - y;
        if(nx <0|| ny < 0 || nx >= map2.length || ny >= map2[0].length) continue;
        if(map2[nx][ny] == 1) return false;
      }
    }
    return true;
  }
  static void turn(){
    int[][] newMap = new int[map2[0].length][map2.length];
    for (int i = 0; i < map2.length; i++) {
      for (int j = 0; j < map2[0].length; j++) {
        newMap[map2[0].length -j -1][i] = map2[i][j];
      }
    }
    map2 = newMap;
  }
}




