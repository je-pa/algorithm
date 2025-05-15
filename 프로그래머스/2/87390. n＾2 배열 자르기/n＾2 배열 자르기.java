import java.util.*;
class Solution {
    public int[] solution(long n, long left, long right) {
        ArrayList<Long> list = new ArrayList<>();
        for(long i=left; i<=right ; i++){
            list.add(Math.max(i/n+(long)1, i%n+(long)1));
        }
        return list.stream().mapToInt(x -> x.intValue()).toArray();
    }
}