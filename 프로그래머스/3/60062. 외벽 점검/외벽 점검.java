import java.util.*;
class Solution {
    int N;
    int[] w;
    int[] d;
    int result = Integer.MAX_VALUE;
    int[][] arrs;
    int R =0;
    public int solution(int n, int[] weak, int[] dist) {
        int answer = 0;
        int size = 1;
        for(int i=2 ; i<=dist.length ; i++){
            size*=i;
        }
        arrs = new int[size][dist.length];
        N = n;
        w = weak;
        d = dist;
        dfs(0, new int[d.length], new boolean[d.length]);
        for(int i=0; i<w.length ; i++){
            for(int[] arr : arrs){
                start(i, arr);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    void dfs(int dep, int[] cur, boolean[] visited){
        if(dep == d.length){
            // System.out.print(R+": ");
            for(int i=0 ; i<cur.length ; i++){
                arrs[R][i] = cur[i];
                // System.out.print(cur[i]+" ");
            }
            // System.out.println();
            R++;
        }
        for(int i=0 ; i<d.length ; i++){
            if(visited[i]) continue;
            visited[i] = true;
            cur[dep] = d[i];
            dfs(dep+1, cur, visited);
            visited[i] = false;
        }
    }
    
    void start(int idx, int[] arr){
        int cur = w[idx];
        int count = 0;
        for(int i=0 ; i<arr.length ; i++){
            cur += arr[i];
            while(count < w.length && 
                  ((idx < w.length && w[idx] <= cur) || (idx >= w.length && w[idx%w.length] <= (cur - N) % N))
                  ){
                idx++;
                count++;
            }
            
            if(count == w.length) {
                result = Math.min(result, i+1);
                break;
            }
            idx %= w.length;
            cur = w[idx];
            cur %= N;                  
        }
    }
    
}