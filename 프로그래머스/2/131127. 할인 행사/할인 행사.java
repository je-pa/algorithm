import java.util.*;
class Solution {
    Map<String,Integer> countMap = new HashMap<>();
    // Map<String,Integer> curMap = new HashMap<>();
    int totalCount = 0;
    public int solution(String[] want, int[] number, String[] discount) {
        int count = 0;
        for(int i=0 ; i<want.length ; i++){
            countMap.put(want[i], number[i]);
            // curMap.put(want[i], 0);
            totalCount += number[i];
        }
        System.out.println(totalCount);
        for(int i=0 ; i<10 ; i++){
            if(countMap.containsKey(discount[i])){
                countMap.put(discount[i], countMap.get(discount[i]) - 1);
                // System.out.println(":::"+discount[i] + countMap.get(discount[i]));
                if(countMap.get(discount[i]) >=0){
                    totalCount--;
                }
            }
        }
        if(totalCount <= 0) count++;
        
        for(int i=1 ; i<discount.length-9 ; i++){
            int j = i + 10 - 1;
            
            if(countMap.containsKey(discount[j])) {
                countMap.put(discount[j], countMap.get(discount[j]) - 1);
                // System.out.println(discount[j] + countMap.get(discount[j]));
                if(countMap.get(discount[j]) >=0){
                    totalCount--;
                }
            }
            if(countMap.containsKey(discount[i-1])) {
                countMap.put(discount[i-1], countMap.get(discount[i-1]) + 1);
                // System.out.println(discount[i-1] + countMap.get(discount[i-1]));
                if(countMap.get(discount[i-1]) >0){
                    totalCount++;
                }
            }
            if(totalCount <= 0) count++;
            // System.out.println(totalCount);
        }
        
        return count;
    }
}