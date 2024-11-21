import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, (x, y) -> (Integer.compare(x[0], y[0])));
        int bi = routes[0][0];
        int bo = routes[0][1];
        
        for(int[] arr : routes){
            // 겹치
            if(arr[0] >= bi && arr[0] <= bo){
                bi = Math.max(bi, arr[0]);
                bo = Math.min(bo, arr[1]);
                continue;
            }
            
            // 안겹침
            answer++;
            bi = arr[0];
            bo = arr[1];
        }
        return answer;
    }
}