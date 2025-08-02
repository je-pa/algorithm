import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    String[] users;
    String[] bans;
    int n;

    public int solution(String[] user_id, String[] banned_id) {
        users = user_id;
        bans = banned_id;
        n = user_id.length;

        dfs(0, 0);  // 시작 인덱스, 방문 상태(비트마스크)

        return set.size();
    }

    void dfs(int idx, int mask) {
        if (idx == bans.length) {
            set.add(mask);  // 현재 조합을 비트마스크로 저장
            return;
        }

        String reg = "^" + bans[idx].replace("*", ".") + "$";
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) != 0) continue;             // 이미 선택된 user
            if (!users[i].matches(reg)) continue;             // 패턴 안 맞음

            dfs(idx + 1, mask | (1 << i));  // i번째 비트 ON
        }
    }
}
