class Solution {

    public int solution(int total, int[] coins) {

        int[] arr = new int[total];
        for(int k = 0;k<total;k++){ arr[k] = 0; }
        for(int i : coins){
            arr[i-1] += 1;
            for(int j=0; j<total ; j++) {
                if(j>=i) { arr[j] += arr[j - i]; }
            }
        }
        return arr[total-1];
    }
}