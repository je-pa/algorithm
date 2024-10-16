import java.util.*;
import java.io.*;

public class Main {
  public static int n;
  public static int m;
//  public static int[][] map;
  public static boolean[] visit;
  public static int[] dx = {1, -1, 0};
//  public static int[] dy = {0, 1, 0, -1};
//  public static int min = 10001;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
//    map = new int[n][m];
    visit = new boolean[200_001];
//    for (int i = 0; i < n; i++) {
//      String s = br.readLine();
//      for (int j = 0; j < m; j++) {
//        int num = s.charAt(j) - '0';
//        map[i][j] = num;
//      }
//    }

    System.out.println(bfs());
  }

  public static int bfs(){
    LinkedList<Integer> q = new LinkedList<>();
    q.add(n);
    q.add(0);
    visit[n] = true;
    while(!q.isEmpty()){
      int curX = q.poll();
      int count = q.poll();
      for(int i = 0; i < 3; i++){
        int nx = 0;
        if(dx[i] == 0){
          nx= curX * 2;
        }else{
          nx= curX + dx[i];
        }
        int nc = count + 1;
        if(nx <0 || nx >= 200_001) continue;
        if(visit[nx]) continue;
        if(nx == m){
          return nc;
        }
        visit[nx] = true;
        q.add(nx);
        q.add(nc);
      }
    }
    return 0;
  }
}
