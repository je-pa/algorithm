class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];
        for(int i=0 ; i<arr1.length; i++){
            for(int j=0; j<arr1[0].length; j++){
                answer[i][j]=arr1[i][j]+arr2[i][j];
            }
        }
        return answer;
    }
}
// class Solution {
//     public int[][] solution(int[][] arr1, int[][] arr2) {
//         int row = Math.max(arr1.length, arr2.length);
//         int col = Math.max(arr1[0].length, arr2[0].length);
//         int[][] answer = new int[row][col];
//         for(int i=0; i<row ; i++){
//           for(int j=0; j<col; j++){
//             answer[i][j] = arr1[i][j] + arr2[i][j];
//           }
//         }   
//         return answer;
//     }
// }