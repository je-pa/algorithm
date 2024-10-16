import java.util.*;
import java.io.*;

public class Main {
  public static int n;
  public static int m;
  public static boolean[] visit;
  public static int[] dx = {1, -1, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    visit = new boolean[200_001];

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
        int nx = curX + (dx[i] != 0 ? dx[i] : curX);
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
