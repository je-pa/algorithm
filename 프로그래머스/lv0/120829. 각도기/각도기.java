class Solution {
    public int solution(int angle) {
        if(angle == 90) return 2;
        if(angle == 180) return 4;
        return angle < 90 ? 1 : 3;
    }
}