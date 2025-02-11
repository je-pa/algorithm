class Solution {
    int N;
    int LEN = 11;
    int[] INFO;
    int[] now;
    int[] result;
    int max= 0;
    public int[] solution(int n, int[] info) {
        INFO = info;
        now = new int[LEN];
        result = new int[LEN];
        dfs(0,n);
        return max == 0 ? new int[]{-1} : result;
    }
    public void dfs(int idx, int remain){
        if(idx >= LEN || remain == 0){
            now[LEN-1]+=remain;
            score();
            now[LEN-1]-=remain;
            return;
        }
        
        if(now[idx] <= INFO[idx]){
            now[idx]++;
            dfs(idx, remain-1);
            now[idx]--;
        }
        
        dfs(idx+1, remain);
    }
    public void score(){
        int l = 0;
        int a = 0;
        for(int i=0 ; i<LEN ; i++){
            if(now[i] == 0 && INFO[i] == 0) continue;
            if(now[i] > INFO[i]){
                l += (LEN - 1 - i);
            }else {
                a += (LEN - 1 - i);
            }
        }
        if(l!=a && l - a >= max){
            if(max == l-a){
                for(int i=LEN-1 ; i>=0 ; i--){
                if(result[i] < now[i]){
                    break;
                }
                if(max != 0 && result[i] > now[i]) return;
            }
            }
            
            max = l-a;
            for(int i=0 ; i<LEN ; i++){
                result[i] = now[i];
            }
        }
    }
}