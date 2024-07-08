import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int index;
        int move = name.length()-1;
        
        for(int i=0;i<name.length();i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            index = i+1;
            while(index<name.length() && name.charAt(index) == 'A') {
                index++;
            }
            move = Math.min(move, i*2+name.length()-index);
            move = Math.min(move, (name.length()-index)*2 + i);
        }
        return answer + move;
    }
}
// class Solution {
//     int idx = 0;
//     public int solution(String name) {
//         int answer = 0;
//         char[] goal = name.toCharArray();
//         char[] cur = new char[name.length()];
//         for(int i=0 ; i<cur.length ; i++){
//             cur[i] = 'A';
//         }
        
//         while(true){
//             System.out.print(idx+" ");
//             answer += upDown(cur[idx], goal[idx]);
//             // System.out.print(upDown(cur[idx], goal[idx]));
//             cur[idx] = goal[idx];
//             int lr = lr(cur, goal);
//             // System.out.println(" "+lr);
//             if(lr == cur.length ) break;
//             answer+=lr;
            
//         }
//         return answer;
//     }
    
//     int upDown(char cur, char goal){
//         int down = 0;
//         int up = 0;
//         if( cur < goal){
//             down = goal - cur;
//             up = (cur+1 - 'A') +('Z' - goal);
//         }else {
//             down = cur - goal;
//             up = (goal+1 - 'A') + ('Z' - cur);
//         }
//         return Math.min(down, up);
//     }
    
//     int lr(char[] cur, char[] goal){
//         int left = 1;
//         int nextIL = idx - left >= 0 ? idx - left : cur.length + idx - left;
//         while(left < cur.length  && cur[nextIL] == goal[nextIL]){
//             left++;
//             nextIL = idx - left >= 0 ? idx - left : cur.length + idx -left;
//         }
//         int right = 1;
//         int nextIR = idx + right < cur.length ? idx + right : idx + right - cur.length;
//         while(right < cur.length && cur[nextIR] == goal[nextIR]){
//             right++;
//             nextIR = idx + right < cur.length ? idx + right : idx + right - cur.length;
//         }
//         int min = Math.min(left, right);
//         if(right == min){
//             idx = nextIR;
//         } else{
//             idx = nextIL;
//         }
//         return min;
//     }
// }