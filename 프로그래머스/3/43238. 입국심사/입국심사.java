import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long low = 0;
        long high = Long.MAX_VALUE;
        long mid = 0;
        boolean is = false;
        while(low <= high){
            long cnt = 0;
            mid = (low + high) /2;
            for(int i=0 ; i< times.length ; i++){
                cnt += mid/times[i];
                if(cnt >= n ) break;
            }
            if(n <= cnt){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }
}