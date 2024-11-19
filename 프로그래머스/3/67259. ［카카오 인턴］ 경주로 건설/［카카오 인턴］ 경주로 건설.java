import java.util.*;
class Solution {
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    boolean[][][] visited;
    int CON = 500;
    int LIN = 100;
    int N;
    int min = Integer.MAX_VALUE;
    public int solution(int[][] board) {
        N = board.length;
        visited = new boolean[N][N][4];
        // dfs(board, -1, 0, 0, 0);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0,0,0,-1));
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int cx = node.x;
            int cy = node.y;
            int cl = node.len;
            int pd = node.preD;
            if(pd!=-1)visited[cx][cy][pd] =true;
            if(cx == N-1 && cy == N-1){
                min = Math.min(min, cl);
                continue;
            }
            for(int i=0 ; i<4 ; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nl = cl + 100;
                // System.out.println(nx +" "+ny);
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }
                if(visited[nx][ny][i] || board[nx][ny] == 1){
                    // System.out.println(nx +" "+ny + " " +visited[nx][ny]+ " " +board[nx][ny]);
                    continue;
                }
                if(i!=pd && !(cx == 0 && cy == 0)) nl += 500;
                pq.add(new Node(nx, ny, nl, i));
            }
        }
        return min;
        
    }
    
    static class Node implements Comparable<Node>{
        int x;
        int y;
        int len;
        int preD;
        public int compareTo(Node n){
            return Integer.compare(this.len, n.len);
        }
        public Node(int x, int y, int len , int preD){
            this.x = x;
            this.y = y;
            this.len = len;
            this.preD = preD;
        }
    }
    
    // public void dfs(int[][] map, int preD, int cx, int cy, int len){
    //     if(cx==N-1 && cy == N-1){
    //         // System.out.println(len);
    //         min = Math.min(len,min);
    //         return;
    //     }
    //     visited[cx][cy]=true;
    //     // System.out.printf("%d,%d: %d\n",cx,cy,len);
        // for(int i=0 ; i<4 ; i++){
        //     int nx = cx + dx[i];
        //     int ny = cy + dy[i];
        //     int nl = len + 100;
        //     // System.out.println(nx +" "+ny);
        //     if(nx < 0 || ny < 0 || nx >= N || ny >= N) {
        //         continue;
        //     }
        //     if(visited[nx][ny] || map[nx][ny] == 1){
        //         // System.out.println(nx +" "+ny + " " +visited[nx][ny]+ " " +map[nx][ny]);
        //         continue;
        //     }
        //     if(i!=preD && !(cx == 0 && cy == 0)) nl += 500;
        //     dfs(map, i, nx, ny, nl);
        //     visited[nx][ny] = false;
        // }
    // }
}