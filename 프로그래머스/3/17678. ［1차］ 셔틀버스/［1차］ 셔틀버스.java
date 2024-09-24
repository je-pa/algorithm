import java.util.*;
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int[] times = Arrays.stream(timetable).mapToInt(s -> {
            String[] arr = s.split(":");
            return Integer.parseInt(arr[0])*60 + Integer.parseInt(arr[1]);
        }).toArray();
        Arrays.sort(times);
        int bus = 60*9;
        int idx = 0;
        for(int i=0 ; i<n-1 ; i++){
            int count = 1;    
            while(idx < timetable.length && times[idx] <= bus && count <= m){
                idx++;
                count++;
            }
            bus += t;
        }
        int count = 1;
        while(idx < times.length && times[idx] <= bus && count < m){
            idx++;
            count++;
        }
        if(idx > timetable.length-1 || count < m || idx < m -1){
            return String.format("%02d:%02d", bus/60, bus%60);
        }
        if(times[idx] <= bus){
            bus = times[idx]-1;
        }
        return String.format("%02d:%02d", bus/60, bus%60);
    }
    
    
}