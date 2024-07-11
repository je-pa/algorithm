class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int[] arr = new int[]{31, 29, 31, 30, 31,30,31,31,30,31,30,31};
        String[] yo = new String[]{"THU","FRI","SAT","SUN","MON","TUE","WED"};
        int sum = 0;
        for(int i=0 ; i< a-1; i++){
            sum+=arr[i];
        }
        sum+=b;
        
        return yo[sum%7];
    }
}