import java.io.*;
import java.util.*;

public class Main {
  static int N, M;
  static int H, W;
  static int SR, SC;
  static int FR, FC;
  static PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(Math::abs));
  static List<List<Integer>> CW = new ArrayList<>();
  static List<List<Integer>> RW = new ArrayList<>();
  static int[] dx = {-1, 1, 0,0};
  static int[] dy = {0, 0, -1, 1};


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }

  static void input(BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    for(int i=0 ; i<N ; i++){
      RW.add(new ArrayList<>());
    }
    for(int i=0 ; i<M ; i++){
      CW.add(new ArrayList<>());
    }
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        int k = Integer.parseInt(st.nextToken());
        if(k==1){
          RW.get(i).add(j);
          CW.get(j).add(i);
        }
      }
    }
    st = new StringTokenizer(br.readLine());
    H = Integer.parseInt(st.nextToken());
    W = Integer.parseInt(st.nextToken());
    SR = Integer.parseInt(st.nextToken())-1;
    SC = Integer.parseInt(st.nextToken())-1;
    FR = Integer.parseInt(st.nextToken())-1;
    FC = Integer.parseInt(st.nextToken())-1;
  }

  static void pro() {
    LinkedList<int[]> q = new LinkedList<>();
    boolean[][] visited = new boolean[N][M];
    q.add(new int[]{SR,SC, 0});
    visited[SR][SC] = true;
    if(SR==FR && SC==FC) {
      System.out.println(0);
      return;
    }
    while(!q.isEmpty()){
      int[] cur = q.poll();
      int cx = cur[0];
      int cy = cur[1];
      int cd = cur[2];
      for(int i=0 ; i<4 ; i++){
//        System.out.println();
        int nx = cx + dx[i];
        int ny = cy + dy[i];
        int nd = cd + 1;
//        System.out.println(nx + " " + ny + ":1");
        if(isOut(nx,ny)) continue;
//        System.out.println(nx + " " + ny + ":out");
        if(isContains(nx, ny, i)) continue;
//        System.out.println(nx + " " + ny + ":con");
        if(visited[nx][ny]) continue;
//        System.out.println(nx + " " + ny + ":visited");
        if(nx == FR && ny == FC){
          System.out.println(nd);
          return;
        }
        visited[nx][ny] = true;
        q.add(new int[]{nx,ny, nd});
      }
    }
    System.out.println(-1);
  }
  static boolean isOut(int x, int y){
    return x < 0 || y < 0 || x+H-1 >= N || y+W-1 >= M;
  }
  static boolean isContains(int x, int y, int d){ // 상0하1좌2우3
    if(d == 0){
      return isContains(y, y+W-1, RW.get(x));
    }else if(d==1){
      return isContains(y, y+W-1, RW.get(x+H-1));
    }else if(d==2){
      return isContains(x, x+H-1, CW.get(y));
    }else if(d==3){
      return isContains(x, x+H-1, CW.get(y+W-1));
    }
    throw new IllegalArgumentException();
  }
  // 1, 3, 5, 8 // 2 4
  static boolean isContains(int s, int e, List<Integer> line){
    if(line.isEmpty()) return false;
    int l = 0;
    int r = line.size() -1;
    while(l<=r){
      int m = (l+r)/2;
      int n = line.get(m);
      if(n < s){
        l = m+1;
      }else if(n > e){
        r = m-1;
      }else{
        return true;
      }
    }
    return false;
  }
}
