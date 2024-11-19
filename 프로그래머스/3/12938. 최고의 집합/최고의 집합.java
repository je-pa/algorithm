class Solution {
    public int[] solution(int n, int s) {
        if(n > s) return new int[]{-1};
        int[] answer = new int[n];
        int d = s/n;
        int p = s%n;
        for(int i=0 ; i<n-p ; i++){
            answer[i]=d;
        }
        d=d+1;
        for(int i=n-p ; i<n ; i++){
            answer[i]=d;
        }
        return answer;
    }
}