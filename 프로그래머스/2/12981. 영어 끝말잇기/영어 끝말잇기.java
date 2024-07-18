import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        String sf = words[0];
        set.add(sf);
        int last = sf.length()-1;
        char cf = sf.charAt(last);
        int[] answer = new int[2];
        
        for(int i=1 ; i<words.length ; i++){
            String now = words[i];
            if(set.contains(now) || cf!=now.charAt(0)){
                answer[0] =  ((i)%n)+1;
                answer[1] = i/n +1;
                break;
            }
            set.add(now);
            cf = now.charAt(now.length()-1);
        }
        
        return answer;
    }
}