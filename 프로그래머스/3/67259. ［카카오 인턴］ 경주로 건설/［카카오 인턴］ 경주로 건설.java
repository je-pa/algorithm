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
                return cl;
            }
            for(int i=0 ; i<4 ; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nl = cl + 100;
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }
                if(visited[nx][ny][i] || board[nx][ny] == 1){
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
}