import java.util.*;

class Solution {
    public int[] solution(int[] numbers, String direction) {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i: numbers){
            list.add(i);
        }
        if(direction.equals("right")) list.addFirst(list.pollLast());
        if(direction.equals("left")) list.addLast(list.pollFirst());
        return Arrays.stream(list.toArray()).mapToInt(o -> (int)o).toArray();
    }
}