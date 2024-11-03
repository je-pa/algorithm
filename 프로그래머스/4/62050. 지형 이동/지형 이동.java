import java.util.*;

class Solution {
    static class Info implements Comparable<Info>{
        int x;
        int y;
        int len;
        Info(int x, int y, int len){
            this.x = x;
            this.y = y;
            this.len = len;
        }
        
        public int compareTo(Info o){
            return Integer.compare(this.len, o.len);
        }
    }
    public boolean[][] visited;
    public int[] dx = {0,0,-1,1};
    public int[] dy = {1,-1,0,0};
    public PriorityQueue<Info> pq = new PriorityQueue<>();
    public int count = 0;
    public int answer = 0;
    
    public int solution(int[][] land, int height) {
        visited = new boolean[land.length][land[0].length];
        pq.add(new Info(0,0,0));
        while(!pq.isEmpty()){
            Info cur = pq.poll();
            if(visited[cur.x][cur.y]) continue;
            answer+=cur.len;
            dfs(cur.x, cur.y, land, height);
        }
           
        return answer;
    }
    public void dfs(int x, int y, int[][] land, int h){
        count++;
        visited[x][y] = true;
        int curH = land[x][y];
        for(int i=0 ; i<4 ; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= land.length || ny >= land[0].length || visited[nx][ny]) continue;
            int nH = land[nx][ny];
            int gap = Math.abs(nH - curH);
            if(gap > h){
                pq.add(new Info(nx, ny, gap));
                continue;
            }
            dfs(nx, ny, land, h);
        }
    }
}