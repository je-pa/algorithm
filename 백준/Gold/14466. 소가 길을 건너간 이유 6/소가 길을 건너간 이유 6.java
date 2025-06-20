import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
  static int N, K, R;
  // 1억개
  static boolean[][][][] bridge;
  // 10000개
  static boolean[][] cow;
  // 10000개
  static boolean[][] visited;
  static int[] dx = {1,-1,0,0};
  static int[] dy = {0,0,1,-1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }
  static void pro() {
    List<Integer> list = new ArrayList<>();
    for(int i=0 ; i<N ; i++) {
      for(int j=0 ; j<N ; j++) {
        if(visited[i][j] || !cow[i][j]) continue;
        list.add(bfs(i,j));
      }
    }
    int count = 0;
    for(int i=0 ; i<list.size() ; i++) {
      for(int j=i+1 ; j<list.size() ; j++) {
        count += list.get(i)*list.get(j);
      }
    } 
    System.out.println(count);
  }

  static int bfs(int x, int y) {
    LinkedList<int[]> q = new LinkedList<>();
    q.add(new int[]{x,y});
    visited[x][y] = true;
    int count = 0;
    while(!q.isEmpty()) {
      int[] c = q.poll();
      int cx = c[0],cy = c[1];
      if(cow[cx][cy]) count++;
      for(int i=0 ; i<dx.length ; i++){
        int nx = cx + dx[i];
        int ny = cy + dy[i];
        if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
        if(visited[nx][ny]) continue;
        if(bridge[cx][cy][nx][ny]) continue;
        visited[nx][ny] = true;
        q.add(new int[]{nx, ny});
      }
    }
    return count;
  }

  private static void input(BufferedReader br) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());

    bridge = new boolean[N][N][N][N];
    cow = new boolean[N][N];
    visited = new boolean[N][N];

    for(int i=0 ;i<R ; i++){
      st = new StringTokenizer(br.readLine());
      int a1 = Integer.parseInt(st.nextToken())-1;
      int b1 = Integer.parseInt(st.nextToken())-1;
      int a2 = Integer.parseInt(st.nextToken())-1;
      int b2 = Integer.parseInt(st.nextToken())-1;

      bridge[a1][b1][a2][b2] = true;
      bridge[a2][b2][a1][b1] = true;
    }

    for(int i=0 ;i<K ; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken())-1;
      int b = Integer.parseInt(st.nextToken())-1;

      cow[a][b] = true;
    }

  }

}

