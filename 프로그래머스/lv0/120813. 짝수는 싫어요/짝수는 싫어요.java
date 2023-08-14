import java.util.*;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i<= n ; i=i+2){
            list.add(i);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}