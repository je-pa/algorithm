import java.util.*;
class Solution {
    int N;
    List<List<int[]>> lists;
    PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> Integer.compare(x[0],y[0]));
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
        int l = 1;
        int r = 10_000_000;
        int an = 0;
        while(l<=r){
            int m = (l+r)/2;
            
            if(check(m)){
                r = m-1;
                an = m;
            }else{
                l = m+1;
            }
        }
        for(int g : gArr){
            bfs(g, an);
        }
        result = pq.poll();
    }
    void bfs(int gate, int min){
        LinkedList<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        q.add(new int[]{gate});
        
        while(!q.isEmpty()){
            int[] c = q.poll();
            int cn = c[0];
            for(int[] arr : lists.get(cn)){
                int nn = arr[0];
                int nd = arr[1];
                if(min < nd) continue;
                if(visited[nn]) continue;
                if(gs.contains(nn)) continue;
                visited[nn] = true;
                if(ss.contains(nn)){
                    pq.add(new int[]{nn, min});
                    continue;
                }
                q.add(new int[]{nn});
            }
        }
    }
    
    boolean check(int n){
        for(int i : gArr){
            if(qStart(i,n)) return true;
        }
        return false;
    }
    boolean qStart(int gate, int mid){
        LinkedList<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        q.add(new int[]{gate});
        
        while(!q.isEmpty()){
            int[] c = q.poll();
            int cn = c[0];
            for(int[] arr : lists.get(cn)){
                int nn = arr[0];
                int nd = arr[1];
                if(mid < nd) continue;
                if(visited[nn]) continue;
                if(gs.contains(nn)) continue;
                if(ss.contains(nn)){
                    return true;
                }
                visited[nn] = true;
                q.add(new int[]{nn});
            }
        }
        return false;
    }

    void input(int n, int[][] paths, int[] gates, int[] summits){
        gArr = gates;
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