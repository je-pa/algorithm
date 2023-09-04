import java.util.*;
class Solution {
    public String solution(String str1, String str2) {
        StringBuffer sb = new StringBuffer();
        char[] cs1 = str1.toCharArray();
        char[] cs2 = str2.toCharArray();
        for(int i=0; i<cs1.length ; i++){
            sb.append(cs1[i]).append(cs2[i]);
        }
        return sb.toString();
    }
}