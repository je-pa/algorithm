import java.util.*;
class Solution {
    int N;
    int[] result;
    int[] lens;
    List<List<Integer>> lists = new ArrayList<>();
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        result = new int[sources.length];
        lens = new int[n+1];
        N = n;
        for(int i=0 ; i<=N ; i++){
            lists.add(new ArrayList<>());
        }
        for(int[] road: roads){
            int a= road[0];
            int b= road[1];
            lists.get(a).add(b);
            lists.get(b).add(a);
        }
        pro(sources, destination);
        return result;
    }
    
    void pro(int[] sources, int d){
        int len = sources.length;
        boolean[] visited = new boolean[N+1];
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[]{d, 0});
        lens[d] = 0;
        visited[d] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curN = cur[0];
            int curL = cur[1];
            for(int nN : lists.get(curN)){
                if(visited[nN]) continue;
                int nL = curL + 1;
                q.add(new int[]{nN, nL});
                lens[nN]= nL;
                visited[nN] = true;
            }
        }
        int idx = 0;
        for(int i : sources){
            int l = lens[i];
            if(l == 0){
                if(i == d) {
                    idx++;
                    continue;
                }
                result[idx] = -1;
            }else{
                result[idx] = l;
            }
            idx++;
        }
    }
}