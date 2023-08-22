import java.util.*;

class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        int[] count = new int['z'-'a'+1];
        for(char c : arr){
            count[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < count.length ; i++){
            if(count[i]==1){
                sb.append((char)('a'+i));
            }
        }
        return sb.toString();
    }
}