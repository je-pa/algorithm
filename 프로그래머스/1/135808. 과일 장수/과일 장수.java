import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>((x,y) -> y-x);
        for(int i=0 ; i<score.length ; i++){
            q.add(score[i]);
        }
        // int count = 0; // 상자 개수
        int countm = 0;// 한상자내의 사과 개수
        int min = k;
        int total = 0;
        while(!q.isEmpty()){
            Integer i = q.poll();
            countm++;
            min = Math.min(i, min);
            if(countm == m){
                total+=(min*m);
                // count++;
                countm=0;
            }
        }
        return total;
    }
}