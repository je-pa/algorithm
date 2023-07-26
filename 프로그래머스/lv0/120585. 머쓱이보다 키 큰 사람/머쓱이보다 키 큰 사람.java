import java.util.*;

class Solution {
    public int solution(int[] array, int height) {
        return (int)Arrays.stream(array).filter(s -> s > height).count();
    }
}