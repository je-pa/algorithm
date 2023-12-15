class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        for(int i=0 ; i<n ; i++){
            if(computers[i][i]==1){
                answer++;
                check(i,computers, n);
            }    
        }
        return answer;
    }
    void check(int x , int[][] computers, int n){
        computers[x][x]=0;

        for(int i=0 ; i<n ; i++){
            if(computers[x][i]==1){
                computers[x][i] = 0;
                computers[i][x] = 0;    
                check(i,computers, n);
            }
        }
    }
}