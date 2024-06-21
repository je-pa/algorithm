// import java.util.Arrays;
// class Solution {
//     public long solution(long n) {
//         String result = "";
//         char[] arr = Long.toString(n).toCharArray();
//         Arrays.sort(arr);
//         for(char i : arr){
//             result = i+result;
//         }
//         return Long.parseLong(result);
//     }
// }//2

import java.util.*;
import java.util.stream.*;

class Solution {
    public long solution(long n) {
//         return Long.parseLong(String.valueOf(n).chars().mapToObj(ch -> (char) ch)
//                 .sorted(Comparator.reverseOrder())
                
//                 .toString());
        String[] split = String.valueOf(n).split("");
        Arrays.sort(split, Comparator.reverseOrder());
        return Long.parseLong(Arrays.stream(split).collect(Collectors.joining()));
    }
}