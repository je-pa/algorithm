class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int l = 0;
        int r = Integer.MAX_VALUE;
        while(l < r){
            int mid = (l + r)/2;
            int count = 0;
            for(int i : stones){
                if(i <= mid){
                    count++;
                }else{
                    count = 0;
                }
                if(count >= k) break;
            }
            if(count >= k){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return r;
    }
}