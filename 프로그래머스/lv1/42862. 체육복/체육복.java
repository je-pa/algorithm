class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] arr = new int[n+2];
        int count=0;
        for(int i=1; i<=n ; i++){
            arr[i] = 1;
        }
        for(int i:lost){
            arr[i]--;
        }
        for(int i:reserve){
            arr[i]++;
        }
        for(int i=1 ; i<=n ; i++){
            if(arr[i]==0){
                if(arr[i-1]==2){
                    arr[i-1]--;
                    arr[i]++;
                }else if(arr[i+1]==2){
                    arr[i+1]--;
                    arr[i]++;
                }
            }
        }
        for(int i=1;i<=n ; i++){
            if(arr[i]>0){
                count++;
            }
        }
        return count;
        // int answer = 0;
        // answer=n-lost.length;
        // for(int i=0;i<lost.length;i++){
        //     for(int j=0;j<reserve.length;j++){
        //         if(lost[i]==reserve[j]){
        //             answer++;
        //             reserve[j]=-1;
        //             lost[i]=-1;
        //             break;
        //         }
        //     }
        // }
        // for(int i=0;i<lost.length;i++){
        //     for(int j=0;j<reserve.length;j++){
        //         if(lost[i]+1==reserve[j]||lost[i]-1==reserve[j]){
        //             answer++;
        //             reserve[j]=-1;
        //             lost[i]=-1;
        //             break;
        //         }
        //     }
        // }
        // return answer;
    }
}