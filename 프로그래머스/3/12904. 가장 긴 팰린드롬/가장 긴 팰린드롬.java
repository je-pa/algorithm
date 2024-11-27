import java.util.*;
class Solution
{
    int N;
    
    public int solution(String s)
    {
        int answer = 1;
        N = s.length();
        if(N == 0){
            return 0;
        }else if(N == 1){
            return 1;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        String s2 = sb.toString();
        int l = 0;
        int r = 0;
        // System.out.println(s2);
        while(r != N+1 && l != N){
            if(l == r) {
                r++;
                continue;
            }
            String ss1= s.substring(l, r);
            String ss2= s2.substring(N-r, N-l);
            // System.out.println(ss1 + " " + ss2);
            if(s2.contains(ss1)){
                if(ss1.equals(ss2)) {
                    answer = Math.max(r-l, answer);
                }
                r++;
            }else{
                l++;
            }
        }
        return answer;
    }
}