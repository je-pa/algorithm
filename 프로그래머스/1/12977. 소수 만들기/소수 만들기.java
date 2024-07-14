class Solution {
    public int solution(int[] nums) {
        int answer=0;
        
        for(int x=0; x<nums.length-2 ; x++){
            for(int y=x+1; y<nums.length-1 ; y++){
                for(int z=y+1; z<nums.length ; z++){
                    int num = nums[x]+nums[y]+nums[z];
                    for(int n=2; n<num-4; n++){
                        if(num%n==0){ break; }
                        if(n==num-5){answer++;}
                    }
                }
            }
        }

        return answer;
    }
}