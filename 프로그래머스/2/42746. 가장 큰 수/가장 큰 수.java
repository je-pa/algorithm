import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(int[] numbers) {
        String str = Arrays.stream(numbers).mapToObj(String::valueOf)
            .sorted( (o1, o2) -> (o2 + o1).compareTo(o1 + o2)
            )// 30 3 34 -> 34 3 30
            .collect(Collectors.joining());
        return str.startsWith("0") ? "0" : str;
    }
}