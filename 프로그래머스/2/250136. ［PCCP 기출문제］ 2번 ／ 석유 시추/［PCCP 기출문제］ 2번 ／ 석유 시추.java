import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] land) {
        int answer = 0;
        int num = -1;
        int[] count = new int[land.length * land[0].length];
        
        for(int i=0 ; i< land.length ; i++){
            for(int j=0 ; j< land[i].length ; j++){
                if(land[i][j] == 1){
                    bfs(i, j, land, num, count);
                    num-=1;
                }
            }
        }
        
        for(int i=0 ; i<land[0].length ; i++){
            Set<Integer> set = new HashSet<>();
            for(int j=0 ; j<land.length ; j++){
                set.add(land[j][i]);
            }
            int total = 0;
            for(int k : set){
                total += count[k*-1];
            }
            answer = Math.max(answer, total);
        }
        
            
        return answer;
    }
    
    void bfs(int i, int j, int[][] land, int num, int[] count){
        LinkedList<int[]> list = new LinkedList<>();
        list.add(new int[]{i, j});
        land[i][j] = num;
        int countNum= 1;
        while(!list.isEmpty()){
            int[] cur = list.poll();
            int curX = cur[0];
            int curY = cur[1];
            for(int k=0 ; k<4 ; k++){
                int nextX = curX + dx[k];
                int nextY = curY + dy[k];
                if(nextX <0 || nextY < 0 || nextX >= land.length || nextY >= land[0].length) continue;
                if(land[nextX][nextY] != 1) continue;
                list.add(new int[]{nextX, nextY});
                land[nextX][nextY] = num;
                countNum++;
            }
        }
        
        
        count[num*-1] = countNum;
    }
}