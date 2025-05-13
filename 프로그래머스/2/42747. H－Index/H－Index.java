class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int l = 0, r = 10_000;
        
        while(l<=r){
            int m = (l+r)/2;
            if(check(citations, m)){
                l = m+1;
                answer = m;
            }else{
                r = m-1;
            }
        }
        return answer;
    }
    boolean check(int[] citations, int h){
        int countEqualsOrBig = 0;
        // int countEqualsOrSmall = 0;
        for(int i : citations){
            if(i >= h){
                countEqualsOrBig++;
            }
        }
        return h <= countEqualsOrBig;
    }
}