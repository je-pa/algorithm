class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        int slen = s.length();
        
        for(int i=1; i<=slen ; i++){
            answer = Math.min(dfs(s, i, 0, 0, 0, "", slen,""),answer);
        }
        return answer;
    }
    
    public int dfs(String s, int cut, int idx, int curLen, int count, String before, int slen, String cur){
        if(idx + cut > slen){
            cur += (count<=1?"":count);
            cur += before;
            // System.out.println(cur);
            return cur.length() + slen%cut;
        }
        String cs = s.substring(idx, idx+cut);
        if(before.equals(cs)){
            return dfs(s, cut, idx+cut, curLen, count+1, before, slen,cur);
        }
        return dfs(s, cut, idx+cut, curLen + cut, 1, cs, slen,cur+ (count<=1?"":count) + before);
        
    }
}