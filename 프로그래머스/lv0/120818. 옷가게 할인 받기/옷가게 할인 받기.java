class Solution {
    public int solution(int price) {
        int p = price/100_000;
        // return (int)(p >= 5 ? price*0.8 : p >= 3 ? price*0.9 : p>=1 ? price*0.95 : price);
        return (int)(price*(p >= 5 ? 0.8 : p >= 3 ? 0.9 : p>=1 ? 0.95 : 1));
    }
}