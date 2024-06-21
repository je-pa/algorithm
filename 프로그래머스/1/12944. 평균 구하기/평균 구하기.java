// class Solution {
//     public double solution(int[] arr) {
//         int sum = 0;
//         for(int i=0; i<arr.length;i++){
//             sum += arr[i];
//         }
//         double answer = (double)sum/arr.length;
        
//         return answer;
//     }
// }//
// import java.util.Arrays;
// class Solution {
//     public double solution(int[] arr) {
//         return Arrays.stream(arr).average().orElse(0);
//     }
// }

class Solution {
    public double solution(int[] arr) {
        if(arr == null){
            return 0;
        }

        int ret = 0;
        if(arr != null){
            for(int n : arr){
                ret += n;
            }
        }
            return (double)ret / arr.length;
        }
}