class Solution {
    public int[][] solution(int n) {
        int[][] arr = new int[n][n];
        int i=1;
        int x=0, y=0;
        int[][] d = {{0,1},{1,0},{0,-1},{-1,0}};
        int cd = 0;
        while(i<n*n+1){
            arr[x][y] = i++;
            
            int cdx = d[cd][0];
            int cdy = d[cd][1];
            if(x+cdx<0 || y+cdy<0 || x+cdx>=n || y+cdy>=n || arr[x+cdx][y+cdy] != 0){
                cd = (cd+1)%4;  
            }
            x += d[cd][0];
            y += d[cd][1];
        }
        return arr;
    }
}