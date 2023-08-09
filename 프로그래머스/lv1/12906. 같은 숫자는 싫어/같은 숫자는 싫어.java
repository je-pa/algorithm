import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(arr[0]);
        for(int i : arr){
            if(list.peekLast() == i) continue;
            list.add(i);
        }
        int size = list.size();
        int[] answer = new int[size];
        for(int i = 0 ; i<size ; i++){
            answer[i] = list.poll();
        }

        return answer;
    }
}