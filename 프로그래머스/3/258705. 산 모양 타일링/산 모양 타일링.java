// class Solution {
//     public int solution(int n, int[] tops) {
//         int answer = 1;
//         int minus = 0;
//         int beforeAnswer = 0;
//         for(int top : tops){
//             beforeAnswer = answer;
//             if(top == 1){
//                 answer = (answer*4)%10007;
//             }else{
//                 answer = (answer*3)%10007;
//             }
//             if(minus > answer){
//                 answer = answer + 10007 - minus;
//             }else{
//                 answer -= minus;
//             }
            
//             minus = beforeAnswer;
            
//         }
//         return answer;
//     }
// }

class Solution {
    public int solution(int n, int[] tops) {
        int[] dp = new int[2*tops.length+3];
        dp[1] = 1;
        for(int i=2; i<dp.length; i++){
            if(i % 2 == 0 || tops[i/2 - 1] == 0){
                dp[i] = (dp[i-1] + dp[i-2]) % 10007;
            }else{
                dp[i] = (2*dp[i-1] + dp[i-2]) % 10007;
            }
        }
        return dp[dp.length-1];
    }
}
