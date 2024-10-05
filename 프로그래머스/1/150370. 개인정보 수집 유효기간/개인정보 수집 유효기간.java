import java.time.*;
import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        // LocalDate time = LocalDate.of(2020, 1, 3).plusMonths(3);
        int[] term = new int['Z'-'A'+1];
        
        for(String str : terms){
            String[] arr = str.split(" ");
            term[arr[0].charAt(0)-'A'] = Integer.parseInt(arr[1]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        int i=0;
        for(String str : privacies){
            i++;
            String[] arr = str.split(" ");
            String s = arr[0];
            String[] dateInfo = s.split("\\.");
            
            LocalDate date = LocalDate.of(Integer.parseInt(dateInfo[0])
                                         ,Integer.parseInt(dateInfo[1])
                                         ,Integer.parseInt(dateInfo[2]))
                .plusMonths(term[arr[1].charAt(0)-'A']);
            String[] toda = today.split("\\.");
            
            LocalDate dateT = LocalDate.of(Integer.parseInt(toda[0])
                                         ,Integer.parseInt(toda[1])
                                         ,Integer.parseInt(toda[2]));
            if(dateT.isBefore(date)) continue;
            list.add(i);
        }      
        int[] result = new int[list.size()];
        
        for(int j =0 ; j<list.size() ; j++){
            result[j] = list.get(j);
        }
        return result;
    }
}