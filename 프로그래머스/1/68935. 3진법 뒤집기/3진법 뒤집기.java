class Solution {
    public int solution(int n) {
        long answer = 0;
        while(n!=0){
            answer+=n%3;
            n/=3;
            answer*=(long)10;
        }
        answer/=10;
        // int i=1;
        // int result = 0;
        // while(answer != 0){
        //     result += (answer%10)*i;
        //     answer/=10;
        //     i*=3;
        // }
        return Integer.parseInt(String.valueOf(answer),3);
    }
}