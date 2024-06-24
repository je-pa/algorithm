import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        char[] cs = s.toCharArray();
        Arrays.sort(cs);
        
        return new StringBuilder((new String(cs))).reverse().toString();
    }
}