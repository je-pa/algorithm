class Solution {
    public String solution(String s, int n) {
        String answer = "";
        //65~90(대)91->65 , 97~122(소) 123->97
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                answer+=" ";
            }else{
                int plusResult = s.charAt(i)+n;
            if(s.charAt(i)>=65&&s.charAt(i)<=90){
                if(plusResult>90){
                    answer += (char)(s.charAt(i)+n-26);
                    continue;
                }
            }
            if(s.charAt(i)>=97&&s.charAt(i)<=122){
                if(plusResult>122){
                    answer += (char)(s.charAt(i)+n-26);
                    continue;
                }
            }
            answer += (char)(s.charAt(i)+n);
            }
        }
        return answer;
    }
}