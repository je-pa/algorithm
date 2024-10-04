import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int[] distances = new int[rocks.length+1];
        Arrays.sort(rocks);
        int left = 0;
        int right = distance;
        set(distances, rocks, distance);
        while(left <= right){
            int count = 0;
            int mid = (left + right) / 2;
            for(int i = 0 ; i < rocks.length ; i++){
                if(distances[i] >= mid) continue;
                count++;
                distances[i+1] += distances[i];
                if(count > n) break;
            }// 9 10
            
            if(distances[rocks.length] < mid) count++;
            
            if(count > n){
                right = mid-1;
            }else{
                left = mid+1;
            }
            set(distances, rocks, distance);
        }
        
        return right;
    }
    
    public void set(int[] distances, int[] rocks, int distance){
        distances[0] = rocks[0] - 0;
        for(int i= 1; i< rocks.length ; i++){
            distances[i] = rocks[i] - rocks[i-1];
        }
        distances[rocks.length] = distance - rocks[rocks.length-1];
    }
}
//2 9 3 3 4 4
//2 11 3 6 4 4
//