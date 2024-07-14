import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        LinkedList<String> list1 = new LinkedList<>();
        LinkedList<String> list2 = new LinkedList<>();
        for(int i=0 ; i<cards1.length ; i++){
            list1.add(cards1[i]);
        }
        for(int i=0 ; i<cards2.length ; i++){
            list2.add(cards2[i]);
        }
        int count = 0;
            // System.out.println(list1.size() +" " + list2.size());
        for(int i=0 ; i<goal.length ; i++){
            String cur = goal[i];
            if(!list1.isEmpty() && list1.peekFirst().equals(cur)){
                list1.poll();
                count++;
                continue;
            }
            if(!list2.isEmpty() && list2.peekFirst().equals(cur)){
                list2.poll();
                count++;
                continue;
            }
        }
        
        // System.out.print(list1.size() +" "+ list2.size());
        return count == goal.length ? "Yes":"No";
    }
}