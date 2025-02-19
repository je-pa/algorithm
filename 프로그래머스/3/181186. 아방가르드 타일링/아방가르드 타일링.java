class Solution {
    public int solution(int n) {
        long[] dp = new long[n+1 < 4? 4 : n+1];
        long[] dp4 = new long[n + 1];
        long[] dp5 = new long[n + 1];
        long[] dp6 = new long[n + 1];
        int MOD = 1_000_000_007;
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 10;
        for(int i=4 ; i<=n ; i++){
            dp[i] += dp[i - 1];
            dp[i] %= MOD;
            dp[i] += dp[i - 2] * 2;
            dp[i] %= MOD;
            dp[i] += dp[i - 3] * 5;
            dp[i] %= MOD;
            if (i - 4 >= 0) {
                long diff = (dp[i - 4] * 2) % MOD;
                dp4[i] = (dp4[i-3] + diff) % MOD;
                dp[i] = (dp[i] + dp4[i]) % MOD;
            }

            if (i - 5 >= 0) {
                long diff = (dp[i - 5] * 2) % MOD;
                dp5[i] = (dp5[i-3] + diff) % MOD;
                dp[i] = (dp[i] + dp5[i]) % MOD;
            }

            if (i - 6 >= 0) {
                long diff = (dp[i - 6] * 4) % MOD;
                dp6[i] = (dp6[i-3] + diff) % MOD;
                dp[i] = (dp[i] + dp6[i]) % MOD;
            }
        }
        return (int)dp[n]%MOD;
    }
}
// class Solution {
//     public int solution(int n) {
//         long[] dp = new long[n+1 < 4? 4 : n+1];
//         int MOD = 1_000_000_007;
//         dp[0] = 1;
//         dp[1] = 1;
//         dp[2] = 3;
//         dp[3] = 10;
//         for(int i=4 ; i<=n ; i++){
//             dp[i] = dp[i-1];
//             dp[i]%=MOD;
//             if(i%3 == 0) {
//                 dp[i]++;
//                 dp[i]%=MOD;
//             }
            
//             for(int j=2 ; i-j>=0 ; j=j+3){
//                 dp[i] += dp[i-j] * 2;
//                 dp[i]%=MOD;
//                 if(i-j-1 >= 0) dp[i] += dp[i-j-1] * 5;
//                 dp[i]%=MOD;
//                 if(i-j-2 >= 0) dp[i] += dp[i-j-2] * 2;  
//                 dp[i]%=MOD;
//             }
//         }
//         return (int)dp[n]%MOD;
//     }
// }