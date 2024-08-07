class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] arr = new int[number+1];
        for(int i=1 ; i<=number ; i++){
            for(int j=1 ; j*i<=number ; j++){
                arr[i*j]++;   
            }
        }
        
        for(int i=1 ; i<arr.length ; i++){
            answer += arr[i] > limit ? power : arr[i];
        }
        return answer;
    }
}