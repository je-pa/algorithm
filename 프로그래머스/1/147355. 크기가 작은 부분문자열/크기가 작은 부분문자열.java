class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int pl = p.length();
        for(int i=0 ; i<=t.length()-pl ; i++){
            t.substring(i, i+pl);
            if(Long.parseLong(t.substring(i, i+pl)) <= Long.parseLong(p)){
                answer++;
            }
        }
        return answer;
    }
}