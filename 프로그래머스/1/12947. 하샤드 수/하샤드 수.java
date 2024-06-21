// class Solution {
//     public boolean solution(int x) {
//         int n = x , sum =0;
//         while(x>=1){
//             sum += x%10;
//             x=x/10;
//         }
//         return sum!=0 && n%sum==0;
//     }
// }

// class Solution {
//     public boolean solution(int x) {
//         String[] temp = String.valueOf(x).split("");

//         int sum = 0;
//         for (String s : temp) {
//             sum += Integer.parseInt(s);
//         }

//         if (x % sum == 0) {
//                 return true;
//         } else {
//           return false;
//         }
//     }
// }

// import java.util.function.IntConsumer;
// class Solution {
//     public boolean solution(int x) {
//         int sum = 0;
//         Integer.toString(x).chars().forEach(c -> sum += c - '0');
//         return x % sum == 0;
//     }
// }

import java.util.*;

class Solution {
    private int sum =0;
    
    public boolean solution(int x) {
        Integer.toString(x).chars().forEach(c -> sum += (c-'0'));
        return x % sum == 0;
    }
}