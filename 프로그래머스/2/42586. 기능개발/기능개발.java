import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> result = new ArrayList<>();
        int len = progresses.length;
        LinkedList<Integer> list  = new LinkedList<>();

        for(int i=0 ; i<len ; i++){
            // if(speeds[i] == 0) {
            //     list.add(Integer.MAX_VALUE);
            //     continue;
            // }
            list.add((int)Math.ceil((100 - progresses[i])/(double)speeds[i]));
        }
        int n = 0;
        while(!list.isEmpty()){
            n = Math.max(n, list.poll());
            // if(n == Integer.MAX_VALUE) break;
            int count = 1;
            while(!list.isEmpty() && list.peekFirst() <= n){
                list.poll();
                count++;  
            }
            result.add(count);
        }
        return result.stream().mapToInt(x -> (int)x).toArray();
    }
}