class Solution {
    boolean[][] check;
    int[][] pic;
    int maxA;
    int curA;
    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        pic = picture;
        check = new boolean[picture.length][picture[0].length];
        for(int i=0 ; i<picture.length ; i++){
            for(int j=0 ; j<picture[0].length ; j++){
                if(check[i][j]) continue;
                if(pic[i][j] == 0) continue;
                dfs(i,j,pic[i][j]);
                maxA=Math.max(maxA,curA);
                curA =0;
                answer[0]+=1;
                // System.out.println();
            }
        }
        answer[1] = maxA;
        return answer;
    }
    
    void dfs(int curx, int cury, int color){
        if(curx<0 || cury < 0||curx >= pic.length || cury >= pic[0].length){
            return;
        }
        if(check[curx][cury]){
            return;
        }
        if(pic[curx][cury] != color){
            return;
        }
        curA++;
        // System.out.print(color+" ");
        check[curx][cury] = true;
        dfs(curx+1, cury, color);
        dfs(curx, cury+1, color);
        dfs(curx-1, cury, color);
        dfs(curx, cury-1, color);
    }
}