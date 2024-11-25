import java.util.*;
import java.util.Map.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Count> m = new HashMap<>();
        
        for(int i=0 ; i<genres.length ; i++){
            m.put(genres[i], m.getOrDefault(genres[i], new Count()).plus(plays[i], i));
        }
        
        Set<Entry<String,Count>> set =  m.entrySet();
        PriorityQueue<Count> p = new PriorityQueue<>();
        for(String str : m.keySet()){
            p.add(m.get(str));
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        while(!p.isEmpty()){
            Count c = p.poll();
            for(int i=0 ; !c.indexs.isEmpty() && i<2  ; i++){
                list.add(c.indexs.poll().index);
            }
        }
        int[] result = new int[list.size()];
        for(int i = 0 ; i<list.size() ; i++){
            result[i] = list.get(i);
        }
        return result;
    }

    static class Count implements Comparable<Count>{
        int plays;
        PriorityQueue<G> indexs = new PriorityQueue<>();
        
        public Count plus(int plays, Integer index){
            this.plays += plays;
            this.indexs.add(new G(plays, index));
            return this;
        }
        
        public int compareTo(Count c){
            return Integer.compare(c.plays, this.plays);
        }
    }
    
    static class G implements Comparable<G>{
        int plays;
        int index;
        public G(int plays, int index){
            this.plays = plays;
            this.index = index;
        }
        public int compareTo(G g){
            if(g.plays != this.plays) return Integer.compare(g.plays, this.plays);
            return Integer.compare(this.index, g.index);
        }
    }
}