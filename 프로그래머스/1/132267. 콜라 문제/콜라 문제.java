class Solution {
    public int solution(int a, int b, int n) {
        return (n > b ? n - b : 0) / (a - b) * b;
    }
    
    public int re(int a , int b, int n){
        if(n < a){
            return 0;
        }
        return n/a*b + re(a, b, n/a*b + (n%a));
    }
}