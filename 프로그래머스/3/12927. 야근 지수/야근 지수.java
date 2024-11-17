import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y) -> Integer.compare(y,x));
        for(int i : works){
            pq.add(i);
        }
        while(n != 0 && !pq.isEmpty()){
            int k = pq.poll() - 1;
            n--;
            if(k == 0) continue;
            pq.add(k);
        }
        while(!pq.isEmpty()){
            answer += Math.pow(pq.poll(),2);
        }
        return answer;
    }
}