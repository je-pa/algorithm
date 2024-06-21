import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        int len = arr.length;
        if(len-1==0){
            return new int[]{-1};
        }
        int[] answer = new int[len-1];
        int min = Arrays.stream(arr).min().getAsInt();
        int lasti = 0;
        int lastj= 0;
        for(int i=0, j=0; i<len-1;i++){
            if(min!=arr[i]){
                answer[j]=arr[i];
                j++;
                lastj= j;
                lasti = i;
            }
        }

        if(lasti != len-1){
            answer[lastj] = arr[lasti+1];    
        }
        
        return answer;
    }
}//3