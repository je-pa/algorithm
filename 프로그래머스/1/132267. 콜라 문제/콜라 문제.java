class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int count = 0;
        
//         while(){
            
//         }
        return re(a,b,n);
    }
    
    public int re(int a , int b, int n){
        if(n < a){
            return 0;
        }
        return (n/a)*b + re(a, b, ((n/a)*b) + (n%a));
    }
}