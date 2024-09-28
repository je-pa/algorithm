class Solution {
//     public int solution(int n, int[] money) {
//         int[][] dp = new int[money.length+1][n+1];
        
        
//         // dp[i-1][j] + dp[i][j-money[i]];        
        
//         return dp[money.length][n];
//     }
    public int solution(int total, int[] coins) {

        int[] arr = new int[total];
        // for(int k = 0;k<total;k++){ arr[k] = 0; }
        for(int i : coins){
            arr[i-1] += 1;
            for(int j=0; j<total ; j++) {
                if(j>=i) 
                    arr[j] += arr[j - i]; 
            }
        }
        return arr[total-1];
    }
}

// class Solution {

//     private int[][] dp;

//     public int solution(int n, int[] money) {

//         dp = new int[money.length + 1][n + 1];//이차원 배열 생성

//         for (int i = 1; i <= money.length; i++) {
//             for (int j = 0; j <= n; j++) {
//                 if (j == 0) {
//                     dp[i][j] = 1;//맨 첫 열은 1로 초기화
//                 } else if (j - money[i-1] >= 0) {
//                     dp[i][j] = (dp[i - 1][j] + dp[i][j - money[i - 1]]) % 1000000007;
//                 } else
//                     dp[i][j] = dp[i - 1][j];
//             }
//         }

//         return dp[money.length][n];
//     }
// }