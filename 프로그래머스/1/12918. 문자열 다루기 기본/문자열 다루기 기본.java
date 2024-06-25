class Solution {
    public boolean solution(String s) {
        boolean answer = true;        
        try{
            Integer.parseInt(s);
        }catch(Exception e){
            return false;
        }
        if(s.length()!=4 && s.length()!=6 ) return false;
        return answer;
    }
}//6