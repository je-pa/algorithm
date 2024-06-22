import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        int len = arr.length;
        if(len-1==0){
            return new int[]{-1};
        }
        int[] answer = new int[len-1];
        int min = Arrays.stream(arr).min().getAsInt();
        for(int i=0, j=0; i<len;i++){
            if(min!=arr[i]){
                answer[j]=arr[i];
                j++;
            }
        }
        
        return answer;
    }
}//3