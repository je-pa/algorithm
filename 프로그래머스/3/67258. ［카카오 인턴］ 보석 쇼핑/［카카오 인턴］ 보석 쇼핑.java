import java.util.*;
class Solution {

    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        int size = set.size();
        Map<String, Integer> map = new HashMap<>();
        int[] answer = new int[2];
        
        int start = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0 ; i< gems.length ; i++){
            map.put(gems[i], map.getOrDefault(gems[i], 0)+1);
            while(map.get(gems[start]) > 1){
                map.put(gems[start], map.get(gems[start])-1);
                start++;
            }
            if (map.size() == size && min > (i - start)) {
                min = i - start;
                answer[0] = start + 1;
                answer[1] = i + 1;
            }
        }
        return answer;
    }
   
}