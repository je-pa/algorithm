import java.util.*;
import java.io.*;
public class Main {
    static int n,m,result=0;
    static int[][] map = new int[8][8];
    static int[][] temp = new int[8][8];

    static int[] dx = {-1, 1, 0, 0};//상 하 좌 우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        for(int i=0; i<n ; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        dfs(0);
        System.out.println(result);
    }

    static void dfs(int count){
        if(count == 3){
            for(int i =0;i<n;i++){
                for(int j=0 ; j<m ; j++){
                    temp[i][j] = map[i][j];
                }
            }
            for(int i =0;i<n;i++){
                for(int j=0 ; j<m ; j++){
                    if(temp[i][j]==2) virus(i,j);
                }
            }
            result = Math.max(result, count());
            return;
        }
        for(int i=0; i<n ; i++){
            for(int j=0; j<m ; j++){
                if(map[i][j] == 0){
                    count++;
                    map[i][j]=1;
                    dfs(count);
                    map[i][j]=0;
                    count--;
                }
            }
        }
    }

    static void virus(int x, int y){
        for(int i=0; i<4 ; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx<0 || nx>=n || ny<0 || ny>=m){
                continue;
            }
            if(temp[nx][ny]==0){
                temp[nx][ny]=2;
                virus(nx, ny);
            }
        }
    }

    static int count(){
        int count =0;
        for(int i=0 ;i<n ; i++){
            for(int j=0; j<m; j++){
                if(temp[i][j]==0){
                    count++;
                }
            }
        }
        return count;
    }
}
