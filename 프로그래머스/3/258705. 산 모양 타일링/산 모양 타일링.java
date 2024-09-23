class Solution {
    public int solution(int n, int[] tops) {
        int answer = 1;
        int minus = 0;
        int beforeAnswer = 0;
        for(int top : tops){
            beforeAnswer = answer;
            if(top == 1){
                answer = (answer*4)%10007;
            }else{
                answer = (answer*3)%10007;
            }
            if(minus > answer){
                answer = answer + 10007 - minus;
            }else{
                answer -= minus;
            }
            
            minus = beforeAnswer;
            
        }
        return answer;
    }
}