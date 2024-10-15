import java.util.*;
import java.io.*;

public class Main {
  public static int[] dx = {-1, 1, 0, 0};
  public static int[] dy = {0, 0, -1, 1};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][n];
    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      for (int j = 0; j < n; j++) {
        arr[i][j] = s.charAt(j) - '0';
      }
    }
    int danji = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for(int i=0 ; i<n ; i++){
      for(int j=0 ; j<n ; j++){
        if(arr[i][j]==1){
          danji++;
          pq.add(bfs(arr, i, j));
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    while(!pq.isEmpty()){
      sb.append(pq.poll())
          .append("\n");
    }
    System.out.println(danji);
    System.out.println(sb);
  }

  public static int bfs(int[][] arr, int x, int y){
    LinkedList<int[]> q = new LinkedList<>();
    q.add(new int[]{x, y});
    arr[x][y] = -1;
    int count = 1;
    while(!q.isEmpty()){
      int[] cur = q.poll();
      for(int i=0 ; i<4 ; i++){
        int nextX = cur[0] + dx[i];
        int nextY = cur[1] + dy[i];
        if(nextX < 0 || nextY < 0 || nextX >= arr.length || nextY >= arr[0].length || arr[nextX][nextY]!=1) continue;
        arr[nextX][nextY] = -1;
        q.add(new int[]{nextX, nextY});
        count++;
      }
    }
    return count;
  }

}
