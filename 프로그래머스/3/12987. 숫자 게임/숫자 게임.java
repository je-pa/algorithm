import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int N = A.length;
        Arrays.sort(B);
        Arrays.sort(A);
        int bi = 0;
        int count =0;
        for(int i=0 ; i<N ; i++){
            while(bi<N && A[i]>=B[bi]){
                bi++;
            }
            if(bi == N) break;
            count++;
            bi++;
        }
        return count;
    }
}