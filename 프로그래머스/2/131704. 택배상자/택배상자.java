import java.util.*;
class Solution {
    public int solution(int[] order) {
        Stack<Integer> st = new Stack<>();
        int result = 0;
        int curIdx = 0;
        for(int i=1 ; i<=order.length ; i++){
            st.push(i);
            while(!st.isEmpty() && curIdx < order.length && st.peek() == order[curIdx]){
                result++;
                curIdx++;
                st.pop();
            }
            
        }
        return result;
    }
}