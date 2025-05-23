import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int count = 0;
    static int max = 0;
    static int cur = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0 ; i<N ; i++){
            for(int j=0; j<M ; j++){
                if(visited[i][j] || map[i][j] == 0) continue;
                cur = 0;
                dfs(i, j);
                count++;
                max = Math.max(cur, max);
            }
        }
        System.out.println(count);
        System.out.println(max);
    }
    static void dfs(int x, int y){
        visited[x][y] = true;
        cur++;
        for(int i=0 ; i<4 ; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if(visited[nx][ny] || map[nx][ny] == 0) continue;
            dfs(nx, ny);
        }
    }
}