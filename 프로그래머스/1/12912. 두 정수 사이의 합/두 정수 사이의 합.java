class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int min = a>b ? b : a;
        int max = min==a ? b : a;
        for(int i=min; i<=max ; i++){
            answer+=i;
        }
        
        return answer;
    }
}