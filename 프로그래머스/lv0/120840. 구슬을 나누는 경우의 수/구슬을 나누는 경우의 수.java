import java.math.*; 
class Solution {
    public int solution(int balls, int share) {
        if(balls==share) return 1;
        return (factorial(balls).divide(factorial(balls-share)).divide(factorial(share))).intValue();
    }
    public BigInteger factorial(int n){
        BigInteger result = new BigInteger("1");;
        for(int i =2 ; i<=n ; i++){
            result = result.multiply(new BigInteger(String.valueOf(i)));
        }
        
        return result;
    }
}