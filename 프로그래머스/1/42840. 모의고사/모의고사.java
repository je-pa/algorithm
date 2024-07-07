import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> arr = new ArrayList<>();
        int[] mans = new int[3];
        int[] man2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] man3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        for(int i = 0 ; i<answers.length ; i++){
            int answer = answers[i];
            mans[0] += i%5+1 == answer ? 1 : 0;
            mans[1] += man2[i%man2.length] == answer ? 1 : 0;
            mans[2] += man3[i%man3.length] == answer ? 1 : 0;
        }
        int o = Math.max(mans[0],Math.max(mans[1],mans[2]));

        for(int i=0 ; i<3 ;i++){
            if(o == mans[i]){
                arr.add(i+1);
            }
        }

        return Arrays.stream(arr.toArray(new Integer[arr.size()])).mapToInt(Integer::intValue).toArray();
    }
}