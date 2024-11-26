class Solution {
    int N;
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        N = diffs.length;
        int l = 1;
        int r = 100_000;
        if(N == 1){
            return 1;
        }
        while(l<=r){
            int mid = (l+r)/2;
            long before = 0;
            long count = 0;
            for(int i=0 ; i<N; i++){
                if(diffs[i]<=mid){
                    count+=(long)times[i];
                }else{
                    count+=(before+(long)times[i])*((long)diffs[i]-mid) + (long)times[i];
                }
                
                before = times[i];
                if(check(count, limit)) break;
            }
            if(check(count, limit)){
                l = mid +1;
            }else{
                r = mid -1;
                answer = mid;
            }
        }
        return l;
    }
    
    boolean check(long count, long limit){
        return count > limit;
    }
}