import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
  static int R, C, T;
  static int[][] map;
  static int[] dx = {1, 0, 0, -1};
  static int[] dy = {0, -1, 1, 0};
  static int[] cleaner = new int[2];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }
  private static void input(BufferedReader br) throws IOException {
    StringTokenizer sb = new StringTokenizer(br.readLine());
    R = Integer.parseInt(sb.nextToken());
    C = Integer.parseInt(sb.nextToken());
    T = Integer.parseInt(sb.nextToken());
    map = new int[R][C];
    int cidx = 0;
    for(int i = 0; i < R; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j = 0; j < C; j++){
        int a = Integer.parseInt(st.nextToken());
        map[i][j] = a;
        if(a == -1){
          cleaner[cidx] = i;
          cidx++;
        }
      }
    }
  }

  private static void pro() {
    int[][] old = map;
    int[][] newArr = new int[R][C];
    for(int k=0 ; k<T ; k++){
      for(int i = 0 ; i < R ; i++){
        for(int j = 0 ; j < C ; j++){
          spread(i, j, old, newArr);
        }
      }
      proCleaner(newArr);
      old = newArr;
      newArr = new int[R][C];
    }
    System.out.println(count(old));
  }

  private static void spread(int x, int y, int[][] old, int[][] newArr){
    if(map[x][y] == -1) return;
    if(old[x][y] > 0 && old[x][y] <5){
      newArr[x][y] += old[x][y];
      return;
    }
    int k = old[x][y] / 5;
    int count = 0;
    for(int i=0 ; i<dx.length ; i++){
      int nx = x + dx[i];
      int ny = y + dy[i];
      if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
      if(map[nx][ny] == -1) continue;
      count ++;
      newArr[nx][ny] += k;
    }
    newArr[x][y] += (old[x][y] - k * count);
  }

  private static int count(int[][] arr){
    int sum = 0;
    for(int[] a : arr){
      for(int i : a){
        if(i == -1) continue;
        sum += i;
      }
    }
    return sum;
  }

  private static void proCleaner(int[][] map){
    int r = cleaner[0];
    for(int i=r-1 ; i>0 ; i--){
      map[i][0] = map[i-1][0];
    }
    for(int i=0 ; i<C-1 ; i++){
      map[0][i] = map[0][i+1];
    }
    for(int i=0 ; i<r ; i++){
      map[i][C-1] = map[i+1][C-1];
    }
    for(int i=C-1 ; i>0 ; i--){
      map[r][i] = map[r][i-1];
    }
    r = cleaner[1];
    for(int i=r+1 ; i<R-1 ; i++){
      map[i][0] = map[i+1][0];
    }
    for(int i=0 ; i<C-1 ; i++){
      map[R-1][i] = map[R-1][i+1];
    }
    for(int i=R-1 ; i>r ; i--){
      map[i][C-1] = map[i-1][C-1];
    }
    for(int i=C-1 ; i>0 ; i--){
      map[r][i] = map[r][i-1];
    }
  }
}

