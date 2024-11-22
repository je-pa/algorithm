class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        for(int i=0 ; i<stations.length+1 ; i++){
            int l = 1;
            int r = 0;
            if(i == 0){
                r = stations[i] - w - 1;
            }else if(i==stations.length){
                r=n;
                l=stations[i-1] +w +1;
            }else{
                l = stations[i-1] + w + 1;
                r = stations[i] - w - 1;
            }
            if(r < l) continue;
            int len = r-l+1;
            // System.out.printf("%d, %d = %d\n", l, r, len);
            answer += (len-1)/(w*2+1) + 1;
        }
        return answer;
    }
}