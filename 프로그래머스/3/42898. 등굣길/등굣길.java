class Solution {
    int MOD = 1_000_000_007;
    int[] dx = {0, 1};
    int[] dy = {1, 0};
    int[][] map;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        map = new int[m+1][n+1];
        for(int[] arr : puddles){
            map[arr[0]][arr[1]] = -1;
        }
        for(int i=1 ; i<=m ; i++ ){
            if(map[i][1] == -1) break;
            map[i][1] = 1;
        }
        for(int i=1 ; i<=n ; i++){
            if(map[1][i] == -1) break;;
            map[1][i] = 1;
        }
        for(int i=2 ; i<=m ; i++){
            for(int j=2 ; j<= n ; j++){
                if(map[i][j] == -1) continue;
                for(int k=0 ; k<dx.length ; k++){
                    int px = i-dx[k];
                    int py = j-dy[k];
                    if(map[px][py] == -1) continue;
                    map[i][j] += map[px][py];
                    map[i][j] %= MOD;
                }
            }
        }
        return  map[m][n];
    }
}