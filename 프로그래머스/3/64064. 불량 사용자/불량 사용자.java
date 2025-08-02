import java.util.*;
class Solution {
    boolean[] visited;
    String[] users;
    String[] bans;
    Set<String> set = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];
        users = user_id;
        bans = banned_id;
        dfs(0);
    
        return set.size();
    }
    void dfs(int idx){
        if(idx == bans.length){
            StringBuilder sb = new StringBuilder();
            for(int i=0 ; i<visited.length ; i++){
                if(visited[i]) sb.append(i);
            }
            set.add(sb.toString());
            return;
        }
        String reg = "^" + bans[idx].replace("*", ".") + "$";
        for(int i=0 ; i<users.length ; i++){
            if(visited[i]) continue;
            if(!users[i].matches(reg)) continue;
            visited[i] = true;
            dfs(idx+1);
            visited[i] = false;
        }
    }
    
}