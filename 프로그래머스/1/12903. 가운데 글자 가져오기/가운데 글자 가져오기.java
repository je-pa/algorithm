import java.util.*;
class Solution {
    public String solution(String s) {
        int len = s.length();
        boolean even = len % 2 == 0;
        StringBuilder sb = new StringBuilder();
        if(even) sb.append(s.charAt(len/2 -1));
        sb.append(s.charAt(len/2));
        return sb.toString();
    }
}