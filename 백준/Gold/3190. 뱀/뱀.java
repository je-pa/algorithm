import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
  static int N;
  static boolean[][] apple;
  static boolean[][] visited;
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};
  static int[] time;
  static char[] dir;
  static Map<Character, Integer> changeDir = new HashMap<>();

  public static void pro() {
    LinkedList<int[]> list = new LinkedList<>();
    list.addLast(new int[]{1, 1});
    visited[1][1] = true;
    int curTime = 0;
    int timeIdx = 0;
    int curDir = 0;
    int curX = 1;
    int curY = 1;
    while(true){
      curTime++;
      curX = curX+dx[curDir];
      curY = curY+dy[curDir];
      if(curX<1 || curY<1 || curX>N || curY>N) break;
      if(visited[curX][curY]) break;
      // 사과일때는 몸통 길이가 늘어나니까 false 안함
      if(!apple[curX][curY]){
        int[] tail = list.removeFirst();
        visited[tail[0]][tail[1]] = false;
      }
      // 머리 이동
      list.addLast(new int[]{curX, curY});
      visited[curX][curY] = true;
      apple[curX][curY]=false;
      
      // 방향전환 
      if(timeIdx < time.length && time[timeIdx] == curTime){
        curDir = (curDir + changeDir.get(dir[timeIdx])+4) % 4;
        timeIdx++;
      }
    }
    System.out.println(curTime);
  }

  public static void input(BufferedReader br) throws IOException {
    N = Integer.parseInt(br.readLine());
    apple = new boolean[N+1][N+1];
    visited = new boolean[N+1][N+1];
    changeDir.put('D', 1);
    changeDir.put('L', -1);
    int k = Integer.parseInt(br.readLine());
    for(int i = 0; i < k; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      apple[a][b] = true;
    }
    int L = Integer.parseInt(br.readLine());
    time = new int[L];
    dir = new char[L];
    for(int i = 0; i < L; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      char b = st.nextToken().charAt(0);
      time[i] = a;
      dir[i] = b;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input(br);
    pro();
  }
}

