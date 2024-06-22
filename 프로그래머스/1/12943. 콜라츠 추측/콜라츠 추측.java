class Solution {
    public int solution(long num) {
        int i;
        for(i=0; num!=1&&i<500;i++){
            num = num%2==0?(num/2):(num*3+1);
        }
        
        return i!=500?i:-1;
    }
}//5점