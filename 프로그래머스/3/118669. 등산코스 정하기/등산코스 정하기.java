import java.util.*;
class Solution {
    int N;
    int MAX = Integer.MAX_VALUE;
    List<List<int[]>> lists;
    PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> {
            if(x[1]!=y[1]) return Integer.compare(x[1],y[1]);
            return Integer.compare(x[0],y[0]);
        });
    Set<Integer> ss;
    Set<Integer> gs;
    int[] gArr;
    int[] result = {};
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        input(n, paths, gates, summits);
        pro();
        
        return result;
    }
    void pro(){
        for(int g : gArr){
            bfs(g);
        }
        result = pq.poll();
    }
    void bfs(int gate){
        PriorityQueue<int[]> q = new PriorityQueue<>((x,y) -> {
            return Integer.compare(x[1],y[1]);
        });
        boolean[] visited = new boolean[N+1];
        q.add(new int[]{gate, 0});
        visited[gate] = true;
        
        while(!q.isEmpty()){
            int[] c = q.poll();
            int cn = c[0];
            int cd = c[1];
            visited[cn] = true;
            if(MAX < cd) continue;
            if(gs.contains(cn)){
                pq.add(new int[]{gate, cd});
                MAX = Math.min(MAX, cd);
                return;
            }
            for(int[] arr : lists.get(cn)){
                int nn = arr[0];
                int nd = arr[1];
                if(visited[nn]) continue;
                if(ss.contains(nn)) continue;
                
                q.add(new int[]{nn, Math.max(cd,nd)});
            }
        }
    }

    void input(int n, int[][] paths, int[] gates, int[] summits){
        gArr = summits;
        N = n;
        lists = new ArrayList<>();
        for(int i=0 ; i<=N ; i++){
            lists.add(new ArrayList<>());
        }
        for(int[] path : paths){
            int a = path[0];
            int b = path[1];
            int c = path[2];
            lists.get(a).add(new int[]{b, c});
            lists.get(b).add(new int[]{a, c});
        }
        ss = new HashSet<>();
        gs = new HashSet<>();
        for(int i : gates){
            gs.add(i);
        }
        for(int i: summits){
            ss.add(i);
        }
    }
}