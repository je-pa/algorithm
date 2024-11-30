import java.util.*;
class Solution {
    int BIN = 0;
    int RS = 1, BS = 2;
    int RE = 3, BE = 4;
    int W = 5;
    int[] dy = {0,0,1,-1};
    int[] dx = {1,-1,0,0};
    int XL, YL;
    boolean[][] rv;
    boolean[][] bv;
    int answer = Integer.MAX_VALUE;
    // LinkedList<int[]> q = new LinkedList<>();
    
    public int solution(int[][] maze) {
        input(maze);
        int crx=0, cry=0, crl=0, cbx=0, cby=0, cbl=0; 
        boolean crf=false, cbf=false;
        for(int i=0 ; i<XL ; i++){
            for(int j=0 ; j<YL ; j++){
                int k = maze[i][j];
                if(k == RS){
                    crx = i;
                    cry = j;
                    crl = 0;
                    crf = false;
                }
                if(k==BS){
                    cbx = i;
                    cby = j;
                    cbl = 0;
                    cbf = false;
                }
            }
        }
        dfs(crx, cry, crl, crf, cbx, cby, cbl, cbf, maze);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    void dfs(int crx, int cry, int crl, boolean crf
            , int cbx, int cby, int cbl, boolean cbf
            ,int[][] maze){
        if(crf && cbf) {
            answer = Math.min(Math.max(crl, cbl),answer);
            return;
        }
        List<int[]> nrs = new ArrayList<>();
        inputNxy(nrs, crf, crx, cry, rv,maze,RE);
        List<int[]> nbs = new ArrayList<>();
        inputNxy(nbs, cbf, cbx, cby, bv,maze,BE);
        for(int[] nr : nrs){
            for(int[] nb : nbs){
                int nrx = nr[0], nry = nr[1], nrl = crl+1;
                int nbx = nb[0], nby = nb[1], nbl = cbl+1;
                boolean nrf = (nr[2] == 1); 
                boolean nbf = (nr[2] == 1);
                if(nrx==nbx && nry==nby) continue;
                // if(nrx==cbx && nry== cby && nbx==crx && nby== cry) continue;
                if(nbx==crx && nby== cry) continue;
                rv[nrx][nry] = true;
                bv[nbx][nby] = true;
                dfs(nrx, nry, crl+1, nr[2] == 1, nbx, nby, cbl+1, nb[2] == 1, maze);
                rv[nrx][nry] = false;
                bv[nbx][nby] = false;
            }
        }
    }
    void inputNxy(List<int[]> ns, boolean f, int cx, int cy, boolean[][] visited, int[][] maze, int e){
        if(f) {
            ns.add(new int[]{cx, cy, 1});
        }else{
            for(int i=0 ; i<4 ; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx<0 || nx>=XL || ny<0 || ny>=YL) continue;
                if(visited[nx][ny]) continue;
                if(maze[nx][ny] == W) continue;
                ns.add(new int[]{nx,ny, (maze[nx][ny] == e)?1:-1});
            }
        }
    }
    void input(int[][] maze){
        XL = maze.length;
        YL = maze[0].length;
        rv = new boolean[XL][YL];
        bv = new boolean[XL][YL];
        // boolean firstR = false;
        // for(int i=0 ; i<XL ; i++){
        //     for(int j=0 ; j<YL ; j++){
        //         int k = maze[i][j];
        //         if(k == RS){
        //             q.add(new int[]{i,j,0,-1});
        //             // rv[i][j] = 1;
        //             // firstR = t;
        //         }
        //         if(k==BS){
        //             q.add(new int[]{i,j,0,-1});
        //             // bv[i][j] = 1;
        //             // firstR = true;
        //         }
        //     }
        // }
        // if(!firstR) q.add(q.poll());
        
    }
//     void bfs(){
//         while(!q.isEmpty()){
//             int[] curR = q.poll();
//             int crx = curR[0];
//             int cry = curR[1];
//             int crl = curR[2];
//             boolean crf = (curR[3] == 1);
//             int[] curB = q.poll();
//             int cbx = curB[0];
//             int cby = curB[1];
//             int cbl = curB[2];
//             boolean cbf = (curB[3] == 1);
//             if(crf && cbf) {
//                 answer = crl;
//                 break;
//             }
//             List<int[]> nrs = new ArrayList<>();
//             inputNxy(nrs, crf, crx, cry, rv,maze,RE);
//             List<int[]> nbs = new ArrayList<>();
//             inputNxy(nbs, cbf, cbx, cby, bv,maze,BE);
            
//             for(int[] nr : nrs){
//                 for(int[] nb : nbs){
//                     if(nr[0]==nb[0] && nr[1]==nb[1]) continue;
//                     if(nr[0]==cbx && nr[1]== cby && nb[0]==crx && nb[1]== cry) continue;
//                     q.add(new int[]{nr[0],nr[1],crl+1,nr[2]});
//                     rv[nr[0]][nr[1]] += 1;
//                     q.add(new int[]{nb[0],nb[1],cbl+1,nb[2]});
//                     bv[nb[0]][nb[1]] += 1;
//                 }
//             }
//         }
//     }
}