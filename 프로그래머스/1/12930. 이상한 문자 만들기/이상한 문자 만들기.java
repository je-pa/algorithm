class Solution {
    public String solution(String s) {

        String answer = "";
        int cnt = 0;
        String[] array = s.split("");

        for(String ss : array) {
            if(ss.equals(" ")){
                cnt = 0;
                answer+= " ";
                continue;
            }
            cnt ++;
            answer += cnt%2 == 0 ? ss.toLowerCase() : ss.toUpperCase(); 
        }
      return answer;
  }
}//9