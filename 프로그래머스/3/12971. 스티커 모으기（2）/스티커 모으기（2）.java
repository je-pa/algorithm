class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int len = sticker.length;
        if(len < 2) return sticker[0];
        int[][] dp = new int[len][2];
        dp[1][1] = sticker[1];
        for(int i=2 ; i<len ; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + sticker[i];
        }
        if(len < 3) return Math.max(sticker[0], sticker[1]);
        int[][] dp2 = new int[len][2];
        dp2[2][1] = sticker[2];
        for(int i=3 ; i<len ; i++){
            dp2[i][0] = Math.max(dp2[i-1][0], dp2[i-1][1]);
            dp2[i][1] = dp2[i-1][0] + sticker[i];
        }
        return Math.max(Math.max(dp[len-1][1], dp[len-1][0]), dp2[len-1][0] + sticker[0]);
    }
}