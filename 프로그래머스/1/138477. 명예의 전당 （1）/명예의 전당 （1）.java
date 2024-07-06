import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = {};
        LinkedList<Integer> deq = new LinkedList<>();
        
        int[] result = new int[score.length];
        int min = score[0];
        for(int i =0 ; i<Math.min(k,score.length) ; i++){
            deq.add(score[i]);
            min = Math.min(score[i], min);
            result[i] = min;
        }
        Collections.sort(deq);
        int idx = k;
        LinkedList<Integer> deq2 = new LinkedList<>();
        for(int i=k ; i<score.length ; i++){
            // int cur = 0;
            // if(!deq.isEmpty()) cur = ;
            if(deq.peekLast() <= score[i]){
                deq.removeFirst();
                deq.add(score[i]);
            }else if(deq.peekFirst()>=score[i]){
                // 넘어간다.
            }else{
                while(!deq.isEmpty() && deq.peekLast() > score[i]){
                    deq2.addFirst(deq.removeLast());
                }
                if(!deq.isEmpty()) deq.removeFirst();
                deq.addLast(score[i]);
                while(!deq2.isEmpty()){
                    deq.addLast(deq2.removeFirst());
                }
            }
            result[idx++] = deq.peekFirst();
            
        }
        
        
        return result;
    }
}
// deq num deq2
// 1,2(),4 3 
// deq[last] <= num
// deq[first] 빼고
// deq.addLast(num)

// deq[last] > numde
// deq[last] > deq2.addFirst
// deq2.removeFirst(); -> deq.size == k 