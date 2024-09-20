import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int L;
  static int R;
  static int[][] map;
  static int[][] visited;
  static int[] dx = {0, 0, -1, 1};
  static int[] dy = {-1, 1, 0, 0};
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());
    map = new int[N][N];
    for(int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < N; j++){
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    int count = 0 ;
    while(day()){
      count++;
    }
    System.out.println(count);
  }
  static boolean day(){
    visited = new int[N][N];
    ArrayList<Integer> list = new ArrayList<>();
    int idx = 0;
    for(int i = 0 ; i< N ; i++){
      for(int j = 0 ; j<N ; j++){
        if(visited[i][j] == 0 && check(i, j)){
          idx++;
          list.add(bfs(i, j, idx));
        }
      }
    }
    if(list.size() == 0){
      return false;
    }else{
      for(int i = 0 ; i< N ; i++){
        for(int j = 0 ; j<N ; j++){
          if(visited[i][j] != 0){
            map[i][j] = list.get(visited[i][j]-1);
          }
        }
      }
      return true;
    }
  }
  static boolean check(int x, int y){
//    if(x < 0 || x >= N || y < 0 || y >= N) return false;
    for(int i =0 ; i < 4 ; i++){
      int nx = dx[i] + x;
      int ny = dy[i] + y;
      if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
      int abs = Math.abs(map[nx][ny] - map[x][y]);
      if(abs >= L && abs <= R) return true;
    }
    return false;
  }

  static int bfs(int x, int y, int idx){
    Queue<Xy> queue = new LinkedList<>();
    int count = 0;
    int sum = 0;
    queue.add(new Xy(x, y));
    visited[x][y] = idx;
    count++;
    sum += map[x][y];
    while(!queue.isEmpty()){
      Xy curr = queue.poll();
      for(int i = 0 ; i <4 ; i++){
        int nx = curr.x + dx[i];
        int ny = curr.y + dy[i];
        if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] != 0) continue;
        int abs = Math.abs(map[nx][ny] - map[curr.x][curr.y]);
        if(abs < L || abs > R) continue;
        queue.add(new Xy(nx, ny));
        visited[nx][ny] = idx;
        count++;
        sum += map[nx][ny];
      }
    }
    return sum/count;
  }

  static class Xy{
    int x;
    int y;
    public Xy(int x, int y){
      this.x = x;
      this.y = y;
    }
  }
}
